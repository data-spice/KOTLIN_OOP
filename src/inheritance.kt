//Mark the class as open
open class Vehicle(
    val name: String,
    val color: String
){
    fun move(){
        println("$name is moving")
    }

    fun stop(){
        println("$name has stopped")
    }
}

// Inheritance in action

class Car(
    val engines: Int,
    val doors: Int,
    name: String,
    color: String
): Vehicle(name, color) {

}

class Plane(
    val engines: Int,
    val doors:Int,
    name: String,
    color: String
): Vehicle(name,color){

}