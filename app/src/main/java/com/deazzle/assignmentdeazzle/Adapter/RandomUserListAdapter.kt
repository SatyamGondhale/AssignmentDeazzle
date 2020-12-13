package com.deazzle.assignmentdeazzle.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deazzle.assignmentdeazzle.R
import com.deazzle.assignmentdeazzle.model.Result
import com.squareup.picasso.Picasso

class RandomUserListAdapter(private var resultList:List<Result>,private var context: Context)
    : RecyclerView.Adapter<RandomUserListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_card, parent, false))
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=resultList.get(position)
        holder.user_name.text=dataModel.name.first+" "+dataModel.name.last
        holder.user_phone.text="satya"
        holder.user_email.text="satya@gmail.com"
        Picasso.get().load(dataModel.picture.medium).placeholder(R.drawable.loading).fit().centerCrop().into(holder.userImage)

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var user_name:TextView
        lateinit var user_phone:TextView
        lateinit var user_email:TextView
        lateinit var like_text:TextView
        lateinit var reject_text:TextView
        lateinit var userImage:ImageView
        lateinit var rejected:ImageView
    }
}