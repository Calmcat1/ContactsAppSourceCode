package com.example.uidesign2.ContactViewModel
import com.example.uidesign2.Contacts.Contacts


interface ContactEvents {
    object SaveContact: ContactEvents
    data class SetFirstName (val firstName : String) : ContactEvents
    data class SetLastName (val lastName : String) : ContactEvents
    data class SetPhoneNumber (val phoneNumber: String) : ContactEvents

    object ShowDialog : ContactEvents
    object HideDialog : ContactEvents

    data class DeleteContact(val contact: Contacts) : ContactEvents

}