package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoStep {


    @Given("la pagina DemoGuru esta disponible")
    public void laPaginaDemoGuruEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
    }

    @And("capturo los datos de la tarjeta")
    public void capturoLosDatosDeLaTarjeta() {
    }

    @And("selecciono una cantidad de productos al carrito y le doy comprar")
    public void seleccionoUnaCantidadDeProductosAlCarritoYLeDoyComprar() {
    }

    @Then("ingreso los datos de la tarjeta")
    public void ingresoLosDatosDeLaTarjeta() {
    }
}
