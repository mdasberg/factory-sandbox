plugins {
    java
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.openapi.generator") version "7.14.0"
}

group = "nl.badgerhill"
version = "0.1.0-SNAPSHOT"

java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
}

repositories { mavenCentral() }

extra["springModulithVersion"] = "1.4.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.4.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports { mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}") }
}

openApiGenerate {
    generatorName = "spring"
    inputSpec = "$projectDir/src/main/resources/openapi/greeting.yaml"
    outputDir = layout.buildDirectory.dir("generated/openapi").get().asFile.path
    apiPackage = "nl.badgerhill.sandbox.greeting.internal.api"
    modelPackage = "nl.badgerhill.sandbox.greeting.internal.api.model"
    // Greeting is the module's public API record; reuse it instead of generating a duplicate.
    importMappings = mapOf("Greeting" to "nl.badgerhill.sandbox.greeting.Greeting")
    schemaMappings = mapOf("Greeting" to "nl.badgerhill.sandbox.greeting.Greeting")
    generateModelTests = false
    generateApiTests = false
    configOptions = mapOf(
        "interfaceOnly" to "true",
        "useSpringBoot3" to "true",
        "useTags" to "true",
        "skipDefaultInterface" to "true",
        "documentationProvider" to "none",
        "annotationLibrary" to "none",
        "openApiNullable" to "false",
        "useBeanValidation" to "true",
        "useResponseEntity" to "false",
    )
}

sourceSets.main { java.srcDir(layout.buildDirectory.dir("generated/openapi/src/main/java")) }
tasks.compileJava { dependsOn(tasks.openApiGenerate) }

tasks.withType<Test> { useJUnitPlatform() }
