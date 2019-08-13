package com.example.foodapp.features.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.R
import com.example.foodapp.features.comments.model.Comment
import kotlinx.android.synthetic.main.item_list_comment.view.*

class AdapterComment(private val list: List<Comment>) : RecyclerView.Adapter<AdapterComment.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_comment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(comment: Comment) {
            val tvName = itemView.tvName
            tvName.text = comment.name
            val tvComment = itemView.tvComment
            tvComment.text = comment.comment
            val avatar = itemView.avatar
            Glide.with(avatar).load(comment.avatar)
                .apply(
                    RequestOptions.circleCropTransform()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.loading_img)
                )
                .into(avatar)
        }

    }
}