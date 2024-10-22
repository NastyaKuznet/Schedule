package com.example.schedule.model

data class ScheduleDay(
    var nameDay: Day,
): ScheduleItem

enum class Day(val ru: String){
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье"),
}