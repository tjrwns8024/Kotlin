# Constructor

- 코틀린에서 클래스는 `class` 라는 키워드를 사용해 선언할 수 있습니다. 

```kotlin
class Sample{ 
    //do Something
}

//  클래스의 header, body는 생략 가능
class Sample
```

## Primary Constructor

- 코틀린의 클래스는 하나의 **primary constructor**와 다수의 **secondary constructor**을 가질 수 있습니다. 

- 이때 primary constructor의 경우 클래스 헤더에 위치합니다. 

```kotlin
class Sample constructor(name:String){
    // do something
}
```

- 이때 primary constructor가 `annotation`이나 `접근 제한자`를 갖고 있지 않다면, **constructor**  키워드를 생략할 수 있습니다.

```kotlin
class Person(name:String){
    // do something
}
```

- primary constructor에서는 어떤 실행문도 포함 될 수 없습니다.  

- 만약 초기화 하는 코드를 넣고 싶을 경우 **init 블럭**을 이용하면 가능합니다. 

```kotliln
class Sample(name: String) {
    val firstProperty = "First property: $name".also(::println)
 
    init {
        println("First initializer block that prints ${name}")
    }
 
    val secondProperty = "Second property: ${name.length}".also(::println)
 
    init {
        println("Second initializer block that prints ${name.length}")
    }
}
 
fun main() {
    val person = Sample("tjrwns")
}

>> 실행 결과
First property: tjrwns
First initializer block that prints tjrwns
Second property: 6
Second initializer block that prints 6
```

- 위와 같이 인스턴스를 초기화 할때, init블록과 property 선언 및 초기화는 같은 우선순위를 가져 **위에서부터 선언된 순서대로 수행됩니다**. 

## Secondary Constructors

- 코틀린은 `constructor`키워드를 통해 secondary constructor를 가질 수 있습니다. 

- 이는 primary constructor와 다르게 생략이 불가능합니다. 

```kotlin
class Person {
    var children: MutableList<Person> = mutableListOf<Person>();
    constructor(parent: Person) {
        parent.children.add(this)
    }
}
```

- 위의 예제에서 body에 구현된 constructor는 secondary constructor입니다. 

