package com.stone.zaypos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.BadgeUtils.attachBadgeDrawable
import com.stone.zaypos.databinding.ActivityMainBinding
import com.stone.zaypos.entity.ZayItem

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter: ZayItemAdapter = ZayItemAdapter()
    var list: ArrayList<ZayItem> = ArrayList()
    lateinit var badgeDrawable : BadgeDrawable


    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()



        //recyclerView
//        adapter.updateAdapter(list)
//        binding.itemList.adapter=adapter

        //BadgeDrawable
        badgeDrawable = BadgeDrawable.create(binding.toolbar.context)
        badgeDrawable.number=25
        attachBadgeDrawable(badgeDrawable,binding.toolbar,R.id.cash)



        //searchView onclick
        binding.buttonSearch.setOnSearchClickListener {
            binding.itemCategory.visibility = View.GONE
            binding.divider.visibility = View.GONE
            binding.buttonSearch.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            Toast.makeText(applicationContext, "click", Toast.LENGTH_LONG).show()

        }
        //searchView onclick
        binding.buttonSearch.setOnCloseListener(
            object : SearchView.OnCloseListener,
                androidx.appcompat.widget.SearchView.OnCloseListener {
                override fun onClose(): Boolean {
                    Toast.makeText(applicationContext, "close", Toast.LENGTH_LONG).show()
                    binding.buttonSearch.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
                    binding.buttonSearch.onActionViewCollapsed()
                    binding.itemCategory.visibility = View.VISIBLE
                    binding.divider.visibility = View.VISIBLE
                    return true

                }
            }
        )

        binding.buttonSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {

                    Toast.makeText(applicationContext, "submit", Toast.LENGTH_LONG).show()
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    Toast.makeText(applicationContext, "text change", Toast.LENGTH_LONG).show()
                    return true
                }

            }
        )

        //spinnerAdapter
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.itemCategory.adapter = adapter
        }


    }
    fun init(){
        var item1=ZayItem(1,"Apple","Food","Each",5,500,5)
        var item2=ZayItem(1,"Banana","Food","Each",6,300,10)
        var item3=ZayItem(1,"Fire dragon","Drink","Each",400,400,10)
        var item4=ZayItem(1,"Orange","Food","Each",700,500,5)
        val item5=ZayItem(1,"Apple","Food","Each",800,500,5)
        var item6=ZayItem(1,"Apple","Food","Each",80,500,5)
        var item7=ZayItem(1,"Apple","Food","Each",4000,500,5)
        var item8=ZayItem(1,"Apple","Food","Each",7000,500,5)
        var item9=ZayItem(1,"Apple","Food","Each",555,500,5)
        var item10=ZayItem(1,"Apple","Food","Each",7777,500,5)
        val item11=ZayItem(1,"Apple","Food","Each",4,500,5)
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)
        list.add(item7)
        list.add(item8)
        list.add(item9)
        list.add(item10)
        list.add(item11)
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)
        list.add(item7)
        list.add(item8)
        list.add(item9)
        list.add(item10)
        list.add(item11)







    }
    


}





