package com.example.swifty_companion.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.AuthConfig

import com.example.swifty_companion.databinding.FragmentSearchBinding
import com.example.swifty_companion.presentation.adapter.UserListAdapter
import com.example.swifty_companion.presentation.viewmodel.SearchViewModel
import com.example.swifty_companion.tools.autoCleared

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()
    private var userAdapter: UserListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initList()
//        bindViewModel()
//        viewModel.user.observe(viewLifecycleOwner, {
//            binding.userLoginText.text = it.login
//        })

        viewModel.user.observe(viewLifecycleOwner, {
            binding.usernameTextView.text = it.login

            Glide.with(view)
                .load(it.imageUrl)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.avatarImageView)
        })
        binding.buttonSearch.setOnClickListener {
            viewModel.getUserByLogin(binding.editTextSearch.text.toString())

        }
        Toast.makeText(context, AuthConfig.TOKEN, Toast.LENGTH_SHORT).show()
        Log.d("mdude", "${AuthConfig.TOKEN}")
    }

//    private fun initList() {
//        userAdapter = UserListAdapter()
//        binding.userList.apply {
//            adapter = userAdapter
//            layoutManager = LinearLayoutManager(requireContext())
//            setHasFixedSize(true)
//        }
//    }
//
//    private fun bindViewModel() {
//        viewModel.user.observe(viewLifecycleOwner, )
//        binding.buttonSearch.setOnClickListener {
//            viewModel.getUserByLogin(binding.editTextSearch.text.toString())
//        }
//    }
}