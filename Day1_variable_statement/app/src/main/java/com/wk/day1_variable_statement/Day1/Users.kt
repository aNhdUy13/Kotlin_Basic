package com.wk.day1_variable_statement.Day1

class Users{

    constructor(){}
    constructor(uName: String, uAge: Int) {
        this.uName = uName
        this.uAge = uAge
    }

    var uName = ""
        get() {
            if (field.isEmpty())
            {
                return "Null Name !"
            }
            return field
        }
        set(value) {
            if (value.length >= 5)
            {
                field = value
            }
            else {
                field = "Name too short !"
            }

        }


    var uAge = 0
        get() {
            return if (field != null) {
                field
            } else {
                0
            }
        }
        set(value) {
            field = if (value in 1..140) {
                value
            } else {
                0
            }
        }
}