package step;

import base.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {

    protected static WebDriver driver;


    @Before
    public void setUp() {

        ConfigFileReader configFileReader = new ConfigFileReader();
        String navegador = configFileReader.getProp("browser").toLowerCase();
        switch (navegador) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Navegador no soportado: " + navegador);
        }
        driver.manage().window().maximize();
        //Tiempo de espera implicito: Es una espera genérica para la ejecución completa
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @AfterStep
    public void screenshot(Scenario scenario) {
        //if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                System.err.println("Error al tomar la captura de pantalla: " + e.getMessage());
            }
        //}
    }


    @After
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        driver.quit();
    }
}
