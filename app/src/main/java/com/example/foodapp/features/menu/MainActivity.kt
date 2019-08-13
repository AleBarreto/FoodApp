package com.example.foodapp.features.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.foodapp.R
import com.example.foodapp.api.FoodApi
import com.example.foodapp.features.comments.CommentDetailActivity
import com.example.foodapp.features.menu.model.Menu
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FoodApi.retrofitService.getListMenu().enqueue(object : Callback<List<Menu>> {
            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                progressBar.visibility = View.GONE
            }
            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                progressBar.visibility = View.GONE
                rvList.visibility = View.VISIBLE
                rvList.adapter = AdapterMenu(response.body()!!) {
                    val intent = Intent(this@MainActivity, CommentDetailActivity::class.java)
                    intent.putExtra("menu", it)
                    startActivity(intent)
                }
            }
        })
    }
}
