package es.codeurjc.ais.tictactoe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;


public class SystemTests {

    private WebDriver plaierUan;
    private WebDriver plaierTchu;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //Otra forma de hacerlo
        //System.setProperty("webdriver.chrome.driver", "C:/Users/ORDENADOR/Downloads/chromedriver.exe");
        WebApp.start();
    }

    @AfterClass
    public static void teardownClass() {
        WebApp.stop();
    }

    @Before
    public void setupTest() {
        WebApp.start();
        plaierUan = new ChromeDriver();
        plaierTchu = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (plaierUan != null) {
            plaierUan.quit();
        }
        if (plaierTchu != null) {
            plaierTchu.quit();
        }
    }

    @Test
    public void uanWinsTest() throws InterruptedException {
        plaierUan.get("http://localhost:8080/");
        plaierTchu.get("http://localhost:8080/");
        // Ponemos los sleeps para que los tests se puedan seguir de forma visual
        // Solo pondremos los sleep en el primer test por motivos didacticos ya
        // que realentizan demasiado el proceso de pruebas
        TimeUnit.SECONDS.sleep(2);
        String nickname1 = "Paco";
        String nickname2 = "Pepe";
        plaierUan.findElement(By.id("nickname")).sendKeys(nickname1);
        plaierTchu.findElement(By.id("nickname")).sendKeys(nickname2);
        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("startBtn")).click();
        plaierTchu.findElement(By.id("startBtn")).click();
        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("cell-4")).click();
        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-3")).click();
        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-0")).click();
        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-6")).click();
        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-8")).click();
        TimeUnit.SECONDS.sleep(3);
        String message = "Paco wins! Pepe looses.";
        Assert.assertEquals(message, plaierTchu.switchTo().alert().getText());
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), message);
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), plaierTchu.switchTo().alert().getText());
    }

    @Test
    public void tchuWinsTest() throws InterruptedException {
        plaierUan.get("http://localhost:8080/");
        plaierTchu.get("http://localhost:8080/");
        // Ponemos los sleeps para que los tests se puedan seguir de forma visual
        // Solo pondremos los sleep en el primer test por motivos didacticos ya
        // que realentizan demasiado el proceso de pruebas
//        TimeUnit.SECONDS.sleep(2);
        String nickname1 = "Paco";
        String nickname2 = "Pepe";
        plaierUan.findElement(By.id("nickname")).sendKeys(nickname1);
        plaierTchu.findElement(By.id("nickname")).sendKeys(nickname2);
//        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("startBtn")).click();
        plaierTchu.findElement(By.id("startBtn")).click();
//        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("cell-4")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-3")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-1")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-0")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-8")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-6")).click();
//        TimeUnit.SECONDS.sleep(3);
        String message = "Pepe wins! Paco looses.";
        TimeUnit.SECONDS.sleep(1);
        //Necesitamos este sleep porque cuando se ejecutan todos los
        //tests juntos, daba timeout y no saltaba la alert()
        Assert.assertEquals(message, plaierTchu.switchTo().alert().getText());
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), message);
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), plaierTchu.switchTo().alert().getText());
    }

    @Test
    public void drawTest() throws InterruptedException {
        plaierUan.get("http://localhost:8080/");
        plaierTchu.get("http://localhost:8080/");
        // Ponemos los sleeps para que los tests se puedan seguir de forma visual
        // Solo pondremos los sleep en el primer test por motivos didacticos ya
        // que realentizan demasiado el proceso de pruebas
//        TimeUnit.SECONDS.sleep(2);
        String nickname1 = "Paco";
        String nickname2 = "Pepe";
        plaierUan.findElement(By.id("nickname")).sendKeys(nickname1);
        plaierTchu.findElement(By.id("nickname")).sendKeys(nickname2);
//        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("startBtn")).click();
        plaierTchu.findElement(By.id("startBtn")).click();
//        TimeUnit.SECONDS.sleep(2);
        plaierUan.findElement(By.id("cell-0")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-2")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-1")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-4")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-5")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-7")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-6")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierTchu.findElement(By.id("cell-3")).click();
//        TimeUnit.SECONDS.sleep(1);
        plaierUan.findElement(By.id("cell-8")).click();
//        TimeUnit.SECONDS.sleep(3);
        String message = "Draw!";
        Assert.assertEquals(message, plaierTchu.switchTo().alert().getText());
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), message);
        Assert.assertEquals(plaierUan.switchTo().alert().getText(), plaierTchu.switchTo().alert().getText());
    }
}
