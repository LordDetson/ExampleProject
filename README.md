# ExampleProject
Example project using Spring Data JPA, Hibernate, H2database, JSF, CDI, EJB, Primefaces
Applications server - WildFly 16.0.0

At the moment, the launch of the application shows the following error:

19:15:28,594 ERROR [io.undertow.request] (default task-1) UT005023: Exception handling request to /Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT/example.xhtml: javax.servlet.ServletException
Caused by: java.lang.ExceptionInInitializerError
	at by.babanin.dao.ApplicationContext.getInstance(ApplicationContext.java:25)
	at by.babanin.dao.ExampleEJB.<init>(ExampleEJB.java:19)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'addressRepository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Not a managed type: class by.babanin.dao.entity.AddressEntity
	at by.babanin.dao.ApplicationContext.<init>(ApplicationContext.java:18)
	at by.babanin.dao.ApplicationContext.<init>(ApplicationContext.java:8)
	at by.babanin.dao.ApplicationContext$Singleton.<clinit>(ApplicationContext.java:14)
Caused by: java.lang.IllegalArgumentException: Not a managed type: class by.babanin.dao.entity.AddressEntity

Error fixed (Thanks to Nickolay Bobrov - Telegram @lWeRl ): 

18:54:17,666 ERROR [org.jboss.msc.service.fail] (ServerService Thread Pool -- 86) MSC000001: Failed to start service jboss.persistenceunit."Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData": org.jboss.msc.service.StartException in service jboss.persistenceunit."Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData": javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
Caused by: org.hibernate.MappingException: Could not determine type for: by.babanin.dao.ExampleEJB, at table: ADDRESS, for columns: [org.hibernate.mapping.Column(exampleEJB)]
18:54:17,674 ERROR [org.jboss.as.controller.management-operation] (management-handler-thread - 1) WFLYCTL0013: Operation ("deploy") failed - address: ([("deployment" => "Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war")]) - failure description: {"WFLYCTL0080: Failed services" => {"jboss.persistenceunit.\"Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData\"" => "javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: org.hibernate.MappingException: Could not determine type for: by.babanin.dao.ExampleEJB, at table: ADDRESS, for columns: [org.hibernate.mapping.Column(exampleEJB)]"}}
18:54:17,679 ERROR [org.jboss.as.server] (management-handler-thread - 1) WFLYSRV0021: Deploy of deployment "Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war" was rolled back with the following failure message: 
{"WFLYCTL0080: Failed services" => {"jboss.persistenceunit.\"Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData\"" => "javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: org.hibernate.MappingException: Could not determine type for: by.babanin.dao.ExampleEJB, at table: ADDRESS, for columns: [org.hibernate.mapping.Column(exampleEJB)]"}}
18:54:17,685 INFO  [org.jboss.as.connector.deployers.jdbc] (MSC service thread 1-3) WFLYJCA0019: Stopped Driver service with driver-name = Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war_org.h2.Driver_1_4
18:54:17,731 INFO  [org.jboss.as.jpa] (ServerService Thread Pool -- 86) WFLYJPA0011: Stopping Persistence Unit (phase 1 of 2) Service 'Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData'
18:54:30,938 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-4) WFLYSRV0028: Stopped deployment Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war (runtime-name: Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war) in 13258ms
[2019-03-26 06:54:31,029] Artifact Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces:war: Error during artifact deployment. See server log for details.
[2019-03-26 06:54:31,029] Artifact Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces:war: java.lang.Exception: {"WFLYCTL0080: Failed services" => {"jboss.persistenceunit.\"Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData\"" => "javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
    Caused by: org.hibernate.MappingException: Could not determine type for: by.babanin.dao.ExampleEJB, at table: ADDRESS, for columns: [org.hibernate.mapping.Column(exampleEJB)]"}}
