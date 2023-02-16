package kg.dvizh.tasknewsapp.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.dvizh.tasknewsapp.databinding.ItemTaskBinding
import kg.dvizh.tasknewsapp.domain.TaskModel

class TaskAdapter(private val taskList: MutableList<TaskModel> = mutableListOf()) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    fun add(item: TaskModel) {
        taskList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }


    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskModel) {
            binding.tvTitle.text = task.title
            binding.tvDescp.text = task.description
        }
    }
}