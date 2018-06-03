package me.dmba.mychecks.ui.utils

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.applyDimension
import android.view.View

/**
 * Created by dmba on 5/31/18.
 */
class ListPaddingDecoration(
    private val padding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }
        outRect.left = padding
        outRect.top = padding
        outRect.right = padding

        val adapter = parent.adapter
        if (adapter != null && itemPosition == adapter.itemCount - 1) {
            outRect.bottom = padding
        }
    }

    companion object {
        private const val DEFAULT_PADDING_IN_DIPS = 6F

        fun from(context: Context): ListPaddingDecoration {
            val metrics = context.resources.displayMetrics
            val padding = applyDimension(COMPLEX_UNIT_DIP, DEFAULT_PADDING_IN_DIPS, metrics).toInt()
            return ListPaddingDecoration(padding)
        }
    }
}
