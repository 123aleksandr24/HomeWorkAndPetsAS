package com.example.a310

fun main() {
    print(getDevelopPosition(2))
    print(getDevelopPosition(-1))
}

fun maxInt (a : Int , b : Int ): Int {
    val maxValue : Int
    if (a < b)  maxValue = b  else  maxValue = a
    //maxValue = if (a < b)   b  else  a
    //или же просто
    //val maxValue : Int = if (a < b)   b  else  a
    return maxValue

    // ещё корчое
    //return if (a < b) b else a

    //без ретурна
    // fun maxInt (a : Int , b : Int ): Int = if (a < b) b else a  // expression body
}

fun calculatePrice (booleanParam: Boolean) : Int {
    return if (booleanParam) {
        val interMediaResult = 234 + 432
        interMediaResult + 3
    } else{
        val interMediaResult = 14  + 3
        interMediaResult + 3
    }
}

fun getCarType (maxSpeed : Int) : String {
//    return if (maxSpeed < 20) {
//        "Трактор"
//    } else if (maxSpeed < 60){
//        "Медленная машина"
//    } else if (maxSpeed < 200){
//        "Обычная машина"
//    } else {
//        "Быстрая машина"
//    }

    return when {   // если есть return ветка else обязательна . Без ретурна её можно удалить.
        maxSpeed < 20 -> {
            "Трактор"
        }
        maxSpeed < 60 -> {
            "Медленная машина"
        }
        maxSpeed < 200 -> {
            "Обычная машина"
        }
        else -> {
            "Быстрая машина"
        }
    }
}

fun getDevelopPosition (experience : Int) : String {
    return if (experience < 0) {
        "Incorrect experience"
    } else {
        when (experience) {
            0 -> "Intern"
            in 1..2 -> "Junior"
            in 3..4 -> "Middle"
            else -> "Senior"
        }
    }
}