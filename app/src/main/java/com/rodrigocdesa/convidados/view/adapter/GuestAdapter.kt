package com.rodrigocdesa.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigocdesa.convidados.databinding.RowGuestBinding
import com.rodrigocdesa.convidados.service.model.GuestModel
import com.rodrigocdesa.convidados.view.listener.GuestListener
import com.rodrigocdesa.convidados.view.viewholder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var guestList: List<GuestModel> = arrayListOf()
    private lateinit var guestListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val itemBinding =
            RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(itemBinding, guestListener)
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    fun updateGuests(list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener) {
        guestListener = listener
    }

}