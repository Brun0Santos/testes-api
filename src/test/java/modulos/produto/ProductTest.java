package modulos.produto;
import dataFactory.ProdutoDataFactory;
import io.restassured.http.ContentType;
import modulos.componentes.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioPojo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Testes de API Rest do modulo de product")
public class ProductTest {
    private String token;

    @BeforeEach
    @DisplayName("configuring API data and get token from user in store ")
    public void beforeEach(){
        HomePage.visitHomePage();
        UsuarioPojo userOne = new UsuarioPojo("brunonoptqs", "123456");
        this.token = given().contentType(ContentType.JSON)
                .body(userOne)
                .when().post("/v2/login")
                .then().extract().path("data.token");
    }
    @Test
    @DisplayName("Validate limit from product")
    public void testValidateValueLimit(){
        //enter the product value and check the displayed message
        given().contentType(ContentType.JSON).header("token", this.token)
                .body(ProdutoDataFactory.createProductValueStatic(0.00))
                .when().post("/v2/produtos").then().assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
        //code return was 422
    }

}
