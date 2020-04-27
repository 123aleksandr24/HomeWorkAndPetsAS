package com.example.a310

fun main() {
    val immutableSet = setOf (1,2,3,2,6,5,4,3,5,4,6) // без повторяющихся элементов
    println(immutableSet)

    val unionSet = setOf(1,2,3 ).union(setOf(1,4,5)) // сложение коллекции с другой
    println(unionSet)

    val substractSet = setOf (1,2,3).subtract(setOf(1,2,4)) // вычитание одной кооллекции из другой
    println(substractSet)

    val interSet = setOf(1,2,4).intersect(setOf(4,5,5)) // выводит те кот-е поворяются в единственном экземпляре
    println(interSet)

    val naturalOrderSet = sortedSetOf(1,4,-1,2,5,2) // выводит числа в натуральном порядке
    println(naturalOrderSet.descendingSet()) // десендингсет возвр эл-ты в убыв порядке

    mutableSetOf(1,2,3).add(34)

    val hashSet = hashSetOf(1,2,3)
    hashSet.add(1)
    hashSet.add(1)

    hashSet.contains(1) // проверка содержит ли элемент возвр булеан
    println(1 in hashSet) // такая же проверка на элемент


}