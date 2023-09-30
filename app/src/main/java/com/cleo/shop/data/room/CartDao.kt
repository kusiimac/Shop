package com.cleo.shop.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertProductToCart(product:CartModel)

    @Query("select * from cartmodel")
    fun selectAllProducts():List<CartModel>

    @Update(onConflict =OnConflictStrategy.ABORT)
    fun updateCartProduct(product:CartModel)
}