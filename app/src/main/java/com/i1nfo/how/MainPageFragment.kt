package com.i1nfo.how

import android.os.Bundle
import android.view.*
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainPageFragment : Fragment() {

    private var scrollCounter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scrollView = view.findViewById<NestedScrollView>(R.id.scroll_view)
        val addButton = view.findViewById<FloatingActionButton>(R.id.add_button)

        // auto hide fab
        scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            val deltaY = scrollY - oldScrollY
            if (deltaY > 0 && addButton.isShown) {
                scrollCounter += deltaY
                if (scrollCounter > 100) {
                    addButton.hide()
                    scrollCounter = 0
                }
            } else if (deltaY < 0 && !addButton.isShown) {
                scrollCounter += deltaY
                if (scrollCounter < -100) {
                    addButton.show()
                    scrollCounter = 0
                }
            }
        }

        // setup searchView
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        val menu = toolbar.menu
        val searchItem = menu.findItem(R.id.app_bar_search)

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                setMenuItemsVisibility(menu, searchItem, false)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                setMenuItemsVisibility(menu, searchItem, true)
                return true
            }
        })

    }


    private fun setMenuItemsVisibility(menu: Menu, except: MenuItem, visible: Boolean) {
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            if (item != except)
                item.isVisible = visible
        }
    }

}