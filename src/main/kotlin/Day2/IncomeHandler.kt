package com.wk.kotlin_basic.Day2_Array_func_scopeFunc

import com.wk.day2_array_func_scopefunc.Day2.User

class IncomeHandler {

    fun totalIncome(userList: List<User>): Double {
        var totalIncome = 0.0
        userList.forEach { user -> totalIncome += user.userIncome }
        return totalIncome
    }

//    val calculateTotalIncomePerDay = { totalIncome: Double ->
//            totalIncome/30
//    }

    fun executeListIncomeUserGreaterThan100(
        originalUserList: List<User>,
        listIncomeUserGreaterThan100: (ArrayList<User>) -> Unit
    ) {
        val tempUserList = ArrayList<User>()
        originalUserList.forEach { tempUserList.add(it) }

        listIncomeUserGreaterThan100(tempUserList)

        var temp = ""
        tempUserList.forEach { i -> temp += "${i.userID} - ${i.userName} - ${i.userIncome}\n" }
        println(temp)
    }


    val calculateUserIncomePerDay = { userList: ArrayList<User> ->
        for (i in 0 until userList.size) {
            userList[i] = User(
                userList[i].userID,
                userList[i].userName,
                userList[i].userIncome / 30
            )
        }
    }


    fun userHaveHighestIncome(userArrayList: ArrayList<User>): User {
        var temp = userArrayList[0]
        userArrayList.forEach { user ->
            if (user.userIncome > temp.userIncome) {
                temp = user
            }
        }
        return temp
    }
}