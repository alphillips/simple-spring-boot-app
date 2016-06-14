# simple-spring-boot-app

A very simple Spring Boot app

For demonstrating the workflow in the presentation  [Java on cloud.gov.au](https://navy-viper.hyperdev.space)

## Prerequisites

1. [Git](https://git-scm.com/)

2. [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

3. [Maven](https://maven.apache.org/)

4. [Cloud Foundry Cli](https://docs.cloudfoundry.org/cf-cli/install-go-cli.html) and access to a [PCF instance](http://pivotal.io/platform)



Clone the repository
```
git clone https://github.com/alphillips/simple-spring-boot-app.git
```

```
cd simple-spring-boot-app/
```

Create a branch
```
git checkout -b feature
```

Make some code change. Including tests

Run the tests
```
mvn test
```

For intergration tests, start the app first
```
mvn spring-boot:run
```
Then
```
mvn integration-test
```

When you are ready to deploy, package the app.

```
mvn package
```

Login to PCF
```
cf login
```
Spin new environment and deploy.
```
cf push feature
```
