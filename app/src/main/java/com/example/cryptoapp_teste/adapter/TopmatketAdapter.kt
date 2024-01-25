package com.example.cryptoapp_teste.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp_teste.R
import com.example.cryptoapp_teste.databinding.TopCurrencyLayoutBinding
import com.example.cryptoapp_teste.models.CryptoCurrency
import com.bumptech.glide.Glide


class TopmatketAdapter(var context : Context , val list : List<CryptoCurrency>):RecyclerView.Adapter<TopmatketAdapter.TopMarketViewHolder>() {


    inner class TopMarketViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var binding = TopCurrencyLayoutBinding.bind(view)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMarketViewHolder {
       return TopMarketViewHolder(LayoutInflater.from(context).inflate(R.layout.top_currency_layout,parent,false))
    }



    override fun onBindViewHolder(holder: TopMarketViewHolder, position: Int) {
        val item = list[position]

        holder.binding.topCurrencyNameTextView.text = item.name
        Glide.with(context)
            .load(
                "https://s2.coinmarketcap.com/static/img/coins/64x64/" + item.id + ".png"
            ).thumbnail(Glide.with(context).load(R.drawable.spinner))
            .into(holder.binding.topCurrencyImageView) // Substitua 'imageView' pelo ID ou referência real para o ImageView no seu layout


        if (item.quotes!![0].percentChange24h > 0) {
            holder.binding.topCurrencyChangeTextView.setTextColor(context.resources.getColor(R.color.green))
            holder.binding.topCurrencyChangeTextView.text =
                "+ ${String.format("%.02f", item.quotes[0].percentChange24h)} % "


        } else {
            holder.binding.topCurrencyChangeTextView.setTextColor(context.resources.getColor(R.color.red))
            holder.binding.topCurrencyChangeTextView.text =
                "${String.format("%.02f", item.quotes[0].percentChange24h)} % "
        }
        Log.d(
            "TopmatketAdapter",
            "Item Name: ${item.name}, Percent Change: ${item.quotes!![0].percentChange24h}"
        )
    }
        override fun getItemCount(): Int {
            return list.size


    }
}