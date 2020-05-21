package chap02.section1

fun main(){
    val foods = mutableListOf("라면","갈비","밥")

    foods.add("초밥")
    foods.removeAt(0)
    foods[1] = "부대찌개"

    println(foods)
    println(foods[0])

}