package com.example.swifty_companion.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.swifty_companion.data.model.User
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class UserListAdapter : AsyncListDifferDelegationAdapter<User>(
    UserDiffUtilCallback()
) {

    init {
        delegatesManager.addDelegate(UserAdapterDelegate())
    }

    class UserDiffUtilCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}