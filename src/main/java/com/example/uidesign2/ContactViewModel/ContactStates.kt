package com.example.uidesign2.ContactViewModel

import com.example.uidesign2.Contacts.Contacts
import kotlinx.coroutines.flow.Flow

data class ContactStates(
    val contacts: List<Contacts> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false

)
