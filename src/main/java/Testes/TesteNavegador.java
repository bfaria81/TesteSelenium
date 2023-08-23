package Testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TesteNavegador {
    private WebDriver driver;

    @BeforeMethod
    public void iniciar() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/brunofaria/Desktop/SENAI/Teste Sistemas/TesteSelenium/Driver");

    }

    @AfterMethod
    public void finalizar() {
        //Esse metodo ira fechar o navegador
        // driver.quit();
    }

    @Test
    public void AbrirNavegadorDoGoogle() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ava.fiep.digital/theme/badiumview/controller.php?_key=badiumview.factory.theme.fiep.app.login.index&_operation=apppage");

        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[1]/input")).sendKeys("0123456789");
        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[2]/div/input")).sendKeys("Senha");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[4]/label/input"));
        checkBox.click();

        WebElement botaoLogin = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[5]/button"));
        botaoLogin.click();

        WebElement msg = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div/div[1]"));
        boolean ismsg = msg.isDisplayed();
        Assert.assertTrue(ismsg);

    }

}


