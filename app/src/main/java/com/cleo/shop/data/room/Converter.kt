package com.cleo.shop.data.room

import androidx.room.TypeConverter
import com.cleo.shop.data.model.ProductResponse
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun convertProductObjectToString(item:ProductResponse): String{
        val x = Gson().toJson(item)
        return x
    }

    @TypeConverter
    fun convertStringToProductObject(item:String): ProductResponse{
        val y = Gson().fromJson(item, ProductResponse::class.java)
        return y
    }
}