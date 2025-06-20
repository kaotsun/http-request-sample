import java.sql.DriverManager
import io.github.cdimascio.dotenv.dotenv

fun main() {
    val dotenv = dotenv()

    val url = "jdbc:mysql://${dotenv["DB_HOST"]}:${dotenv["DB_PORT"]}/${dotenv["DB_NAME"]}"
    val user = dotenv["DB_USER"]
    val password = dotenv["DB_PASSWORD"]

    val conn = DriverManager.getConnection(url, user, password)
    val stmt = conn.createStatement()

    val rs = stmt.executeQuery("SELECT * FROM users")
    println("Before update:")
    while (rs.next()) {
        println("${rs.getInt("id")}: ${rs.getString("name")} - ${rs.getInt("age")}")
    }

    val ps = conn.prepareStatement("UPDATE users SET age = age + 1 WHERE name = ?")
    ps.setString(1, "Jiro")
    ps.executeUpdate()

    val rs2 = stmt.executeQuery("SELECT * FROM users")
    println("After update:")
    while (rs2.next()) {
        println("${rs2.getInt("id")}: ${rs2.getString("name")} - ${rs2.getInt("age")}")
    }

    conn.close()
}

