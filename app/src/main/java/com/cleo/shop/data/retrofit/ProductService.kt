package com.cleo.shop.data.retrofit

import com.cleo.shop.data.model.ProductResponse
import retrofit2.http.GET

interface ProductService {
    @GET("/products")
    suspend fun getProducts(): List<ProductResponse>
}