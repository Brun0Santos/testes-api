package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo createProductValueStatic(double valor){
        ProdutoPojo product = new ProdutoPojo();
        product.setProdutoNome("Ryzen x3200");
        product.setProdutoValor(valor);

        List<String> cores = new ArrayList<>();
        cores.add("Red");
        cores.add("Blue");

        product.setProdutoCores(cores);
        product.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Carregador");
        componente.setComponenteQuantidade(2);
        componente.setComponenteNome("Fonte");
        componente.setComponenteQuantidade(1);

        componentes.add(componente);

        product.setComponentes(componentes);

        return product;
    }
}
