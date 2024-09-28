package kg.twnscake.twinscaketest.presentation.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kg.twnscake.twinscaketest.data.model.BalanceModel
import kg.twnscake.twinscaketest.data.model.TransactionsModel
import kg.twnscake.twinscaketest.databinding.FragmentHomeBinding
import kg.twnscake.twinscaketest.presentation.extensions.jsonFromAssetString
import kg.twnscake.twinscaketest.presentation.extensions.jsonFromAssetsList
import kg.twnscake.twinscaketest.presentation.ui.base.BaseFragment
import kg.twnscake.twinscaketest.presentation.utils.AssetsJsons

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val listOfTransactions = arrayListOf<TransactionsModel>()
    private val homeAdapter by lazy {
        HomeAdapter(
            requireContext(),
            this::onItemClick,
            listOfTransactions
        )
    }

    override fun initView() {
        setUpRecyclerView()
        vb.tvYourBalanceValue.text =
            requireContext().jsonFromAssetString<BalanceModel>(AssetsJsons.BALANCE).balance.toString()
    }

    override fun initData() {
        super.initData()
        addTransactions()
    }

    private fun setUpRecyclerView() {
        vb.recyclerViewTransactions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

    private fun addTransactions() {
        listOfTransactions.clear()
        listOfTransactions.addAll(requireContext().jsonFromAssetsList(AssetsJsons.TRANSACTIONS))
    }

    private fun onItemClick(model: TransactionsModel) {
        if (model.isExpense){
            Snackbar.make(this.requireView(), "Покупка в магазине", Snackbar.LENGTH_SHORT).show()
        } else
            Snackbar.make(this.requireView(), "Пополнение счета", Snackbar.LENGTH_SHORT).show()
    }
}