package com.example.thymeleafhelloworld.controller

import com.example.thymeleafhelloworld.domain.Student
import com.example.thymeleafhelloworld.form.CreateStudentForm
import com.example.thymeleafhelloworld.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/students")
    fun listStudents(model: Model): String {
        model.addAttribute("students", studentService.getStudents())
        return "students"
    }

    @GetMapping("/student/{studentId}")
    fun findStudent(@PathVariable("studentId") sId: String, model: Model): String {
        model.addAttribute("student", studentService.findStudentById(sId))
        return "student"
    }

    @PostMapping("/student")
    fun addStudent(createStudentForm: CreateStudentForm, model: Model): String {

        studentService.createStudent(
            Student(
                studentId = createStudentForm.studentId!!,
                lastName = createStudentForm.lastName!!,
                firstName = createStudentForm.firstName!!,
            )
        )
        return "redirect:/student/" + createStudentForm.studentId
    }

    @GetMapping("/student")
    fun createStudentPage(model: Model): String {
        model.addAttribute("studentForm", CreateStudentForm())
        return "new-student-form"
    }
}