import HelloByJava
import java.util.*

class HelloByKotlin{
    fun printHello(){
        println("Hello Kotlin.")
    }
}

class DogKotlin: AnimalJava(){
    override fun cry() {
        println("bowwow")
    }
}

class GreeterImplKotlin: GreeterJava{
    override fun hello() {
        println("Hello.")
    }
}

class CompanyConstants{
    companion object{
        @JvmStatic
        val maxEmployeeCount = 100
    }
}

fun main() {
    val hello = HelloByJava()
    hello.printHello()

    val uuid: UUID = UUID.randomUUID()
    println(uuid.toString())

    val dog = DogKotlin()
    dog.cry()

    val greeter = GreeterImplKotlin()
    greeter.hello()

    val user = UserJava()
    user.id = 100
    user.name = "tanaka"
    println("${user.id}, ${user.name}")
}