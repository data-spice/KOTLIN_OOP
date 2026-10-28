fun main(){
    //filter() - keeps only the elements that satisfy a certain condition

    val marks =listOf<Int>(10,20,30,40)

    val passed= marks.filter{
        it>=30
    }

    println(passed)


    /*
    filterIndexed() - is similar to filter(), but it gives you two things for each element:
            1. The element's index.
            2. The element itself.
     */


    val names=listOf<String>("Brian","Mary","John","Kim","Zed")

    val result=names.filterIndexed{
        index,name -> index%2==0
    }

    println(result)

    /*
    filterNot() - does the opposite of filter keeps the values where the condition is false

     */

    val notPassed= marks.filterNot{
            it>=30
    }

    println(notPassed)


    /*
    filterIsInstance() - filters elements based on their type rather than a condition that you write about their values
     */
    val items: List<Any> = listOf(
        "Brian",
        25,
        "Mary",
        40,
        true,
        "John"
    )

    val names2=items.filterIsInstance<String>()

    println(names2)

}