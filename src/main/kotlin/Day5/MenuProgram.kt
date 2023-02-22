package Day5

abstract class MenuProgram {

    fun run()
    {
        while (true)
        {
            menu()
            val userSelection = readlnOrNull()?.toInt()
            if (userSelection != null) {
                executeMenuSelection(userSelection)
            }

            if (userSelection == 0) break
        }

    }


    abstract fun menu()
    abstract fun executeMenuSelection(userSelection:Int)
}