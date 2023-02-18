package com.wk.kotlin_basic.Day1_variable_statement

class Users {
//    var name: String?= null
//
//    fun test() {
//        if (name != null) {
//            //thuc hien 1 cau lenh mat nhieu thoi gian
//            name?.length
//        }
//    }

    constructor(){}
    constructor(uName: String, uAge: Int) {
        this.uName = uName
        this.uAge = uAge
    }

    var uName = ""
        get() {
            if (field.isEmpty()) {
                return "Null Name !"
            }
            return field
        }
        set(value) {
            if (value.length >= 5) {
                field = value
            } else {
                field = "Name too short !"
            }

        }


    var uAge: Int = 0
        set(value) {
            field = if (value in 1..140) {
                value
            } else {
                0
            }
        }
}