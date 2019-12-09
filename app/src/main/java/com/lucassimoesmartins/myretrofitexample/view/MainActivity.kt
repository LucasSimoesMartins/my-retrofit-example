package com.lucassimoesmartins.myretrofitexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucassimoesmartins.myretrofitexample.constants.Constants
import com.lucassimoesmartins.myretrofitexample.util.NetworkUtils
import com.lucassimoesmartins.myretrofitexample.R
import com.lucassimoesmartins.myretrofitexample.data.Endpoint
import com.lucassimoesmartins.myretrofitexample.model.PopularMovies
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    private fun getData() {
        val retrofitClient =
            NetworkUtils.getRetrofitInstance(Constants.BASE_URL)

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPopularMovies()

        callback.enqueue(object : Callback<PopularMovies> {

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                txtResult.text = t.message
            }

            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                txtResult.text = if(response.body() != null) response.body().toString() else "Check your API_KEY in Constants.kt file"
            }
        })
    }
}
