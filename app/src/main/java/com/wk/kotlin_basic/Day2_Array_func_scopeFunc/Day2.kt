package com.wk.day2_array_func_scopefunc.Day2

import com.wk.kotlin_basic.Day2_Array_func_scopeFunc.IncomeCalculator


val simpleTitle:String by lazy { "Input your choice here : " }
var arr = ArrayList<User>()

fun main (arc:Array<String>)
{
    /**
        Day 2 : ND Học
        - Mảng(Array)
        - Hàm(Function)
        - Scope function
     * */
    menu()
}

fun menu()
{
    do
    {
        println("\n\n=================================")
        println("1. Add user")
        println("2. Count and Display all users")
        println("3. Sorting ID increase")
        println("4. Sorting ID decrease")
        println("5. User have income > 100")
        println("6. Total and AVG income")
        println("0. LOGOUT")
        println("=================================")
        print(simpleTitle)
        val mChoice  = readLine()

        when(mChoice)
        {
            "0" -> {
                println("System End !")
            }
            "1" -> {
                addUser()
            }
            "2" -> {
                println(countAndDisplayUser())
            }

            "3" -> {
                // Sort type : 1 = Increase (Default) ; 2 = Decrease
                sortUserById()
            }

            "4" -> {
                // Sort type : 1 = Increase (Default) ; 2 = Decrease
                sortUserById(sortType = 2) // named param
            }

            "5" -> {
                val avgIncome = arr.filter { user: User -> user.uIncome > 100 }
                println(countAndDisplayUser(avgIncome as ArrayList<User>))
            }

            "6" -> {

                // calculate avg income through class "IncomeCalculator"
                val incomeCalculator = IncomeCalculator()
                println(incomeCalculator.totalIncome(arr))

                // calculate total income function (by create "totalIncome" function in main class )
                // without modify "IncomeCalculator" class
                println(incomeCalculator.avgIncome(arr))

            }
        }

    }while (mChoice != "0")


}

// Extension function for "IncomeCalculator" class
fun IncomeCalculator.avgIncome(arr:ArrayList<User>) : String
{
    var totalIncome = 0.0
    arr.map { user -> totalIncome += user.uIncome}
    return  "AVG income = ${totalIncome/arr.size}"
}



fun addUser() {
    do {
        print("\n- Input number of users : ")
        val n = readLine()

        if (n != null && n.toInt() > 0)
        {
            // Using scope function (apply) , instead of create variable to assign, we can use
            // param in class "User" to assign with value
            User().apply {
                for (i in 1..n.toInt())
                {
                    do {
                        print("- Input ID of user ($i) : ")
                        uID = readLine()!!.toInt()

                        print("+ Input user's name : ")
                        uName = readLine().toString()

                        print("+ Input user's income : ")
                        uIncome = readLine()!!.toDouble()

                    }while (uName == "" || uID.toString() == "")

                    arr.add(User(uID, uName, uIncome))
                }
            }.also {
                println("\nInputted user :")
                arr.map { i -> println("${i.uID} - ${i.uName} - ${i.uIncome}") }

            }
        }
        else
        {
            println("Input number of user !")
        }
    }while (n == null)



}

fun countAndDisplayUser(mArr: ArrayList<User> = arr):String {

    var temp = ""
    mArr.map { i -> temp += "${i.uID} - ${i.uName} - ${i.uIncome}\n" }
    temp += "\n=> Total user = ${mArr.size}"

    return temp
}


fun sortUserById(mArr:ArrayList<User> = arr, sortType:Int = 1) // default param
{
    if (sortType == 1)
    {
        // Sort increase
        for (i in 0 ..  mArr.size)
        {
            for (j in 0 until mArr.size - 1)
            {
                if (mArr[j].uID > mArr[j+1].uID)
                {
                    val temp = mArr[j]
                    mArr[j] = mArr[j+1]
                    mArr[j+1] = temp
                }
            }
        }
    }

    else if (sortType == 2)
    {
        // Sort decrease
        for (i in 0 ..  mArr.size)
        {
            for (j in 0 until mArr.size - 1)
            {
                if (mArr[j].uID < mArr[j+1].uID)
                {
                    val temp = mArr[j]
                    mArr[j] = mArr[j+1]
                    mArr[j+1] = temp
                }
            }
        }
    }


    else {
        println("Invalid !")
    }

    for (i in mArr)
    {
        println("${i.uID} _ ${i.uName}")
    }
}

