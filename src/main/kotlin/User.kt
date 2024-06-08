import java.time.LocalDate
import java.time.format.DateTimeParseException

class User {
    var name: String = ""
        set(value) {
            if (value.isEmpty()) {
                println("invalid name")
                // TODO default value
            } else {
                field = value
            }
        }

    var gender: String = ""
        set(value) {
            if (value.isEmpty() || !(value.equals("муж") || value.equals("жен"))) {
                println("invalid gender")
                // TODO default value
            } else {
                field = value
            }
        }

    var birthday: LocalDate = LocalDate.parse("2000-01-01")
        set(value) {
            try {
                // TODO default value
                field = LocalDate.parse(value.toString())
            } catch (e: DateTimeParseException) {
                println("invalid birthday: ${e.message}")
            }
        }

    var phoneNumber: String = ""
        set(value) {
            if (!isCorrectPhoneNumber(value)) {
                //println("invalid phone number")
                // TODO default value
            } else {
                field = value
            }
        }

    // no need to parse for invalid values
    // only for exceptions
    var salary: Int = 0

    fun isCorrectPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumberPattern = "^\\+7\\d{10}$" // start of line, +7, any digits 10 times, end of line
        return phoneNumber.matches(Regex(phoneNumberPattern))
    }

    // fallback option with regex
    fun isCorrectBirthDay(birthday: String): Boolean {
        val birthdayPattern = "\\d{2}[.]\\d{2}[.]\\d{4}"
        return birthday.matches(Regex(birthdayPattern))
    }
}
