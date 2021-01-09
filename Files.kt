@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

import java.io.File


/**
 *
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    val outputStream = File(outputName).bufferedWriter()
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            outputStream.newLine()
            continue
        }
        if (line.contains("жы", ignoreCase = true) || line.contains("чы", ignoreCase = true) ||
            line.contains("шы", ignoreCase = true) || line.contains("щы", ignoreCase = true) ||
            line.contains("жя", ignoreCase = true) || line.contains("чя", ignoreCase = true) ||
            line.contains("шя", ignoreCase = true) || line.contains("щя", ignoreCase = true) ||
            line.contains("жю", ignoreCase = true) || line.contains("чю", ignoreCase = true) ||
            line.contains("шю", ignoreCase = true) || line.contains("щю", ignoreCase = true)
        ) {
            var hey = line.replace("жы", "жи")
            hey = hey.replace("Жы", "Жи")
            hey = hey.replace("ЖЫ", "ЖИ")
            hey = hey.replace("жЫ", "жИ")
            hey = hey.replace("шы", "ши")
            hey = hey.replace("шЫ", "шИ")
            hey = hey.replace("ШЫ", "ШИ")
            hey = hey.replace("Шы", "Ши")
            hey = hey.replace("жя", "жа")
            hey = hey.replace("ЖЯ", "ЖА")
            hey = hey.replace("Жя", "Жа")
            hey = hey.replace("жЯ", "жА")
            hey = hey.replace("шя", "ша")
            hey = hey.replace("ШЯ", "ША")
            hey = hey.replace("Шя", "Ша")
            hey = hey.replace("шЯ", "шА")
            hey = hey.replace("жю", "жу")
            hey = hey.replace("ЖЮ", "ЖУ")
            hey = hey.replace("Жю", "Жу")
            hey = hey.replace("жЮ", "жУ")
            hey = hey.replace("шю", "шу")
            hey = hey.replace("ШЮ", "ШУ")
            hey = hey.replace("Шю", "Шу")
            hey = hey.replace("шЮ", "шУ")

            hey = hey.replace("чы", "чи")
            hey = hey.replace("ЧЫ", "ЧИ")
            hey = hey.replace("Чы", "Чи")
            hey = hey.replace("чЫ", "чИ")
            hey = hey.replace("щы", "щи")
            hey = hey.replace("ЩЫ", "ЩИ")
            hey = hey.replace("щЫ", "щИ")
            hey = hey.replace("Щы", "Щи")
            hey = hey.replace("чя", "ча")
            hey = hey.replace("ЧЯ", "ЧА")
            hey = hey.replace("Чя", "Ча")
            hey = hey.replace("чЯ", "чА")
            hey = hey.replace("щя", "ща")
            hey = hey.replace("ЩЯ", "ЩА")
            hey = hey.replace("Щя", "Ща")
            hey = hey.replace("щЯ", "щА")
            hey = hey.replace("чю", "чу")
            hey = hey.replace("ЧЮ", "ЧУ")
            hey = hey.replace("Чю", "Чу")
            hey = hey.replace("чЮ", "чУ")
            hey = hey.replace("щю", "щу")
            hey = hey.replace("ЩЮ", "ЩУ")
            hey = hey.replace("Щю", "Щу")
            hey = hey.replace("щЮ", "щУ")
            if (line.contains("жюри") || line.contains("брошюра") || line.contains("парашют")) {
                hey = hey.replace("жури", "жюри")
                hey = hey.replace("Жури", "Жюри")
                hey = hey.replace("жУри", "жЮри")
                hey = hey.replace("ЖУри", "ЖЮри")
                hey = hey.replace("рошура", "рошюра")
                hey = hey.replace("роШура", "роШюра")
                hey = hey.replace("роШУра", "роШЮра")
                hey = hey.replace("рошУра", "рошЮра")
                hey = hey.replace("арашут", "арашют")
                hey = hey.replace("араШут", "араШют")
                hey = hey.replace("араШУт", "араШЮт")
                hey = hey.replace("арашУт", "арашЮт")
            }

            outputStream.write(hey)
            outputStream.newLine()
            continue
        }
        outputStream.write(line)
        outputStream.newLine()
    }
    outputStream.close()
}

/**
 * 
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    var answer = File(outputName).bufferedWriter()
    var lineLength = 0
    var longest = 0
    for (line in File(inputName).readLines()) {

        if (longest < line.trim().length) {
            longest = line.trim().length
        }
    }
    for (line in File(inputName).readLines()) {
        lineLength = longest - line.trim().length
        lineLength /= 2
        while (lineLength != 0) {
            answer.write(" ")
            lineLength--
        }
        answer.write(line.trim())

        answer.newLine()
    }
    answer.close()
}

