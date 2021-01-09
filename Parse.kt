@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1




/**
 * 
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше либо равны нуля.
 */
fun mostExpensive(description: String): String {
    if (description==null || description=="" ) {
        return ""
    }
    if (description.contains("; ")) {
        var hey = description.split("; ")
        var listok = mutableListOf<Pair<String, Double>>()
        for (part in hey) {

            listok.add(Pair(part.split(" ").get(0), part.split(" ").get(1).toDouble()))
        }
        var answer = ""
        var price = listok.get(0).second
        for ((a, b) in listok) {
            if (b >= price) {
                price = b
                answer = a
            }
        }
        return answer
    } else {
        return description.split(" ").get(0)
    }


}


