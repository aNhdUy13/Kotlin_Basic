package com.wk.day2_array_func_scopefunc.Day2

class User {

    constructor() {}

    constructor(userID: Int, userName: String, userIncome: Double) {
        this.userID = userID
        this.userName = userName
        this.userIncome = userIncome
    }

    var userID: Int = -1
        get() {
            return if (field < 0) {
                -1
            } else {
                field
            }
        }
        set(value) {
            field = if (value < 0) {
                -1
            } else {
                value
            }
        }

    var userName: String = ""
        get() {
            return if (field.length < 3) {
                "Name too short !"
            } else {
                field
            }
        }


    var userIncome: Double = 0.0
        get() {
            return if (field < 0) {
                0.0
            } else {
                field
            }
        }


    override fun toString(): String {
        return "$userID _ $userName _ $userIncome"
    }
}