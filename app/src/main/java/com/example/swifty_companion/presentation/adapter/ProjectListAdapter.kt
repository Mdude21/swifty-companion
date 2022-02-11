package com.example.swifty_companion.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swifty_companion.data.model.ProjectUsers
import com.example.swifty_companion.databinding.ItemProjectsBinding

class ProjectListAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private var projects: List<ProjectUsers> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    override fun getItemCount(): Int = projects.size

    fun setProjects(projects: List<ProjectUsers>) {
        this.projects = projects
    }

}

class ViewHolder(private val binding: ItemProjectsBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(project: ProjectUsers) {
        with(binding) {
            projectTextView.text = project.project.name
            finalMarkTextView.text = project.finalMark.toString()
            projectSlugTextView.text = project.project.slug
            if (project.validation == true && project.finalMark!! >= 80) {
                projectTextView.setTextColor(Color.parseColor("#00FF0A"))
                finalMarkTextView.setTextColor(Color.parseColor("#00FF0A"))
                projectSlugTextView.setTextColor(Color.parseColor("#00FF0A"))
            } else {
                projectTextView.setTextColor(Color.parseColor("#FF0000"))
                finalMarkTextView.setTextColor(Color.parseColor("#FF0000"))
                projectSlugTextView.setTextColor(Color.parseColor("#FF0000"))
            }
        }
    }
}