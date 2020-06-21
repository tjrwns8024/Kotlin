# Kotlin chapter 2
## **함수**

- 함수(function)는 일정 동작을 수행하는 특정 형식의 코드 뭉치를 의미합니다. 
- 함수는 자바의 메서드에 해당합니다.  
> fun 함수명 (인수 1: 자료형, 인수2: 자료형2 ... ) : 반환자료형  

##### Example)

- 다음은 하나의 문자열을 인수로 받고 println( ) 메서드로 출력하는 greet( ) 함수를 작성하고 사용하는 예입니다.

- 코틀린에서는 반환값이 없을 때 Unit형을 사용합니다. 

- Unit은 자바의 void 에 대응합니다.

```kotlin 
fun greet(str: String) : Unit{
    println(str)
}

greet("안녕")
```

- 반환값이 Unit일 경우에는 다음과 같이 반환 자료형을 생략할 수 있습니다.

```kotlin 
fun greet(str:String){
    println(str)
}
```

> 메서드 VS 함수  
- 메서드와 함수는 혼동되는 용어입니다.
- 메서드는 객체와 관련된 함수입니다. 
- 함수는 좀 더 일반적인 용어이며 모든 메서드는 **함수**입니다.