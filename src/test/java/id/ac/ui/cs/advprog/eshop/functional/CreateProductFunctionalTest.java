package id.ac.ui.cs.advprog.eshop.functional;

import id.ac.ui.cs.advprog.eshop.model.Product;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product/list", testBaseUrl, serverPort);
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        // User can go to create page
        WebElement createButton = driver.findElement(By.tagName("a"));
        createButton.click();

        // User can input productName and productQuantity
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();
        String name = "Sampo Cap Bambang";
        nameInput.sendKeys(name);

        WebElement qtyInput = driver.findElement(By.id("quantityInput"));
        qtyInput.clear();
        String qty = "100";
        qtyInput.sendKeys(qty);

        // User can submit
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        // Product created
        List<WebElement> product = driver.findElements(By.tagName("td"));
        Iterator<WebElement> elementIterator = product.iterator();
        assertTrue(elementIterator.hasNext());

        String productName = elementIterator.next().getText();
        assertEquals(name, productName);
        String productQty = elementIterator.next().getText();
        assertEquals(qty, productQty);
        assertFalse(elementIterator.hasNext());
    }
}
