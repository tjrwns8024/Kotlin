# **Collections( List, Map, Set)**

- **Collection**은 대부분의 프로그래밍 언어에 있는 자료구조입니다.

- **Collection**은 **Generic**으로 구현 되어 다양한 타입과 함께 사용될 수 있습니다.   

- 기본적으로 **collection**은 Mutable과 Immutable로 나뉩니다. 

- Mutable은 말 그대로 변할 수 없는 이라는 뜻을 가지며 생성하면 추가, 삭제가 가능합니다. 

- 이와 반대로 Immutable은 불변의 이라는 뜻을 가지며 수정이 되지 않습니다. 

![collection 상속 구조](https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRHIzN-upUPgOXPqLYV6s026PaD05qEvrpZ-Q&usqp=CAU)


## List

- List는 데이터가 저장하거나 삭제될 때 순서를 지키는 Collection입니다. 

- Mutable과 Immutable을 모두 지원합니다. 

### Immutable(수정할 수 없는)

- **listOf<타입>(아이템...)**으로 Immutable List를 생성 및 초기화를 할 수 있습니다.   

- Immuatable이므로 수정을 할 수 없기에 get만 가능합니다.   

```kotlin
fun main(){
    val sample= listOf<String>("tjrwns", "dbs", "cnldjq", "gkrhtlvek")
// val fruits= listOf("apple", "banana", "kiwi", "peach") -> 타입 생략 가능
    println("size: ${sample.size}")
    println("sample.get(2): ${sample.get(2)}")
    println("sample[3]: ${sample[3]}")
    println("sample.indexOf(\"cnldjq\"): ${sample.indexOf("cnldjq")}")
}

>> 실행결과
size: 4
sample.get(2): cnldjq
sample[3]: gkrhtlvek
sample.indexOf("cnldjq"): 2
```


### Mutable(수정가능한)

- 수정가능한 List는 **mutableListOf**로 선언합니다.   

- listOf와 비슷하지만, 추가 및 삭제가 가능합니다. 

```kotlin
fun main(){
    val sample= mutableListOf("tjrwns", "dbs", "cnldjq", "gkrhtlvek")
    sample.remove("tjrwns")
    sample.add("grape")
    println("sample: $sample")

    sample.addAll(listOf("wpqkf", "whgdmsrht"))
    println("sample: $sample")
    sample.removeAt(3)
    println("sample: $sample")
}

>> 실행 결과
sample: [dbs, cnldjq, gkrhtlvek, grape]
sample: [dbs, cnldjq, gkrhtlvek, grape, wpqkf, whgdmsrht]
sample: [dbs, cnldjq, gkrhtlvek, wpqkf, whgdmsrht]

```

## Set

- **Set**은 동일한 아이템이 없는 Collection입니다.   

- **Set**의 아이템들의 순서는 특별히 정해져 있지 않습니다.   

- **Set**은 null 객체를 갖고 있을 수 있습니다.  

- 동일한 객체는 추가될 수 없기 때문에 null도 1개만 갖고 있을 수 있습니다.  

### Immutable

- **setOf<타입>(아이템...)**으로 객체를 생성할 수 있습니다. 

```kotlin
val numbers = setOf<Int>(33, 22, 11, 1, 22, 3)
println(numbers)
println("size: ${numbers.size}")
println("contains(1): ${numbers.contains(1)}")
println("isEmpty(): ${numbers.isEmpty()}")

>> 실행결과
[33, 22, 11, 1, 3]
numbers.size: 5
numbers.contains(1): true
numbers.isEmpty(): false
```

forEach 또는 Iterator 등으로 모든 객체를 탐색할 수도 있습니다. 

### Mutable

- **mutableSetOf<타입>(아이템들...)** 로 생성할 수 있습니다. 

- 추가, 삭제가 가능합니다. 

```kotlin
val numbers = mutableSetOf<Int>(33, 22, 11, 1, 22, 3)
println(numbers)

numbers.add(100)
numbers.remove(33)
println(numbers)

numbers.removeIf({ it < 10 }) // 10 이하의 숫자를 삭제
println(numbers)

>>실행 결과
[33, 22, 11, 1, 3]
[22, 11, 1, 3, 100]
[22, 11, 100]
```

## Map

- **Map**은 key와 value를 짝지어 저장하는 Collection입니다.   

- Map의 key는 유일하기 때문에 동일한 이름은 허용 안합니다.   

### Immutable

- **mapOf<key type, value type>(아이템...)**으로 생성할 수 있습니다.   

- 아이템은 Pair객체러 표현하며, Pair에 key와 value를 넣을 수 있습니다.   

- Pair(A,B)는 A to B로 간단히 표현이 가능합니다.   
(가능한 이유: to 가 infix이기 때문)  

```kotlin
val numbersMap = mapOf<Int, String>(
            1 to "one", 2 to "two", 3 to "three")
    println("numbersMap: $numbersMap")
    val numbersMap2 = mapOf(Pair("1", "one"), Pair("2", "two"), Pair("3", "three"))
    println("numbersMap2: $numbersMap2")

>> 실행 결과
numbersMap: {1=one, 2=two, 3=three}
numbersMap2: {1=one, 2=two, 3=three}

```

- Map의 데이터를 읽는 것도 다른 Collection과 유사합니다.  

```kotlin
fun main(){
    val numbersMap = mapOf<Int, String>(
            1 to "one", 2 to "two", 3 to "three")
    println("numbersMap.get(1): ${numbersMap.get(2)}")
    println("numbersMap[\"1\"]: ${numbersMap[1]}")
    println("numbersMap[\"1\"]: ${numbersMap.values}")
    println("numbersMap keys:${numbersMap.keys}")
    println("numbersMap values:${numbersMap.values}")

    for (value in numbersMap.values) {
        println(value)
    }
}

>>실행 결과
numbersMap.get(2): two
numbersMap["1"]: one
numbersMap["1"]: [one, two, three]
numbersMap keys:[1, 2, 3]
numbersMap values:[one, two, three]
one
two
three
```

### Mutable

- **mutableMapOf<key type, value type>(아이템...)**으로 생성합니다.   

- 객체 추가는 **put**메소드이고 put메소드는 배열 방식도 지원합니다.

```kotlin
fun main(){
    val numbersMap = mutableMapOf<Int, String>(
            1 to "one", 2 to "two", 3 to "three")
    println("numbersMap: $numbersMap")

    numbersMap.put(4, "four")
    numbersMap[5] = "five"
    println("numbersMap: $numbersMap")

    numbersMap.remove(1)
    println("numbersMap: $numbersMap")

    numbersMap.clear()
    println("numbersMap: $numbersMap")
}

>>실행 결과
numbersMap: {1=one, 2=two, 3=three}
numbersMap: {1=one, 2=two, 3=three, 4=four, 5=five}
numbersMap: {2=two, 3=three, 4=four, 5=five}
numbersMap: {}
```

## Collection

- List와 Set은 Collection을 상속합니다.  

```kotlin
fun printAll(strings: Collection<String>) {
    for(s in strings) print("$s ")
    println()
}

val stringList = listOf("one", "two", "one")
printAll(stringList)

val stringSet = setOf("one", "two", "three")
printAll(stringSet)

>> 실행 결과
one two three
one two three
```