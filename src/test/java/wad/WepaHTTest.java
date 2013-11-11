/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author trantane
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WepaHTTest {

    private WebDriver driver;
    private String baseAddress;

    public WepaHTTest() {
    }

    @Before
    public void setUp() {
        this.driver = new HtmlUnitDriver();
        this.baseAddress = "http://localhost:8080/WepaHT/app/";
        
    }

    @Test
    public void alisaaKirjaIlmaKirjautumista() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        driver.get("http://localhost:8080/WepaHT/app/add");

//        // haetaan kenttä nimeltä tunnus
//        WebElement element = driver.findElement(By.name("name"));
//
//        // asetetaan kenttään arvo
//        element.sendKeys("Bob");
//
//        // lähetetään lomake
//        element.submit();

        Assert.assertTrue(driver.getPageSource().contains("Login with Username and Password"));
    }
@Test
    public void bkirjauduPalveluunVaarillaTunnuksilla() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        driver.get("http://localhost:8080/WepaHT/app/add");

        // haetaan kenttä nimeltä tunnus
        WebElement user = driver.findElement(By.name("j_username"));
        WebElement pass = driver.findElement(By.name("j_password"));
        // asetetaan kenttään arvo
        user.sendKeys("nsa");
        pass.sendKeys("asn");

        // lähetetään lomake
        user.submit();

        Assert.assertTrue(driver.getPageSource().contains("Your login attempt was not successful, try again."));
    }

    @Test
    public void ckirjauduPalveluunOikeillaTunnuksilla() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        driver.get("http://localhost:8080/WepaHT/app/add");

        // haetaan kenttä nimeltä tunnus
        WebElement user = driver.findElement(By.name("j_username"));
        WebElement pass = driver.findElement(By.name("j_password"));
        // asetetaan kenttään arvo
        user.sendKeys("nsa");
        pass.sendKeys("nsa");

        // lähetetään lomake
        user.submit();

        Assert.assertTrue(driver.getPageSource().contains("Logout"));
    }


@Test
    public void dLisaaKirja() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        driver.get("http://localhost:8080/WepaHT/app/add");

        // haetaan kenttä nimeltä tunnus
        WebElement user = driver.findElement(By.name("j_username"));
        WebElement pass = driver.findElement(By.name("j_password"));
        // asetetaan kenttään arvo
        user.sendKeys("nsa");
        pass.sendKeys("nsa");

        // lähetetään lomake
        user.submit();

        WebElement isbn =  driver.findElement(By.name("isbn"));
        isbn.sendKeys("9780980200447");
        
        isbn.submit();
        
        Assert.assertTrue(driver.getPageSource().contains("Slow reading"));
    }

@Test
    public void eTarkistaTiedot(){

    
        driver.get("http://localhost:8080/WepaHT/app/books/?search=");

        WebElement tiedot =  driver.findElement(By.linkText("Slow reading"));
        
        tiedot.click();
        Assert.assertTrue(driver.getPageSource().contains("John Miedema"));
    }

@Test
    public void gmuokkaaKirjanTietoja() {
    
    driver.get("http://localhost:8080/WepaHT/app/books/?search=");

        WebElement tiedot =  driver.findElement(By.linkText("Slow reading"));
        
        tiedot.click();
        WebElement siirry =  driver.findElement(By.linkText("Muokkaa kirjan tietoja"));
        siirry.click();
        
        WebElement user = driver.findElement(By.name("j_username"));
        WebElement pass = driver.findElement(By.name("j_password"));
        user.sendKeys("nsa");
        pass.sendKeys("nsa");
        user.submit();
        
        WebElement name =  driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("JepJep");
        name.submit();
        
        Assert.assertTrue(driver.getPageSource().contains("JepJep"));
        
}

@Test
    public void gpoistaKirja() {

        driver.get("http://localhost:8080/WepaHT/app/books/?search=");

        WebElement tiedot =  driver.findElement(By.linkText("JepJep"));
        
        tiedot.click();
        WebElement siirry =  driver.findElement(By.linkText("Poista kirja"));
        siirry.click();
        
        WebElement user = driver.findElement(By.name("j_username"));
        WebElement pass = driver.findElement(By.name("j_password"));
        user.sendKeys("nsa");
        pass.sendKeys("nsa");
        user.submit();
        
        WebElement poista =  driver.findElement(By.id("command"));
        poista.submit();
        
        Assert.assertFalse(driver.getPageSource().contains("JepJep"));
    }
}
// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
    // public void hello() {}
