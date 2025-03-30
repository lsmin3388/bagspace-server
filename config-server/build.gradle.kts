plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.bagspace.config.server"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Cloud BOM
	implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2024.0.0"))

	// Spring Cloud Config Server
	implementation("org.springframework.cloud:spring-cloud-config-server")

	// Spring Security
	implementation("org.springframework.boot:spring-boot-starter-security")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}
