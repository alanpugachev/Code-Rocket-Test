import java.time.Duration
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun main() {
    val reader = Reader()
    val converter = Converter()

    var users = converter.convertArrayToUsers(reader.readUsersFromFile("src/main/kotlin/data.txt"))

    // print all users data
    users.forEach{
        println("${it.name};${it.gender};${it.birthday};${it.phoneNumber};${it.salary}")
    }

    // amount of men and women
    println("Amount of women: ${users.filter { it.gender == "жен" }.count()}")
    println("Amount of men: ${users.filter { it.gender == "муж" }.count()}")

    // age greater than 25
    println("Greater than 25: ${users.filter { ChronoUnit.YEARS.between(it.birthday, LocalDate.now()) > 25 }.count()}")

    // average salary
    println("Average salary: ${users.sumOf { it.salary } / users.size}")

    // amount of women who has phone number
    println("Amount of women who has phone number: ${users.filter { it.gender == "жен" && it.phoneNumber.isNotEmpty() }.count()}")
}
