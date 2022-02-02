package com.example.swifty_companion.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.AuthConfig
import com.example.swifty_companion.databinding.FragmentInfoBinding
import com.example.swifty_companion.databinding.FragmentSearchBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private val binding by viewBinding(FragmentInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailTextView.text = AuthConfig.User?.email
        binding.firstnameTextView.text = AuthConfig.User?.displayname
        binding.nickTextView.text = AuthConfig.User?.login
        binding.phoneTextView.text = AuthConfig.User?.phone
        Glide.with(view)
            .load(AuthConfig.User?.imageUrl)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView)
    }
}