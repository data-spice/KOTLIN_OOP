data class Patient(
    val name: String,
    val age: Int
)

fun main() {
    val patients = listOf(
        Patient("Brian", 25),
        Patient("Mary", 17),
        Patient("John", 40),
        Patient("Alice", 30),
        Patient("Peter", 15)
    )

    //filter - Selects elements that satisfy a condition
    //
    val adults= patients.filter{
        it -> it.age>=18
    }
    println(adults)

    //map - transform every element into something else by looping through each

    val names= patients.map{
        patient -> patient.name
    }

    val nextYear = patients.map{
        it.age + 1

    }

    val upperCaseNames=patients.map{it.name.uppercase()}

    val adultNames=patients.filter{it.age>=18}.map{it.name}

    println(adultNames)
    println(names)
    println(upperCaseNames)
    println(nextYear)



    val employees=listOf(
        listOf("A","B"),
        listOf("C","D")
    )

    println(employees)

    //combines the 2d list of things in this case it was the employees list of lists
    println(employees.flatten())



}