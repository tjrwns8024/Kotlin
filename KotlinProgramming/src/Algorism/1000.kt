package Algorism

import java.util.*


fun main() {
    val sc: Scanner = Scanner(System.`in`)

    val num = sc.nextInt()
    var i:Int?
    var j:Int?
    var k:Int?

    for(i in 1..num){
        for(j in 1..num-(i)){
            print(" ")
        }
        for(k in 1..i){
            print("*")
        }
        println()
    }

}