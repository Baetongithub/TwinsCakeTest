package kg.twnscake.twinscaketest.data.model

import com.google.gson.annotations.SerializedName

data class TransactionsModel(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("is_expense")
    val isExpense: Boolean
)
