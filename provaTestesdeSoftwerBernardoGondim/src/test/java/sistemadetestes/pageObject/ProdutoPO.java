package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutoPO extends BasePO {

    // Campos da página de cadastro de produto
    @FindBy(id = "nomeProduto")
    public WebElement inputNomeProduto;

    @FindBy(id = "descricaoProduto")
    public WebElement inputDescricaoProduto;

    @FindBy(id = "quantidadeProduto")
    public WebElement inputQuantidadeProduto;

    @FindBy(id = "valorProduto")
    public WebElement inputValorProduto;

    @FindBy(id = "dataCadastroProduto")
    public WebElement inputDataCadastroProduto; // Novo campo: Data de Cadastro

    @FindBy(id = "btn-cadastrar")
    public WebElement buttonCadastrar;

    @FindBy(id = "btn-adicionar")  // Adicionado botão "Criar" a partir do HTML fornecido
    public WebElement buttonAdicionar;

    @FindBy(css = "form.form-produto>div.alert>span")
    public WebElement spanMensagem;

    // Campos da página de cadastro de valor
    @FindBy(id = "btn-cadastrar-valor")
    public WebElement buttonCadastrarValor;

    @FindBy(css = "form.form-valor>div.alert>span")
    public WebElement spanMensagemValor;

    // Campos da página de cadastro de código
    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "btn-cadastrar-codigo")
    public WebElement buttonCadastrarCodigo;

    @FindBy(css = "form.form-produto>div.alert>span")
    public WebElement spanMensagemCodigo;

    // Campos da página de cadastro de nome
    @FindBy(id = "btn-enviar")
    public WebElement buttonEnviar;

    @FindBy(id = "btn-voltar")
    public WebElement buttonVoltar;

    @FindBy(css = "form.form-nome>div.alert>span")
    public WebElement spanMensagemNome;

	public Object inputPesquisa;

	public Object divResultadoPesquisa;

	public Object linkVoltar;

	public Object botaoCriar;

	public Object botaoSair;

    /**
     * Construtor padrão para a criação de uma nova instância da página de cadastro de produto
     * @param driver Driver da página de cadastro de produto
     */
    public ProdutoPO(WebDriver driver) {
        super(driver); // Inicializa a classe base
        PageFactory.initElements(driver, this); // Inicializa os elementos
    }

    // Métodos gerais
    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    public String obterMensagemValor() {
        return this.spanMensagemValor.getText();
    }

    public String obterMensagemCodigo() {
        return this.spanMensagemCodigo.getText();
    }

    public String obterMensagemNome() {
        return this.spanMensagemNome.getText();
    }

    public String obterTituloPagina() {
        return driver.getTitle();
    }

    // Métodos específicos para cada página
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    // Ações para cadastrar produto
    public void executarAcaoDeCadastrarProduto(String nomeProduto, String descricaoProduto, String quantidadeProduto, String valorProduto, String dataCadastroProduto) {
        escrever(inputNomeProduto, nomeProduto);
        escrever(inputDescricaoProduto, descricaoProduto);
        escrever(inputQuantidadeProduto, quantidadeProduto);
        escrever(inputValorProduto, valorProduto);
        escrever(inputDataCadastroProduto, dataCadastroProduto);  // Novo campo
        buttonCadastrar.click();
    }

    // Ações para cadastrar valor
    public void executarAcaoDeCadastrarValor(String valorProduto) {
        escrever(inputValorProduto, valorProduto);
        buttonCadastrarValor.click();
    }

    // Ações para cadastrar código
    public void executarAcaoDeCadastrarCodigo(String codigo, String nome, String quantidade, String valor) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        buttonCadastrarCodigo.click();
    }

    // Ações para cadastrar nome
    public void executarAcaoComNome(String nome) {
        escrever(inputNome, nome);
        buttonEnviar.click();
    }

    // Ação para voltar à tela de login
    public void voltarParaLogin() {
        buttonVoltar.click();
    }

    // Ação para clicar no botão "Criar" que foi adicionado no HTML
    public void clicarBotaoAdicionar() {
        buttonAdicionar.click();  // Clica no botão "Criar" na tela
    }

	public String obterResultadoDaPesquisa() {
		// TODO Auto-generated method stub
		return null;
	}

	public void pesquisar(String string) {
		// TODO Auto-generated method stub
		
	}

	public char[] menuDeCadastroVisivel() {
		// TODO Auto-generated method stub
		return null;
	}
}