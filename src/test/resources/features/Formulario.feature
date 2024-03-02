Feature: Automatización de Formulario

  @Formulario
  Scenario Outline: Ingreso de Datos
    Given ingreso a la pagina de NovusTechnology
    And ingreso los datos del formulario
      | Nombre | Apellido | Pasatiempos | Género    |
      | York   | Correa   | Deportes    | Masculino |
    And ingresamos el numero de telefono y correo electronico "<correoElectronico>"
    And seleccionamos "<Departamento>" y la primera ciudad
    And selecciono los comandos de selenium y cargo una imagen
    Then hacemos click en el boton enviar y valida el mensaje "Información Personal"
    Examples:
      | correoElectronico    | Departamento |
      | yorkcorrea1@test.com | LIMA         |
      #| yorkcorrea2@test.com | ICA          |


  @Error
  Scenario: Validar mensaje de error
    Given ingreso a la pagina de NovusTechnology
    Then valido el mensaje de error "Este campo es obligatorio"

  @Toast
  Scenario: Validar Toast de la página NovusTechnology
    Given ingreso a la pagina de NovusTechnology
    When doy click al Toast
    Then valido que se muestre

  @Alerta
  Scenario: Validar Alerta de la página NovusTechnology
    Given ingreso a la pagina de NovusTechnology
    Then valido que al aceptar se abra una nueva ventana y si doy cancelar no haga nada

  @Csv
  Scenario: Ingreso de datos mediante Csv
    Given ingreso a la pagina de NovusTechnology
    Then ingreso los datos por csv
















