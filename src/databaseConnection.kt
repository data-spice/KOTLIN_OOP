import java.sql.DriverManager

fun main(){
    val url ="jdbc:postgresql://localhost:5432/kotlin_db"
    val username= "postgres"
    val password="Vatika@24.sql"

    val connection=DriverManager.getConnection(
        url,
        username,
        password
    )

    println("Database connected successfully")

    connection.close()


}