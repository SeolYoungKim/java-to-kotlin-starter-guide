package com.lannstark.lec18

data class Fruit(
    val id: Long?,
    val name: String,
    val factoryPrice: Int,
    val currentPrice: Int
) {
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}

fun main() {
    val fruits = listOf(
        Fruit(3, "사과", 1300, 1400),
        Fruit(1, "사과", 1000, 1200),
        Fruit(6, "바나나", 3000, 3100),
        Fruit(null, "사과", 1400, 1500),
        Fruit(2, "사과", 1200, 1300),
        Fruit(4, "사과", 1400, 1500),
        Fruit(9, "수박", 10000, 11000),
        Fruit(7, "바나나", 3100, 3200),
        Fruit(8, "바나나", 3200, 3300),
    )

    // filter & map
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    val apples2 = fruits.filterIndexed { index, fruit ->
//        println("index = $index, fruit = $fruit")
        fruit.name == "사과"
    }

    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { index, fruit -> index to fruit.currentPrice }  // kotlin.Pair로 만들 수 있다

    val nonNullApplePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.id }  // 결과 중 null이 아닌것만 추출한다


    // all : 조건을 모두 만족하면 true, 그렇지 않으면 false
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }
    println("isAllApple = $isAllApple")

    // none : 조건을 모두 불만족하면 true, 그렇지 않으면 false
    val isNoneApple = fruits.none { fruit -> fruit.name == "사과" }
    println("isNoneApple = $isNoneApple")

    // any : 조건을 하나라도 만족하면 true, 그렇지 않으면 false
    val isAnyApple = fruits.any { fruit -> fruit.name == "사과" }
    println("isAnyApple = $isAnyApple")

    // count : 개수를 센다
    val appleCount = fruits.count { fruit -> fruit.name == "사과" }
    println("appleCount = $appleCount")

    // sortedBy : 정렬 (default: 오름차순)
    val sortedByAscFruits = fruits.sortedBy { fruit -> fruit.currentPrice }
        .map { fruit -> fruit.currentPrice }
    println("sortedByAscFruits = $sortedByAscFruits")

    // sortedByDescending : 내림차순 정렬
    val sortedByDescFruits = fruits.sortedByDescending { fruit -> fruit.currentPrice }
        .map { fruit -> fruit.currentPrice }
    println("sortedByDescFruits = $sortedByDescFruits")

    // distinctBy : 중복 제거
    val distinctFruits = fruits.distinctBy { fruit -> fruit.name }  // 이름 기준으로 중복을 제거
        .map { fruit -> fruit.name }
    println("distinctFruits = $distinctFruits")

    // first : 첫번째 요소 (null이 아니어야 함. 결과가 없어 null이면 에러.)
    val firstApple = fruits.first { fruit -> fruit.name == "사과" }
    println("firstApple = $firstApple")

    // firstOrNull : 첫번째 요소 (null이어도 됨)
    val firstAppleNull = fruits.firstOrNull { fruit -> fruit.name == "멜론" }
    println("firstAppleNull = $firstAppleNull")

    // last : 마지막 요소 (null이 아니어야 함. 결과가 없어 null이면 에러.)
    val lastApple = fruits.last { fruit -> fruit.name == "사과" }
    println("lastApple = $lastApple")

    // lastOrNull : 마지막 요소 (null이어도 됨)
    val lastAppleNull = fruits.lastOrNull { fruit -> fruit.name == "멜론" }
    println("lastAppleNull = $lastAppleNull")

    // groupBy : 그룹핑하여 Map으로 반환
    // name을 기준으로 그룹핑
    val groupByName: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    println("groupByName = $groupByName")

    // name to List<factoryPrice>
    val groupByNameToFactoryPrice: Map<String, List<Int>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })
    println("groupByNameToFactoryPrice = $groupByNameToFactoryPrice")

    // associateBy : Map으로 변환
    // 중복되지 않는 key를 가지고 Map을 만들 때 사용
    // id to Fruit
    val idToFruit: Map<Long?, Fruit> = fruits.associateBy { fruit -> fruit.id }
    println("idToFruit = $idToFruit")

    // id to FactoryPrice
    val idToFactoryPrice: Map<Long?, Int> = fruits.associateBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })
    println("idToFactoryPrice = $idToFactoryPrice")

    // 중첩 컬렉션 처리
    val nestedFruits = listOf(
        listOf(
            Fruit(3, "사과", 1300, 1400),
            Fruit(1, "사과", 1000, 1200),
            Fruit(6, "바나나", 3000, 3100),
        ),
        listOf(
            Fruit(null, "사과", 1400, 1500),
            Fruit(2, "사과", 1200, 1300),
            Fruit(4, "사과", 1400, 1500),
        ),
        listOf(
            Fruit(9, "수박", 10000, 11000),
            Fruit(7, "바나나", 3100, 3200),
            Fruit(8, "바나나", 3200, 3300),
        ),
    )

    val samePriceFruits = nestedFruits.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }

    val samePriceFruits2 = nestedFruits.flatMap { list ->
        list.filter(Fruit::isSamePrice)
    }

    val samePriceFruits3 = nestedFruits.flatten()
        .filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)


private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
