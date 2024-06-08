import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Converter {
    fun convertArrayToUsers(array: List<String>): List<User> {
        var users: MutableList<User> = mutableListOf()
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        for(it in array) {
            var userString = it.split(";")

            var user = User()
            user.name = userString[0]
            user.gender = userString[1]
            user.birthday = LocalDate.parse(userString[2], formatter)
            user.phoneNumber = userString[3]
            if (userString[4] == "") {
                user.salary = 0
            } else {
                user.salary = userString[4].toInt()
            }

            users.add(user)
        }

        //users.forEach { println("${it.name}; ${it.gender}; ${it.birthday}; ${it.phoneNumber}; ${it.salary}") }
        return users
    }
}