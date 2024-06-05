fun main() {
    val reader = Reader()
    val converter = Converter()

    var users = reader.readUsersFromFile("src/main/kotlin/data.txt")
    var users2 = converter.convertArrayToUsers(users)

    //users.forEach { println(it) }
}
