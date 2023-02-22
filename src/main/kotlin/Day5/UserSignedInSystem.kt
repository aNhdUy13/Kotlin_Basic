package Day5

import Day4.listNumber

class UserSignedInSystem(existedUser: User) : MenuProgram() {

    val signedInUser: User = existedUser

    override fun menu() {
        println("\n\nSigned in Account (ID : ${signedInUser.userAccountNumber} , Name : ${signedInUser.userName}, Balance : ${signedInUser.userAccountBalance})")
        println("=================================")
        println("1. Withdraw money")
        println("2. Cash deposit")
        println("3. Account information")
        println("4. Transfer Money")
        println("0. LOGOUT")
        println("=================================")
        print("Select your option : ")
    }

    override fun executeMenuSelection(userSelection: Int) {
        when (userSelection) {
            1 -> {
                withdrawMoney()

            }

            2 -> {
                depositMoney()

            }

            3 -> {
                showUserInformation()
            }

            4 -> {
                transferMoney()
            }
        }
    }



    private fun transferMoney() {
        print("- Enter destination account's number to transfer : ")
        val destinationTransferAccount = readlnOrNull().toString()

        BankSystem.listUser.find {
            destinationTransferAccount == it.userAccountNumber

        }.also { destinationUserAccount ->

            if (destinationUserAccount != null) {
                if (!destinationUserAccount.equals(signedInUser.userAccountNumber)) {
                    print("+ Enter amount of money u want to transfer : ")
                    val transferMoney = readlnOrNull()?.toDouble() ?: 0.0

                    if (signedInUser.userAccountBalance - transferMoney > 0) {
                        // Update balance for current user
                        signedInUser.userAccountBalance = signedInUser.userAccountBalance - transferMoney
                        updateData(signedInUser)

                        // Update balance for destination user
                        destinationUserAccount.userAccountBalance =
                            destinationUserAccount.userAccountBalance + transferMoney
                        updateData(destinationUserAccount)

                        println("Transfer successfully $transferMoney VND to account \"$destinationTransferAccount\"")

                    } else {
                        println("[WARNING] Not enough balance to transfer !")
                    }
                } else {
                    println("[WARNING] Cannot transfer to yourself !")
                }

            } else {
                println("[WARNING] Account number \"$destinationTransferAccount\" not available")
            }
        }
    }


    private fun depositMoney() {
        var amountOfDepositMoney = 0

        do {
            print("- Input amount of withdraw money : ")
            amountOfDepositMoney = readlnOrNull()?.toInt() ?: 0

            if (amountOfDepositMoney < 0)
                println("Invalid deposit money\n\n")

        } while (amountOfDepositMoney < 0)

        signedInUser.userAccountBalance = signedInUser.userAccountBalance + amountOfDepositMoney
        updateData(signedInUser)

        showUserInformation("=> User information after deposit :")
    }

    private fun withdrawMoney(feeToWithdraw: Double = 5.0) {

        if (signedInUser.userAccountBalance - feeToWithdraw > 0) {
            var amountOfWithdrawMoney = 0

            do {
                print("- Input amount of withdraw money ($feeToWithdraw VND/Transaction): ")
                amountOfWithdrawMoney = readlnOrNull()?.toInt() ?: 0

                if (amountOfWithdrawMoney < 0)
                    println("Invalid withdraw money\n\n")

                if (signedInUser.userAccountBalance - amountOfWithdrawMoney.toDouble() - feeToWithdraw < 0)
                    println(
                        "Your balance not enough to withdraw money !\n" +
                                "+ Current balance = ${signedInUser.userAccountBalance}\n" +
                                "+ Withdraw money = $amountOfWithdrawMoney \n\n"
                    )

            } while (amountOfWithdrawMoney < 0 || signedInUser.userAccountBalance - amountOfWithdrawMoney.toDouble() < 0)


            signedInUser.userAccountBalance = signedInUser.userAccountBalance - amountOfWithdrawMoney - feeToWithdraw
            updateData(signedInUser)

            showUserInformation("=> User information after withdraw :")


        } else {
            println("Your balance not enough to withdraw money !")
        }
    }


    private fun showUserInformation(title: String = "") {
        println(title)
        println("ID : ${signedInUser.userId}; Name : ${signedInUser.userName}; Address : ${signedInUser.userAddress}; Account Number : ${signedInUser.userAccountNumber}; Account balance : ${signedInUser.userAccountBalance}")
    }

    private fun updateData(updatedUser: User) {
        BankSystem.listUser.find {
            updatedUser.userAccountNumber == it.userAccountNumber
        }.also {
            if (it != null) {
                it.userAccountBalance = updatedUser.userAccountBalance
            }
        }

    }
}