package com.cleo.shop.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleo.shop.R
import com.cleo.shop.ui.adapter.ProductAdapter
import com.cleo.shop.vm.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (isNetworkConnected(this@MainActivity)) {
            //Connected to the internet

            CoroutineScope(Dispatchers.IO).launch {

                try {
                    val remoteProducts = viewModel.getRemoteProducts()

                            withContext(Dispatchers.Main) {
                                val productView = findViewById<RecyclerView>(R.id.product_view)
                                val productAdapter = ProductAdapter(this@MainActivity, remoteProducts!!)
                                productView.adapter = productAdapter
                                productView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                            }

                } catch (t: Throwable){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_LONG)
                            .show()
                    }

                }


            }

        }
//        else {
//            Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_LONG)
//                .show()
//        }
//    }
//        private fun isNetworkConnected(context: Context): Boolean {
//            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
//    }
}