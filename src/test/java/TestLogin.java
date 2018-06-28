import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by 848257135 on 2018-4-29.
 */
public class TestLogin {
    @Test
    public void login_indexHtml(){
        //火狐浏览器的启动
        WebDriver driver;
        System.setProperty("webdriver.firefox.bin","E:\\firefox\\firefox.exe");
        //实例化一个Firefox对象
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/static/im/index.html");
        driver.findElement(By.id("j-account")).sendKeys("admin");
        driver.findElement(By.id("j-secret")).sendKeys("123456");
        driver.findElement(By.id("j-loginBtn")).click();
    }
}
