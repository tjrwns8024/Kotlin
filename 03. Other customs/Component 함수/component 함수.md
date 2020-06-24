# **구조 분해 선언과 component 함수**

구조 분해를 사용하며 복합적인 값을 분해해서 여러 다른 변수를 한꺼번에 초기화 할 수 있다. 

## 구조 분해 선언


```kotlin
val a = Point(30,40)
val (x,y) = a   // x와 y 변수를 선언한 다음에 a의 여러 컴포넌트로 초기화합니다. 
println(x)

// 30

println(y)

//40
```

<br/>

구조 분해 선언은 일반 변수 선언과 비슷해 보입니다. 다만 =의 좌변에 여러 변수를 괄호로 묶었다는 점이 다릅니다. 
내부에서 구조 분해 선언은 다시 관례를 사용합니다.   

구조 분해 선언의 각 변수를 초기화하기 위해 **componentN** 이라는 함수를 호출합니다.  
여기서 N은 구조 분해 선언에 있는 변수 위치에 따라 붙는 번호입니다.   


```kotlin
val (x,y) = a //는 아래와 같이 컴파일 됩니다. 

val x = a.component1()
val y = a.component2()
```

data 클래스의 주 생성자에 들어있는 프로퍼티에 대해서는 컴파일러가 자동으로 componentN 함수를 만들어줍니다.  

아래 예제는 데이터 타입이 아닌 클래스에서 이런 함수를 어떻게 구현하는지 보여줍니다. 

```kotlin
class Point(val x:Int, val y:Int){
    operator fun component1() = x
    operator fun component2() = y
}
```

**구조 분해 선언** 함수에서 여러 값을 반환할 때 유용합니다. 여러 값을 한꺼번에 반환해야 하는 함수가 있다면 반환해야 하는 모든 값이 들어갈 데이터 클래스를 정의하고 함수의 반환 타입을 그 데이터 클래스로 바꿉니다. 

```kotlin
data class NameComponents(val name: String, val extension: String)

fun splitName(fullName: String): NameComponents{
    val result = fullName.split('.',limit = 2)
    return NameComponents(result[0], result[1])
}

>> 실행 코드

val(name, ext) = splitName("example.kt")

println(name)
//example

println(ext)
//kt

```

<br/>

배열이나 컬렉션에도 componentN 함수가 있음을 안다면 이 예제를 더 개선할 수 있습니다.   
크기가 정해진 컬렉션을 다루는 경우 구조 분해가 특히 더 유용합니다.   

표준 라이브러리의 Pair와 Triple은 그 안에 담겨있는 원소의 의미를 말해주지 않으므로 경우에 따라 가독성이 떨어질 수 있는 반면, 직접 클래스를 작성할 필요가 없으므로 코드는 더 단순해집니다. 

<br/>


## 구조 분해 선언과 루프 

함수 본문 내의 선언문뿐 아니라 변수 선언이 들어갈 수 있는 장소라면 어디든 구조 분해 선언을 사용할 수 있다. 예를 들어 루프 안에서도 구조 분해 선언을 사용할 수 있다. 

```kotlin
fun printEntries(map:Map<String, String>){
    for((key, value) in map){
        println("$key -> $value")
    }
}

>>실행 코드

val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
printEntries(map)


//Oracle -> Java
//JetBrains -> Kotlin
```

 

 ## 번외

 ### 이항 산술 연산 오버로딩

 연산자를 오버로딩하는 함수 앞에는 꼭 **operator** 키워드를 붙여야 합니다.  
**operator** 키워드를 붙임으로써 어떤 함수가 관례를 따르는 함수임을 명확히 할 수 있습니다. 


코틀린에서는 직접 연산자를 만들어 사용할 수 없고 언어에서 미리 정해둔 연산자만 오버로딩할 수 있으며 관례에 따르기 위해 클래스에서 정의해야 하는 이름이 연산자별로 정해져 있습니다. 

