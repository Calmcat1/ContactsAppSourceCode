package com.example.uidesign2.Contacts
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var firstName : String,
    var LastName : String,
    var phoneNumber : String
)
