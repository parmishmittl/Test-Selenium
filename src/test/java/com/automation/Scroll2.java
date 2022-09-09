package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scroll2 {
    @Test
    public static void testAmazon() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\parkumar18\\IdeaProjects\\Test-SeleniumDemo\\Drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.amazon.in/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.findElement(By.className("hm-icon-label")).click();

        chromeDriver.findElement(By.linkText("TV, Appliances, Electronics")).click();

        chromeDriver.findElement(By.linkText("Televisions")).click();

        chromeDriver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[21]/ul/li[4]/span/a/div/label/i")).click();

        chromeDriver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).click();

        chromeDriver.findElement(By.linkText("Price: High to Low")).click();

        chromeDriver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div[2]/div[1]/h2")).click();


        String mainWindow = chromeDriver.getWindowHandle();
        Set<String> windows = chromeDriver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String newWindow = it.next();
            if (!mainWindow.equalsIgnoreCase(newWindow)) {
                chromeDriver.switchTo().window(newWindow);
            }

        }
        String about =
                chromeDriver.findElement(By.xpath("//div[@id='featurebullets_feature_div']/div/h1")).getAttribute("innerHTML");
        System.out.println(about);
        Assert.assertEquals(about, " About this item ");

        List<WebElement> productDescription =
                chromeDriver.findElements(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']"));
        for (WebElement product : productDescription) {
            System.out.println(product.getText());
        }
        chromeDriver.quit();
    }
}
