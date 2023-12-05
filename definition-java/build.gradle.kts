plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.temporal:temporal-sdk:1.18.2")
    implementation("org.slf4j:slf4j-nop:2.0.6")
}

tasks.test {
    useJUnitPlatform()
}