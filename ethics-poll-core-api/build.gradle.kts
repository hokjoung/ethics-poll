tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":storage:db-core"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    api("org.jsoup:jsoup:1.13.1")
    api("net.sourceforge.htmlunit:htmlunit:2.49.1")
    api("com.google.code.gson:gson:2.8.6")
}
