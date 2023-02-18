package com.wk.kotlin_basic.Day3_Class


val arrVehicle = ArrayList<Vehicle>()
lateinit var vehicleHandler: VehicleHandler

fun main() {

    menu()
}

fun menu() {
    do {
        println("\n\nSelect vehicle for holiday")
        println("=================================")
        println("1. Add vehicle")
        println("2. Show available vehicle")
        println("3. Select by price")
        println("4. Select by speed")
        println("5. Most expensive vehicle")
        println("0. LOGOUT")
        println("=================================")
        print("Select your option : ")
        val mChoice = readLine()

        when (mChoice) {
            "0" -> {
                println("System End !")
            }

            "1" -> {
                addVehicle()
            }

            "2" -> {
                showVehicle()
            }

            "3" -> {
                vehicleHandler = PriceVehicle()
                showVehicle(vehicleHandler.selectVehicleBy(arrVehicle), "Select vehicle by price (cheap -> expensive)")
            }

            "4" -> {
                vehicleHandler = SpeedVehicle()
                showVehicle(vehicleHandler.selectVehicleBy(arrVehicle), "Select vehicle by Speed (fast -> Slow)")
            }

            "5" -> {
                val selectVehicle = PriceVehicle()
                println(selectVehicle.mostExpensiveVehicle(arrVehicle))
            }
        }

    } while (mChoice != "0")


}

fun addVehicle() {
    do {
        print("\n- Input number of vehicle : ")
        val n = readlnOrNull()

        if (n != null && n.toInt() > 0) {
            var vehicleName: String
            var vehiclePrice: Double
            var vehicleSpeed: Double

            for (i in 1..n.toInt()) {
                do {
                    print("- Input name of vehicle ($i) : ")
                    vehicleName = readlnOrNull().toString()

                    print("+ Input vehicle's price : ")
                    vehiclePrice = readlnOrNull()?.toDouble() ?: 0.0

                    print("+ Input vehicle's speed (km/h): ")
                    vehicleSpeed = readlnOrNull()?.toDouble() ?: 0.0

                } while (vehicleName == "" || vehiclePrice.toString() == "" || vehicleSpeed.toString() == "")

                arrVehicle.add(Vehicle(vehicleName, vehiclePrice, vehicleSpeed))
            }

            println("\nInputted vehicles :")
            arrVehicle.forEach() { v ->
                println("${v.vehicleName} _ ${v.vehiclePrice} _ ${v.vehicleSpeed}")
            }
        } else {
            println("Input number of vehicle !")
        }

    } while (n == null)


}


fun showVehicle(listVehicle: List<Vehicle> = arrVehicle, title: String = "") {
    println(title)
    listVehicle.forEach { v -> println("${v.vehicleName} _ ${v.vehiclePrice} _ ${v.vehicleSpeed}") }
}