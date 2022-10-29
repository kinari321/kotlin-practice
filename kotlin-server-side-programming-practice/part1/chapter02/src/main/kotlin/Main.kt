fun main() {
    // 高階関数
    printCalcResult(10, 20, { num1, num2 -> num1 + num2 })
    printCalcResult(10, 20, { num1, num2 -> num1 * num2 })

    // タイプエイリアスに置き換え
    printCalcResult1(10, 20, { num1, num2 -> num1 + num2 })

    // 拡張機能
    println(3.square())
}

typealias Calc = (Int, Int) -> Int

fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1, num2)
    println(result)
}

fun printCalcResult1(num1: Int, num2: Int, calc: Calc) {
    val result = calc(num1, num2)
    println(result)
}

fun Int.square(): Int = this * this