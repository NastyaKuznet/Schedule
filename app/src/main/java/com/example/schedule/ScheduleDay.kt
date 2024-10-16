package com.example.schedule

data class ScheduleDay(
    var nameDay: Day,
    //var listLessons: List<ScheduleLesson>,
): ScheduleItem

enum class Day(val ru: String){
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
}