
plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application
    // You can run your app via task "run": ./gradlew run
    application

    /*
     * Adds tasks to export a runnable jar.
     * In order to create it, launch the "shadowJar" task.
     * The runnable jar will be found in build/libs/projectname-all.jar
     */
    
    // uncomment when the jar file will be needed
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.danilopianini.gradle-java-qa") version "1.25.0"

    id("org.danilopianini.unibo-oop-gradle-plugin") version "1.0.5-dev02-c451bb9"
}


repositories {
    mavenCentral()
}

val javaFXModules = listOf(
    "base",
    "controls",
    "fxml",
    "swing",
    "media",
    "graphics"
)

val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP

dependencies {
    // Suppressions for SpotBugs
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.8.1")
    implementation("org.apache.commons:commons-math3:3.6.1") // Use the latest version

    // Example library: Guava. Add what you need (and remove Guava if you don't use it)
    // implementation("com.google.guava:guava:28.1-jre")

    // JavaFX: comment out if you do not need them
    val javaFxVersion = 15
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }

    val jUnitVersion = "5.10.1"
    // JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
}

tasks.withType<Test> {
    // Enables JUnit 5 Jupiter module
    useJUnitPlatform()
}

application {
    // Define the main class for the application
    mainClass.set("tbooop.application.AppLauncher")
}

 java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }