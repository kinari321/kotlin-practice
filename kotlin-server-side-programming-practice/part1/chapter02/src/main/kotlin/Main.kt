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
    data class User(val name: String)

    fun createUserLet(name: String?): User? {
        return if (name != null) User(name) else null
    }


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
    fun updateUserAlso(id: Int, newName: String, newAddress: String) {
        val userAlso = getUser(id).also { u ->
            u.name = newName
            u.address = newAddress
        }
        println(userAlso)
    }
}