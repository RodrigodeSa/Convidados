package com.rodrigocdesa.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rodrigocdesa.convidados.service.constants.GuestConstants
import com.rodrigocdesa.convidados.service.model.GuestModel
import com.rodrigocdesa.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {

        when (filter) {
            GuestConstants.FILTER.EMPTY -> {
                mGuestList.value = mGuestRepository.getAll()
            }
            GuestConstants.FILTER.PRESENT -> {
                mGuestList.value = mGuestRepository.getPresent()
            }
            else -> {
                mGuestList.value = mGuestRepository.getAbsent()
            }
        }
    }

    fun delete(id: Int) {
        mGuestRepository.delete(mGuestRepository.get(id))
    }

}