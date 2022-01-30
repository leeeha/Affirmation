package com.tutorial.affirmation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.affirmation.R
import com.tutorial.affirmation.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
    ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // nested class
    // 뷰홀더는 리스트의 한 아이템 뷰를 나타내며 필요에 따라 재사용됨.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    // 재사용할 수 있는 뷰홀더가 없을 때, 새로운 뷰홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // parent는 아이템 뷰가 추가되는 리사이클러뷰
        // list_item.xml 레이아웃을 뷰 객체로 인플레이트 시킴.
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // 새로운 뷰홀더 생성하여 리턴
        return ItemViewHolder(adapterLayout)
    }

    // 뷰홀더의 특정한 아이템 뷰의 내용 변경
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        // 전달한 id에 해당하는 문자열 리턴 받아서 텍스트뷰에 적용
        holder.textView.text =  context.resources.getString(item.stringResourceId)

        // 전달한 id에 해당하는 이미지를 이미지뷰에 적용
        holder.imageView.setImageResource(item.imageResourceId)
    }

    // 데이터셋의 크기 리턴
    override fun getItemCount() = dataset.size
}