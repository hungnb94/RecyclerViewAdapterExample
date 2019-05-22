package com.solar.hung.adapterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), AdapterListener {
    private val listData = ArrayList<RandomImage>()
    private val normalAdapter = NormalAdapter(listData)

    private val images = arrayListOf(R.drawable.test_img_1, R.drawable.test_img_2, R.drawable.test_img_3)
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createList()
        normalAdapter.setAdapterListener(this)
        rcvListItem.adapter = normalAdapter

        fabAdd.setOnClickListener {
            val items = arrayListOf(createRandomObject(), createRandomObject(), createRandomObject())
            val start = 3
            items.forEachIndexed { index, image ->
                listData.add(start + index, image)
            }
            normalAdapter.notifyItemRangeInserted(start, items.size)
        }
    }

    override fun onChangeText(position: Int) {
        val data = listData[position]
        data.textData = UUID.randomUUID().toString()
        normalAdapter.notifyItemChanged(position)
    }

    override fun onChangeImage(position: Int) {
        val data = listData[position]
        data.imageResource = images[random.nextInt(images.size)]
        normalAdapter.notifyItemChanged(position)
    }

    private fun createList() {
        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
//        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
//        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
//        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
//        listData.add(RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)]))
    }

    private fun createRandomObject():RandomImage {
        return RandomImage(UUID.randomUUID().toString(), UUID.randomUUID().toString(), images[random.nextInt(images.size)])
    }
}
