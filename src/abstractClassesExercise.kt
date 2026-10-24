abstract class Vehicle2(
    var brand:String,
    val registrationNumber: String
){
    open fun move(
    ){
        TODO("Implement this later")
    }

    fun displayDetails(){
        println("""
            ===============================
            Brand: $brand
            Registration Number: $registrationNumber
            
        """.trimIndent())
    }
}


class Car2(
    brand: String,
    registrationNumber: String
): Vehicle2(brand, registrationNumber){

    override fun move()= println("The car is moving on two wheels.")
}


class mortorBike(
    brand: String,
    registrationNumber: String
): Vehicle2(brand, registrationNumber)
{
    override fun move()=println("The motorcycle is moving on two wheels")
}



fun main (){
    val car1=Car2("Toyota","KDA 123A")
    val bike1=mortorBike("Honda","KDB 456B")

    car1.displayDetails()
    bike1.displayDetails()



}