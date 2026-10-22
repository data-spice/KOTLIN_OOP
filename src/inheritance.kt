//Mark the class as open
open class Vehicle(
    val name: String,
    val color: String
){
    fun move(){
        println("$name is moving")
    }

    open fun stop(){
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

    override fun stop(){
        println("$engines engines have stopped")
    }

}

class Plane(
    val engines: Int,
    val doors:Int,
    name: String,
    color: String
): Vehicle(name,color){

}


fun main(){
    val car =Car(1,4,"BMW","Red")
    val plane=Plane(4,2,"Boieng","Black")

    car.move()
    plane.move()
    car.stop()
    plane.stop()





}