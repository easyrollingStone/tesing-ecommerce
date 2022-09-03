import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(60 , TimeUnit.MILLISECONDS);
        driver.findElement(By.id("input-email")).sendKeys("lisaa@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("testing@123");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();

        WebElement LaptopsNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement AllLaptopsNotebooks = driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(LaptopsNotebooks).click(AllLaptopsNotebooks ).build().perform();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
        String Product_1= driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String Product_2= driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();
        if(Product_1.equals ("MacBook Air")){
            System.out.println("Same Product1");
        }
        else{
            System.out.println("Different Product1");
        }
        if(Product_2.equals ("MacBook Pro")){
            System.out.println("Same Product2");
        }
        else{
            System.out.println("Different Product2");
        }
       String Total = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[2]//td[2]")).getText();
        if (Total.equals("$3,000.00")){
            System.out.println("CheckOut Amount Correct ");
        }
        else {
            System.out.println("CheckOut Amount InCorrect ");
        }
        driver.findElement(By.xpath("//a[text()='Checkout']")).click();
        driver.quit();




    }
}
