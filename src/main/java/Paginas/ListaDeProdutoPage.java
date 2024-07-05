package Paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ListaDeProdutoPage {
    private WebDriver navegador;

    public ListaDeProdutoPage(WebDriver navegador) {

        this.navegador = navegador;

        }

        //vou para a tela de cadastro de produto
        public FormularioDeAdicaoProdutoPage acessarOFormularioDeAdicaoDeNovoProduto() {
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoProdutoPage(navegador);
    }

    //vou validar que a mensagem de erro foi aprensentado
        public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
            }

}


