# Object 



코틀린에서는 **object 키워드**를 다양한 상황에서 사용하지만 모든 경우 클래스를 재정의하면서 동시에 **인스턴스(객체)를 생성**한다는 공통점이 있습니다. 


## 객체 선언 ( 싱글 톤 쉽게 만들기)

객체 지향 프로그래밍을 하다 보면, 인스턴스가 하나만 필요한 클래스가 유용한 경우가 많습니다.   

자바에서는 다음과 같이, 보통 클래스의 생성자를 private으로 선언하고, static 변수에 클래스 객체를 저장하는 패턴으로 구현합니다. 

```java
public class DataRepo{
    private static DataRepo INSTANCE;

    private DataRepo(){ }

    public static DataRepo getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataRepo();
        }
        return INSTANCE;
    }
}

```
위의 코드를 보면 상당히 길죠!!   

**코틀린은 object 키워드를 사용하여 싱글톤을 언어 자체에서 기본 지원**해줍니다. 

```kotlin
object DataRepo{ }

//코틀린 
>> val dataRepo = DataRepo

//자바
>> DataRepo dataRepoo = new DataRepo.INSTANCE;
```

이렇게 코틀린에서 싱글톤 선언은 **object** 키워드로 시작하면 되고, 이로써 싱글톤 작업이 단 한 문장으로 끝납니다.   

또한 코틀린에서 object는 그 자체로 하나의 객체이기 때문에, 바로 dot(.)을 이용하여 프로퍼티나 메서드에 접근가능합니다.

```kotlin
fun main(){
    Sample.ex = "예제1"
    Sample.ex2 = 2

    println("예제 이름: ${Sample.ex}, 에제 번호 : ${Sample.ex2}")
}

object Sample{
    var ex:String = " "
    var ex2: Int = 0
}

```
### 정리
- 코틀린에서 사용 -> 객체명만으로 사용가능  

- 자바에서 사용 -> 자동으로 생성된 INSTANCE 필드를 호출하여 사용가능


## Companion object

- 동반 객체는 최상위 수준에서는 사용할 수 없고 클래스 내부에 정의하여 사용합니다  

- 동반 객체는 클래스 내부에 정의된 객체 선언이라고 할 수 있습니다. 

- **동반 객체를 포함하는 클래스 내부에서는 동반객체의 속성이나 함수를 자신의 속성이나 함수인 것처럼 인식하므로 동반 객체의 이름을 지정하지 않고 사용가능합니다. **

```kotlin
class A{
    companion object{
        var total = 0
        var a:Int = 0
        var name:String = ""
    }
    
    fun plus(){
        total++
    }
}

fun main(){
    val test = A()
    test.plus()
    test.plus()
    
    A.name = "ddd"
    A.a = 3
    println("${A.a}" + A.name)
    println(A.total)
}

>>실행결과

3ddd
2
```