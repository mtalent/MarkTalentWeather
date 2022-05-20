package com.assignment.marktalentweather.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.assignment.marktalentweather.R
import com.assignment.marktalentweather.api.ApiService
import com.assignment.marktalentweather.repository.WeatherRepository
import com.assignment.marktalentweather.viewmodel.FragmentOneViewModel
import com.assignment.marktalentweather.viewmodel.FragmentOneViewModelsFactory

class FragmentOne : Fragment() {

    private lateinit var factory: FragmentOneViewModelsFactory

    private lateinit var viewModel: FragmentOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = ApiService()
        val repository = WeatherRepository(api)
        factory = FragmentOneViewModelsFactory(repository)
        viewModel = ViewModelProviders.of(this, factory)[FragmentOneViewModel::class.java]
    }
}