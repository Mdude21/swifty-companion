package com.example.swifty_companion.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swifty_companion.R
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
    fun bind(project: ProjectUsers){
        with(binding) {
            projectTextView.text = project.project.name
            finalMarkTextView.text = project.finalMark.toString()
            statusTextView.text = project.status
            if (project.validation == true && project.finalMark!! >= 80){
                projectTextView.setTextColor(R.color.green)
                finalMarkTextView.setTextColor(R.color.green)
                statusTextView.setTextColor(R.color.green)
            }
            else if (project.validation == false){
                projectTextView.setTextColor(R.color.red)
                finalMarkTextView.setTextColor(R.color.red)
                statusTextView.setTextColor(R.color.red)
            }
        }
    }
}