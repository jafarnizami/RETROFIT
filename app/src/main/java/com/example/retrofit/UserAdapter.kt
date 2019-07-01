package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_users.view.*

class UserAdapter (private val users:List<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val li= parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView= li.inflate(R.layout.layout_users,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount()=users.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user=users[position]
        holder.itemView.tvName.text=user.name
        holder.itemView.tvUsername.text=user.username
        holder.itemView.tvEmail.text=user.email //keep these vales same as the values in the json file
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

}