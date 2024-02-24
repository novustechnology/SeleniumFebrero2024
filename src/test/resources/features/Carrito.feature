@Carrito
Feature: Compra de un articulo con Tarjeta de Credito
  Yo como usuario de la tienda DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer un tramite personal

  Background: Generar Tarjeta
    Given la pagina DemoGuru esta disponible
    When doy click en generar tarjeta


  @Carrito1
  Scenario: Ingreso de datos de Tarjeta para compra
    #Given la pagina DemoGuru esta disponible
    #When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono una cantidad de productos al carrito y le doy comprar
    Then ingreso los datos de la tarjeta

  @Carrito2
  Scenario Outline: Compro 2 veces
    #Given la pagina DemoGuru esta disponible
    #When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono una cantidad "<cantidad>" de productos al carrito y le doy comprar
    And ingreso los datos de la tarjeta
    Then validamos que el pago fue exitoso "Payment successfull!"
    Examples:
      | cantidad |
      | 3        |
      #| 5        |