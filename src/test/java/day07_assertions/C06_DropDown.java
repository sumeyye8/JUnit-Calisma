package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {

    // Bir class oluşturun: DropDown
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    // False yazdırın


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

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
              //  dropdown'i locate etmek secmek icin yeterli degil, select objesi olusturmamiz gerekir
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");   //developer ne yazdiysa o alinir. String ifade seklinde "2" yazmis
        System.out.println(select.getFirstSelectedOption().getText());
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown options'i yazdırın
        List<WebElement> tumPsiyonlar= select.getOptions();
        for (WebElement each: tumPsiyonlar
             ) {
            System.out.println(each.getText());

        }

        // 5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        // False yazdırın
        int dropDownBoyut= tumPsiyonlar.size();
        if (dropDownBoyut==4){
            System.out.println("true");
        }else {
            System.out.println("false");

        } /*

            3 opsiyon vardi
            Please select an option  -> gorunen opsiyon 0 index'tir
            Option 1
            Option 2
            false
        */


    }









}
