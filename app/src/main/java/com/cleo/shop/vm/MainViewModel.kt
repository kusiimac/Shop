package com.cleo.shop.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleo.shop.data.model.ProductResponse
import com.cleo.shop.data.retrofit.RetrofitInstance
import com.cleo.shop.data.room.CartModel
import com.cleo.shop.data.room.DBBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    suspend fun getRemoteProducts(): List<ProductResponse>? {
        var products: List<ProductResponse> ?= null
        val x = viewModelScope.async(Dispatchers.IO) {
            val service = RetrofitInstance().createProductService()
             products = service.getProducts()
            products
        }
        products = x.await()
        return products
    }

    fun insertCartItem(context:Context, item:CartModel){
        viewModelScope.launch(Dispatchers.IO) {
            DBBuilder().initializeDB(context).createCartDao().insertProductToCart(item)
        }
    }
}
