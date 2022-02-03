package com.example.swifty_companion.presentation.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.AuthConfig
import com.example.swifty_companion.databinding.FragmentInfoBinding
import com.example.swifty_companion.databinding.FragmentSearchBinding
import com.example.swifty_companion.presentation.adapter.ProjectListAdapter
import com.example.swifty_companion.presentation.viewmodel.InfoViewModel
import com.example.swifty_companion.tools.autoCleared

class InfoFragment : Fragment(R.layout.fragment_info) {

    private val viewModel : InfoViewModel by viewModels()

    private val binding by viewBinding(FragmentInfoBinding::bind)

    private val projectAdapter = ProjectListAdapter()


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailTextView.text = AuthConfig.User?.email
        binding.firstnameTextView.text = AuthConfig.User?.displayname
        binding.nickTextView.text = AuthConfig.User?.login
        binding.walletTextView.text = AuthConfig.User?.wallet.toString()
        binding.projectList.layoutManager = LinearLayoutManager(activity)
        viewModel.getLevel()
        viewModel.level.observe(viewLifecycleOwner, {
            binding.levelTextView.text = "Level: $it"
            binding.progressBar.setProgress(((it * 100) % 100).toInt(), true)
        })
        Glide.with(view)
            .load(AuthConfig.User?.imageUrl)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView)
        binding.projectList.adapter = projectAdapter
        projectAdapter.setProjects(AuthConfig.User!!.projectUsers.filter {
            it.status == "finished" && it.finalMark != null
//            it.finalMark!! >= 80
        }
        )
        projectAdapter.notifyDataSetChanged()
    }

}