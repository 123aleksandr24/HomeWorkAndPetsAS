package com.example.a310

fun main() {
    val string : String = "string "
    val nullableString : String? = null

    val length : Int = string.length
    val nullableLength : Int? = nullableString?.length

    nullableString?.reversed()
        ?.find { it == '4' }
        ?.isDigit()

    if (nullableString != null) {
        println("String length is ${nullableString.length ?: "incorrect"}")
    } else {
        println ("String is null")
    }

    readLine()?.toIntOrNull()
        ?.let { number -> // сэйвкол для того чтобы вывести когда строка не является нулём
            println("Вы ввели чичло $number")
        }
        ?: println("Вы ввели не число")

    printLength(null)
    printLength("gdfgf")
}

fun printLength (string : String?) {
    string ?: return
    print("Длинна строки = ${string!!.length}") // !! - при уверенности что ообъект не явл нулём
}