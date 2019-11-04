# **Kotlin chapter 2**
## **변수와 자료형**
> val username: String = "Kildong"
- 변경되지 않는 변수 username이 String자료형으로 선언되었고
"Kildong"이 값으로 할당되었습니다.
- 그런데 코틀린은 자료형을 지정하지 않고 변수를 선언하면 변수에 할당된 값을 보고 알아서 자료형을 지정할 수 있습니다. 
- 저것을 자료형을 추론한다라고 합니다.
> val username = "Kildong" // 코틀린이 자료형을 추론하여 자료형을 String 으로 결정
- 단 자료형을 지정하지 않는 벼수는 반드시 자료형을 추론 할 값을 지정해야 합니다. 

- 값이 할당되지도 않은 변수의 자료형은 추론 할 수 없기 때문입니다.
> val username //**자료형을 지정하지 않은 변수는 사용할 수 없다**

- 값을 할당하지 않으면서 변수를 선언하려면 자료형을 반드시 지정해야 합니다. 


※ TIP

- 변수 이름은 숫자로 시작하면 안된다.
- 변수 이름에는 when, if와 같이 코틀린에서 사용되는 키워드는 쓸 수 없다.
- 변수 이름은 의미 있는 단어를 사용하여 만드는 것이 좋다
- 여러 단어를 사용하여 변수 이름을 지을때 [카멜 표기법](https://sibalja.tistory.com/2)을 사용하는 것이 좋다.




## **자료형 검사하고 변환하기**
- 코틀린은 변수를 사용할 때 반드시 값이 할당되어 있어야 한다는 원칙이 있습니다. 
- 한편 값이 없는 상태는 null이라고 부릅니다. 
- 코틀린에서는 null상태인 변수를 허용하려면 물음표(?) 기호를 사용해 선언해야 합니다. 

 변수에 null 할당하기
```kotlin
fun main(){
    var str1: String = "Hello Kotlin"
    str1 = null // 오류!!! null을 허용하지 않음
    println("str1: $str1")
}
```

- 변수에 null 할당을 허용하려면 자료형 뒤에 물음표(?)기호를 명시해야 합니다.

```kotlin
fun main(){
    var str1:String? = "Hello Kotlin"
    str1 = null
    println("str1: $str1")
}
```

자료형 반환
- 코틀린에서는 자료형이 다르면 반환 함수를 사용해야 합니다.

```kotlin
val a: Int = 1 // Int형 변수에 a를 선언하고 1을 할당
val b: Double = a //자료형 불일치 
val c: Int = 1.1 //자료형 불일치
```

- 위 코드에서는 Int형 변수 a에 명시적으로 Double형으로 변환하는 toDouble() 메서드를 점(.)과 함께 붙여 사용합니다.

```kotlin
val b:Double = a.toDouble() //변환메서드 사용
```

자료형 검사하기
- **is** 키워드를 사용하면 됩니다.
- **is** 는 왼쪽 항의 변수가 오른쪽 항의 자료형과 같으면 true, 아니면 false를 반환합니다.

```kotlin
fun main(){
    val num = 256

    if(num is Int){
        print(num)
    }else if(num !is Int){
        print("Not a Int")
    }
}  // 실행결과 : 256
```