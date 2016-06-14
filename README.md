# simple-spring-boot-app

A very simple Spring Boot app

For demonstrating the workflow in the presentation [insert demo link]

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

Make some code change. Including a tests

Run the test, run the app

```
mvn spring-boot:run
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
