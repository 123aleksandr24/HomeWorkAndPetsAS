package com.example.a310

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val pairl = Pair("key","value")
    val pair2 = 1 to 2 // выводит пару кей вэлью

    println("first = ${pairl.first} , second = ${pairl.second}")
    println(pair2)

    val map = mapOf(
        "Name1" to "+799999999",
        "Name2" to "+798888888",
        "Name3" to "+797777777"
    )

    println(map["Name1"])
    println(map["Name4"])

    val mutableMap = map.toMutableMap() // переводит из не изменяемой в изменяемую
    val mutableMap2 = mutableMapOf("1" to "2")
    mutableMap["Name1"] = "123213"
    mutableMap["Name"] = "4322"
    mutableMap.put ("key","value")
    mutableMap.remove("key")

    mutableMap.toMap() // запрещает редактирование клиентам и используется так же в джругих коллекциях
    val sortedMap = sortedMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )
    println(sortedMap)

    val hashMap = hashMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )

    println(hashMap.keys)
    println(hashMap.values)

    for (key in hashMap.keys) {
        println("key $key , value = ${hashMap[key]}")
    }

    hashMap.forEach { entry -> entry.key
    entry.value }

    hashMap.forEach { (key, value) ->
        key
        value }
 }