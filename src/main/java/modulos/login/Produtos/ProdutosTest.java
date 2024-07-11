package modulos.login.Produtos;

import Paginas.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName( "Teste Web do Modulo de Produtos")
public class ProdutosTest {
    private WebDriver navegador;
    @BeforeEach
    public void beforeEach(){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //vou maximar a tela
       this. navegador.manage().window().maximize();

        //vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

            }

    @Test
    @DisplayName("Nao é Permitido Registrar Produto Com Valor Igual A Zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
            String mensagemApresentada =  new LoginPage(navegador)
                 .informarOUsuario("admin")
                 .informarASenha("admin")
                 .submeterFormularDeLogin()
                 .acessarOFormularioDeAdicaoDeNovoProduto()
                 .informarnomeDoProduto("Mouse")
                 .informarValorProduto("000")
                 .informarCoresProduto("Preto, amarelo")
                 .submeterFormularioDeAdicaoComErro()
                 .capturarMensagemApresentada();

          Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }
      @Test
      @DisplayName("Nao é Permitido Registrar Produto Com Valor maior que 7000.01")
      public void TestNaoEPermitidoRegistrarProdutoComValorMaiorQue700001(){
             String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarnomeDoProduto("cadeira")
                .informarValorProduto("700001")
                .informarCoresProduto("cinza,branca,amarela")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

      }

     @Test
     @DisplayName("Posso adicionar produtos que estejam na faixa de 0,00 até 7000.00")
     public void PossoAdicionarProdutosComValorUmCentavoASeteMilReais(){
       String mensagemApresentada =  new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarnomeDoProduto("monitor")
                .informarValorProduto("150000")
                .informarCoresProduto("cinza,branca,amarela")
                .submeterFormularioDeAdicaoComSucesso()
               .capturarMensagemApresentada();

       //Produto adicionado com sucesso
         Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

         }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de 7000.00")
    public void PossoAdicionarProdutosvalorDSeteMilReais(){
        String mensagemApresentada =  new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarnomeDoProduto("monitor")
                .informarValorProduto("700000")
                .informarCoresProduto("cinza,branca,amarela")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        //Produto adicionado com sucesso
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @AfterEach
    public void afterEach() {
        //vou fechar navegador
        navegador.quit();
    }

}
