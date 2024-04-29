import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsTests {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

        @BeforeAll
        static void setupAll() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setup() {
            driver = new ChromeDriver();
            driver.get("https://www.mts.by/");
            agreeWithCookieIfDisplayed();
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

    @DisplayName("Проверка названия блока")
    @Test
    void testRechargeBlock() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id='pay-section']//h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assert blockTitle.isDisplayed();
        assert blockTitle.getText().equals(expectedTitle);
    }

    @DisplayName("Проверка наличия логотипов платёжных систем")
    @Test
    void testRechargeBlockPaymentSystem() {
        List<WebElement> paymentSystemLogos = driver.findElements(By.xpath("//*[@id='pay-section']//img"));
        assert !paymentSystemLogos.isEmpty();
    }

    @DisplayName("Проверка работы ссылки «Подробнее о сервисе")
    @Test
    void testRechargeBlockMoreDetails() {
        WebElement moreDetailsLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        assert moreDetailsLink.isDisplayed();
        moreDetailsLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals(expectedUrl);
    }

    void agreeWithCookieIfDisplayed() {
        WebElement cookieWrapperAgree = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        if (cookieWrapperAgree.isDisplayed()) {
            cookieWrapperAgree.click();
        }
    }

    @DisplayName("Заполнение полей и проверка работы кнопки «Продолжить»")
    @Test
    void testRechargeBlockContinueButton() {
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        sumField.sendKeys("100");

        WebElement emailField = driver.findElement(By.xpath("//*[@id='connection-email']"));
        emailField.sendKeys("info1234@gmail.com");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='bepaid-app']")));

        assert dialog.isDisplayed();
    }
}
