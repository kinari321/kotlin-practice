package com.example.thymeleafhelloworld.service

import com.example.thymeleafhelloworld.domain.Student

interface StudentService {

    // 生徒のリストを取得
    fun getStudents(): List<Student>

    fun findStudentById(id: String): Student?

    fun createStudent(student: Student)
}