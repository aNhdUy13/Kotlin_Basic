import com.wk.day2_array_func_scopefunc.Day2.User
import com.wk.kotlin_basic.Day2_Array_func_scopeFunc.IncomeHandler


val simpleTitle: String by lazy { "Input your choice here : " }
var userList = ArrayList<User>()
val incomeHandler = IncomeHandler()

const val SortIncreasing = 1
const val SortDecreasing = 2

fun main(arc: Array<String>) {
    /**
    Day 2 : ND Học
    - Mảng(Array)
    - Hàm(Function)
    - Scope function
     * */
    menu()

}

fun menu() {
    do {
        println("\n\n=================================")
        println("1. Add user")
        println("2. Count and Display all users")
        println("3. Sorting ID increase")
        println("4. Sorting ID decrease")
        println("5. User have income > 100")
        println("6. Total and AVG income")
        println("7. User have highest income")
        println("8. Income user get per day")
        println("0. LOGOUT")
        println("=================================")
        print(simpleTitle)
        val mChoice = readlnOrNull()?.toInt()

        when (mChoice) {
            0 -> {
                println("System End !")
            }

            1 -> {
                addUser()
            }

            2 -> {
                println(countAndDisplayUser())
            }

            3 -> {
                sortUserById()
            }

            4 -> {
                sortUserById(sortType = SortDecreasing)
            }

            5 -> {
//                val listUserIncomeGreaterThan100 = userArrayList.filter { user: User ->
//                    user.userIncome > 100
//                }

                incomeHandler.executeListIncomeUserGreaterThan100(
                    userList,
                    listUserIncomeGreaterThan100
                )

            }

            6 -> {
                // calculate avg income through class "IncomeCalculator"
                println("Total income = ${incomeHandler.totalIncome(userList)}")

                // calculate total income function (by create "totalIncome" function in main class )
                // without modify "IncomeCalculator" class
                println(incomeHandler.avgIncome(userList))
            }

            7 -> {
                val userHasHighestIncome: User = incomeHandler.userHaveHighestIncome(userList)
                println("User have highest income :  ${userHasHighestIncome.userID} , name = ${userHasHighestIncome.userName} , income = ${userHasHighestIncome.userIncome}")
            }

            8 -> {
                val calculatedIncomeUserList = ArrayList<User>()

                userList.forEach {
                    calculatedIncomeUserList.add(it)
                }

                incomeHandler.calculateUserIncomePerDay(calculatedIncomeUserList)

                var temp = ""
                calculatedIncomeUserList.forEach { i ->
                    temp += "${i.userID} - ${i.userName} - ${i.userIncome}\n"
                }
                println(temp)

            }

        }

    } while (mChoice != 0)


}

// Extension function for "IncomeCalculator" class
fun IncomeHandler.avgIncome(listUser: List<User>): String {
    val totalIncome = totalIncome(listUser)
    return "AVG income = ${totalIncome / listUser.size}"
}


val listUserIncomeGreaterThan100 = { userList: ArrayList<User> ->

    val tempUserList = ArrayList<User>()

    userList.forEach { tempUserList.add(it) }

    userList.clear()

    for (i in 0 until tempUserList.size) {
        if (tempUserList[i].userIncome > 100) {
            userList.add(tempUserList[i])
        }
    }
}


fun addUser() {
    do {
        print("\n- Input number of users : ")
        val n = readlnOrNull()

        if ((n != null) && (n.toInt() > 0)) {
            // Using scope function (apply) , instead of create variable to assign, we can use
            // param in class "User" to assign with value
            User().apply {
                for (i in 1..n.toInt()) {
                    do {
                        print("- Input ID of user ($i) : ")
                        userID = readlnOrNull()?.toInt() ?: -1

                        print("+ Input user's name : ")
                        userName = readlnOrNull().toString()

                        print("+ Input user's income : ")
                        userIncome = readlnOrNull()?.toDouble() ?: -1.1

                    } while (userName == "" || userID.toString() == "")

                    userList.add(User(userID, userName, userIncome))
                }
            }.also {
                println("\nInputted user :")
                userList.forEach { user ->
                    println("${user.userID} _ ${user.userName} _ ${user.userIncome}")
                }

            }
        } else {
            println("Input number of user !")
        }
    } while (n == null)


}


fun countAndDisplayUser(listUser: List<User> = userList): String {
    var temp = ""

    listUser.forEach { i ->
        temp += "${i.userID} - ${i.userName} - ${i.userIncome}\n"
    }

    temp += "\n=> Total user = ${listUser.size}"

    return temp
}


fun sortUserById(mArr: ArrayList<User> = userList, sortType: Int = 1) {
    if (sortType == SortIncreasing) {
        // Sort increase
        for (i in 0..mArr.size) {
            for (j in 0 until mArr.size - 1) {
                if (mArr[j].userID > mArr[j + 1].userID) {
                    val temp = mArr[j]
                    mArr[j] = mArr[j + 1]
                    mArr[j + 1] = temp
                }
            }
        }
    } else if (sortType == SortDecreasing) {
        // Sort decrease
        for (i in 0..mArr.size) {
            for (j in 0 until mArr.size - 1) {
                if (mArr[j].userID < mArr[j + 1].userID) {
                    val temp = mArr[j]
                    mArr[j] = mArr[j + 1]
                    mArr[j + 1] = temp
                }
            }
        }
    } else {
        println("Invalid !")
    }

    mArr.forEach { i ->
        println("${i.userID} _ ${i.userName}")
    }
}

