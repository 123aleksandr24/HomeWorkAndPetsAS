package com.example.a310

fun main() {
    print("Введите число: ")
    val n  = readLine()?.toIntOrNull() ?: return

    println("Вы ввели число: $n")

    println(calculateSunRecursive(n))

    println(calculateSunRecursiveTailrec(n))
}

fun calculateSunRecursive (n: Int) : Int { // рекурсивная функция
    return  if (n == 0 ) {
        0
    } else {
        n + calculateSunRecursive(n-1)
    }
}

tailrec fun calculateSunRecursiveTailrec (n: Int, accum : Int = 0) : Int { // рекурсивная функция
    return  if (n == 0 ) {
        accum
    } else {
        calculateSunRecursiveTailrec(n-1,accum + n)
    }
}