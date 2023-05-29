package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HandleIframe {

    // Bir class olusturun: IframeTest
    // https://the-internet.herokuapp.com/iframe adresine gidin.
    // Bir metod olusturun: iframeTest
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    // Text Box’a “Merhaba Dunya!” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    // dogrulayin ve konsolda yazdirin.


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

    @After
    public void tearDown(){
        //driver.quit();
    }


    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


        // Bir metod olusturun: iframeTest
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement baslikElementi= driver.findElement(By.xpath("//h3")); // basina // koydugumuz icin xpath'tir ,koymasaydik By.tagName derdik
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());   // yaziyi konsola yazdirmak icin



        // Text Box’a “Merhaba Dunya!” yazin

            /*
                text box'i dogru locate etmemize ragmen driver'i bulamadi
                bunun uzerine HTML kodlari inceleyince text box'in aslinda bir IFrame icerisinde oldugunu gorduk
                bu durumda once iframe'i locate edip switchTo() ile o iframe'e gecmeliyiz

             */

        WebElement iFrameElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);    // frame secerken webelement olani sectik

        WebElement textKutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya!");


        /*
            link yazi elementini dogru locate etmemize ragmen yazdirmadi
            cunku yukarida iFrame'e gecis yapmistik
            once oradan cikmamiz gerek
         */

        driver.switchTo().defaultContent();
        WebElement linkYaziElementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(5000);


        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin.



    }
}
