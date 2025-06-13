# SpringBoot REST API

API REST de gestion de inventario desarrollado en SpringBoot, implementando SpringSecurity y JWT para la gestion de autenticacion. El frontend del mismo se puede encontrar en: [API-Frontend](https://github.com/Ginazai/API-Frontend-1).




## Tecnologias utilizadas

El proyecto fue desarrollado utilizando las siguientes tecnologias:

*   JavaSE-1.8
*   SpringBoot 3.4.5
*   Spring Security 6.2.0
*   Listado de dependencias en `pom.xml`
## Instalacion

Las instrucciones de instalacion son especificamente para el entorno en el que fue desarrollado el proyecto (Eclipe IDE).
#### Pre-requisitos:

1.  Desde **Eclipse Marketplace** instale **Spring Tools (aka Spring Tool Suite) 4.30.0**.
2.  MS SQL Server 2019.
3.  **SQL Server Management Studio 20** para facilitar la gestion de la base de datos.

* Alternativamente se puede utilizar otra base de datos, pero se debera configurar la dependencia en el `pom.xml` asi como la configuracion en `application.properties`.

1. Cree un nuevo "Spring Starter Project" en Eclipse.
2. Asegurese de que contenga los siguientes parametros:
* Type: Maven
* Packaging: Jar
* Java Version: 17
* Language: Java
* Group: `com.dashboard`
* Package: `com.dashboard`
3. Navegue a la carpeta del proyecto y reemplace el contenido por el que se encuentra en este repositorio.
\
**Nota:** Ajuste las configuraciones del usuario y contraseña en `application.properties` segun lo configurado en MS SQL Server.
\
\
El proyecto contiene los queries utilizados en SQL Server en la carpeta `SQLServerQueries`, especificamente:
1.  Un archivo `.txt` para flexibilidad de uso.
2.  5 archivos (del 0 al 4) enumerados por orden de uso.
\
**Importante:** El ultimo query debe ser ejecutado luego de ejecutar `POST register` en la coleccion de **Postman** para conferir los permisos administrativos al usuario recien registrado


## Pruebas

Se incluye una coleccion de **Postman** ([`Outputs API.postman_collection.json`](https://github.com/Ginazai/Spring-JPA-Test-API/blob/master/Outputs%20API.postman_collection.json)) que puede ser descargada y cargada a Postman respectivamente para su ejecucion. 

**Nota:** la coleccion cuenta con un `script` para manejar la autenticacion por lo que basta con darle _run_ a la misma. 


## API Reference

#### Registrarse
```http
  POST /register
```
Estructura esperada:
```json
{
    "name" : "name lastname",
    "username" : "username",
    "password" : "abc123"
}
```
#### Login
```http
  POST /login
```
Estructura esperada:
```json
{
    "username" : "username",
    "password" : "abc123"
}
```
Para todas las siguientes consultas la autenticacion es requerida:
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `JWT token` | `string` | **Required**. El token proporcionado al iniciar sesion |

#### Obtener todos los productos
```http
  GET /productos
```
#### Obtener un producto

```http
  GET /productos/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del producto |

#### Crear un producto
```html
  POST /productos
```
Estructura esperada:
```json
{
    "name": "test",
    "price": 5.99,
    "tags": "",
    "active": false
}
```
#### Actualizar un producto
```html
  POST /productos/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del producto |

#### Borrar un producto
```html
  DELETE /productos/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del producto |

#### Obtener todas las categorias
```html
  GET /categorias
```
#### Obtener una categoria
```html
  GET /categorias/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id de la categoria|

#### Crear una categoria
```html
  POST /categorias
```
Estructura esperada:
```json
{
    "name" : "sample category",
    "active" : true
}
```
#### Actualizar una categoria
```html
  PUT /categorias/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id de la categoria |

#### Borrar una categoria
```html
  DELETE /categorias/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id de la categoria |

**Importante:** para las siguientes consultas se debe estar autenticado como administrador.
#### Obtener todos los usuarios
```html
  GET /usuarios
```
#### Obtener un usuario
```html
  GET /usuarios/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del usuario |

#### Crear usuario
```html
  POST /usuarios
```
Estructura esperada:
```json
{
    "name" : "test user",
    "username" : "sampleusername",
    "password" : "12345"
}
```
#### Actualizar usuario
```html
  PUT /usuarios/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del usuario |

#### Borrar usuario
```html
  DELETE /usuarios/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del usuario |
