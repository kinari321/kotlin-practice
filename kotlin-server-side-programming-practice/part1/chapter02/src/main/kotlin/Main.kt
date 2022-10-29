fun main() {
    // デフォルト引数
//    val user8 = User8(1)
//    println(user8.toString())
    // 名前付き引数
//    val user9 = User9(1, "Tanaka", 24)
//    println(user9)

    // 関数型
     // 足し算
    val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
    val calc1: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
    println(calc(5, 10))
     // 二乗
    val squared1: (Int) -> Int = { it * it }
    val squared2: (Int) -> Int = fun(num: Int): Int { return num * num }
    println(squared2(5))

    // 高階関数
    printCalcResult(10, 20, { num1, num2 -> num1 + num2 })
    printCalcResult(10, 20, { num1, num2 -> num1 * num2 })
}

//data class User8(val id: Int, val name: String = "Default Name")

data class User9(val id: Int, val name: String = "Default Name", val age: Int)

fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1, num2)
    println(result)
}