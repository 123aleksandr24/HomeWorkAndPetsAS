package com.example.a310

fun main() {
    val array = arrayOf ("Петр", "Александр","Василий") + arrayOf("Новый пользователь") // оператор сложения

    for (user in array){
        println(user)
    }

    array.forEach {println(it)}
    array.forEachIndexed {index , user -> println("Index = $index, element = $user")} // обращение по индексу

    val firstElement = array[0]
    val lastElement = array [array.lastIndex]

    array[0] = "Новый Петр"

    array.forEach { println(it) }

    val emptyArray = emptyArray<String>()

    val largeArray = Array (100) { index -> "User $index"}
    largeArray.forEach { println(it) }


}