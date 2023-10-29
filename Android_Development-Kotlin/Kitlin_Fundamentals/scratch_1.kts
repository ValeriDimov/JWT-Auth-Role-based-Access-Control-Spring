fun findResult(
    firstNumber: Int = 10,
    secondNumber: Int
): Boolean {
    return firstNumber > secondNumber
}

val isBigger = findResult(secondNumber = 8)
isBigger


//val intList = listOf(5, 4, 3, 2, 1)
//var result = intList[0]
//
//for (i in 1..4) {
//    if (i <= 0) {
//        continue
//    }
//    result *= intList.get(i)
//}
//
//println(result)



