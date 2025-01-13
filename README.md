# sboot3-simple-jpa-auditing-envers
Ejemplo simple de auditoria con Spring Data JPA Auditing + Hibernate Envers. Si no agregamos las librerías de seguridad, no se puede auditar 
el usuario (null) que realiza la operación, por eso se está simulando mediante el AuditorAware.

## https://hibernate.org/orm/envers/
## Auditing Made Easy with Hibernate Envers | Spring Boot | Java: https://www.youtube.com/watch?v=5CT512srEYQ
## https://medium.com/maestral-solutions/creating-a-win-win-scenario-auditing-entity-revisions-in-spring-boot-with-hibernate-fc0cf81e4f50
## https://medium.com/@hkn94/entity-auditing-in-spring-boot-with-hibernate-envers-4b127c58fe7d

# Hibernate envers
By Default Hibernate enver uses REVINFO table to log data for revision. This includes keeping track of the revision number and timestamp.
REVINFO table also uses hibernate_sequence for primary key.

When you do any update at "customers" entity, you will see revision history at "customers_aud" and "revinfo" table. There are 3 revision types:

0 means entity is created;
1 means entity is updated;
2 means entity is removed;

En properties:
# activamos la generación automática de tablas
spring.jpa.hibernate.ddl-auto=create

# desactivamos la ejecución de scripts de Flyway
spring.flyway.enabled=false

# aplicamos auditoría automática solo a la entidad Customer desactivando la auditoría de la propiedad "age"
# no tenemos activada la auditoría de usuario (spring security, login, ...)

# drop
use jpa_audit_envers;
drop table if exists customers;
drop table if exists customers_aud;
drop table if exists revinfo;