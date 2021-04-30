package org.ybk.clientcontentprovidersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.ybk.clientcontentprovidersample.databinding.RecyclerViewItemBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.CheeseViewHolder>() {

    private val cheeseList = ArrayList<Cheese>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheeseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RecyclerViewItemBinding>(
                inflater, R.layout.recycler_view_item, parent, false)
        return CheeseViewHolder(binding)
    }

    override fun getItemCount(): Int = cheeseList.size

    override fun onBindViewHolder(holder: CheeseViewHolder, position: Int) {
        holder.bind(cheeseList[position])
    }

    fun updateItems(items: ArrayList<Cheese>) {
        cheeseList.clear()
        cheeseList.addAll(items)
        notifyDataSetChanged()
    }

    inner class CheeseViewHolder(
            private val binding: RecyclerViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cheese: Cheese) {
            binding.cheeseItem = cheese
            binding.executePendingBindings()
        }
    }
}