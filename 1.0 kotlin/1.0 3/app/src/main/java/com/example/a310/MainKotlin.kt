package com.example.a310

fun main(){
    val helloWorldString = "helloworld"
    val helloWorldString2: String
    helloWorldString2 = "helloworld"

    val array = arrayListOf (1)
    array.add(2)
    array.add(3)

    print (array)

    val intVal = 3232323
    val shortVal : Short = 123
    val longVal : Long = 2321321321321 // L - обозначение лонга
    val longValL = 2321321321321L
    val  floatVal = 323231.4343f // если не написать букву f - будет дабл значение

    val booleanVal : Boolean = true
    val booleanVal2 : Boolean = false

    val booleanVal3 = booleanVal || booleanVal2
    val booleanVal4 = booleanVal && booleanVal2
    val booleanVal5 = !booleanVal && booleanVal2.not() // в обоих случаях отрицание

    val isEqual = intVal == 5 // будет false

    val charVal : Char = '2'
    val stringVal = "string"
    val multiStringVal = """
        dsfdsf
        sdfsdf
        sdfsdf
    """.trimIndent() // не обязателен

    val name = "Ivan"
    val lastName = "Ivanov"
    val isMale = true

    val humanReadableName = "My name is ${name} and lastname ${lastName}"

    val humanReadableExpanded = "${if(isMale) "His" else "Her"} and lastname ${lastName}"
        print(multiStringVal)

    3432432f.toDouble() // преобразование флот в дабл
    213.toString() // преобразование числа в строку ы
}
