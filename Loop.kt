@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.sqrt


/**
 * 
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var a = 10
    var b = 1
    if (n > 999999999) return 10
    while (true) {
        if (n % a == n) {
            break
        }
        a *= 10
        b++
    }
    return b
}

/**
 * 
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var result = 1
    var resultLast = 1
    if (n == 1 || n == 2) return 1
    for (i in 3..n) {
        result += resultLast
        resultLast = result - resultLast
    }
    return result
    // Нужно поменять с Int на Long или уйдет в негатив из-за размера
}



/**
 * 
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (a in 2..n) {
        if (n % a == 0) {
            return a
        }
    }
    return n
}

/**
 * 
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var b = 1
    for (i in 1 until n - 1) {

        if (n % i == 0) {
            b = i
        }
    }
    return b
}

/**
 * 
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var a = 10
    var b = 10
    var c = 1
    while (true) {
        if (n % a == n) {
            break
        }
        a *= 10
    }
    while (true) {
        if (!(n / (a / 10) % 10 == (n % b)/c)) {
            return false
        }

        a /= 10
        if (a==1) {
            break
        }
        b *= 10
        c *= 10
    }
    return true
}

/**
 * 
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean  {
    var a = 10
    var b = 10
    while (true) {
        if (n % a != (n / b) % 10) {
            return true
        }
        b *= 10
        if (n % b == n) {
            break
        }

    }
    return false
}

/**
 * 
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var c = 0
    var a = 0


    for (i in 1..n) {
        if (c >= n) {
            break
        }
        a = i*i
        c += digitNumber(a)

    }
    if (c > n) {
        for (i in 1..c-n) {
            a /= 10
        }
    }
    a %= 10
    return a
}



/**
 * 
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var c = 0
    var a = 0

    for (i in 1..n) {
        if (c >= n) {
            break
        }
        a = fib(i)

        c += digitNumber(a)
    }
    if (c > n) {
        for (i in 1..c-n) {
            a /= 10
        }
    }
    a %= 10
    return a
}
