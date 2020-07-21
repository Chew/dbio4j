# DBio API for Java

An implementation of the discord.bio API in Java.

## Downloading / Installing

You'll need to install the build you want. All are considered dev builds unless otherwise specified in a [Release](https://github.com/JavaAPIs/dbio4j/releases).

Replace `[version]` with the latest build found on [the Jenkins page](https://jenkins.chew.pw/job/JavaAPIs/job/dbio4j/lastSuccessfulBuild/). See dbio4j-[version string].jar.

### Maven

First, you need Chew's Maven repository
```xml
<repository>
    <id>chew-jenkins</id>
    <url>https://jenkins.chew.pw/plugin/repository/everything/</url>
</repository>
```
```xml
<dependency>
    <groupId>bio.discord</groupId>
    <artifactId>dbio4j</artifactId>
    <version>[version]</version>
</dependency>
```

### Gradle

First you need Chew's Maven repository
```groovy
repositories {
    maven {
        url 'https://jenkins.chew.pw/plugin/repository/everything/'
    }
}
```
Then you need the dependency
```groovy
dependencies {
    compileOnly 'bio.discord:dbio4j:[version]'
}
```

Builds remain there indefinitely, but it's always best to stay up to date.

Alternatively, on the same Jenkins link, you can manually download the JAR yourself for safe keeping, in case it does go down.

## Using

Using the API is simple. Here's an example to get you started!

```java
```

You can view the Javadocs [here](https://jenkins.chew.pw/job/JavaAPIs/job/dbio4j/javadoc/overview-summary.html).
