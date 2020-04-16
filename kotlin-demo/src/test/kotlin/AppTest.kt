import kotlin.test.Test
import kotlin.test.assertEquals

import java.net.URL

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver

class AppTest {
    private var driver: WebDriver

    init {
        // That is a default port and url for Selenium Hub
        val url = URL("http://localhost:4444/wd/hub")
        // Instantiate RemoteWebDriver with ChromeOptions
        driver = RemoteWebDriver(url, ChromeOptions())
    }

    @Test
    fun testKotlinOrg() {
        // Visit kotlinlang.org website
        driver.get("https://kotlinlang.org")

        // Find element with "global-header-logo" class name
        val element = driver.findElement(By.className("global-header-logo"))

        // Test, if the found element's text is "Kotlin"
        assertEquals(element.text, "Kotlin")

        // Quit the driver to release resources
        driver.quit()
    }
}