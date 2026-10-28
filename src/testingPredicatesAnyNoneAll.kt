/*
=========================================
            WHAT IS A PREDICATE
=========================================
-- A predicate is a condition or function that takes an element and
   return true or false.
-- The operations include any(), none() and all().

 */

fun main(){
    val isAdult: (Int) -> Boolean= {age -> age>=18}
// Int means the input is an integer.
// Boolean means the function returns true or false.
//{...} indicates the condition.


    val ages = listOf(15, 22, 17, 30)

    println(ages.any(isAdult))// at least one element matches
    println(ages.none(isAdult))// none of the elements matches

    println(ages.all(isAdult))//all the elements match


}