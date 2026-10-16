/*
================================================================================================
    -- lateinit delays initialization till later ie
            lateinit var someThing: String

================================================================================================
        ---    LAZY INITIALIZATION ---
   -- This means delaying of initialization of a variable until a value is given i.e.
        val result by lazy{
            println("calculation")
            10*5
        }
   -- Suppose that result is the result of a very computationally expensive task.
      Kotlin will allow you to access the result variable but the actual logic in the lazy block will run
      on the first access of the result then use the stored value of the result ie
                    println(result)
                    println(result)
                    println(result)

                    OUTPUT:     calculation //print 1 -> First initialization
                                50
                                50 //print 2 -> uses the stored value onwards
                                50 //print 3
================================================================================================

 */



fun main(args: Array<String>){

    val user1=User("Victor","Mwaniki",23)

    // This object will be initialized when the object is first used
    val user2 by lazy{
        User("Dotvyesky","Malboros",56)
    }

    println(user2.firstName)

}