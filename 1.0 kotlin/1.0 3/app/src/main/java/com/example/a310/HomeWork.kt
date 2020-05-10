package com.example.a310

import kotlin.math.abs
import kotlin.io.println as println1


fun main() {

    // 1. Ввести число N с клавиатуры.
    println1("Введите число N что бы задать N чисел")
    val n = readLine()?.toIntOrNull() ?: return
    println1("Введите $n чисел")

    // 4. Шаги 2–3 вынести в функцию, которая принимает число N и возвращает список из N чисел, введённых с клавиатуры
           val listN = getN(n)

    // 5. Вывести в консоль количество введенных положительных чисел. (Использовать if).
    for (number in listN) {
        if (number > 0) {
            println1(number)
        }
    }

    // 6. Вывести в консоль только четные введённые числа. (Использовать фильтрацию коллекции с помощью функции filter.)
    val filterArray = listN.filter { it % 2 == 0 }
    println1("фильтр чётных чисел $filterArray")

    //7. Вывести в консоль количество уникальных введенных чисел. (Использовать set.)
//    val list = setOf (listN) // без повторяющихся элементов
//    println1("без повторяющихся элементов $list")
    val setN = listN.toSet()
    kotlin.io.println("числа сетом без повторяющихся элементов $setN")
    //8. Вычислить сумму всех введенных чисел с помощью агрегирующей функции коллекции sum.
    val sum = listN.sum();

    //10. Создать Map, где ключ — число, а значение — НОД из пункта 9.
    //fun IntArray.toSet(): Set<Int>
//    list.toSet(): Set <Int,Int>
//    val map = mutableMapOf<Int, Int>()
//    for (number in listN) {
//        map[number] = nod(number, sum)
//    }

    //11. Вывести все числа с НОД в формате: Число <>, сумма <>, НОД <>. Использовать итерацию по Map из пункта 10.
    // Для каждого из чисел использовать новую строку.

    for (number in listN) {
        kotlin.io.println("число $number сумма $sum НОД ${nod(number, sum)} ")
    }

}



//9. Для каждого числа посчитать наибольший общий делитель (НОД) для этого числа и суммы из пункта 8.
// (Создать функцию для вычисления НОД, которая использует рекурсию с модификатором tailrec.)
tailrec fun nod(a: Int, b: Int): Int {
    if (b == 0)
        return abs(a);
    return nod(b, a % b)
}

fun getN(n : Int): MutableList<Int> {
//2. После этого ввести следующие N чисел каждое с новой строки (если пользователь ввел не число — игнорируется эта строка)
// ( использовать цикл и нуллабельные типы)

    val list = mutableListOf<Int>() ;
    while (list.size < n) {
        val s = readLine()?.toIntOrNull() ?: continue
        // 3. Сохранить числа в список
        list.add(s)
    }
   return list
}

fun sum (listN: MutableList<Int>): Int {
    var sum: Int = 0
    for (current : Int in listN){
        sum += current
    }
    return sum
}


