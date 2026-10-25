/*
===================================================================================================
                                  --- USES OF SUPER ---
===================================================================================================
-- In Kotlin super lets a class access an implementation or member from its parent class or an
   implemented interface, rather than using its own overridden implementation.
                this -> refers to the current object
                super -> refers to the parent implementation available to the current class
 */



open class Zoo{
    open fun sound(){
        println("All animals make sound")
    }
}

//Note that even if the constructor is empty it must be included in the parent class being inherited
class Lion(): Zoo(){
    override fun sound(){
        super.sound()
        println("Lions roar")
    }

}


fun main(){
    val lion1= Lion()
    lion1.sound()
}