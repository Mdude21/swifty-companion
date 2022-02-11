package com.example.swifty_companion.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.AuthConfig
import com.example.swifty_companion.databinding.FragmentSearchBinding
import com.example.swifty_companion.presentation.viewmodel.SearchViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("mdude token", "${AuthConfig.TOKEN}")

        viewModel.user.observe(viewLifecycleOwner) {
            binding.usernameTextView.text = it.login

            Glide.with(view)
                .load(it.imageUrl)
                .transform(CircleCrop())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.avatarImageView)
        }
        binding.buttonSearch.setOnClickListener {
            viewModel.getUserByLogin(binding.editTextSearch.text.toString())

        }

        viewModel.isComplete.observe(viewLifecycleOwner) {
            binding.buttonSearch.isEnabled = it
            if (it)
                binding.userProgressBar.visibility = View.GONE
            else
                binding.userProgressBar.visibility = View.VISIBLE
        }

        viewModel.isDefault.observe(viewLifecycleOwner) {
            val tmp = it
            binding.usernameTextView.setOnClickListener {
                if (tmp)
                    findNavController().navigate(R.id.action_searchFragment_to_infoFragment)
            }
        }

    }
}