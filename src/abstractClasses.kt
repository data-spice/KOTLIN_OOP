/*
=======================================================================================================
                                 --- ABSTRACT CLASSES ---
 -- An abstract class is a class designed to serve as a foundational class to other classes.
    It can contain properties and functions that subclasses share, as well as functions that subclasses
    share, as well as the functions that the subclasses are required to implement.
                        
 */


/*
 -- abstract tells kotlin that the class is intended to be a base class and cannot be instantiated directly.
 -- The properties will be available to the subclasses.
 */

abstract class HospitalEmployee(
    val name: String,
    val employeeId: Int,
    val salary: Double
){
    fun displayDetails(){
        println("""
            =========================
            Name: $name
            EmployeeID: $employeeId
            Salary: $salary
        """.trimIndent())
    }
}


class Doctor(
    name: String,
    employeeId: Int,
    salary: Double
): HospitalEmployee(name, employeeId, salary)


class Nurse(    name: String,
                employeeId: Int,
                salary: Double
): HospitalEmployee(name, employeeId, salary)





fun main (){
    val doc=Doctor("Malaila",1001,10000000.00)
    val nur=Doctor("Amona",1001,10056000.00)

    doc.displayDetails()
    nur.displayDetails()
}