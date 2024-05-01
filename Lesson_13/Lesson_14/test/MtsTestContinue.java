import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsTestContinue {
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

    void agreeWithCookieIfDisplayed() {
        WebElement cookieWrapperAgree = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        if (cookieWrapperAgree.isDisplayed()) {
            cookieWrapperAgree.click();
        }
    }

    void checkEmptyFieldPlaceholder(String fieldXpath, String expectedPlaceholder) {
        WebElement field = driver.findElement(By.xpath(fieldXpath));
        String actualPlaceholder = field.getAttribute("placeholder");
        assert actualPlaceholder.equals(expectedPlaceholder) : "Ожидаемая надпись: " + expectedPlaceholder + ", Фактическая надпись: " + actualPlaceholder;
        System.out.println(actualPlaceholder);
    }

    @DisplayName("Заполнение полей для варианта 'Услуги связи' и проверка работы кнопки «Продолжить»")
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

        //WebElement cardNumberField = dialog.findElement(By.xpath("//*[@id=\"cc-number\"]"));
        String expectedTitle = "Номер карты";
        System.out.println(dialog.getText());
        assert dialog.isDisplayed();
        assert dialog.getText().equals(expectedTitle);
    }

    @Test
    void testWindow(){
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
        dialog.findElement(By.xpath("//*[contains(text(),'Оплата: Услуги связи')]']"));

    }

    @DisplayName("Проверка наличия логотипов платёжных систем в окне 'Услуги связи'")
    @Test
    void testRechargeBlockPaymentSystem() {

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
        dialog.findElement(By.xpath("/html/body/app-root//img[2]"));
        List<WebElement> paymentIcons = dialog.findElements(By.xpath(".//img[contains(@class, 'payment-icon')]"));
        Assertions.assertTrue(paymentIcons.size() > 0, "Иконки платёжных систем не найдены");
    }


    @DisplayName("Проверка полей варианта оплаты 'Услуги связи' ")
    @Test
    void testValidationForServicePayment() {
        driver.get("https://www.mts.by/");

        // Нажимаем на кнопку выбора оплаты услуг связи
        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем надписи в незаполненных полях
        checkEmptyFieldPlaceholder("//*[@id='connection-sum']", "Сумма");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }

    @DisplayName("Проверка полей варианта оплаты 'Домашний интернет'")
    @Test
    void testValidationForServicePayment2() {
        driver.get("https://www.mts.by/");

        // Нажимаем на кнопку выбора оплаты услуг связи
        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        WebElement servicePaymentButton2 = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[2]/p"));
        servicePaymentButton2.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем надписи в незаполненных полях
        checkEmptyFieldPlaceholder("//*[@id='connection-sum']", "Сумма");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }

    @DisplayName("Проверка полей варианта оплаты 'Рассрочка'")
    @Test
    void testValidationForServicePayment3() {
        driver.get("https://www.mts.by/");

        // Нажимаем на кнопку выбора оплаты услуг связи
        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        WebElement servicePaymentButton2 = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[3]/p"));
        servicePaymentButton2.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkEmptyFieldPlaceholder("//*[@id=\"score-instalment\"]", "Номер счета на 44");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }

    @DisplayName("Проверка полей варианта оплаты 'Задолженность'")
    @Test
    void testValidationForServicePayment4() {
        driver.get("https://www.mts.by/");

        // Нажимаем на кнопку выбора оплаты услуг связи
        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        WebElement servicePaymentButton2 = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[4]/p"));
        servicePaymentButton2.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkEmptyFieldPlaceholder("//*[@id=\"score-arrears\"]", "Номер счета на 2073");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }
}
