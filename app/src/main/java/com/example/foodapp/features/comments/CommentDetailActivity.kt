package com.example.foodapp.features.comments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.foodapp.R
import com.example.foodapp.api.FoodApi
import com.example.foodapp.features.comments.model.Comment
import com.example.foodapp.features.menu.model.Menu
import kotlinx.android.synthetic.main.activity_comment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_detail)

        val menu = intent.extras?.get("menu") as Menu

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        FoodApi.retrofitService.getCommentsMenu(menu.id).enqueue(
            object : Callback<List<Comment>> {
                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                    pbComments.visibility = View.GONE
                }

                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                    pbComments.visibility = View.GONE
                    rvComments.visibility = View.VISIBLE
                    val data = response.body()
                    rvComments.adapter = AdapterComment(data!!.shuffled())
                }
            }
        )

    }

}
