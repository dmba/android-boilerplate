package me.dmba.mychecks.ui.screens.main

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.inflate
import me.dmba.mychecks.data.model.Check

/**
 * Created by dmba on 6/2/18.
 */

interface OnChecksItemClickListener {
    fun onCheckItemClick(position: Int, check: Check, sharedView: View)
}

class ChecksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindModel(check: Check) = itemView.apply {
        name.text = check.name
        date.text = check.date
        amount.text = check.amount
        logo.setImageResource(check.imgRes)
    }
}

class ChecksRecyclerViewAdapter(
    private val clickListener: OnChecksItemClickListener,
    private val data: List<Check>
) : RecyclerView.Adapter<ChecksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ChecksViewHolder {
        val itemView = parent.inflate(R.layout.item_layout, false)
        return ChecksViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ChecksViewHolder, position: Int) {
        holder.bindModel(data[position])

        ViewCompat.setTransitionName(holder.itemView, data[position].name)

        holder.itemView.setOnClickListener {
            clickListener.onCheckItemClick(holder.adapterPosition, data[position], holder.itemView)
        }
    }

}
