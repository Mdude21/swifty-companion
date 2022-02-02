package com.example.swifty_companion.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.model.User
import com.example.swifty_companion.databinding.ItemUserBinding
import com.example.swifty_companion.tools.bindingInflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class UserAdapterDelegate :
    AbsListItemAdapterDelegate<User, User, UserAdapterDelegate.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup): UserAdapterDelegate.Holder {
        return Holder(parent.bindingInflate(ItemUserBinding::inflate))
    }

    override fun isForViewType(item: User, items: MutableList<User>, position: Int): Boolean {
        return true
    }

    override fun onBindViewHolder(item: User, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }


    class Holder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: User) {
            binding.usernameTextView.text = item.login

            Glide.with(itemView)
                .load(item.imageUrl)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.avatarImageView)
        }
    }
}