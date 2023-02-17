package com.wk.kotlin_basic.Day2_Array_func_scopeFunc

import com.wk.day2_array_func_scopefunc.Day2.User

class IncomeCalculator {

    fun totalIncome(arr:ArrayList<User>):String
    {
        var totalIncome = 0.0

        arr.map { user -> totalIncome += user.uIncome}

        return  "Total income = $totalIncome"
    }
}