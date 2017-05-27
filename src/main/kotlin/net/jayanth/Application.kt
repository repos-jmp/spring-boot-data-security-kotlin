package net.jayanth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringRestKotlinApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SpringRestKotlinApplication::class.java, *args)
        }
    }
}