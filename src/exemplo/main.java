package exemplo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import sentinela.Sentinela;

public class main {

	public static void main(String[] args) {

		// Caminho dos arquivos a serem testados
		File index = new File("SUT\\index.html");
		File index_diff = new File("SUT\\index_diff.html");

		// Inicializa firefox driver
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Vers�o original e alterada da p�gina a ser testada

		// Baseline
		driver.get(index.getAbsolutePath());

		// Vers�o alterada
		// driver.get(index_diff.getAbsolutePath());

		// Exemplos de webelement
		WebElement painelJumbo = driver.findElement(By.id("painelJumbo"));
		WebElement barraProgresso = driver.findElement(By.id("barraProgresso"));

		// -------------------USO DA API--------------------//

		// Cria uma inst�ncia da API, passando o path das imagens, o path onde o
		// relatorio ser� gerado e por �ltima a resolu��o que ir� trabalhar.

		Sentinela sentinela = new Sentinela(driver, "C:\\temp\\", "C:\\temp\\relatorio\\", 1920, 1080);

		// Valida uma p�gina inteira
		sentinela.validate("Pagina_Completa");

		// Gerar o relatorio final
		sentinela.generateReport();

		driver.quit();
	}
}