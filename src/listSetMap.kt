/*
========================================================================================================================
 -- A collection is a way to store and organise multiple pieces of data in one variable.

========
1) LIST
========
-- Stores a list of registered patients.
-- Ordered


========
2) SET
========
-- Stores unique patient ID numbers ,preventing duplicates.


========
3) MAP
========
-- Connects each patient ID to the patient's name.


 */



fun main(){
    /*
===================================
LIST VS MUTABLE LIST OF
===================================
 */
    val patients= listOf("Mary","Brian")
    val editablePatients= mutableListOf("Kim","Sam")

    editablePatients.add("Abed")
    editablePatients.remove("Sam")
    println(editablePatients)

    println(patients.contains("Mary"))

    println(patients.size)

    println(patients.isEmpty())

/*
======================================
SETS - Unique values,no index access
=====================================
 */

    val id=mutableSetOf(1001,1002,1003,1004,1005)

    // id[0]=10034 invalid

    id.remove(1001)
    println(id.add(1007)) //returns a boolean if the operation is successful
    println(id)

/*
===============================
MAPS- Key value pairs
--map keys need to be unique
===============================
 */
    val students=mutableMapOf(
        101 to "Brian",
        102 to "Mary",
        103 to "John"
    )


    students[101]="Baraka"
    println(students[101])
    println(students.keys)
    println(students.values)


    val result=students[999] ?: "Not available"

    println(result)


    for((id,name) in students){
        println("ID: $id, Name: $name")
    }


}