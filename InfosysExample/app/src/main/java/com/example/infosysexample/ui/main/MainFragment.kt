package com.example.infosysexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.infosysexample.R
import com.example.infosysexample.Utils.VolleyClient
import com.example.infosysexample.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private  val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //here we will make our binding and bind any classes we need to it

        val binding=MainFragmentBinding.inflate(inflater)

        binding.lifecycleOwner=this

        binding.viewModel=viewModel

        binding.cardRecycler.adapter=CardsAdapter()

        binding.executePendingBindings()

        //Old way of getting cards cards are now handled solely within the viewmodel

//        viewModel.cards.observe(viewLifecycleOwner){
//            (binding.cardRecycler.adapter as CardsAdapter).submitList(it)
//        }

//        viewModel.getCardsList()

        return binding.root
    }

    //replaced this because it was deprecated
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //removed in favor of lazy implementation
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

}