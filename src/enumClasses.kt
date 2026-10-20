/*
============================================================================================================
                                     --- ENUM DEFINITION ---
-- An enum is a way to define a fixed set of named constants
   i.e.     Assume an order status where the orders are in the following specific states:
                    enum class OrderStatus{
                            PENDING,
                            PROCESSING,
                            SHIPPED,
                            DELIVERED
                         }
============================================================================================================
 */



enum class Direction(
    var direction: String,
    var distance: Int
){
    NORTH("north",10),
    SOUTH("south",20),
    EAST("east",30),
    WEST("west",40)
}

fun main(){
    //accessing things in the enum class
    println(Direction.WEST.direction)
    println(Direction.WEST.distance)
    println(Direction.EAST.name)
    println(Direction.NORTH)
    println(Direction.SOUTH)



//.values() returns the values of the array then .contentToString() returns it in a readable format
    println(Direction.values().contentToString())

    for(direction in Direction.values()){
        println(direction)
    }

}