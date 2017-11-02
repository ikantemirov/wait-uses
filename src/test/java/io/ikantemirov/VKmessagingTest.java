package io.ikantemirov;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VKmessagingTest {

    public WebDriver driver = new ChromeDriver();
    String randomMsg = "Hello from WebDriver " + RandomStringUtils.randomAlphanumeric(20);
    AccountData accountData = ConfigFactory.create(AccountData.class, System.getProperties());

    @Test
    public void vkWriteMessageToEroshenko() {
        driver.get("http://vk.com");
        driver.findElement(By.id("index_email")).sendKeys(accountData.login() + Keys.TAB + accountData.password() + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//[@id='l_msg']")));
        driver.findElement(By.xpath("//[@id='l_msg']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='im_dialogs_search']")));
        driver.findElement(By.xpath("//input[@id='im_dialogs_search']")).sendKeys("Артем Ерошенко");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-list-id='356736cr']")));
        driver.findElement(By.xpath("//li[@data-list-id='356736cr']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='im_editable0']")));
        driver.findElement(By.xpath("//div[@id='im_editable0']")).sendKeys(randomMsg + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'header-icon_search')]")));
        driver.findElement(By.xpath("//button[contains(@class,'header-icon_search')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='im_history_search']")));
        driver.findElement(By.xpath("//input[@id='im_history_search']")).sendKeys(randomMsg +Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(node(), '" + randomMsg +"') and contains(@class, 'text wall_module')]")));
        Assert.assertEquals("False", randomMsg, driver.findElement(By.xpath("//div[contains(node(), '" + randomMsg +"') and contains(@class, 'text wall_module')]")).getText());
    }
}
