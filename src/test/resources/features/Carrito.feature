@Carrito
Feature: Compra de un articulo con Tarjeta de Credito
  Yo como usuario de la tienda DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer un tramite personal


  @Carrito1
  Scenario: Ingreso de datos de Tarjeta para compra
    Given la pagina DemoGuru esta disponible
    When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono una cantidad de productos al carrito y le doy comprar
    Then ingreso los datos de la tarjeta
