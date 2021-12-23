package com.stone.zaypos

import androidx.recyclerview.widget.RecyclerView
import com.stone.zaypos.databinding.AddItemLayoutBinding
import com.stone.zaypos.entity.ZayItem

class ZayItemViewHolder(itemView: AddItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val binding=itemView
    fun bindData(item:ZayItem){
        binding.zayItem=item
    }
}