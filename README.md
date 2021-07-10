
# BancoWposs

Proyecto elaborado con Java framework Spring Boot, Spring Data JPA, MYSQL, Swagger

Para poder acceder a los endpoints http://localhost:8081/swagger-ui.html#
en el cual se encuentra los endpoints del controlador usuario
registrar es un metodo POST con la siguiente URL http://localhost:8081/registrar 
deposito es un metodo POST con la siguiente URL http://localhost:8081/deposito
retiro es un metodo POST con la siguiente URL http://localhost:8081/retiro
Transferencia es un metodo POST con la siguiente URL http://localhost:8081/tranferencia
listar es un metodo GET con la siguiente URL http://localhost:8081/listar







----------Base de Datos----------------

la conexion a la base de datos es con mysql la cual debe tener una base de datos llamada "bancowposs", con la cual Spring Boot data JPA conecta la base de datos y crea las tablas con sus respectivas relaciones. las tablas que se crearan son las siguientes

-------------USUARIO----------------
     Long id;
    String nombre;
    TipoDocumentoEntity tipoDocumento;
    Integer identificacion;
    String celular;
    String email;
    String clave;
    boolean estado;
    String numeroCuenta;
    float monto;
    
------------TIPODOCUMENTO------------
    Long id;
    String nombre;



