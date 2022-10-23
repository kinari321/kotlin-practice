fun main() {
//    # アクセサメソッド
//    val user = User7(1, "tanaka")
//    user.name = "Kotlin"
//    println(user.name)

//    # equals
//    val user = User7(1, "tanaka")
//    val same = User7(1, "tanaka")
//    val other = User7(2, "tanaka")
//
//    println(user == same)
//    println(user == other)

//    # hashCode
//    val user = User7(1, "tanaka")
//    val same = User7(1, "tanaka")
//    val other = User7(2, "tanaka")
//
//    val set = hashSetOf(user)
//    println(set.contains(same))
//    println(set.contains(other))

//    # toString
//    val user = User7(1, "tanaka")
//    println(user.toString())

//    # componentN
//    val user = User7(1, "tanaka")
//    println(
//        "user.component1(): $user.component1()" +
//                "$user.component2()"
//    )

//    # copy
    val user = User7(1, "tanaka")
    val updated = user.copy(1, "Kotlin")
    println(updated.toString())
}

data class User7(val id: Int, var name: String)