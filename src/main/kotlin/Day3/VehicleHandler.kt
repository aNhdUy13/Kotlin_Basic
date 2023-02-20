package com.wk.kotlin_basic.Day3_Class

abstract class VehicleHandler {

    abstract fun vehicleSelection(arrayListVehicle:ArrayList<Vehicle>):ArrayList<Vehicle>

}


interface VehicleSpeedInterface {
    fun vehicleHasFastestSpeed(vehicleList:List<Vehicle>):String

}




class PriceVehicle(): VehicleHandler()
{
    override fun vehicleSelection(arrayListVehicle: ArrayList<Vehicle>): ArrayList<Vehicle> {

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
        return "Most expensive vehicle ( ${curr.vehiclePrice}VND ): ${curr.vehicleName} _ ${curr.vehicleSpeed} km/h"
    }


    fun mostExpensiveVehicle(arrayListVehicle: ArrayList<Vehicle>, title:String) : String
    {
        var curr = arrayListVehicle[0]

        for (i in 0 until   arrayListVehicle.size)
        {
            if (arrayListVehicle[i].vehiclePrice > curr.vehiclePrice)
            {
                curr = arrayListVehicle[i]
            }
        }

        println(title)
        return "${curr.vehicleName} _ ${curr.vehiclePrice}VND _ ${curr.vehicleSpeed} km/h"
    }

}




class SpeedVehicle(): VehicleHandler(), VehicleSpeedInterface
{
    override fun vehicleSelection(arrayListVehicle: ArrayList<Vehicle>): ArrayList<Vehicle> {

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

    override fun vehicleHasFastestSpeed(vehicleList: List<Vehicle>): String {
        var curr = vehicleList[0]

        for (i in vehicleList.indices)
        {
            if (vehicleList[i].vehicleSpeed > curr.vehicleSpeed)
            {
                curr = vehicleList[i]
            }
        }
        return "Fastest vehicle ( ${curr.vehicleSpeed} km/h ): ${curr.vehicleName} , ${curr.vehiclePrice}VND"
    }



}