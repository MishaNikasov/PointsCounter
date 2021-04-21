package com.nikasov.pointscounter.ui.adapter

import com.nikasov.pointscounter.R
import com.nikasov.pointscounter.data.TableModel
import com.nikasov.pointscounter.databinding.ItemPlayerTableBinding
import javax.inject.Inject

class TableAdapter @Inject constructor(): BaseAdapter<TableModel, ItemPlayerTableBinding>() {

    override var layoutId: Int = R.layout.item_player_table

    override fun bind(binding: ItemPlayerTableBinding, model: TableModel, position: Int) {
        binding.apply {
            this.model = model
            addPointBtn.setOnClickListener {
                model.score ++
                score.text = model.score.toString()
            }
            removePointBtn.setOnClickListener {
                model.score --
                score.text = model.score.toString()
            }
        }
    }

}