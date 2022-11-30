package com.akash.androidinterviewpreperation.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akash.androidinterviewpreperation.databinding.SimpleListItemLayoutBinding


class SimpleListAdapter : RecyclerView.Adapter<SimpleListAdapter.ListViewHolder>() {


    companion object{
        val DIFF_CALLBACK =object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }
    private val mDiffer: AsyncListDiffer<String> =
        AsyncListDiffer(this, DIFF_CALLBACK)

    inner class ListViewHolder(val binding:SimpleListItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bindTo(item: String?) {
            item?.let {
                binding.itemName.text = it;
            }
        }

    }

    fun submitList(newList:List<String>){
        mDiffer.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = SimpleListItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = mDiffer.currentList[position]
        holder.bindTo(item)
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size;
    }
}