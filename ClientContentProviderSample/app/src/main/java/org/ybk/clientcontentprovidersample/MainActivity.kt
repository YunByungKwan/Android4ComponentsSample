package org.ybk.clientcontentprovidersample

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.ybk.clientcontentprovidersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val AUTHORITY = "com.example.android.contentprovidersample.provider"
        private val CONTENT_URI = Uri.parse("content://$AUTHORITY/cheeses")
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        adapter = RecyclerAdapter()
    }

    fun fetchCheeseListFromContentProvider() {
        val cheeseList = ArrayList<Cheese>()
        val cursor = contentResolver.query(CONTENT_URI, arrayOf("_id", "name"),
            null, null, null)

        while(cursor!!.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex("_id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            cheeseList.add(Cheese(id, name))
        }
        binding.recyclerView.adapter = adapter
        adapter.updateItems(cheeseList)
    }
}