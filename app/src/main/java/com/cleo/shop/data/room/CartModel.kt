package com.cleo.shop.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cleo.shop.data.model.ProductResponse


@Entity
data class CartModel(
    @PrimaryKey(autoGenerate = true) var id:Int ?= null,
    var product:ProductResponse,
    var quantity:Int = 0
)