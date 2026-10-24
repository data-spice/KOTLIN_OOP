/*
===================================================================================================
                                     --- INTERFACES ---
 --An interface is a contract that tells a class what abilities or behaviors it must provide.
 --Imagine a transport company has cars, motorcycles, buses and electric vehicles.
   --> Some vehicles can be started.Some can be charged. Some can be tracked using the GPS.
       These abilities do not necessarily belong to one family of classes. An electric car
       and an electric motorcycle are different types of vehicles, but both can be charged.
 -- An interface lets us define a shared ability without requiring the classes to inherit from the
    same parent class.
 -- For example, we could define a Chargeable interface.Any class that implements it promises to give the
    charging behaviour.


 */


//The function has no body because the interface specifies the required behavior not the implementation, similar to an abstract function.

interface Chargeable{
    fun charge()
}

class ElectricCar(): Chargeable{
    override fun charge() {
        println("The electric car is charging.")
    }
}


// This means that the class below implements the chargeable class

class ElectricMotorcycle():Chargeable{
    override fun charge() {
        println("The electric motorcycle is charging")
    }
}


fun main(){
    val car=ElectricCar()
    val bike=ElectricMotorcycle()

    car.charge()
    bike.charge()
}
