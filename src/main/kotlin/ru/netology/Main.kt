package ru.netology

fun main() {
    val online = 0
    val second = 1
    val minute = 60
    val hour = 3_600
    val day = 86_400
    val twoDay = 172_800
    val threeDay = 259_200

    for (i in 1..5){
        val randomValue = (online..threeDay + 1).random()
        val realTime = if(randomValue < hour) {randomValue / 60} else {randomValue / 3600}

        printPeople(randomValue)
        printWasOnline(online, day, hour, second, minute, randomValue, realTime, twoDay, threeDay)
        printHoursOrMinutes(randomValue, hour, realTime)
    }
}

private fun printPeople(randomValue: Int){
    when (randomValue % 10) {
        0 -> println(" Марина")
        1 -> println(" Игорь")
        2 -> println(" Андрей")
        3 -> println(" Ольга")
        4 -> println(" Александр")
        5 -> println(" Светлана")
        6 -> println(" Евгений")
        7 -> println(" Михаил")
        8 -> println(" Роман")
        9 -> println(" Елизвета")
    }
}

private fun printWasOnline(online: Int, day: Int, hour: Int, second: Int, minute: Int,
    randomValue: Int, realTime: Int, twoDay: Int, threeDay: Int) {
    when (randomValue) {
        online -> println("Онлайн")
        in second until minute -> print("был(а) в сети только что\n")
        in minute until hour -> print("был(а) в сети $realTime ")
        in hour until day -> print("был(а) в сети $realTime ")
        in day until twoDay -> print("был(а) в сети сегодня\n")
        in twoDay until threeDay -> print("был(а) в сети вчера\n")
        else -> {
            println("был(а) в сети давно\n")
        }
    }
}

private fun printHoursOrMinutes(randomValue: Int, hour: Int, realTime: Int) {
    if (randomValue < hour) {
        when (realTime) {
            1, 21, 31, 41, 51 -> print("минуту назад\n")
            in 2..4, in 22..24,
            in 32..34, in 42..44,
            in 52..54 -> print("минуты назад\n")
            else -> {
                print("минут назад\n")
            }
        }
    } else {
        when (realTime) {
            1, 21 -> print("час назад\n")
            2, 3, 4, 22, 23 -> print("часа назад\n")
            in 5..20 -> print("часов назад\n")
        }
    }
}