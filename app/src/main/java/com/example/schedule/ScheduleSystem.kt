package com.example.schedule

import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Calendar

class ScheduleSystem() {

    private val firstWeek = mutableListOf(
        ScheduleDay(Day.MONDAY),
        ScheduleLesson("18:20-19:50",
            "Базы и хранилища данных",
            TypeLesson.LECTURE),
        ScheduleLesson("19:55-21:25",
            "Базы и хранилища данных",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.TUESDAY),
        ScheduleLesson("18:20-19:50",
            "Управление ИТ-проектами",
            TypeLesson.LECTURE),
        ScheduleLesson("19:55-21:25",
            "Управление ИТ-проектами",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.WEDNESDAY),
        ScheduleLesson("Весь день",
            "Нет пар",
            TypeLesson.NONE),
        ScheduleDay(Day.THURSDAY),
        ScheduleLesson("19:30-21:00",
            "Разработка Интернет-приложений",
            TypeLesson.LECTURE),
        ScheduleDay(Day.FRIDAY),
        ScheduleLesson("13:15-14:45",
            "Экономика Программной инженерии",
            TypeLesson.LECTURE),
        ScheduleLesson("15:00-16:30",
            "Экономика Программной инженерии",
            TypeLesson.PRACTICE),
        ScheduleLesson("16:40-18:10",
            "Экономика Программной инженерии",
            TypeLesson.PRACTICE),
        ScheduleLesson("19:30-21:00",
            "Тестирование ПО",
            TypeLesson.LECTURE),
        ScheduleDay(Day.SATURDAY),
        ScheduleLesson("11:20-12:50",
            "Тестирование ПО",
            TypeLesson.PRACTICE),
        ScheduleLesson("13:15-14:45",
            "Тестирование ПО",
            TypeLesson.PRACTICE),
        ScheduleLesson("15:00-16:30",
            "Технологии прикладного программирования",
            TypeLesson.PRACTICE),
        ScheduleLesson("16:40-18:10",
            "Технологии прикладного программирования",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.SUNDAY),
        ScheduleLesson("Весь день",
            "Нет пар",
            TypeLesson.NONE),
    )

    private val secondWeek = mutableListOf(
        ScheduleDay(Day.MONDAY),
        ScheduleLesson("16:40-18:10",
            "Анализ данных",
            TypeLesson.LECTURE),
        ScheduleLesson("18:20-19:50",
            "Базы и хранилища данных",
            TypeLesson.LECTURE),
        ScheduleDay(Day.TUESDAY),
        ScheduleLesson("18:20-19:50",
            "Управление ИТ-проектами",
            TypeLesson.LECTURE),
        ScheduleLesson("19:55-21:25",
            "Управление ИТ-проектами",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.WEDNESDAY),
        ScheduleLesson("18:20-19:50",
            "Базы и хранилища данных",
            TypeLesson.PRACTICE),
        ScheduleLesson("19:55-21:25",
            "Базы и хранилища данных",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.THURSDAY),
        ScheduleLesson("19:30-21:00",
            "Разработка Интернет-приложений",
            TypeLesson.LECTURE),
        ScheduleDay(Day.FRIDAY),
        ScheduleLesson("15:00-16:30",
            "Анализ данных",
            TypeLesson.PRACTICE),
        ScheduleLesson("16:40-18:10",
            "Анализ данных",
            TypeLesson.PRACTICE),
        ScheduleLesson("19:30-21:00",
            "Тестирование ПО",
            TypeLesson.LECTURE),
        ScheduleDay(Day.SATURDAY),
        ScheduleLesson("11:20-12:50",
            "Тестирование ПО",
            TypeLesson.PRACTICE),
        ScheduleLesson("13:15-14:45",
            "Тестирование ПО",
            TypeLesson.PRACTICE),
        ScheduleLesson("15:00-16:30",
            "Технологии прикладного программирования",
            TypeLesson.PRACTICE),
        ScheduleLesson("16:40-18:10",
            "Технологии прикладного программирования",
            TypeLesson.PRACTICE),
        ScheduleDay(Day.SUNDAY),
        ScheduleLesson("Весь день",
            "Нет пар",
            TypeLesson.NONE),
    )

    private var dayList = mutableListOf<ScheduleItem>()
    private var weekList = mutableListOf<ScheduleItem>()
    private var selectedDay = Day.MONDAY

    fun getDayList(): MutableList<ScheduleItem>{
        return dayList
    }

    fun getWeekList(): MutableList<ScheduleItem>{
        return weekList
    }

    fun getSelectedDay(): Day{
        return selectedDay
    }

    init {
        val numberWeek = (Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) + 1) % 2
        weekList = when(numberWeek){
            1 ->  firstWeek
            else -> secondWeek
        }
        val numberDayOfWeek = LocalDate.now().dayOfWeek

        when(numberDayOfWeek){
            DayOfWeek.MONDAY -> findDay(Day.MONDAY)
            DayOfWeek.TUESDAY -> findDay(Day.TUESDAY)
            DayOfWeek.WEDNESDAY -> findDay(Day.WEDNESDAY)
            DayOfWeek.THURSDAY -> findDay(Day.THURSDAY)
            DayOfWeek.FRIDAY -> findDay(Day.FRIDAY)
            DayOfWeek.SATURDAY -> findDay(Day.SATURDAY)
            else -> findDay(Day.SUNDAY)
        }
    }

    private fun findDay(day: Day){
        selectedDay = day
        var flag = false
        for(i in weekList){
            if(i is ScheduleDay){
                flag = i.nameDay == day
            }else if(flag){
                dayList.add(i)
            }
        }
    }

}