/*
========================
groupby()
========================
--Takes a collection and groups its elements according to a value calculated for each element.
 */
data class Patient2(
    val patientId: Int,
    val name: String,
    val age: Int
)
fun main(){
    val marks= listOf<Int>(45,70,85,40,90,65)

    val result= marks.groupBy{
        if(it >= 50 ) "Pass" else "Fail"
    }

    println(result)
    println(result["Pass"])
    println(result["Fail"])


    val patients = listOf(
        Patient2(101, "Brian", 15),
        Patient2(102, "Mary", 25),
        Patient2(103, "John", 17),
        Patient2(104, "Grace", 30),
        Patient2(105, "Peter", 25)
    )



}