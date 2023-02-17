package com.wk.day2_array_func_scopefunc.Day2

class User {

    constructor(){}
    constructor(uID: Int, uName: String, uIncome:Double) {
        this.uID = uID
        this.uName = uName
        this.uIncome = uIncome
    }

    var uID:Int = 0
        get() {
            if (field == null || field < 0)
            {
                return 0
            }
            else {
                return  field
            }
        }
        set(value) {
            field = value
        }

    var uName:String = ""
        get() {
            if (field.length < 3)
            {
                return "Name too short !"
            }
            else {
                return  field
            }
        }
        set(value) {
            field = value
        }

    var uIncome:Double = 0.0
        get() {
            if (field == null || field < 0)
            {
                return 0.0
            }
            else {
                return  field
            }
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "$uID _ $uName _ $uIncome"
    }
}