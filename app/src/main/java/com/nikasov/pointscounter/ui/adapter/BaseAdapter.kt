package com.nikasov.pointscounter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Model, ItemBinding : ViewDataBinding> : RecyclerView.Adapter<BaseAdapter<Model, ItemBinding>.BaseViewHolder>() {

    protected abstract var layoutId: Int
    protected var onItemClickListener: ((Model) -> Unit)? = null

    var items: List<Model> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun setItemClickListener(listener: ((Model) -> Unit)) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items[position]?.let { model ->
            bind(holder.binding, model, position)
        }
    }

    inner class BaseViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder((binding as ViewDataBinding).root)

    protected abstract fun bind(binding: ItemBinding, model: Model, position: Int)

}
