package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

//Padrão para criar pago Objects: Sempre deve de ter uma atributo da classe que de tipo WebDriver e tenha um construtor da
// classe que pegue um atribito de fora e jogue dentro do atributo do page object
public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

       public LoginPage informarOUsuario(String usuario) {
        //Preenchendo campo usuário
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }
    public LoginPage informarASenha(String senha) {
        //Preenchendo campo senha
       navegador.findElement(By.cssSelector("label[for='senha']")).click();
       navegador.findElement(By.id("senha")).sendKeys(senha);

       return this;
       }

    //Aqui estou clicando em no botão login e indo para a nova pagina de lista de produtos
    public ListaDeProdutoPage submeterFormularDeLogin() {
     navegador.findElement(By.cssSelector("button[type='submit']")).click();

     return new ListaDeProdutoPage(navegador);

    }

}
