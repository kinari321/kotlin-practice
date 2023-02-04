package com.example.thymeleafhelloworld.service

import com.example.thymeleafhelloworld.domain.Student
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl : StudentService {

    val studentList: MutableList<Student> = mutableListOf(
        Student(studentId = "1", firstName = "Bernard", lastName = "Rieux"),
        Student(studentId = "2", firstName = "Jea", lastName = "Tarrou"),
        Student(studentId = "3", firstName = "Raymond", lastName = "Rambert"),
    )

    override fun getStudents(): List<Student> {
        return studentList
    }

    override fun findStudentById(id: String): Student? {
        return studentList.find { it.studentId == id }
    }

    override fun createStudent(student: Student) {
        studentList.add(student)
    }

}