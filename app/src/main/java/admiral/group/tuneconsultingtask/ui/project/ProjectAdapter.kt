package admiral.group.tuneconsultingtask.ui.project

import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.ItemviewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter():RecyclerView.Adapter<ProjectAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemviewBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<ProjectEntity>() {

        override fun areItemsTheSame(oldItem: ProjectEntity, newItem: ProjectEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProjectEntity, newItem: ProjectEntity): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var mTodo: List<ProjectEntity>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemviewBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val nameProject = mTodo[position].nameProject

        holder.binding.apply {
            nameproject.text=nameProject
        }

    }

    override fun getItemCount()=mTodo.size


}