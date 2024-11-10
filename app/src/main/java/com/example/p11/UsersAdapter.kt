package com.example.p11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.p11.databinding.ItemBinding
import com.example.p11.model.Data

typealias OnClickDisaster = (Data) -> Unit

class UsersAdapter(
    private var listUsers: List<Data>,
    private val onClickUser: (Data) -> Unit
) : RecyclerView.Adapter<UsersAdapter.ItemUsersViewHolder>() {

    inner class ItemUsersViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: Data) {
            with(binding) {
                txtName.text = "${user.first_name} ${user.last_name}"
                txtEmail.text = user.email
                Glide.with(imgPlaceholder.context).load(user.profileImage).into(imgPlaceholder)

                // Set click listener pada item untuk memanggil onClickUser
                root.setOnClickListener { onClickUser(user) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUsersViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemUsersViewHolder(binding)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: ItemUsersViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }

    // Fungsi untuk memperbarui data adapter
    fun setData(newList: List<Data>) {
        listUsers = newList
        notifyDataSetChanged()
    }
}