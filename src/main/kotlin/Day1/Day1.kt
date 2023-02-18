package com.wk.kotlin_basic.Day1_variable_statement


lateinit var users: Users
//var age = 12
//val lazyAge by lazy {
//    age
//}

val simpleTitle: String by lazy { "Input your choice here : " }
val userList = ArrayList<Users>()


fun main(args: Array<String>) {
    /**
    Khai báo biến và kiểu dữ liệu
    - Câu lệnh rẽ nhánh if, else
    - Câu lệnh when
    - Vòng lặp while, do while
    - Vòng lặp for
     * */
//    age = 15
//
//    println(lazyAge)
//
//    age = 20
//
//    println(lazyAge)

    menu()
}


fun menu() {
    do {
        println("\n\n=================================")
        println("1. Add user")
        println("2. Display all users")
        println("3. Sort users by age increasing")
        println("0. LOGOUT")
        println("=================================")
        print(simpleTitle)
        val mChoice = readLine()

        when (mChoice) {
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
    } while (mChoice != "0")


}


fun addUser() {
    var uName: String
    var uAge: String

    do {
        print("\n- Input user's name : ")
        uName = readLine().toString()

        print("- Input user's age : ")
        uAge = readLine().toString()

    } while (uName == "" || uAge == "")

    users = Users()
    users.uName = uName
    users.uAge = uAge.toInt()
    println("Input data : ${users.uName} _ ${users.uAge}")

    users = Users(uName, uAge.toInt())
    userList.add(users)
}

fun displayUser(mUserList: List<Users> = userList) {

    mUserList.forEach { i -> println("${i.uName} , ${i.uAge} years old") }
}

fun sortAgeIncrease() {

    val sortList = userList
    for (i in 0..sortList.size) {
        for (j in 0 until sortList.size - 1) {
            if (sortList[j].uAge > sortList[j + 1].uAge) {
                val temp = sortList[j]
                sortList[j] = sortList[j + 1]
                sortList[j + 1] = temp
            }
        }
    }

    displayUser(sortList)

}


