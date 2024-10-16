package com.example.schedule

data class ScheduleLesson(
    var time: String,
    var nameLesson: String,
    var typeLesson: TypeLesson,
): ScheduleItem

enum class TypeLesson(val ru: String){
    LECTURE("Лекция"),
    PRACTICE("Практика"),
}