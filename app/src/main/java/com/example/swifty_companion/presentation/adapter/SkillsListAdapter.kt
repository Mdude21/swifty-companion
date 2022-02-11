package com.example.swifty_companion.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swifty_companion.data.model.Skills
import com.example.swifty_companion.databinding.ItemSkillsBinding
import java.math.RoundingMode

class SkillsListAdapter : RecyclerView.Adapter<SkillsViewHolder>() {
    private var skills: List<Skills> = emptyList()

    override fun getItemCount(): Int = skills.size

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        holder.bind(skills[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSkillsBinding.inflate(layoutInflater, parent, false)
        return SkillsViewHolder(binding)
    }

    fun setSkills(skills: List<Skills>) {
        this.skills = skills
    }
}

class SkillsViewHolder(private val binding: ItemSkillsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(skill: Skills) {
        with(binding) {
            SkillLevelTextView.text =
                skill.level.toBigDecimal().setScale(2, RoundingMode.FLOOR).toDouble().toString()
            SkillNameTextView.text = skill.name
        }
    }

}