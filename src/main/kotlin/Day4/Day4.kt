package Day4

import com.wk.kotlin_basic.Day3_Class.*

val listNumber = mutableListOf<Int>()
val mapNumber = mutableMapOf<Int,Int>()
fun main() {

    menu()
}

fun menu() {
    do {
        println("\n\n=================================")
        println("1. Add number to list")
        println("2. Show available numbers")
        println("3. Find number > 5")
        println("4. Remove duplicate number in the list")
        println("5. Sort number ascending")
        println("6. Sort number descending")
        println("7. Multiply numbers")
        println("0. LOGOUT")
        println("=================================")
        print("Select your option : ")
        val mChoice = readlnOrNull()?.toInt()

        when (mChoice) {
            0 -> {
                println("System End !")
            }

            1 -> {
                addNumber()
            }

            2 -> {
                showNumbers()
            }

            3 -> {
                val listNumberGreaterThan5 = listNumber.filter { number -> number > 5 }
                println(listNumberGreaterThan5)
            }

            4 -> {
                removeDuplicateNumber()
            }

            5 -> {
//                listNumber.sort() // Sort thẳng trên list
                val sortListNumberAscending = listNumber.sorted()

                println(sortListNumberAscending)
            }
            6 -> {
//                listNumber.sortDescending() // sort thẳng trên list
                val sortListNumberDescending = listNumber.sortedDescending()
                println(sortListNumberDescending)
            }
            7 -> {
                val multiplyNumber = listNumber.map {
                    it*it
                }
                println(multiplyNumber)


            }

        }

    } while (mChoice != 0)

}

fun removeDuplicateNumber() {
    val mutableSet = mutableSetOf<Int>()


    val listNumberRemovedDuplicateNumber = mutableListOf<Int>()
    var duplicateNumber = ""

    listNumber.forEach {
        if (mutableSet.add(it)) {
            listNumberRemovedDuplicateNumber.add(it)
        } else {
            duplicateNumber += "$it "
        }
    }

    println("Original list : $listNumber")
    println("Removed duplicate numbers list : $listNumberRemovedDuplicateNumber")
    println("Duplicate numbers [ $duplicateNumber ]")

}

fun showNumbers() {

    println("List numbers : $listNumber")

    println("List numbers with position : $mapNumber")
}

fun addNumber() {
    do {
        print("\n- Amount of number u want to enter : ")
        val amountNumber = readlnOrNull()

        if (amountNumber != null && amountNumber.toInt() > 0) {
            var number: Int

            for (i in 1..amountNumber.toInt()) {
                do {
                    print("- Input number ($i) : ")
                    number = readlnOrNull()?.toInt() ?: -1

                } while (number <= 0)

                listNumber.add(number)
                mapNumber[i] = number
            }

        } else {
            println("Input number !")
        }

    } while (amountNumber == null)


}

