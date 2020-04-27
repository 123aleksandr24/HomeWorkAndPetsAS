package com.example.a310

fun main() {
    val mutableList = mutableListOf ("1","2", "3") // listOf просто для чтения mutableListOf для редактирования
    println(mutableList)

    mutableList[0]

    mutableList.forEach { println(it)}

    val emptyList = emptyList<String>()

    mutableList[0] = "1.2"
    println(mutableList)

    mutableList.removeAt(0) // удаляет первый элемент
    mutableList.add("4") // добавялет в конец
    mutableList.add(1,"new 1")
    println(mutableList)

    mutableList.addAll(listOf("10","20")) // добавляет элементы в конец
    println(mutableList)
}