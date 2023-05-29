package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.table.TableRowSorter;
import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    // 1.Bir class olusturun : RadioButtonTest
    // 2.Gerekli yapiyi olusturun ve asagidaki görevi tamamlayin
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
      driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // - “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // - “radio buttons” elementlerini locate edin
        WebElement kadınButon= driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButon=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButon=driver.findElement(By.xpath("//input[@value='-1']"));

        // - Secili degilse cinsiyet butonundan size uygun olani secin

        Thread.sleep(3000);

        if (!erkekButon.isSelected()){
            erkekButon.click();
        }

        Thread.sleep(3000);

    }
}
