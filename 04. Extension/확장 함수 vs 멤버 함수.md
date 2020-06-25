# 확장 함수 VS 멤버 함수

클래스가 멤버 함수를 가지고 동일한 receiver type 과 동일한 이름으로 정의된 확장 함수가 있으면 **멤버 함수**가 항상 우선입니다.   

아래의 코드를 보며 설명 하도록 하겠습니다. 

```kotlin
fun main(args:Array<String>){
    val car = Car()
    println(car.getPrice())
}

class Car{
    fun getPrice():Int{
        return 10000
    }
}

fun Car.getPrice():Int{
    return 20000
}

>> 실행결과
10000
```

Car클래스 내에 getPrice라는 멤버 함수가 존재하고 receiver typer으로 Car를 사용한 getprice라는 확장함수가 있습니다.   

이 경우 getPrice를 호출하면 멤버함수가 우선적으로 호출이 됩니다.

하지만 overload한 확장 함수는 확장 함수가 호출이 됩니다. 

```kotlin
fun main(args:Array<String>){
    val car = Car()
    println(car.getPrice(1))
}

class Car{
    fun getPrice():Int{
        return 10000
    }
}

fun Car.getPrice(price: Int):Int{
    return price + 20000
}

>> 실행결과
20001
```