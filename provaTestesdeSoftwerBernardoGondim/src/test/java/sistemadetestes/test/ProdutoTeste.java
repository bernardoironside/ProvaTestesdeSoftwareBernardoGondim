package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTeste extends BaseTest  {

    private static ProdutoPO produtoPage;
    private static WebDriver driver;

    @BeforeClass
    public static void prepararTestes() {
        // Inicializar o driver (isso pode variar dependendo do seu setup)
        driver = new ChromeDriver(); // Exemplo com ChromeDriver
        produtoPage = new ProdutoPO(driver);
    }

    @Before
    public void prepararTestesParaCadaFuncao() {
        driver.navigate().refresh();
    }

    @Test
    public void TC001_VoltarAoLogin() {
        // Testa se o título da página está correto antes de clicar no link
        assertEquals("Controle de Produtos", produtoPage.obterTituloPagina());
        
        // Clica no link de voltar
        ((Object) produtoPage.linkVoltar).click(); 
        
        // Verifica se o título da página mudou para "Login"
        assertEquals("Login", produtoPage.obterTituloPagina());
    }

    @Test
    public void TC003_AbrirTelaDeCadastroAoClicarUmaVez() {
        // Verifica se o menu de cadastro está invisível
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertFalse(produtoPage.menuDeCadastroVisivel());
        
        // Clica no botão de criação
        produtoPage.botaoCriar.click(); 
        
        // Verifica se o menu de cadastro se tornou visível
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertTrue(produtoPage.menuDeCadastroVisivel());
    }

    private void assertTrue(char[] menuDeCadastroVisivel) {
		// TODO Auto-generated method stub
		
	}

	private void assertFalse(char[] menuDeCadastroVisivel) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void TC004_FecharTelaDeCadastroAoClicarEmSair() {
        // Verifica que o menu de cadastro está inicialmente invisível
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertFalse(produtoPage.menuDeCadastroVisivel());
        
        // Clica no botão de criação para abrir o menu de cadastro
        ((Object) produtoPage.botaoCriar).click();
        
        // Verifica se o menu de cadastro está visível
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertTrue(produtoPage.menuDeCadastroVisivel());
        
        // Clica no botão de sair duas vezes (baseado no comportamento da tabela)
        ((Object) produtoPage.botaoSair).click();
        ((Object) produtoPage.botaoSair).click(); 
        
        // Verifica que o menu de cadastro está invisível após fechar
        System.out.println(produtoPage.menuDeCadastroVisivel());
        assertFalse(produtoPage.menuDeCadastroVisivel());
    }

    // Fechar o driver após os testes
    @AfterClass
    public static void fecharDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}