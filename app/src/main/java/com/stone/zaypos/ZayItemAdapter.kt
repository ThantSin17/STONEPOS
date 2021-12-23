package com.stone.zaypos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.zaypos.databinding.AddItemLayoutBinding
import com.stone.zaypos.entity.ZayItem

class ZayItemAdapter : RecyclerView.Adapter<ZayItemViewHolder>() {
    private val list: ArrayList<ZayItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZayItemViewHolder {
        return ZayItemViewHolder(
            AddItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    fun updateAdapter(newList:ArrayList<ZayItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ZayItemViewHolder, position: Int) {
        list[position].let {
            holder.bindData(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
