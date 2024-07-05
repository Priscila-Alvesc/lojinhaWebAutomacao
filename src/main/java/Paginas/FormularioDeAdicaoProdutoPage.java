package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FormularioDeAdicaoProdutoPage {
    private WebDriver navegador;

   public FormularioDeAdicaoProdutoPage (WebDriver navegador){

       this.navegador = navegador;

    }
    //vou preencher dados do produto e o valor sera = 0, e devera emitir mensagem erro
    public FormularioDeAdicaoProdutoPage informarnomeDoProduto (String produtoNome){
    navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

    return this;
}

    public FormularioDeAdicaoProdutoPage informarValorProduto (String valorProduto){
        navegador.findElement(By.name("produtovalor")).sendKeys(valorProduto);

        return this;
    }
    public FormularioDeAdicaoProdutoPage informarCoresProduto (String produtoCores){
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);

        return this;
    }

    public ListaDeProdutoPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type = 'submit']")).click();

        return new ListaDeProdutoPage(navegador);
    }

    public FormularioDeEdicaoProdutoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type = 'submit']")).click();

        return new FormularioDeEdicaoProdutoPage(navegador);

    }


}
