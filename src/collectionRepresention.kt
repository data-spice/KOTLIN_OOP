/*
===================================================================================================
String Representation- how a collection is represented as text

joinToString()- a function that combines elements into a new string

joinTo()- writes collection elements into an existing location such as StringBuilder

contentToString() - a function that is used to convert an array into a readable string showing its elements
 */



//What is StringBuilder?

fun main() {
    val numbers = listOf(10, 20, 30)
    println(numbers)

    println(numbers.toString())


    val fruits = setOf("Mango", "Orange", "Banana")

    val prices = mapOf(
        "Mango" to 100,
        "Orange" to 50
    )

    println("======================================================================")
    println(fruits)
    println(fruits.toString())
    println(fruits.joinToString())
    println(
        fruits.joinToString(
            separator = ", ",
            prefix = "Fruits: ",
            postfix = ".",
            limit = 2,
            truncated = " and others"
        )
    )
    println("======================================================================")
    println(prices)
    println(prices.toString())
    println("======================================================================")

    data class Student(
        val name: String,
        val marks: Int
    )

    val students = listOf(
        Student("Brian", 80),
        Student("Mary", 90)
    )

    println(students)
    println(students.joinToString())
    println("======================================================================")
    val result1 = numbers.joinToString(
        separator = ", ",
        prefix = "[",
        postfix = "]"
    ) { number ->
        "KSh $number"
    }

    val result = numbers.joinToString { "KSh $it" }
    println(result)
    println(result1)
    println("======================================================================")


    val buffer = StringBuilder("Registered: ")

    students.joinTo(
        buffer = buffer,
        separator = ", ",
        prefix = "[",
        postfix = "]"
    )

    println(buffer.toString())
    println("======================================================================")

    val numbers2 = arrayOf(10, 20, 30)

    println(numbers2)

    println(numbers2.contentToString())
    println("======================================================================")

    val numbers3 = arrayOf(
        arrayOf(1, 2),
        arrayOf(3, 4)
    )
    println(numbers3)

    println(numbers3.contentToString())

    println(numbers3.contentDeepToString())
    println("======================================================================")
}