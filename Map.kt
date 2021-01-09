@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson5.task1



/**
 * Сложная
 *
 * Для заданного списка неотрицательных чисел и числа определить,
 * есть ли в списке пара чисел таких, что их сумма равна заданному числу.
 * Если да, верните их индексы в виде Pair<Int, Int>;
 * если нет, верните пару Pair(-1, -1).
 *
 * Индексы в результате должны следовать в порядке (меньший, больший).
 *
 * Постарайтесь сделать ваше решение как можно более эффективным,
 * используя то, что вы узнали в данном уроке.
 *
 * Например:
 *   findSumOfTwo(listOf(1, 2, 3), 4) -> Pair(0, 2)
 *   findSumOfTwo(listOf(1, 2, 3), 6) -> Pair(-1, -1)
 */
fun findSumOfTwo(list: List<Int>, number: Int): Pair<Int, Int> {
    var first = -1
    var second = -1
    for (hmm in list) {
        for (i in list.indexOf(hmm) + 1 until list.size) {
            if (hmm + list.get(i) == number) {
                first = list.indexOf(hmm)
                second = i
            }
        }
    }
    return Pair(first, second)
}

/**
 * Очень сложная
 *
 * Входными данными является ассоциативный массив
 * "название сокровища"-"пара (вес сокровища, цена сокровища)"
 * и вместимость вашего рюкзака.
 * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
 * которые вы можете унести в рюкзаке.
 *
 * Перед решением этой задачи лучше прочитать статью Википедии "Динамическое программирование".
 *
 * Например:
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     850
 *   ) -> setOf("Кубок")
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     450
 *   ) -> emptySet()
 */
fun bagPacking(treasures: Map<String, Pair<Int, Int>>, capacity: Int): Set<String> {

    var hey = mutableSetOf<String>()
    var list = mutableListOf<Pair<Int, Int>>()
    for ((k, v) in treasures) {
        if (v.first > capacity) {
            continue
        }
        list.add(v)
    }
    var totalWeight = 0
    var totalPrice = 0
    for (item in list) {
        totalWeight += item.first
        totalPrice += item.second
    }
    list.sortWith(compareBy({ it.second }, { it.first }))
    for (item in list) {
        if (totalWeight <= capacity) {
            break
        }
        totalWeight -= item.first
        list.remove(item)
    }
    for (item in list) {
        for ((k, v) in treasures) {
            if (v == item) {
                hey.add(k)
                break
            }
        }
    }
    return hey
}
