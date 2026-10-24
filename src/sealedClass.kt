/*
=================================================================================================
                            --- WHAT IS A SEALED CLASS  ---
 -- Suppose your clinic fas three possible appointment status in an enum class:  SCHEDULED, COMPLETED , CANCELLED.
    This works perfectly if all you need is a name for each status. But what if you need each status to contain
    different information?
    For example:
                - A SCHEDULED appointment should contain its appointment date.
                - A COMPLETED appointment should contain the doctors notes.'
                - A CANCELLED appointment should contain the reason for the cancellation.
          -- A sealed class lets each subtype have its own structure.

=================================================================================================
                             ---    CREATING A SEALED CLASS    ---
    sealed class AppointmentStatus{

            // Subtypes
         data class Scheduled(
                val appointmentDate: String
            ): AppointmentStatus()

         data class Completed(
                val doctorsNotes: String
            ): AppointmentStatus()

         data class Cancelled(
                val reason : String
            ): AppointmentStatus()

    }

    -- The above can be used as follows:
            val status= AppointmentStatus.Cancelled("Patient requested the cancellation")
=================================================================================================
                        ---  USING A WHEN CLAUSE IN THE SEALED CLASS--


fun displayStatus(status: AppointmentStatus) {

    when (status) {

        is AppointmentStatus.Scheduled ->
            println("Appointment date: ${status.appointmentDate}")

        is AppointmentStatus.Completed ->
            println("Doctor's notes: ${status.doctorNotes}")

        is AppointmentStatus.Cancelled ->
            println("Cancellation reason: ${status.reason}")
    }
}


-- The above can be used as follows:
        val appointmentStatus =
            AppointmentStatus.Cancelled("Doctor unavailable")

        displayStatus(appointmentStatus)


        OUTPUT:
            Cancellation reason: Doctor unavailable

=================================================================================================
 */

class Student(
    val name: String,
    val marks: Int,
    val result: ExamResult
)

sealed class ExamResult {

    data class Passed(
        val comment: String
    ) : ExamResult()

    data class Failed(
        val comment: String
    ) : ExamResult()

    data class Absent(
        val comment: String
    ) : ExamResult()
}

fun displayResult(student: Student) {

    when (student.result) {

        is ExamResult.Passed ->
            println("${student.name} passed with ${student.marks} marks.")

        is ExamResult.Failed ->
            println("${student.name} failed with ${student.marks} marks. Try harder next time.")

        is ExamResult.Absent ->
            println("${student.name} was absent during the examination.")
    }
}

fun main() {

    val student1 = Student(
        "Alexorov",
        90,
        ExamResult.Passed("Truly a work of art")
    )

    val student2 = Student(
        "Mary",
        32,
        ExamResult.Failed("Needs more revision")
    )

    val student3 = Student(
        "John",
        0,
        ExamResult.Absent("Did not attend")
    )

    displayResult(student1)
    displayResult(student2)
    displayResult(student3)
}






