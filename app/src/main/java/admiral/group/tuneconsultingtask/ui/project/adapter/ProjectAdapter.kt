package admiral.group.tuneconsultingtask.ui.project.adapter

import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.ItemviewBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

// Adapter is also Creational Pattern.

class ProjectAdapter(
    private val onClickListener: OnClickListener
):RecyclerView.Adapter<ProjectAdapter.ViewHolder>(){

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

        val result = mTodo[position]

        holder.binding.apply {
            nameproject.text=result.nameProject
        }
        holder.binding.itevView.setOnClickListener {
          onClickListener.onClick(result.id)

        }
    }

    override fun getItemCount()=mTodo.size

    class OnClickListener(val clickListener: (id:Int) -> Unit) {
        fun onClick(id: Int) = clickListener(id)
    }

}