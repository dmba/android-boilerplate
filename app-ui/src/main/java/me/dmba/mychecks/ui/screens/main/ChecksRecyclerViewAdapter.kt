package me.dmba.mychecks.ui.screens.main

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.inflate
import me.dmba.mychecks.data.model.Check

/**
 * Created by dmba on 6/2/18.
 */

interface OnChecksItemClickListener {
    fun onCheckItemClick(check: Check, sharedView: View)
}

class ChecksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindModel(check: Check) = itemView.apply {
        name.text = check.name
        date.text = check.date
        amount.text = check.amount

        Picasso
            .with(itemView.context)
            .load(check.imgUrl)
            .into(logo)
    }
}

class ChecksRecyclerViewAdapter(
    private val clickListener: OnChecksItemClickListener
) : RecyclerView.Adapter<ChecksViewHolder>() {

    private var data: List<Check> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ChecksViewHolder {
        val itemView = parent.inflate(R.layout.item_layout, false)
        return ChecksViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ChecksViewHolder, position: Int) {
        holder.bindModel(data[position])

        ViewCompat.setTransitionName(holder.itemView, data[position].id)

        holder.itemView.setOnClickListener {
            clickListener.onCheckItemClick(data[position], holder.itemView)
        }
    }

    fun updateData(items: List<Check>) {
        data = items
        notifyDataSetChanged()
    }

}
