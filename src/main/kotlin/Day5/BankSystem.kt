package Day5

import Day4.*

class BankSystem : MenuProgram() {

    val hashSetAccountNumber = HashSet<String>()

    companion object {
        val listUser = ArrayList<User>()
    }

    override fun menu() {
        println("\n\nBank System")
        println("=================================")
        println("1. Create new user's account")
        println("2. Show available account")
        println("3. List of account balance (Highest -> smallest) based on alphabet")
        println("4. Find user's account by name, number, address, balance")
        println("5. Find user in the range of balance")
        println("6. Login")
        println("0. EXIT")
        println("=================================")
        print("Select your option : ")
    }

    override fun executeMenuSelection(userSelection: Int) {
        when (userSelection) {
            1 -> {
                createUserAccount()
            }

            2 -> {
                showListOfUsers()
            }

            3 -> {
                print("- Input character to display (Ex : a) : ")
                val enteredCharacter = readlnOrNull().toString()

                println("=> Original list : ")
                showListOfUsers()
                println("=> Sorted list by character \"$enteredCharacter\" :")
                if (displayAccountBalanceFromHighestToSmallestBasedOnAlphabet(enteredCharacter).isEmpty()) {
                    println("No name start with \"$enteredCharacter\" in the list !")
                } else {
                    showListOfUsers(displayAccountBalanceFromHighestToSmallestBasedOnAlphabet(enteredCharacter))
                }
            }

            4 -> {
                println(findUserByInputField())
            }

            5 -> {
                print("- Input start balance : ")
                val startBalance = readlnOrNull()?.toDouble() ?:0.0
                print("- Input end balance : ")
                val endBalance = readlnOrNull()?.toDouble() ?: 0.0
                println(findUserInTheRangeOfBalance(startBalance,endBalance))

            }

            6 -> {
                loginToTheSystem()

            }
        }

    }

    private val findUserInTheRangeOfBalance = { startBalance: Double, endBalance: Double ->

        if (startBalance >= endBalance) {
            "[ERROR] Start balance cannot > End balance"
        } else {
            var templateFindingField = ""

            listUser.forEach {
                if (it.userAccountBalance in startBalance..endBalance) {
                    templateFindingField += "ID : ${it.userId}; Name : ${it.userName}; Address : ${it.userAddress}; Account Number : ${it.userAccountNumber}; Account balance : ${it.userAccountBalance}\n"
                }
            }

            templateFindingField
        }

    }

    private val findUserByInputField = { ->
        print("- Input user's account name, number, address, balance to find : ")
        val enteredFindingField = readlnOrNull().toString().lowercase()

        var templateFindingField = ""
        listUser.forEach {
            if (it.userName.lowercase().contains(enteredFindingField)
                || it.userAccountNumber.lowercase().contains(enteredFindingField)
                || it.userAddress.lowercase().contains(enteredFindingField)
                || it.userAccountBalance.toString().contains(enteredFindingField)
            ) {
                templateFindingField += "ID : ${it.userId}; Name : ${it.userName}; Address : ${it.userAddress}; Account Number : ${it.userAccountNumber}; Account balance : ${it.userAccountBalance}\n"
            }
        }

        templateFindingField
    }

//    fun findUserByInputField(): String {
//        print("- Input user's account name, number, address, balance to find : ")
//        val enteredFindingField = readlnOrNull().toString().lowercase()
//
//        var templateFindingField = ""
//
//        listUser.forEach {
//            if (it.userName.lowercase().contains(enteredFindingField)
//                || it.userAccountNumber.lowercase().contains(enteredFindingField)
//                || it.userAddress.lowercase().contains(enteredFindingField)
//                || it.userAccountBalance.toString().contains(enteredFindingField)
//            ) {
//                templateFindingField += "ID : ${it.userId}; Name : ${it.userName}; Address : ${it.userAddress}; Account Number : ${it.userAccountNumber}; Account balance : ${it.userAccountBalance}\n"
//            }
//        }
//
//        return templateFindingField
//    }


    private fun displayAccountBalanceFromHighestToSmallestBasedOnAlphabet(enteredCharacter: String): List<User> {

        val listUserByCharacter = ArrayList<User>()

        listUser.forEach {
            if (it.userName.startsWith(enteredCharacter)) {
                listUserByCharacter.add(it)
            }
        }
        listUserByCharacter.sortByDescending {
            it.userAccountBalance
        }

        return listUserByCharacter
    }


    private fun createUserAccount() {
        var userName = ""
        var userAddress = ""
        var userAccountNumber = ""
        var userAccountPassword = ""
        var userAccountBalance = 0.0

        do {
            print("- Input user's name : ")
            userName = readlnOrNull().toString()
            print("+ Input user's address : ")
            userAddress = readlnOrNull().toString()
            print("+ Input user's account number (5 number) : ")
            userAccountNumber = readlnOrNull().toString()
            print("+ Input user's account password : ")
            userAccountPassword = readlnOrNull().toString()
            print("+ Input user's account balance : ")
            userAccountBalance = readlnOrNull()?.toDouble() ?: 0.0
        } while (userName == "" || userAddress == "" || userAccountNumber.length != 5 || userAccountPassword == "" || userAccountBalance < 0)


        val userId = listUser.size + 1
        val user = User(userId, userName, userAddress, userAccountNumber, userAccountPassword, userAccountBalance)

        if (hashSetAccountNumber.add(user.userAccountNumber)) {
            listUser.add(user)
            hashSetAccountNumber.add(user.userAccountNumber)
            println("=> User account added successfully !")
        } else {
            println("[ERROR] Account number \"$userAccountNumber\" already available in the system !")
            createUserAccount()
        }


    }

    private fun loginToTheSystem() {
        print("- Input user's account number (5 number) : ")
        val userAccountNumber = readlnOrNull().toString()
//                print("+ Input user's account password : ")
//                val userAccountPassword = readlnOrNull().toString()

        listUser.find {
            userAccountNumber == it.userAccountNumber
        }.also {
            if (it != null) {
                val existedUser = User(
                    it.userId,
                    it.userName,
                    it.userAddress,
                    it.userAccountNumber,
                    it.userAccountPassword,
                    it.userAccountBalance,
                )

                println("Account is Available, Start sign in ...")
                val userSignedInHandler = UserSignedInSystem(existedUser)
                userSignedInHandler.run()

            } else {
                println("Not exist Account number \"$userAccountNumber\" !")
            }
        }
    }


    private fun showListOfUsers(mListUser: List<User> = listUser) {
        var templateUser = ""
        mListUser.forEach {
            templateUser += "ID : ${it.userId}; Name : ${it.userName}; Address : ${it.userAddress}; Account Number : ${it.userAccountNumber}; Account balance : ${it.userAccountBalance}\n"
        }
        println(templateUser)
    }
}