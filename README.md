# ExampleProject
Example project using Spring Data JPA, Hibernate, H2database, JSF, CDI, EJB, Primefaces
Applications server - WildFly 16.0.0

At the moment, the launch of the application shows the following error:

18:54:17,666 ERROR [org.jboss.msc.service.fail] (ServerService Thread Pool -- 86) MSC000001: Failed to start service jboss.persistenceunit."Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData": org.jboss.msc.service.StartException in service jboss.persistenceunit."Tutorial_JSF-CDI-EJB-JPA-Hibernate-H2-Primfaces-1.0-SNAPSHOT.war#jpaData": javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
	at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:198)
	at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:128)
	at org.wildfly.security.manager.WildFlySecurityManager.doChecked(WildFlySecurityManager.java:649)
	at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1.run(PersistenceUnitServiceImpl.java:212)
	at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1982)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1486)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1348)
	at java.lang.Thread.run(Thread.java:748)
	at org.jboss.threads.JBossThread.run(JBossThread.java:485)
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: jpaData] Unable to build Hibernate SessionFactory
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.persistenceException(EntityManagerFactoryBuilderImpl.java:1016)
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:942)
	at org.jboss.as.jpa.hibernate5.TwoPhaseBootstrapImpl.build(TwoPhaseBootstrapImpl.java:44)
	at org.jboss.as.jpa.service.PersistenceUnitServiceImpl$1$1.run(PersistenceUnitServiceImpl.java:170)
	... 9 more
Caused by: org.hibernate.MappingException: Could not determine type for: by.babanin.dao.ExampleEJB, at table: ADDRESS, for columns: [org.hibernate.mapping.Column(exampleEJB)]
	at org.hibernate.mapping.SimpleValue.getType(SimpleValue.java:486)
	at org.hibernate.mapping.SimpleValue.isValid(SimpleValue.java:453)
	at org.hibernate.mapping.Property.isValid(Property.java:226)
	at org.hibernate.mapping.PersistentClass.validate(PersistentClass.java:624)
	at org.hibernate.mapping.RootClass.validate(RootClass.java:267)
	at org.hibernate.boot.internal.MetadataImpl.validate(MetadataImpl.java:347)
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:466)
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:939)
	... 11 more

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
