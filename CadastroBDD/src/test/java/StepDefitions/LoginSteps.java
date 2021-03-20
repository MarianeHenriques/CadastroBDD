package StepDefitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class LoginSteps {
	
	WebDriver driver;
	
	
	public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }
	
	@Given("Estando na Pagina de Cadastro")
	public void estando_na_pagina_de_cadastro() throws IOException {
	
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\msilva16\\AppData\\Local\\Temp\\7zOC3F364A9\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		  driver.manage().window().maximize();
		  driver.get("http://advantageonlineshopping.com/#/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.get("http://advantageonlineshopping.com/#/register");
         

          TakesScreenshot ts=(TakesScreenshot)driver;
          java.io.File source =ts.getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(source, new java.io.File("./Screenshot/Registro.png"+getDate()));
	
	}
	

	@When("Inserir Nome de usuario, email, senha e confirmacao de senha")
	public void inserir_nome_de_usuario_email_senha_e_confirmacao_de_senha() throws IOException {
	    
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("usernameRegisterPage")).sendKeys("FernaM");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("emailRegisterPage")).sendKeys("Fernandm@gmail.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("passwordRegisterPage")).sendKeys("Fern00MM");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Fern00MM");
       
        
        TakesScreenshot ts=(TakesScreenshot)driver;
        java.io.File source =ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new java.io.File("./Screenshot/DadosCadatro.png"+getDate()));
	    
        
	}

	@And("Clicar no Checbox e acionar o botao registrar")
	public void clicar_no_checbox_e_acionar_o_botao_registrar() throws IOException {
		 //CheckBox
		 WebElement ele = driver.findElement(By.name("i_agree"));
         Actions action = new Actions(driver);
         action.moveToElement(ele).perform();
         driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
         driver.findElement(By.name("i_agree")).click();
        //Confirmar
         driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
         driver.findElement(By.id("register_btnundefined")).click();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
       
        TakesScreenshot ts=(TakesScreenshot)driver;
 		java.io.File source =ts.getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(source, new java.io.File("./Screenshot/PerfilUsuario.png"+getDate()));
 	
	}
	

	@Then("Validar usuario Cadastrado")
	public void validar_usuario_cadastrado() throws IOException  {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".containMiniTitle")).click();
		driver.findElement(By.cssSelector("#loginMiniTitle > .option:nth-child(1)")).click();
		
		String Perfil = driver.findElement(By.linkText("MY ACCOUNT")).getText();
		
		Assert.assertEquals("MY ACCOUNT", Perfil);
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		java.io.File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new java.io.File("./Screenshot/PerfilUsuario.png"+getDate()));
	
	}


}
