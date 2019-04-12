package com.bydmr.groupielibrary

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_expandable_header.*

class ExpandableHeaderItem(
        private val title: String
) : Item(), ExpandableItem {

    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.item_expandable_header.text = title
        viewHolder.item_expandable_header.setCompoundDrawablesWithIntrinsicBounds(0,0, getRotatedIconResId(), 0)

        viewHolder.item_expandable_root.setOnClickListener {
            expandableGroup.onToggleExpanded()
            viewHolder.item_expandable_header.setCompoundDrawablesWithIntrinsicBounds(0,0, getRotatedIconResId(), 0)
        }
    }

    override fun getLayout(): Int = R.layout.item_expandable_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    private fun getRotatedIconResId(): Int =
            if (expandableGroup.isExpanded)
                R.drawable.ic_keyboard_arrow_up
            else
                R.drawable.ic_keyboard_arrow_down
}