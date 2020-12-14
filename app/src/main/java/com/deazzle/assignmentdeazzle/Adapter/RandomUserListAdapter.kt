package com.deazzle.assignmentdeazzle.Adapter

import android.content.Context
import android.os.Handler
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deazzle.assignmentdeazzle.R
import com.deazzle.assignmentdeazzle.database.RandomUser
import com.squareup.picasso.Picasso

class RandomUserListAdapter( var resultList:List<RandomUser>, var context: Context)
    : RecyclerView.Adapter<RandomUserListAdapter.ViewHolder>(){

    val tempList= mutableListOf<RandomUser>()
    init {
         tempList.addAll(resultList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_card, parent, false))
    }

    override fun getItemCount(): Int {
        return tempList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=tempList.get(position)
        holder.name?.text=dataModel.name.first+" "+dataModel.name.last
        holder.phone?.text=dataModel.phone
        holder.email?.text=dataModel.email
        Picasso.with(context).load(dataModel.pic.large).placeholder(R.drawable.loading).fit().centerCrop().into(holder.profile_pic)
        holder.accept.setOnClickListener {
            holder.like_text.visibility=View.VISIBLE
            val handler = Handler()
            handler.postDelayed({
                holder.like_text.visibility=View.GONE
                tempList.removeAt(position)
                notifyItemRemoved(position)
            }, 1000)
        }
        holder.reject.setOnClickListener {
            holder.reject_text.visibility=View.VISIBLE
            val handler = Handler()
            handler.postDelayed({
                holder.reject_text.visibility=View.GONE
                tempList.removeAt(position)
                notifyItemRemoved(position)
            }, 1000)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name=itemView.findViewById<TextView>(R.id.name)
        var phone=itemView.findViewById<TextView>(R.id.phone)
        var email=itemView.findViewById<TextView>(R.id.email)
        var profile_pic=itemView.findViewById<ImageView>(R.id.user_image)
        var like_text=itemView.findViewById<TextView>(R.id.like_text)
        var reject_text=itemView.findViewById<TextView>(R.id.reject_text)
        var accept=itemView.findViewById<ImageView>(R.id.accept)
        var reject=itemView.findViewById<ImageView>(R.id.reject)
    }
}