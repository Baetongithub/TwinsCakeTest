package kg.twnscake.twinscaketest.presentation.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.collection.intFloatMapOf
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kg.twnscake.twinscaketest.R
import kg.twnscake.twinscaketest.data.model.TransactionsModel
import kg.twnscake.twinscaketest.databinding.ItemTransactionsBinding

class HomeAdapter(
    private val context: Context,
    private val onItemClick: (TransactionsModel) -> Unit,
    private val list: List<TransactionsModel>
) : RecyclerView.Adapter<HomeAdapter.BalanceViewHolder>() {

    private var _isExpense: Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        return BalanceViewHolder(
            ItemTransactionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {
        holder.bind(list[position])

        if (_isExpense)
            holder.itemView.background.setTint(
                ContextCompat.getColor(
                    context,
                    R.color.expense_color
                )
            )
        else holder.itemView.background.setTint(
            ContextCompat.getColor(
                context,
                R.color.income_color
            )
        )
        holder.itemView.setOnClickListener {
            onItemClick(list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BalanceViewHolder(
        private val vb: ItemTransactionsBinding
    ) : RecyclerView.ViewHolder(vb.root) {

        fun bind(model: TransactionsModel) {
            vb.tvDate.text = model.date
            vb.tvAmount.text = model.amount
            vb.tvDescription.text = model.description
            _isExpense = model.isExpense
        }
    }
}