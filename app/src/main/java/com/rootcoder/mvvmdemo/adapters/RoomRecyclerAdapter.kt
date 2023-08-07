package com.rootcoder.mvvmdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.RoomdbItemViewBinding
import com.rootcoder.mvvmdemo.datamodels.RoomdbDM
import com.rootcoder.mvvmdemo.interfaces.AdapterClickListener

class RoomRecyclerAdapter( var list:List<RoomdbDM>,val listener: AdapterClickListener) : RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:RoomdbItemViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
        ,R.layout.roomdb_item_view, parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list.get(position)

        holder.binding.tvData.setText(itemData.toString())

        holder.bind(position,listener)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(val binding: RoomdbItemViewBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(position:Int, listener: AdapterClickListener){
            binding.tvData.setOnClickListener {
                listener.onClick(position,it)
            }
        }
    }


}