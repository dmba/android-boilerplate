package me.dmba.mychecks.ui.screens.details

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.check_item_layout.view.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.inflate
import me.dmba.mychecks.data.model.CheckItem

/**
 * Created by dmba on 6/9/18.
 */
class CheckItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindModel(item: CheckItem) = itemView.apply {
        checkItemName.text = item.name
        checkItemAmount.text = item.amount
    }
}

class CheckItemsAdapter constructor(
    private val data: List<CheckItem>
) : RecyclerView.Adapter<CheckItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CheckItemsViewHolder {
        val itemView = parent.inflate(R.layout.check_item_layout, false)
        return CheckItemsViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CheckItemsViewHolder, position: Int) {
        holder.bindModel(data[position])
    }

}
