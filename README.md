SampleMifel - Prueba Tecnica
-----

> Esta prueba tecnica consiste en consumir la PokeApi y obtener 
> la información del Pokemon Ditto y mostrarla en formato JSON, 
> tambien es requerido que la se exponga un recurso que encripte 
> una cadena de caracteres utilizando el algoritmo *AES/CBC/PKCS5Padding*; 
> aunque no es solicitado un recurso para desencriptar el contenido 
> se genera uno para dicho fin. 

Iniciar Proyecto con maven
-

Se requiere tener Apache Maven instalado para descargar las dependencias y construir el proyecto

<code>_$_ mvn spring-boot:run</code>
o utilizar cualquier IDE integrado con Maven

Acceder a recursos con Token
--
1. Utilizar el Signup para generar un usuario y poder acceder a los recursos
2. Utilizar el Signip para generar un token con el usuario creado
3. Utilizar el HttpHeader **Authorization** y pegar el token generado. (Revisar en las Cookies de Signin)
4. Lanzar la petición al recurso deseado, verificando el Role de acceso


## Capaz utilizadas

    - api: Almacena la capa REST y sus recursos de comunicaón
    - config: Contiene los archivos de configuración
    - entities: Contiene las entidades SQL
    - pokemon: Contine el consumo de la Pokeapi
    - repository: Contiene los DynamicQuerys o capa SQL de alto y bajo nivel

Dependencias en __pom.xml__
- Spring Boot
- Spring Security
- Spring Web
- Spring JPA
- spring Security Oauth2
- Lombok
- H2


### Importar Postman Collection (RECOMENDADO)

Public URL: https://www.getpostman.com/collections/b9da70512c3504fcebe5

> Postman > import > Link > __public_url__ > continue


### Recursos Expuestos con sus Roles 

| Metodo | Controlador | Accion   | Role      |
|--------|-------------|----------|-----------|
| POST   | /auth       | /signup  | PUBLIC    |
| ...    | ...         | /signin  | PUBLIC    |
| ...    | ...         | /signout | PUBLIC    |
| POST   | /api/crypto | /encrypt | PUBLIC    |
| ...    | ...         | /decrypt | PUBLIC    |
| GET    | /api/person | /test    | PUBLIC    |
| POST   | ...         | /filter  | MODERATOR |
| ...    | ...         | /all     | ADMIN     |
