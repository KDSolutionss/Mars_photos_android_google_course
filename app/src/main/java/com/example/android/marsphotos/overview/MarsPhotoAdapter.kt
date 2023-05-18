package com.example.android.marsphotos.overview
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto


class MarsPhotoAdapter:androidx.recyclerview.widget.ListAdapter<MarsPhoto,MarsPhotoAdapter.ViewHolder>(DiffCallback)
{
    class ViewHolder(private var binding:
                              GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo=getItem(position)
        holder.bind(photo)
    }
}
