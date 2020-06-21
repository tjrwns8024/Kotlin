# Kotlin chapter 5
## **Class**
- 클래스는 붕어빵 틀에 비유할 수 있고 인스턴스는 클래스로 생성한 객체의 실체인 붕아빵에 비유할 수 있습니다. 
- 코틀린에서의 클래스는 자바와 역할은 유사하지만 더 간결합니다.

### **클래스 선언**
- 다음은 클래스를 선언하고, 생성한 클래스로 인스턴스를 생성하는 방법을 나타냅니다.
```kotlin 
//클래스 선언
class Person{

}

//인스턴스 생성
val person = Person()
```

- 자바에서는 **new**키워드로 객체를 생성하지만 코틀린에서는 **new**키워드를 사용하지 않습니다. 

### **생성자**

```kotlin
class person(var name:String){

}
```
- 생성자에 초기화 코드를 작성하려면 다음과 같이 **constructor**로 생성자를 표현하고 블록에 코드를 자성합니다. 

```kotlin
class Person(){
    constructor(name: String){
        println(name)
    }
}

// 코틀린에서는 생성자 이외에도 init블록에 작성한 코드가 클래스를 인스턴스화 할 때 가장 먼저 초기화 됩니다. 

class Person(name: String){
    init{
        println(name)
    }
}
```

### **프로퍼티**
- 클래스의 속성을 사용할 때는 멤버에 직접 접근하며 이를 프로퍼티라고 한다. 
- 프로퍼티에 값을 쓰려면 = 기호로 값을 대입합니다.
- 속성에 값을 설정하거나 얻으려면 getter/ setter 메서드 없이 바로 점을 찍고 name 프로퍼티에 접근할 수 있습니다.

```kotlin
//클래스 선언
class Person(var name:String){

}

//인스턴스 생성
val person = Person("멋쟁이")
person.name = "키다리"  //쓰기

println(person.name)
```

### **접근제한자**

- 접근 제한자란 변수나 함수를 공개하는 데 사용하는 키워드입니다.
    - public (생략 가능) : 전체공개
    - private : 현재 파일 내부에서만 사용가능
    - internal : 같은 모듈 내에서만 사용가능
    - protected : 상속받은 클래스에서 사용가능

```kotlin
class A{
    val a = 1 //public
    private val b = 2
    protected val c = 3
    internal val d = 4
}
```

### **클래스 상속**
- 코틀린에서의 클래스는 기본적으로 상속이 금지됩니다. 
- 상속이 가능하게 하려면 **open** 키워드를 클래스 선언 앞에 추가합니다. 
```kotlin
open class Animal(){

}
class Dog:Animal(){

}

//생성자를 가지고 있는 경우
open class Animal(val name:String){

}
class Dog(name:String): Animal(name){

}
```
### **내부 클래스**
- 내부 클래스 선언에는 inner를 사용합니다. 
- 내부 클래스는 외부 클래스에 대한 참조를 가지고 있습니다. 

```kotlin 
class OuterClass{
    var a = 10

    //내부 클래스
    inner class OuterClass2{
        fun something(){
            a = 20 // 접근가능
        }
    }
}
```

### **추상 클래스**
- 추상 클래스는 미구현 메서드가 포함된 클래스를 말합니다.
- 추상 클래스는 직접 인스턴스화 할 수 없고 다른 클래스가 상속하여 미구현 메서드를 구현해야 합니다.

```kotlin
abstract class A{
    abstract fun func()

    fun func(){

    }
}

class B:A(){
    override fun func(){
        println("hello")
    }

}
val a = A() // 에러
val b = B()  // OK
```