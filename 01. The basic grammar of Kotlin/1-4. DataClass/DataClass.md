# **DataClass**

data class 란 말 그대로 클래스가 data를 가지고 있는 클래스입니다. 하지만 기존 클래스와 다르게 data만 가지고 아무것도 하지 않습니다. 

## data class 특징

- 데이터 클래스의 생성자(primary constructor)는 1개 이상의 프로퍼티를 선언되어야 합니다.   

- 데이터 클래스의 생성자 프로퍼티는 val or var로 선언해야 합니다.   

- 데이터 클래스에는 inner, abstract, sealed, open을 붙일 수 없습니다.  

- 데이터 클래스는 상속받을 수 없습니다.

<br/>

## data class 사용법

```kotlin
data class Sample(var name:String, var age: Int)
```

- 여기서 **data class**는 data의 사용을 쉽게 해주려고 만든 class임을 알아두어야 한다.   

- 이때문에 컴파일러가 컴파일 할 때 제공하는 함수가 있다.

### 제공해주는 함수
  

- copy()  

- hashCode()

- equals()  

- toString()  
 
- componentN()


## Copy()

- copy( )는 객체의 복사본을 만들어 리턴합니다.   

- 객체는 얕은 복사로 생성됩니다.   

- copy()의 인자로 생성자에 정의된 프로퍼티를 넘길 수 있습니다.   

- 받은 프로퍼티만 변경되고 나머지 값은 동일한 객체가 생성됩니다.  

```kotlin
val sample = Sample("tjrwns",3)

val smaple2 = sample.copy(name = "sample")

println(sample)
println(sample2)

>>실행 결과
Sample(name=tjrwns, age = 3)
Sample(name=sample, age = 3)

```

<br/>

## toString(),hashCode(), equals()

- toString()은 생성자에 정의된 프로퍼티만 출력하고, 클래스 내에 지역변수로 선언한 프로퍼티는 출력하지 않습니다.   

- 지역변수도 toString()에 출력하고 싶으면 직접 오버라이드해서 구현해줘야 합니다. 

```kotlin
data class Sample(val name:String, val age:Int)

fun main(){
    val sample = Sample("tjrwns",3)

    val sample2 = sample.copy(name = "sample")

    println(sample.toString())
    println(sample.hashCode())
    println(sample2.toString())
    println(sample3.hashCode())

    if(sample.equals(sample2)){
        println("Equals")
    }else{
        println("Not Equlas")
    }
}


>>실행 결과

Sample(name=tjrwns, age=3)
-1280129597
Sample(name=sample, age=3)
1864843161
Not Equlas

```

## 데이터 분해 및 대입(Destructuring Declarations)

우리는 일반적으로 객체의 내부 변수를 다른 변수에 대입하려면 아래와 같은 코드를 통해 해야합니다. 

```kotlin
val sample = Sample("tjrwns",3)
val userName = sample.name
val userAge = sample.age
```
하지만 데이터클래스를 사용하면 한줄로 나타낼 수 있습니다. 

```kotlin
val sample = Sample("tjrwns",3)

val (userName,userAge) = sample
```

### 동작원리

위의 예제를 자바로 변환해본다면 위에서 언급했던 componentN() 메소드가 생성이 됩니다. 

```java
public final class Sample {
    public Site(String name, Int age) {
        this.name = name;
        this.age = age;
    }

    public final String component1() {
        return this.name;
    }

    public final Int component2() {
        return this.age;
    }
}
```

여기서 생성된 componentN()의 리턴 값이 name, age 변수에 대입이 되는 것입니다. 


## 정리

- data class는 데이터 저장을 목적으로 하는 클래스로 사용하기 좋습니댜.  

- 또한 data class는 Destructuring Declarations를 지원하기 때문에 코드를 간결하고 가독성있게 만들어 줍니다. 