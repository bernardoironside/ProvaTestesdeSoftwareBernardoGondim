package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		//loginPage.inputEmail.sendKeys("");
		//loginPage.escrever(loginPage.inputEmail, "");
		//loginPage.inputSenha.sendKeys("");
		
		//loginPage.buttonEntrar.click();
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
//		loginPage.inputEmail.sendKeys("");
		loginPage.escrever(loginPage.inputEmail, "teste");
		loginPage.inputSenha.sendKeys("");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
//		loginPage.inputEmail.sendKeys("");
		loginPage.escrever(loginPage.inputEmail, "");
		loginPage.escrever(loginPage.inputSenha, "teste");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailErradoESenhaErrada() {
		loginPage.escrever(loginPage.inputEmail, "teste");
		loginPage.escrever(loginPage.inputSenha, "teste");
		loginPage.buttonEntrar.click();

		String mensagem = loginPage.obterMensagem();

		assertEquals(mensagem, "E-mail ou senha inválidos");
	}

	@Test
	public void TC005_naoDeveLogarNoSistemaComEmailCertoESenhaErrada() {
		loginPage.escrever(loginPage.inputEmail, "admin@admin.com");
		loginPage.escrever(loginPage.inputSenha, "teste");
		loginPage.buttonEntrar.click();

		System.out.println("Pior caso:");

		String mensagem = loginPage.obterMensagem();
		assertEquals(mensagem, "E-mail ou senha inválidos");
	}

	@Test
	public void TC006_naoDeveLogarNoSistemaComEmailErradoESenhaCerta() {
		loginPage.escrever(loginPage.inputEmail, "teste");
		loginPage.escrever(loginPage.inputSenha, "admin@123");
		loginPage.buttonEntrar.click();

		String mensagem = loginPage.obterMensagem();
		assertEquals(mensagem, "E-mail ou senha inválidos");
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");
	}
}