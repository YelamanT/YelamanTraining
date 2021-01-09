@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sqrt


/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    if (age in 11..19 || (age in 105..119)) {
        return "$age лет"
    }
    return when {
        age % 10 == 1 -> {
            "$age год"
        }
        age % 10 == 0 -> {
            "$age лет"
        }
        age % 10 < 5 -> {
            "$age года"
        }

        else -> {
            "$age лет"
        }
    }

}



/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    return when {
        (kingX == rookX1 && kingX == rookX2) || (kingX == rookX1 && kingY == rookY2) || (kingX == rookX2 && kingY == rookY1) || (kingY == rookY1 && kingY == rookY2) -> {
            3
        }
        kingX == rookX1 || kingY == rookY1 -> {
            1
        }
        kingX == rookX2 || kingY == rookY2 -> {
            2
        }
        else -> {
            0
        }

    }
}

