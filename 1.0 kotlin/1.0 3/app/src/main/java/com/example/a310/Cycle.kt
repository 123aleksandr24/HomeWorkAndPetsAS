package com.example.a310

fun main() {

    println ("Введите число : ")
    val n = readLine()?.toIntOrNull() ?: return // ридлайн как сканер

    println("Вы ввели число : $n")

    println("Сумма с помощью while = ${calculateSumByWhile(10)}")

    println("Сумма с помощью while и return = ${calculateSumByWhileInfinite(n)}")

    println("Сумма с помощью while и break = ${calculateSumByWhileInfiniteBreak(n)}")

    printEvenNumber(n)

    println("Сумма с помощью do while = ${calculateSumDoWhile(n)}")

    println("Сумма с помощью do while = ${calculateSumFor(n)}")

    printCurrentCh()

    printEvenNumberFor(n)

}

fun calculateSumByWhile (n : Int ) : Long {
    var sum: Long = 0
    var currentNumber : Int = 0
    while (currentNumber <= n) {
        sum += currentNumber
        currentNumber++
    }
    return sum
}

fun calculateSumByWhileInfinite (n : Int ) : Long {
    var sum: Long = 0
    var currentNumber : Int = 0

    while (true) {

        if (currentNumber > n)  return sum// прерывает цикл при этом условии и возвр значение

        sum += currentNumber
        currentNumber++
    }
}

fun calculateSumByWhileInfiniteBreak (n : Int ) : Long {
    var sum: Long = 0
    var currentNumber : Int = 0

    while (true) {

        if (currentNumber > n)  break //  выйдет из цикла на этом шаге

            sum += currentNumber
        currentNumber++
    }
    return sum
}

fun printEvenNumber (n : Int) {
    var currentNumber = 0
    while (currentNumber <= n) {
        val numberBefore = currentNumber
        currentNumber++
        if (numberBefore % 2 == 1 ) continue
        println (numberBefore)
    }
}

fun calculateSumDoWhile (n : Int ) : Long {
    var sum: Long = 0
    var currentNumber : Int = 0

    do {
        println ("Iteration $currentNumber")
        sum += currentNumber
        currentNumber++
    } while (currentNumber <= n)
    return sum
}

fun calculateSumFor (n: Int): Long {
    var sum : Long = 0

    val range = 0..n
    //val range = 0 until n // не  включает в итерацию число n

    for (currentNumber in range) { // in - включение диапазона val range
        sum += currentNumber
    }
    return sum
}

fun printCurrentCh ()  {
    for (currentCh : Char in "string"){ // итерация по буквам s t r i n g
        println(currentCh)
    }
}

fun printEvenNumberFor (n: Int) {
    val range = 1..n step 2 // включает числа с шагом 2
    //val range = n downTo 0 step 2 // идёт по убыванию
    for (currentNumber in range) {
        println(range)
    }
}