package com.bydmr.groupielibrary

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_fancy.*

class FancyItem(
        private val color: Int,
        private val number: Int
): Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.cardView_fancy.setBackgroundColor(color)
        viewHolder.textView_fancy_number.text = number.toString()
    }

    override fun getLayout(): Int = R.layout.item_fancy

    override fun getSpanSize(spanCount: Int, position: Int): Int = spanCount / 3 // Fits three fancy items in one row
}