# Proyecto Vuelos - Spring Boot

Este proyecto es un **API REST** para gestionar vuelos. Permite crear, actualizar, eliminar y consultar información de vuelos. El proyecto está desarrollado con **Spring Boot** y Java.

---

## Tecnologías utilizadas

- Java 17+
- Spring Boot 3+
- Maven
- Lombok
- Postman (para pruebas de la API)

---

## Estructura del proyecto

## 📁 Project Structure

- **controllers**: REST API endpoints
- **services**: Business logic
- **repositories**: In-memory data handling
- **models**: Domain models
- **dtos**: API response objects
- **exceptions**: Global exception handling
- **utils**: Utility classes
- **static**: Web resources (index.html)


markdown
Copiar código

---

## Endpoints disponibles

| Método | URL                | Descripción                           |
|--------|------------------|---------------------------------------|
| GET    | `/vuelos`         | Lista todos los vuelos con filtros opcionales |
| GET    | `/vuelos/{id}`    | Obtiene un vuelo por su ID            |
| POST   | `/vuelos`         | Crea un nuevo vuelo                   |
| PUT    | `/vuelos/{id}`    | Actualiza un vuelo existente          |
| DELETE | `/vuelos/{id}`    | Elimina un vuelo por su ID            |

### Filtros en GET `/vuelos`

- `empresa` → Filtra por la empresa del vuelo
- `lugarLlegada` → Filtra por lugar de llegada
- `fechaSalida` → Filtra por fecha de salida (formato: YYYY-MM-DD)
- `ordenarPor` → Ordenar resultados por `empresa`, `lugarLlegada`, `fechaLlegada`
- `orden` → Orden ascendente (`ASC`) o descendente (`DESC`)

---

## Ejemplos de peticiones (Postman)

### 1. Obtener todos los vuelos
GET http://localhost:8080/vuelos

shell
Copiar código

### 2. Filtrar por empresa
GET http://localhost:8080/vuelos?empresa=Iberia

shell
Copiar código

### 3. Crear un vuelo
POST http://localhost:8080/vuelos
Body (JSON):
{
"nombreVuelo": "H011-V",
"empresa": "Air Europa",
"lugarSalida": "Madrid",
"lugarLlegada": "Lisboa",
"fechaSalida": "2025-09-10",
"fechaLlegada": "2025-09-10"
}

shell
Copiar código

### 4. Actualizar un vuelo
PUT http://localhost:8080/vuelos/1
Body (JSON):
{
"nombreVuelo": "H001-V",
"empresa": "Iberia",
"lugarSalida": "Madrid",
"lugarLlegada": "Buenos Aires",
"fechaSalida": "2025-05-20",
"fechaLlegada": "2025-05-21"
}

shell
Copiar código

### 5. Eliminar un vuelo
DELETE http://localhost:8080/vuelos/1

yaml
Copiar código

---

## Manejo de errores

- **404 Not Found** → Cuando un vuelo no existe
- **400 Bad Request** → Cuando los datos de un vuelo no son válidos (fecha de salida posterior a fecha de llegada, o campos obligatorios vacíos)

---

## Archivo `index.html`

Se puede acceder a través de `http://localhost:8080` si se coloca en:

src/main/resources/static/index.html

php-template
Copiar código

Contenido sugerido:

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Proyecto Vuelos</title>
</head>
<body>
    <h1>Bienvenido al Proyecto Vuelos</h1>
    <p>Usa Postman para probar los endpoints.</p>
</body>
</html>
Cómo ejecutar el proyecto
Clonar el repositorio.

Abrir el proyecto en IntelliJ IDEA.

Ejecutar la clase VuelosApplication.java.

Abrir en navegador: http://localhost:8080

Usar Postman para probar los endpoints.

