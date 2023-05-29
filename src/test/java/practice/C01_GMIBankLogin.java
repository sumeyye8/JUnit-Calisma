package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {
    public static void main(String[] args) {

        // https://www.gmibank.com/ adresine gidin
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gmibank.com/");

        driver.close();
    }
}
