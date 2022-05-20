package com.assignment.marktalentweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.marktalentweather.repository.WeatherRepository

@Suppress("UNCHECKED_CAST")
class FragmentOneViewModelsFactory (
    private val repository: WeatherRepository
        ) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FragmentOneViewModel(repository) as T
    }

}