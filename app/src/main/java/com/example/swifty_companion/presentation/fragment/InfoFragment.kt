package com.example.swifty_companion.presentation.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.swifty_companion.R
import com.example.swifty_companion.data.AuthConfig
import com.example.swifty_companion.databinding.FragmentInfoBinding
import com.example.swifty_companion.presentation.adapter.ProjectListAdapter
import com.example.swifty_companion.presentation.adapter.SkillsListAdapter
import com.example.swifty_companion.presentation.viewmodel.InfoViewModel


class InfoFragment : Fragment(R.layout.fragment_info) {

    private val viewModel: InfoViewModel by viewModels()

    private val binding by viewBinding(FragmentInfoBinding::bind)

    private val projectAdapter = ProjectListAdapter()

    private val skillAdapter = SkillsListAdapter()


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            emailTextView.text = AuthConfig.User?.email
            firstnameTextView.text = AuthConfig.User?.displayname
            evalPointsDisplay.text = AuthConfig.User?.correctionPoint.toString()
            walletTextView.text = AuthConfig.User?.wallet.toString()

            viewModel.getLevel()
            viewModel.level.observe(viewLifecycleOwner) {
                levelTextView.text = "Level: $it"
                progressBar.setProgress(((it * 100) % 100).toInt(), true)
            }

            Glide.with(view)
                .load(AuthConfig.User?.imageUrl)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

            projectList.layoutManager = LinearLayoutManager(activity)
            projectList.adapter = projectAdapter
            val projectDividerItemDecoration = DividerItemDecoration(
                projectList.context,
                (projectList.layoutManager as LinearLayoutManager).orientation
            )
            projectList.addItemDecoration(projectDividerItemDecoration)
            projectAdapter.setProjects(AuthConfig.User!!.projectUsers.filter {
                it.status == "finished" && it.finalMark != null
            }
            )

            skillRecyclerView.layoutManager = LinearLayoutManager(activity)
            skillRecyclerView.adapter = skillAdapter
            val skillDividerItemDecoration = DividerItemDecoration(
                skillRecyclerView.context,
                (skillRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
            skillRecyclerView.addItemDecoration(skillDividerItemDecoration)
            if (AuthConfig.User!!.cursUsers.size == 1)
                skillAdapter.setSkills(AuthConfig.User!!.cursUsers[0].skills)
            else
                skillAdapter.setSkills(AuthConfig.User!!.cursUsers[1].skills)
        }
    }

}