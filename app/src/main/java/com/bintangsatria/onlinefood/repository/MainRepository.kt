package com.bintangsatria.onlinefood.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bintangsatria.onlinefood.domain.BannerModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance("https://online-food1-default-rtdb.europe-west1.firebasedatabase.app")

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val listData = MutableLiveData<MutableList<BannerModel>>()
        val ref = firebaseDatabase.getReference("Banners")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BannerModel>()
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(BannerModel::class.java)
                    if (item != null) {
                        list.add(item)
                    }
                }
                listData.value = list
                // Log to check data
                println("Banners loaded from Firebase: ${list.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle possible errors.
                listData.value = mutableListOf()
                println("Failed to load banners: ${error.message}")
            }
        })
        return listData
    }
}