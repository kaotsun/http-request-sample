import org.springframework.web.reactive.function.client.WebClient

fun main() {
    val client = WebClient.create("https://jsonplaceholder.typicode.com")

    val result = client.get()
        .uri("/todos/1")
        .retrieve()
        .bodyToMono(String::class.java)
        .block()

    println("Kotlin Response: $result")
}

