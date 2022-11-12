//import java.beans.BeanProperty
import java.lang.IllegalStateException
import kotlin.reflect.KProperty
//import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    // スコープ関数
    val list = mutableListOf<Int>()
    for (i in 1..10) {
        if (i % 2 == 1) list.add(i)
    }
    val oddNumbers = list.joinToString(separator = " ")
    println(oddNumbers)

    // with
    val oddNumbersWith = with(mutableListOf<Int>()) {
        for (i in 1..10) {
            if (i % 2 == 1) this.add(i)
        }
        this.joinToString(separator = "")
    }
    println(oddNumbersWith)

    // run
    val oddNumbersRun = mutableListOf<Int>().run {
        for (i in 1..10) {
            if (i % 2 == 1) this.add(i)
        }
        this.joinToString(separator = ",")
    }
    println(oddNumbersRun)

    // let
//    data class User(val name: String)

//    fun createUserLet(name: String?): User? {
//        return if (name != null) User(name) else null
//    }

    // apply(alsoを推奨)
    data class User1(val id: Int, var name: String, var address: String)

    fun getUser(id: Int): User1 {
        return User1(id, "Tanaka", "Tokyo")
    }

    fun updateUserApply(id: Int, newName: String, newAddress: String) {
        val userApply = getUser(id).apply {
            name = newName
            address = newAddress
        }
        println(userApply)
    }
    updateUserApply(100, "TanakaKotlin", "NY")

    // also
//    fun updateUserAlso(id: Int, newName: String, newAddress: String) {
//        val userAlso = getUser(id).also { u ->
//            u.name = newName
//            u.address = newAddress
//        }
//        println(userAlso)
//    }

    // デリゲート
    val executorDelegate = AddCalclationExecutorExecutorDelegate(CommonCalculationExecutor())
    executorDelegate.printStartMessage()
    println(executorDelegate.calc(8, 11))

    //委譲プロパティ
    val delegatePerson = DelegatePerson()
    delegatePerson.name = "tanaka"
    delegatePerson.address = "Tokyo"
    println(delegatePerson.address)

    //コレクションライブラリ
    val userList =
        listOf(User1(1, "hoge", "Kotlin"), User1(2, "fuga", "Java"), User1(3, "piyo", "Kotlin"))
    println("idが２以上のUser: ${userList.filter { it.id >= 2 }}")
    println("最初のUser: ${userList.firstOrNull()}")
    println("最後のUser: ${userList.lastOrNull()}")
    println("重複のないuserList ${userList.distinct()}")
    println("map生成: ${userList.associateBy { it.id }}")
    println("map生成,任意の値: ${userList.associateWith { it.address.length }}")
    println("group化: ${userList.groupBy { it.address }}")
    println("count: ${userList.count()}")
    println("分割: ${userList.chunked(2)}")
    val listNum = listOf<Int>(1, 2, 3, 4, 5)
    println("畳み込み ${listNum.reduce { sum, value -> sum * value }}")

    println("=== コルーチン ===")
    coroutine()
}

interface CalclationExecutor {
    val message: String
    fun calc(num1: Int, num2: Int): Int
    fun printStartMessage()
}

class CommonCalculationExecutor(override val message: String = "calc") : CalclationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        throw IllegalStateException("Not Implements calc")
    }

    override fun printStartMessage() {
        println("start $message")
    }
}

class AddCalclationExecutorExecutorDelegate(private val calclationExecutor: CalclationExecutor) :
    CalclationExecutor by calclationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

class DelegateWithMessage<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("${property.name}を取得します")
        return value!!
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("${property.name}を更新します")
        this.value = value
    }
}

class DelegatePerson {
    var name: String by DelegateWithMessage()
    var address: String by DelegateWithMessage()
}

// coroutine
fun coroutine() {
//    GlobalScope.launch {
//        delay(1000L)
//        println("Naoto.")
//    }
    println("My name is")
    Thread.sleep(2000L)

    runBlocking {
        launch { printName() }
    }
    asyncAwait()
}

suspend fun printName() {
    delay(1000L)
    println("サスペンド関数を呼び出しています")
}

fun asyncAwait() {
    runBlocking {
        val num1 = async {
            delay(2000L)
            1 + 2
        }
        val num2 = async {
            delay(1000L)
            3 + 4
        }
        println("計算中...")
        println("sum=${num1.await() + num2.await()}")
    }
}











