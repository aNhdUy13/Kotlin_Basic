package com.wk.kotlin_basic.Day3_Class

abstract class VehicleHandler {

    abstract fun selectVehicleBy(arrayListVehicle:ArrayList<Vehicle>):ArrayList<Vehicle>

}



class SpeedVehicle(): VehicleHandler()
{
    override fun selectVehicleBy(arrayListVehicle: ArrayList<Vehicle>): ArrayList<Vehicle> {

        for (i in 0 until  arrayListVehicle.size)
        {
            for (j in 0 until  arrayListVehicle.size-1)
            {
                if (arrayListVehicle[j].vehicleSpeed < arrayListVehicle[j+1].vehicleSpeed)
                {
                    val temp = arrayListVehicle[j]
                    arrayListVehicle[j] = arrayListVehicle[j+1]
                    arrayListVehicle[j+1] = temp
                }
            }
        }

        return arrayListVehicle
    }

}


class PriceVehicle(): VehicleHandler()
{
    override fun selectVehicleBy(arrayListVehicle: ArrayList<Vehicle>): ArrayList<Vehicle> {

        for (i in 0 until  arrayListVehicle.size)
        {
            for (j in 0 until  arrayListVehicle.size-1)
            {
                if (arrayListVehicle[j].vehiclePrice > arrayListVehicle[j+1].vehiclePrice)
                {
                    val temp = arrayListVehicle[j]
                    arrayListVehicle[j] = arrayListVehicle[j+1]
                    arrayListVehicle[j+1] = temp
                }
            }
        }
        return arrayListVehicle
    }



    fun mostExpensiveVehicle(arrayListVehicle: ArrayList<Vehicle>) : String
    {
        var curr = arrayListVehicle[0]

        for (i in 0 until   arrayListVehicle.size)
        {
            if (arrayListVehicle[i].vehiclePrice > curr.vehiclePrice)
            {
                curr = arrayListVehicle[i]
            }
        }
        return "Most expensive vehicle : ${curr.vehicleName} _ ${curr.vehiclePrice}VND _ ${curr.vehicleSpeed} km/h"
    }
}