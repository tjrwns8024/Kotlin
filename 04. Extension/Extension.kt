class School(){
    fun everyday():String{
        return "365 일"
    }
}

fun School.goSchool():School{
    println("학교 가기 싫다")

    return this
}

fun main(){
    val school:School = School()

    println(school.goSchool().everyday())
}