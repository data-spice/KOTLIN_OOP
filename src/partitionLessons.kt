fun main(){
    val ages=listOf<Int>(15, 22, 17, 30, 12, 19)
    val result=ages.partition{it>17}
    println(result)
    println(result.first[2])
    println(result.second[0])

/*
creates partitions based on a condition, you can also use filter twice , also destruction is possible
 */

    val (adults,children)=ages.partition{
        it>17
    }

    println(adults)
    println(children)
}