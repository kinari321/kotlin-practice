fun main() {
//    printOddEvenNumberText(100)
//    println(getOddEvenNumberText(99))
//    val user1 = User1()
//    println(user1.name)
//    val user5 = User5()
//    user5.name = ""
//    println(user5.name)
    val user7 = User7(1, "Tanaka")
    user7.name = "Yamada"
    println(user7)
}

//fun printOddEvenNumberText(num: Int) {
//    val text = if (num % 2 == 1) "奇数" else "偶数"
//    println(text)
//}
//
//fun getOddEvenNumberText(num: Int): String {
//    return if (num % 2 == 1) {
//        "奇数"
//    } else {
//        return "偶数"
//    }
//}
//
//class User1 {
//    val name: String = "Tanaka"
//}
//
//class User3 {
//    lateinit var name: String
//}

//class User5 {
//    var name: String = ""
//        set(value) {
//            if (value == "") {
//                field = "kotlin"
//            } else {
//                field = value
//            }
//        }
//}
//
//class User6 {
//    val id: Int = 1
//    val name = "Kotlin"
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return true
//
//        other as User6
//
//        if (id != other.id) return false
//        if (name != other.name) return false
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return 31 * name.hashCode() + id
//    }
//
//    //
//    override fun toString(): String {
//        return "User6(id=$id, name=$name)"
//    }
//}

data class User7(val id: Int, var name: String)