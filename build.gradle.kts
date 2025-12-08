plugins {
    application
    java
}

repositories {
    mavenCentral()
}

dependencies {


    // This dependency is used by the application.
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation ("com.github.cliftonlabs:json-simple:3.1.0")       
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "src.main.java.shellCLI.Shell"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
