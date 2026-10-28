/*
====================================================
    THE + OPERATOR IN COLLECTIONS
====================================================
-- The + operator creates a new collection by adding an element or combining collections.


===================================================
    THE - OPERATOR IN COLLECTIONS
===================================================
-- The - operator creates a new collection by removing matching elements.
 */


fun main(){
    val number=listOf<Int>(10,20,30)
    println(number+40)
    println(number+listOf<Int>(90,80))
    println(number-20)
    println(number-listOf<Int>(30,20))

    val students= mapOf(
        101 to "ME"
    )
    println(students+(102 to "them"))
}