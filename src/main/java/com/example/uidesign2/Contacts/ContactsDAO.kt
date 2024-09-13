package com.example.uidesign2.Contacts

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDAO {
    @Upsert
    suspend fun upsertContact(contact : Contacts) : Void

    @Delete
    suspend fun deleteContact(contact : Contacts) : Void

    @Query("SELECT * FROM Contacts")
    fun getContacts(): Flow<List<Contacts>>

    @Query("SELECT * FROM Contacts ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName() : Flow<List<Contacts>>

    @Query("SELECT * FROM Contacts ORDER BY LastName ASC")
    fun getContactsOrderedByLastName() : Flow<List<Contacts>>

    @Query("SELECT * FROM Contacts ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber() : Flow<List<Contacts>>


}