import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@DisplayName("Тестирование полей сайта https://www.mts.by")
public class TestMtsContinue {
    WebDriver driver;

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
    }


    @DisplayName("Заполнение полей для варианта 'Услуги связи' и проверка реквизитов во всплывающем окне»")
    @Story("Test-1")
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
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='bepaid-iframe']")));

        driver.switchTo().frame(dialog);

        WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ng-tns-c45-1 ng-star-inserted']")));

        WebElement cardNumberLabel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-star-inserted') and contains(., 'Срок действия') and not(contains(., 'CVC'))]")));
        WebElement cardNumberLabel3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-star-inserted') and contains(., 'Имя держателя (как на карте)')]")));

        WebElement cardNumberLabel4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-star-inserted') and contains(., 'CVC') and not(contains(., 'Срок действия'))]")));

        WebElement cardNumberLabel5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(., '100.00 BYN') and not(contains(., 'Оплата:'))]")));

        WebElement cardNumberLabel6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '100.00 BYN')]")));

        WebElement cardNumberLabel7 = driver.findElement(By.xpath("//*[contains(text(), '375297777777')]"));

        String expectedTitle = "Номер карты";
        String expectedTitle2 = "Срок действия";
        String expectedTitle3 = "Имя держателя (как на карте)";
        String expectedTitle4 = "CVC";
        String expectedTitle5 = "100.00 BYN";

        assert cardNumberLabel.getText().equals(expectedTitle);
        assert cardNumberLabel2.getText().equals(expectedTitle2);
        assert cardNumberLabel3.getText().equals(expectedTitle3);
        assert cardNumberLabel4.getText().equals(expectedTitle4);
        assert cardNumberLabel5.getText().equals(expectedTitle5);
        assert cardNumberLabel6.getText().equals(expectedTitle5);
        Assertions.assertTrue(cardNumberLabel7.isDisplayed(), "Элемент не отображается");
    }

    @DisplayName("Проверка наличия логотипов платёжных систем во всплывающем окне при выборе 'Услуги связи'")
    @Attachment
    @Story("Test-2")
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
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='bepaid-iframe']")));

        driver.switchTo().frame(dialog);

        List<WebElement> paymentSystemLogos = driver.findElements(By.xpath("//app-card-page//img[contains(@src, 'payment')]"));

        assert !paymentSystemLogos.isEmpty();
    }

    @DisplayName("Проверка полей варианта оплаты 'Услуги связи'")
    @Story("Test-3")
    @Test
    void testValidationForServicePayment() {

        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkEmptyFieldPlaceholder("//*[@id='connection-sum']", "Сумма");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }

    @DisplayName("Проверка полей варианта оплаты 'Домашний интернет'")
    @Story("Test-4")
    @Test
    void testValidationForServicePayment2() {

        WebElement servicePaymentButton = driver.findElement(By.xpath("//*[@id='pay-section']//button/span[1]"));
        servicePaymentButton.click();

        WebElement servicePaymentButton2 = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[2]/p"));
        servicePaymentButton2.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkEmptyFieldPlaceholder("//*[@id='connection-sum']", "Сумма");
        checkEmptyFieldPlaceholder("//*[@id='connection-email']", "E-mail для отправки чека");
        checkEmptyFieldPlaceholder("//*[@id='connection-phone']", "Номер телефона");
    }

    @DisplayName("Проверка полей варианта оплаты 'Рассрочка'")
    @Step("Test-5")
    @Test
    void testValidationForServicePayment3() {

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
    @Story("Test-6")
    @Test
    void testValidationForServicePayment4() {

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
