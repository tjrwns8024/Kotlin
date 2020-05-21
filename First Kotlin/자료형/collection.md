# Kotlin chapter 7 
### **리스트**
- 리스트는 배열처럼 같은 자료형의 데이터들을 순서대로 가지고 있는 자료구조입니다. 

- 중복된 아이템을 가질 수 있고 추가, 삭제 , 교체 등이 쉽습니다. 

>요소를 변경할 수 없는 읽기 전용 리스트는 listOf()메서드로 작성 할 수 있습니다 

```kotlin
val foods:List<String> = listOf("라면","갈비","밥")
```
>형추론으로 자료형 생략 가능
```kotlin
val foods = listOf("라면","갈비","밥")
```
>요소를 변경하는 리스트를 작성할 때는 mutableListOf()메서드를 사용

```kotlin
val foods = mutableListOf("라면","갈비","밥")

foods.add("초밥")  //초밥을 맨뒤에 추가
foods.removeAt(0)  //맨 앞의 아이템 삭제
foods[1] = "부대찌개" //foods.set(1, "부대찌개") 1번 인덱스의 아이템을 부대찌개로 변경

println(foods)     // [갈비,부대찌개,초밥]

println(foods[0])  // 갈비
println(foods[1])  // 부대찌개
println(foods[2])  // 초밥
```

### **맵**
- 맵은 키와 값의 쌍으로 이루어진 키가 중복될 수 없는 자료구조입니다. 

- 맵의 요소에 접근할 때는 대괄호 안에 키를 요소명으로 작성하여 접근합니다. 

```kotlin
//읽기 전용 맵
val map = mapOf("a"to 1, "b" to 2, "c" to 3)

//변경 가능한 맵
val citiesMap = mutableMapof("한국" to "서울", "일본" to "동경", 
"중국" to "북경")

// 요소에 덮어쓰기
citiesMap["한국"] = "서울특별시"

//추가
citiesMap["미국"] = "워싱턴"
```

> 맵 전체의 키와 값을 탐색할 때는 간단히 탐색 가능
```kotlin
for((k,v) in map){
    println("$k -> $v")
}
```

### **집합**

- 집합은 중복되지 않는 요소들로 구성된 자료구조입니다.

- 리스트와 맵과 함께 대표적인 기본 자료구조이다. 

```kotlin
//읽기 전용 집합
val citySet = setOf("서울", "수원", "부산")

//수정 가능한 집합
val citySet2 = mutableSetOf("서울","수원","부산")

citySet2.add("안양")       // [서울, 수원, 부산, 안양]
citySet2.remove("수원")    // [서울, 부산, 안양]

//집합의 크기
println(citySet2.size)  //3 
//'서울'이 집합에 포함되어 있나요
println(citySet2.contains("서울"))
```