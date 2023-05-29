package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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

        driver.quit();
    }


    @Test
    public void test01(){

        // 1- amazon anasayfa gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();


        // 2- nutella icin arama yaptirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);


        /*
            CDwindow-93FC2E5D16C352803FB4871E76EE5538

            bu kod acilan sayfanin uniqe hash kodudur
            Selenium sayfalar arasi geciste bu window handle degerini kullanir

            eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
            su an da bulundugumuz sayfaya gecmek istiyorsak
            driver.switchTo().window("CDwindow-93FC2E5D16C352803FB4871E76EE5538");
            bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz


         */

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi= driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline'][1]"));
        driver.switchTo().newWindow(WindowType.TAB);

        /*
            bu komutu kullandigimizda driver otomatik olarak olusturulan
            new tab'a gecer
            yeni tab'da gorevi gerceklestirmek icin
            adimlari bastan almamiz gerekir
         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline'][1]"));
        


        // 4- yeni bir tab'da acilan urunun fiyatini yazin



    }
}
