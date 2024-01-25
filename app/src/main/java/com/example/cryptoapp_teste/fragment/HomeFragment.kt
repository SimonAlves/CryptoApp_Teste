package com.example.cryptoapp_teste.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.cryptoapp_teste.TopLossGainPagerAdapter
import com.example.cryptoapp_teste.adapter.TopmatketAdapter
import com.example.cryptoapp_teste.api.ApiInterface
import com.example.cryptoapp_teste.api.ApiUtilities
import com.example.cryptoapp_teste.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        getTopCurrencyList()

        setTabLayout()

        return binding.root
    }
    private fun setTabLayout(){
        val adapter = TopLossGainPagerAdapter(this)
        binding.contentViewPager.adapter = adapter
        binding.contentViewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    binding.topGainIndicator.visibility = VISIBLE
                    binding.topGainIndicator.visibility = GONE
                } else {
                    binding.topGainIndicator.visibility = VISIBLE
                    binding.topGainIndicator.visibility = GONE
                }

            }
        })
        TabLayoutMediator(binding.tabLayout,binding.contentViewPager){
            tab,position ->
            var title = if (position==0){
                "Maiores ganhadores"
            }else{
                "Principais perdedores"
            }
            tab.text = title
        }.attach()
    }

    private fun getTopCurrencyList() {
        lifecycleScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()
            withContext(Dispatchers.Main){
                binding.topCurrencyRecyclerView.adapter = TopmatketAdapter(requireContext(),res.body()!!.data.cryptoCurrencyList)

            }

          Log.d("SHUBH","getTopCurrencyList: ${res.body()!!.data.cryptoCurrencyList}")
        }

    }
}



