@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

/**
 * 
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var a = mutableListOf<Int>()
    var b = n
    var i = 2
    while (true) {
        if (b == 1) {
            break;
        }
        if (b % i ==0) {
            a.add(i)
            b /= i
        } else {
            i++
        }

    }
    return a.sorted()
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
    var list = factorize(n)
    var ans = list[0].toString()
    for (i in 1..list.size-1) {
        ans = ans.plus("*"+list[i])
    }
    return ans
}

/**
 *  
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var charA = listOf("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    var charB = listOf(
        "десять",
        "двацдать",
        "тридцать",
        "сорок",
        "пятьдесят",
        "шестьдесят",
        "семьдесят",
        "восемьдесят",
        "девяносто"
    )
    var charC =
        listOf("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var charD = listOf("тысяча", "тысяч", "тысячи")
    var result = mutableListOf<String>()
    var b= 1
    while (true) {
        result.add(charA[n/b%10-1])

        b *= 10
        if (n%b==n) {
            break;
        }
        result.add(charB[n/b%10-1])

        b *= 10
        if (n%b==n) {
            break;
        }
        result.add(charC[n/b%10-1])

        b *= 10
        if (n%b==n) {
            break;
        }
        if (n/b%10==1) {
            result.add(charD[0])
        } else if (n/b%10==2 || n/b%10==3 || n/b%10==4 ) {
            result.add(charD[2])
        } else {
            result.add(charD[1])
        }

        b *= 10
        if (n%b==n) {
            break;
        }
    }
    var answer = result.get(result.size-1)
    for (i in 0..result.size-2) {
        answer = answer.plus(" "+result.get(result.size-(i+2)))
    }
    return answer


}
