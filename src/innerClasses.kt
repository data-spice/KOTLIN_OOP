/*
========================================================================================================================
                            --- KOTLIN INNER CLASSES ---
-- Inner class is a class declared inside another class that can access the properties and functions of the outer class
   instance.
   i.e.
        class Person(val name: String){

                inner class Job(val title:String){

                            fun display(){
                                println($name works as a $title)
                            }
                }
          fun main(){
            val person=Person("Victor")


            val job=person.Job("Developer") //create the person object first and then create the job object


            job.display()
========================================================================================================================

             }
 */

class School(
    val schoolName: String
){
    inner class Student(
        val studentName:String
    ){
        fun displayDetails(){
            println("$studentName studies in $schoolName")
        }
    }
}


fun main(){
    val school1=School("Dedan Kimathi University of Technology")
    val student1=school1.Student("Victor Mwaniki")

    student1.displayDetails()
}