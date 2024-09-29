package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" 
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	    
	    <modelVersion>4.0.0</modelVersion>
	    
	    <parent>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-parent</artifactId>
	        <version>3.3.4</version>
	        <relativePath/> 
	    </parent>
	    
	    <groupId>com.codingdojo.brightideas</groupId>
	    <artifactId>BrightIdeas</artifactId>
	    <version>0.0.1-SNAPSHOT</version>
	    <packaging>war</packaging>
	    
	    <name>BrightIdeas</name>
	    <description>Bright Ideas Project for Spring Boot</description>
	    
	    <properties>
	        <java.version>17</java.version>
	    </properties>
	    
	    <dependencies>
	        <!-- Spring Boot JPA Dependency -->
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-data-jpa</artifactId>
	        </dependency>
	
	        <!-- Spring Boot Web Dependency -->
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-web</artifactId>
	        </dependency>
	
	        <!-- MySQL Connector -->
	        <dependency>
	            <groupId>com.mysql</groupId>
	            <artifactId>mysql-connector-j</artifactId>
	            <scope>runtime</scope>
	        </dependency>
	
	        <!-- Spring Boot DevTools for hot reloads -->
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-devtools</artifactId>
	            <scope>runtime</scope>
	            <optional>true</optional>
	        </dependency>
	
	        <!-- Spring Boot Tomcat for WAR packaging -->
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-tomcat</artifactId>
	            <scope>provided</scope>
	        </dependency>
	
	        <!-- Spring Boot Test for Unit and Integration Testing -->
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-test</artifactId>
	            <scope>test</scope>
	        </dependency>
	
	        <!-- Jakarta Validation for Form Validation -->
	        <dependency>
	            <groupId>jakarta.validation</groupId>
	            <artifactId>jakarta.validation-api</artifactId>
	            <version>3.0.2</version>
	        </dependency>
	
	        <!-- BCrypt for password hashing -->
	        <dependency>
	            <groupId>org.mindrot</groupId>
	            <artifactId>jbcrypt</artifactId>
	            <version>0.4</version>
	        </dependency>
	    </dependencies>
	
	    <build>
	        <plugins>
	            <!-- Spring Boot Maven Plugin -->
	            <plugin>
	                <groupId>org.springframework.boot</groupId>
	                <artifactId>spring-boot-maven-plugin</artifactId>
	            </plugin>
	        </plugins>
	    </build>
	</project>
	
}

