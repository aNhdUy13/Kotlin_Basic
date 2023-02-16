package com.wk.day1_variable_statement.Day1



fun main(args: Array<String>)
{
    /**
     * Scenario : create a library program with
     * + List of functions (Menu)
     * + Add new user
     * + Display all users available in the system
     * + Sort users by age increasing
     * */
    menu()
}

lateinit var users:Users
val simpleTitle:String by lazy {
    "Input your choice here : "
}

val userList = ArrayList<Users>()

fun menu()
{
    do
    {
        println("\n\n=================================")
        println("1. Add user")
        println("2. Display all users")
        println("3. Sort users by age increasing")
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
                displayUser()
            }
            "3" -> {
                sortAgeIncrease()
            }
        }

    }while (mChoice != "0")


}


fun addUser() {
    var uName:String
    var uAge: String

    do {
        print("\n- Input user's name : ")
        uName = readLine().toString()

        print("- Input user's age : ")
        uAge = readLine().toString()

    }while (uName == "" || uAge == "")

    users = Users()
    users.uName = uName
    users.uAge = uAge.toInt()
    println("Input data : ${users.uName} _ ${users.uAge}")

    users = Users(uName, uAge.toInt())
    userList.add(users)
}

fun displayUser() {
    for (i in userList)
    {
        println("${i.uName} , ${i.uAge} years old")
    }
}

fun sortAgeIncrease() {

    var sortList = ArrayList<Users>()

    sortList = userList

    for (i in 0..sortList.size)
    {
        for (j in 0 until  sortList.size-1)
        {
            if (sortList[j].uAge > sortList[j+1].uAge)
            {
                val temp = sortList[j]
                sortList[j] = sortList[j+1]
                sortList[j+1] = temp
            }
        }
    }

    for (i in sortList)
    {
        println("${i.uName} , ${i.uAge}")
    }

}


