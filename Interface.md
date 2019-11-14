# Kotlin chapter 6
## **인터페이스**


- 인터페이스는 미구현 메서드를 포함하여 클래스에서 이를 구현한다. 
- 주로 클래스에 동일한 속성을 부여해 같은 메서드라도 다른 행동을 할 수 있게 하는 데 사용합니다. 

```kotlin 
interface Runnable{
    fun run()
}
// 인터페이스는 구현이 없는 메서드 뿐만 아니라 구현된 메서드도 포함 가능

interface Runnable{
    fun run()

    fun fastRun() = println("빨리 달린다")
}
```
> **override?**  
>*  부모 Class에서 정의한 메서드를 자식 Class에서 변경하는 것

## **NULL**

- 코틀린에서는 기본적으로 NULL값을 허용하지 않습니다. 
- 따라서 모든 객체는 생성과 동시에 값을 대입하여 초기화해야합니다. 

```kotlin 
val a: String // 초기화를 반드시 해야함

val b: String = null // 코틀린은 기본적으로 null 허용안함

// null값 허용을 위해 자료형의 오른쪽에 ? 기호를 붙여준다.
val c: String? = null // ok 
```

### **lateinit 키워드로 늦은 초기화**
- 안드로이드를 개발할 때 초기화를 나중에 할 경우가 있다. 
- 이때는 lateinit키워드를 변수 선언 앞에 추가하면 됩니다. 
``` kotlin 
lateinit var a:String 

a = "hello"
println(a)
```
**단, 조건**
- **var변수**에서만 사용
- null값으로 초기화 불가
- 초기화 전에는 변수를 사용 할 수 없다

### **lazy로 늦은 초기화**
- lateinit이 **var**로 선언한 변수의 늦은 초기화라면 lazy는 값을 변경할 수 없는 **val**을 사용할 수 있습니다. 

```kotlin
val str:String by lazy{
    println("초기화")
    "hello"
}

println(str) // 초기화라고 찍힌후 hello로 초기화가 된다
println(str) // hello 로 str이 초기화 되었으므로 hello 가 찍힌다.
```
**조건**
- val에서만 사용합니다.   
- 조건이 적기 때문에 상대적으로 lateinit보다 편하게 사용할 수 있습니다. 

### **null값이 아님을 보증**
- 변수 뒤에 !!을 추가하면 null값이 아님을 보증한다. 
```kotlin 
val name: String? = "키다리"

val name2: String = name //error 
val name3: String? = name //ok

val name4: String = name!! //ok

```