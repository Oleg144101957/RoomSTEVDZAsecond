package com.vishnevskiypro.roomstevdzasecond.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.roomstevdzasecond.R
import com.vishnevskiypro.roomstevdzasecond.data.User
import com.vishnevskiypro.roomstevdzasecond.databinding.ItemUserBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(users: List<User>){
        this.userList = users
        notifyDataSetChanged()

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemUserBinding.bind(view)
        fun bind(user: User){
            binding.apply {
                idText.text = user.id.toString()
                firstNameText.text = user.firstName
                lastNameText.text = user.secondName
                ageText.text = user.age.toString()
            }

        }
    }
}