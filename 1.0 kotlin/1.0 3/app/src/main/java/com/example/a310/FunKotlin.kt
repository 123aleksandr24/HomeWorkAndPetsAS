package com.example.a310

import kotlin.random.Random

fun main() {

    print(multiply(123,4))

    println(10/3f) // преобр в флот

    print(hasChildAccess(height = 110 , age = 20 , weight = 50 ))

    functionWithAnyParam(3) // Any пар-р принимает любой тип
    functionWithAnyParam("dfdf")
}

fun multiply ( a : Int , b : Int): Int {
    val result = a * b
    return result
    // result = a * b  // можно просто заинлайнить (вернуть сразу перемноженное)
}

// ещё короче в одну строчку
//fun multiply ( a : Int , b : Int) = a * b

fun hasChildAccess (height : Int , weight : Int , age : Int ) : Boolean {
    return height > 150 && weight > 30 && age > 10
}

fun functionreturnAny () : Any {
    return if (Random.nextBoolean()){ // возвращает рандомно либо то либо другое
        2323
    } else {
        "fdfsd"
    }
}

fun functionWithAnyParam (param : Any ) { // принимает Any (любой тип) и ничего неделает  , неявно возвращает тип Unit (аналог void джава)

}



