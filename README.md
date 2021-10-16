# Credit Cards API
Java API que devuelve tarjetas de crédito según el perfil del usuario de acuerdo con el cuadro siguiente:

![credit cards table](https://github.com/ungeimer/creditcards-api/blob/master/img/creditcardTable.jpg?raw=true)

## Importar el proyecto
* Asegurate de tener instalado:
    * `Java (min. version 8)` 
    * `Maven` 
* Visual Studio Code:
    * `Extension Pack for Java:` https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack
    * `Spring Boot Extension Pack:` https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack
    *`Lombok Annotations Support for VS Code:` https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok
    

### Ejecutando el código
* La clase `CreditcardapiApplication.java` es la clase principal. Ejecuta su método `main`.

## Usando la API
`/profile?information={ userinformation }`

### Ejemplo
# Input 
`/profile?information=Sports,69,20000`
# Output 
`Martí Clasica Citibanamex, América Deporteísmo, Pumas Deporteísmo, Toluca Deporteísmo, La verde Deporteísmo`

![Postman](https://github.com/ungeimer/creditcards-api/blob/master/img/PostmanTest.jpg?raw=true)

* Si pasas algún dato válido, te retornará las tarjetas de crédito.
* Si algún dato pasado no encaja en ningún perfil, no aparecerá ninguna tarjeta de crédito.


* ***creditcard***
Contiene las clases `models(POJOs)` y `repository` para el dominio CreditCard.

* ***Profile***
Contiene las clases `Controlador` y `Servicio`, que contienen las solicitudes/enrutadores de la API y juntas brindan las reglas y la lógica del negocio.

* ***`CreditcardapiApplication` y `CreditcardapiApplicationConfig`***
Estas son las clases runner de la API.


