# 확장 함수(Extension Function)

코틀린은 클래스 상속을 사용하지 않고도 새로운 기능을 가지는 클래스로 확장할 수 있습니다. 그것은 바로 **extension**입니다. 코틀린은 **extension function** **extension property**를 지원합니다. 

## 확장 함수(Extesion Function)

- 확장 함수는 **[확장하려는 대상.함수]**로 쉽게 생성이 가능합니다. 

아래의 예제를 봅시다. 

```kotlin
fun main(args:Array<String>){
    val car = Car()
    println(car.getBrandName())
}

class Car{
    fun getPrice():Int{
        return 10000
    }
}

// 확장함수 
fun Car.getBrandName(): String{
    return "BMW"
}

>> 실행결과
BMW
```

이로써 Car 클래스 멤버로 추가되거나 기존 함수를 수정하지도 않았지만  존재하지 않았던 getBrandName()이라는 함수가 만들어졌습니다.   

그런데 확장 함수의 Car에 커서를 올리면 receiver 파라미터가 사용되지 않아서 발생한 경고가 나옵니다.   

여기서 **receiver**란 **'확장 하려는 대상'**입니다.   
이번에는 해당 확장 함수에 receiver type 과 동일한 return type을 선언하여 실제 receiver를 사용해보겠습니다. 


```kotlin
fun main(args:Array<String>){
    val car = Car()
    println(car.getBrandName().getPrice())
}

class Car{
    fun getPrice(): Int{
        return 10000
    }
}

fun Car.getBrandName():Car{ //receiver type과 동일한 Car이므로 멤버 함수인 getPrice 까지 호출이 됩니다. 
    println("BMW")
    return this
}
```

### Basic Type을 이용한 확장 함수

Basic Type은 Int, Double, Byte와 같은 Number를 비롯해 Boolean, Array, String까지 다양합니다.   

```kotlin
fun main(args:Array<String>){
    println("Hello".getLongerString("Hi"))
}

fun String.getLongerString(x: String): String{
    return if(this.length > x.length) this else x
}

>> 실행결과
Hello
```

위의 예제를 분석해봅시다. 

1) "Hello".getLongerString("Hi")  
2) 확장하려는 대상, 확장 함수명(확장 함수 파라미터 타입)  
3) String.getLongerString(String)  

여기서 확장을 하려는 대상, 즉 receiver type이 String이고 확장 함수명은 getLongerString 그리고 파라미터 타입은 String입니다.   

약간 변형을 시켜봅시다. 

```kotlin
fun main(args:Array<String>){
    println("Hello".getLongerLength(3))
}

fun String.getLongerString(x: Int): Int{
    return if(this.length > x) this.length else x
}

>> 실행결과
5
```

## Extensions are resolved statically

```kotlin
fun main(args:Array<String>){
    printFuel(Bus())
}

open class Car
class Bus:Car()

fun Car.getFuel() = "gasoline"
fun Bus.getFuel() = "lpg"

fun printFuel(fuel:Car){
    println(fuel.getFuel())
}

>>실행 결과
gasoline
```

이 코드를 보면 의문점이 들 것입니다. 왜 Bus타입으로 호출을 했는데 Car타입의 확장 함수가 실행이 되었을까?  

정답은 확장 함수가 정적으로 전달되기 때문입니다.   
이는 printFuel함수에 파라미터 fuel은 Car 타입으로 정적인 상태로 있다는 것을 의미합니다. 

---
참고 : 서준수님의 브런치