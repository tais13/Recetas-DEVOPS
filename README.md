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
- Antes de abrir cada PR: confirmar que los tests de `mvn test` pasan de forma exitosa y revisar detenidamente el *diff* del código.#Prueba final del trigger
  
