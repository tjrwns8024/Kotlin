# 컬렉션 함수형 API

- 함수형 프로그래밍을 사용하면 컬렉션을 다룰 때 편리합니다.   

- 대부분의 작업에 라이브러리 함수를 활용 가능하고 코드를 아주 간결하게 만들 수 있습니다.   


## filter, map : 필수적인 함수들

- filter와 map은 컬렉션을 활용할 때 기반이 되는 함수라 할 수 있습니다. 

### filter

```kotlin
data class person(val name:String, val age:Int)

//filter함수는 컬렉션을 반복하면서 주어진 람다에 각 원소를 넘겨서 람다가 true를 반환하는 원소만 모읍니다. 

val list = listOf(1, 2, 3, 4)
println(list.filter{ it%2 == 0}) // 짝수만 필터링

>> 실행 결과

[2,4]
```

- 결과는 입력 컬렉션의 원소중에서 주어진 조건을 만족하는 원소만으로 이뤄진 새로운 컬렉션입니다.

```kotlin
val people = listOf(Person("tjrwns",18), Person("dnldjq",19))
println(people.filter{it.age > 18})

>>실행 결과
[Person(name=cnldjq,age = 19)]
```

### map

- filter함수는 컬렉션에서 원치 않는 원소들을 제거합니다.   

- 하지만 filter함수는 원소를 변환 할 수는 없습니다.   

- 원소를 변환하려면 map 함수를 사용해야합니다. 

```kotlin
val list = listOf(1,2,3,4)
println(list.map(it*it))

>>실행 결과
[1,4,9,16]
```

또한 사람의 리스트가 아닌 사람의 이름 리스트를 출력하고 싶다면 map으로 반환하면 됩니다. 

```kotlin
val sample = listOf(Person("tjrwns",18), Person("cnldjq",19))

println(sample.map{it.name})

>>실행 결과
[tjrwns, cnldjq]
```

위와 같은 filter, map 호출을 보다 쉽게 연결 시킬 수 있습니다. 

```kotlin
fun main(){
    val people = listOf(Person("tjrwns",18), Person("cnldjq",19))
    println(people.filter{ it.age!! > 18 }.map{it.name})
}

>> 실행 결과
[cnldjq]
```


## all, any, count, find : 컬렉션에 술어 적용

- 컬렉션에 대해 자주 수행하는 연산으로 컬렉션의 모든 원소가 어떤 조건을 만족하는지 판단하는 연산이 있습니다. 

- 바로 any, all가 이러한 연산입니다.  

- count 는 조건을 만족하는 원소의 개수를 반환합니다. 

- find는 조건을 만족하는 **첫 번째 원소**를 반환합니다.


### all, any  


아래의 예제는 어떤 사람의 나이가 18살 이하인지 판단하는 술어 함수입니다. 
```kotlin
val judgeTrue = { p: Person -> p.age <= 18}

//여기서 모든 원소가 이 술어를 만족하는지 궁금하다면 all 함수를 사용합니다. 

val sample = listOf(Person("tjrwns",18), Person("cnldjq",19))
println(sample.all(judgeTrue))

>>실행 결과 : false

//술어를 만족하는 원소가 하나라도 있는지 궁금하면 any를 사용합니다. 

println(sample.any(judgeTrue))

>>실행 결과 : true
```

이와 반대로 **!all**을 수행한 결과오 그 조건의 부정에 대해 **any**를 수행한 결과는 같습니다. 


### count

- count는 술어를 만족하는 원소의 개수를 구할 때 사용합니다. 

```kotlin
val sample = listOf(Person("tjrwns",18),Person("cnldjq",19))
println(sample.count(judgeTrue))

>> 실행 결과

1
```

### find

- 술어를 만족하는 원소를 **하나** 찾고 싶으면 find 함수를 사용합니다. 

```kotlin
val sample = listOf(Person("tjrwns",18),Person("cnldjq",19))
println(sample.find(judgeTrue))

>>실행 결과

Person(name = tjrwns, age = 18)
```

- 이 식은 조건을 만족하는 원소가 하나라도 있는 경우 가장 먼저 조건을 만족한다고 확인된 원소를 반환합니다. 


## groupBy : 리스트를 여러 그룹으로 이뤄진 맵으로 변경

- groupBy 함수는 특성을 파라미터로 전달하면 자동으로 구분해주는 역할을 합니다. 

```kotlin
val sample = listOf(Person("tjrwns",18),Person("cnldjq",19),Person("gkrh",18),Person("tlvek",19))

println(sample.groupBy{it.age})

>>실행 결과

{18 = [Person(name = "tjrwns",age = 18), Person(name = "gkrh", age = 18)],
19 = [Person(name = "cnldjq", age = 19), Person(name = "tlvek", age = 19)]}
```

- **groupBy**의 결과 타입은 Map<Int,List< Person >> 입니다.  

- 위의 예제는 컬렉션의 원소를 구분하는 특성이 **key**이고  **key**값에 따른 각 그룹의 값이 모인 **map**이다. 


```kotlin
val list = listOf("a","ab","b")
println(list.groupBy(String::first))

>>실행 결과
{a = [a,ab], b = [b]}
```


## flatMap과 flatten : 중첩된 컬렉션 안의 원소 처리


바로 예제를 통해 알아보도록 합시다. 
```kotlin
class Book(val title: String, val authors : List<String>)
```

- 책마다 저자가 한명 또는 여러명이 있습니다. 

- 도석관에 있는 책의 저자를 모두 모은 집합을 아래와 같이 가져올 수 있습니다. 

```kotlin
books.flatMap{it.authors}.toSet()
```

- flatMap 함수는 먼저 인자로 주어진 람다를 컬렉션의 모든 객체에 적용하고 람다를 적용한 결과 얻어지는 여러 리스트를 한 곳에 모읍니다.   

- 말이 좀 어렵습니다. 예제를 통해 살펴보도록 하겠습니다. 

```kotlin
val strings = listOf("abc","def")
println(strings.flatMap{ it.toList() })

>>실행 결과
[a, b, c, d, e, f]
```

- toList() 함수를 문자열에 적용하면 리스트가 만들어집니다. 

```kotlin
val books = listOf(Book("tjrwns",listOf("duftlagl")),
                    Book("cnldjq",listOf("gkrh")),
                    Book("tlvek", listOf("duftlagl","gkkw")))

println(books.flatMap{it.authors}.toSet())

>> 실행결과
[duftlagl, gkrh, gkwk]
```

