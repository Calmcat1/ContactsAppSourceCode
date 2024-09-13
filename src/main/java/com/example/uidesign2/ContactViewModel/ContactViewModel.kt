package com.example.uidesign2.ContactViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uidesign2.Contacts.Contacts
import com.example.uidesign2.Contacts.ContactsDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel (
    private val dao : ContactsDAO,

): ViewModel() {

    val _state = MutableStateFlow(ContactStates())

    private val _contacts: Flow<List<Contacts>> = dao.getContacts()

    val state = combine(_state, _contacts){
        state, contacts ->
        state.copy(
            contacts = contacts
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactStates())

    fun onEvent(event: ContactEvents){
        when(event){
            is ContactEvents.DeleteContact -> {
                viewModelScope.launch{
                    dao.deleteContact(event.contact)
                }
            }

            is ContactEvents.SetLastName ->{
                _state.update {
                    it.copy(
                        lastName = event.lastName
                    )
                }
            }

            is ContactEvents.SetFirstName ->{
                _state.update{
                    it.copy(
                        firstName = event.firstName
                    )
                }
            }

            is ContactEvents.SetPhoneNumber -> {
               _state.update{
                   it.copy(
                       phoneNumber = event.phoneNumber
                   )
               }
            }

            ContactEvents.ShowDialog -> {
                _state.update{
                    it.copy(
                        isAddingContact = true
                    )
                }

            }

            ContactEvents.HideDialog -> {
                _state.update{
                    it.copy(
                        isAddingContact = false
                    )
                }

            }

            ContactEvents.SaveContact -> {
                val firstName = _state.value.firstName
                val lastName = _state.value.lastName
                val phoneNumber = _state.value.phoneNumber

                if(firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()){
                    return
                }

                val contact = Contacts(
                    firstName = firstName,
                    LastName = lastName,
                    phoneNumber = phoneNumber
                )

                viewModelScope.launch{
                    dao.upsertContact(contact)
                }

                _state.update {
                    it.copy(
                        isAddingContact = false,
                        firstName = "",
                        lastName = "",
                        phoneNumber = ""
                    )
                }
            }

        }
    }
}