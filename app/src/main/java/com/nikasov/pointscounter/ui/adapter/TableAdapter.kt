package com.nikasov.pointscounter.ui.adapter

import android.content.Context
import android.graphics.Color.*
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.color.colorChooser
import com.google.android.material.card.MaterialCardView
import com.nikasov.pointscounter.R
import com.nikasov.pointscounter.data.TableModel
import com.nikasov.pointscounter.databinding.ItemPlayerTableBinding
import javax.inject.Inject

class TableAdapter @Inject constructor(): BaseAdapter<TableModel, ItemPlayerTableBinding>() {

    override var layoutId: Int = R.layout.item_player_table

    override fun bind(binding: ItemPlayerTableBinding, model: TableModel, position: Int) {
        binding.apply {
            this.model = model

            fun changeScore(value: Int) {
                model.score += value
                score.text = model.score.toString()
            }

            addPointBtn.setOnClickListener {
                changeScore(1)
            }
            removePointBtn.setOnClickListener {
                changeScore(-1)
            }
            addFive.setOnClickListener {
                changeScore(5)
            }
            addTen.setOnClickListener {
                changeScore(10)
            }
            addTwenty.setOnClickListener {
                changeScore(20)
            }

            cardName.setOnClickListener {
                showColorDialog(binding.root.context, cardName)
            }
        }
    }

    private fun showColorDialog(context: Context, cardView: MaterialCardView) {
        val colors = intArrayOf(RED, GREEN, BLUE)
        MaterialDialog(context).show {
            title(text = "Color")
            colorChooser(
                colors = colors,
                allowCustomArgb = true,
                showAlphaSelector = false
            ) { _, color ->
                cardView.setCardBackgroundColor(color)
            }
            positiveButton(text = "Select")
        }
    }


}