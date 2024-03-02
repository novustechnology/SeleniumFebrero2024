package page;

import base.BasePage;
import base.ConfigFileReader;
import io.cucumber.datatable.DataTable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FormularioPage extends BasePage {
    public FormularioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String CSV_FILE_PATH = "src/test/resources/data/test.csv";

    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(xpath = "//img[@alt='Loader']")
    private WebElement loader;

    @FindBy(id = "nombre")
    private WebElement txtNombre;

    @FindBy(id = "apellido")
    private WebElement txtApellido;

    @FindBy(xpath = "//input[starts-with(@id,'mobile_')]")
    private WebElement txtNroTelefono;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "department")
    private WebElement cbDepartamento;

    @FindBy(id = "picture")
    private WebElement btnImagen;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnEnviar;

    @FindBy(id = "infoModalLabel")
    private WebElement lblInfoPersonal;

    public void ingresarUrl() {
        driver.get(configFileReader.getProp("url1"));
    }

    public void ingresarDatosFormulario(DataTable dataTable) {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            txtNombre.sendKeys(lista.get(i).get("Nombre"));
            txtApellido.sendKeys(lista.get(i).get("Apellido"));
            driver.findElement(By.xpath("//label[text()='" + lista.get(i).get("Pasatiempos") + "']")).click();
            driver.findElement(By.xpath("//label[text()='" + lista.get(i).get("Género") + "']")).click();

        }
    }


    public void ingresarTelefonoYCorreo(String email) {
        String numeroAleatorio = new Random().ints(10, 0, 10)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        txtNroTelefono.sendKeys(numeroAleatorio);
        txtEmail.sendKeys(email);
    }

    public void seleccionarDepartamentoCiudad(String departamento) {
        new Select(cbDepartamento).selectByValue(departamento);
        new Select(driver.findElement(By.id("city"))).selectByIndex(5);
    }

    public void seleccionarComandoSelenium() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(driver.findElement(By.xpath("//option[text()='Browser Commands']")))
                .click(driver.findElement(By.xpath("//option[text()='Navigation Commands']")))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void cargarImagen() throws InterruptedException {
        btnImagen.sendKeys("D:\\Proyectos Intellij\\SeleniumFebrero2024\\src\\test\\resources\\data\\cucumber.png");
        Thread.sleep(5000);
    }

    public void clickEnviar() {
        btnEnviar.click();
    }

    public String validarMensajeInformacion() {
        wait.until(ExpectedConditions.visibilityOf(lblInfoPersonal));
        return lblInfoPersonal.getText();
    }

    public String validarMensajeError() {
        wait.until(ExpectedConditions.invisibilityOf(loader));
        btnEnviar.click();
        String mensajeError = txtApellido.getAttribute("validationMessage");
        System.out.println("Mensaje de Error: " + mensajeError);
        return mensajeError;

    }

    public void ingresarDatosCsv() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(loader));
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            for (CSVRecord csvRecord : csvParser) {
                txtNombre.sendKeys(csvRecord.get("Nombre"));
                txtApellido.sendKeys(csvRecord.get("Apellido"));
                driver.findElement(By.xpath("//label[text()='" + csvRecord.get("Pasatiempos") + "']")).click();
                driver.findElement(By.xpath("//label[text()='" + csvRecord.get("Género") + "']")).click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
