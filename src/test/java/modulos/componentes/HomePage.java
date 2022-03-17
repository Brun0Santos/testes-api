package modulos.componentes;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class HomePage {
    public static void visitHomePage(){
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";

    }
}
