# Recetas — Microservicio de riesgo recetas

Microservicio correspondiente al **caso caso07 — MediCare** (Telemedicina) de la Evaluación Parcial N°1.

| | |
|---|---|
| Asignatura | JVY0101 — Java: Diseño y Construcción de Soluciones Nativas en Nube |
| Stack | Spring Boot 3.3 · Java 21 · Maven · Spring Data JPA · H2 · springdoc-openapi |
| Calidad | JaCoCo cobertura LINE 100% · Cucumber (BDD) alineado a endpoints REST |
| Entrega | Docker / Docker Compose |

## Responsabilidad (SRP)

administra los datos y la lógica del dominio de Recetas del caso caso07 (MediCare). Su base de datos es una **H2 en memoria** (un solo microservicio por base), cumpliendo aislamiento de datos por dominio.

## Página de presentación

Al ejecutar el servicio, `http://localhost:8080/` muestra la página de presentación del microservicio con documentación y enlaces a:

- **Swagger UI**: `/swagger-ui/index.html`
- **OpenAPI (yaml)**: `/v3/api-docs.yaml`
- **ReDoc**: `/redoc.html`
- **H2 Console**: `/h2-console`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/recetas` | Lista todos los recursos |
| GET | `/api/recetas/{id}` | Obtiene un recurso por id |
| POST | `/api/recetas` | Crea un recurso |
| PUT | `/api/recetas/{id}` | Actualiza un recurso |
| DELETE | `/api/recetas/{id}` | Elimina un recurso |

## Documentación del proyecto

La documentación completa está en la carpeta [`docs/`](docs/):

- [`docs/00_Resumen.md`](docs/00_Resumen.md) — propósito, responsabilidad y tecnologías
- [`docs/01_Arquitectura.md`](docs/01_Arquitectura.md) — componentes, arquitectura y patrones
- [`docs/02_API.md`](docs/02_API.md) — contrato REST y ejemplos curl
- [`docs/03_Pruebas.md`](docs/03_Pruebas.md) — tests unitarios, cobertura y Cucumber
- [`docs/04_Despliegue.md`](docs/04_Despliegue.md)
- [`docs/05_Justificacion.md`](docs/05_Justificacion.md) — justificación del servicio: RF/RNF/seguridad cubiertos, stack y por qué cada tecnología AWS
- [`docs/diagramas/`](docs/diagramas/) — C4 (contexto, contenedores, componentes), secuencia e infraestructura AWS — Docker, Docker Compose e integración

## Cómo ejecutar locmente

```bash
mvn spring-boot:run
```

## Cómo ejecutar con Docker

```bash
docker compose up --build
# http://localhost:8080
```

## Cómo ejecutar las pruebas

```bash
mvn test      # unit tests + Cucumber
mvn verify    # + verificación de cobertura JaCoCo (100% LINE, falla si baja)
```
##  Método de ramificación

Elegimos GitFlow ya que esta es ideal para proyectos con releases planficados, los cuales corresponderán a nuestras entregas de pruebas parciales a lo largo del semestre. Además, la estructura clásica de Gitflow está compuesta por las ramas "main", "develop", "hotfix/" y "feature/", que es lo que se exige en la pauta de la entrega 1. De esta manera, en la rama "develop" podemos seguir avanzando con el código nuevo de cada entrega, en las ramas "hotfix/" se podrán realizar arreglos rápidos sin mezclar los cambios con los códigos sin terminar de "develop", y en la rama "main" mantendremos la versión final y estable de cada entrega.

### Convención de Commits
Formato: `tipo(alcance): descripcion-corta` (Escrito en minúsculas y sin tildes).

| Tipo | Para qué | Ejemplo |
| :--- | :--- | :--- |
| **feat** | Nueva funcionalidad | `feat(ui): agregar pie de pagina` |
| **fix** | Corrección de bug | `fix(home): corregir titulo` |
| **docs** | Documentación | `docs: agregar changelog` |
| **chore** | Tareas / CI | `chore(ci): agregar workflow hola mundo` |

### Naming de Ramas
- Estructura: `feature/<feature-name>` y `hotfix/<feature-name>`, en minúsculas y separadas con guiones.
- Ejemplos: `feature/pagina-presentacion`, `hotfix/titulo-pagina`.

### Flujo de Merge
- Las *features* y *hotfixes* siempre entran mediante **Pull Request**, nunca con *push* directo a `main` o `develop`.
- Se requiere al menos **1 aprobación** del compañero antes de fusionar.
- Usar *merge commit* o *squash*, y borrar la rama inmediatamente después de fusionar (*delete branch*).

### Estrategia de Revisión
- El autor crea el Pull Request y asigna a un integrante del equipo como revisor.
- El revisor comenta, aprueba o solicita cambios; nunca se fusiona un PR sin haber sido revisado previa y detalladamente.
- Antes de abrir cada PR: confirmar que los tests de `mvn test` pasan de forma exitosa y revisar detenidamente el *diff* del código.

### Reflexion individual Tais
- A lo largo de este proyecto aprendí a estructurar un flujo de trabajo profesional utilizando GitFlow. Lo más valioso fue entender el impacto de los entornos de integración continua mediante GitHub Actions, ya que nos permitió automatizar las verificaciones de nuestro microservicio en Spring Boot y asegurar que el código en develop y main fuera siempre estable. Mi aporte principal estuvo centrado en la gestión de ramas, la creación de la documentación base (CHANGELOG.md y README.md) y la participación activa como autor y revisor de Pull Requests, lo que me ayudó a comprender la importancia de la colaboración y las revisiones de código antes de cada merge.


###Uso de Inteligencia Artificial

Utilizamos Gemini como herramienta de apoyo puntual a lo largo del laboratorio:

Comandos y flujo de Git: Nos ayudó a resolver dudas con los comandos en la terminal, cómo sincronizar develop con main tras el hotfix y cómo manejar los reverts cuando nos equivocamos en un merge.

GitHub Actions: Fue una guía para revisar la sintaxis de los archivos YAML en la carpeta .github/workflows y asegurarnos de que la integración continua corriera sin errores.
