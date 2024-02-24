package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ValidarPagoPage extends BasePage {
    public ValidarPagoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    private WebElement lblPayment;

    @FindBy(xpath = "//a[@class='button special']")
    private WebElement btnHome;

    public String validarMensajePago(){
        wait.until(ExpectedConditions.visibilityOf(lblPayment));
        String texto = lblPayment.getText();
        System.out.println(texto);
        return texto;
    }

    public boolean validarBoton(){
        return btnHome.isDisplayed();
    }

}
