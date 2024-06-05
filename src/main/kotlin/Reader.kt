import java.io.File

class Reader {
    fun readUsersFromFile (path: String): MutableList<String> {
        val users = File(path).useLines { it.toMutableList() }
        //users.forEach { it -> println(it) }

        return users
    }
}