package com.bydmr.groupielibrary

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val excitingSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val booringFancyItems = generateFancyItems(6)
        val excitingFancyItems = generateFancyItems(12)

        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3
        }

        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }

        ExpandableGroup(ExpandableHeaderItem("Booring group"), true).apply {
            add(Section(booringFancyItems))
            groupAdapter.add(this)
        }

        ExpandableGroup(ExpandableHeaderItem("Exciting group"), false).apply {
            excitingSection.addAll(excitingFancyItems)
            add(excitingSection)
            groupAdapter.add(this)
        }

        fab_shuffle.setOnClickListener {
            excitingFancyItems.shuffle()
            excitingSection.update(excitingFancyItems)
        }
    }

    private fun generateFancyItems(count: Int): MutableList<FancyItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(255, rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256))
            FancyItem(color, rnd.nextInt(100))
        }
    }
}
