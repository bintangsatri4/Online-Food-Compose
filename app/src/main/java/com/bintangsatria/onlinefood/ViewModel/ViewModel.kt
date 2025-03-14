package com.bintangsatria.onlinefood.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bintangsatria.onlinefood.domain.BannerModel
import com.bintangsatria.onlinefood.domain.CategoryModel
import com.bintangsatria.onlinefood.domain.FoodModel
import com.bintangsatria.onlinefood.repository.MainRepository

class ViewModels: ViewModel(){

    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }
    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadFiltered(id: String): LiveData<MutableList<FoodModel>> {
        return repository.loadFiltered(id)
    }
}