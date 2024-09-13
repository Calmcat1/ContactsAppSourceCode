package com.example.uidesign2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.uidesign2.ContactComposableUIElements.ContactScreen
import com.example.uidesign2.ContactViewModel.ContactEvents
import com.example.uidesign2.ContactViewModel.ContactStates
import com.example.uidesign2.ContactViewModel.ContactViewModel
import com.example.uidesign2.Contacts.Contacts
import com.example.uidesign2.Contacts.ContactsDatabase
import com.example.uidesign2.ui.theme.UIdesign2Theme



class ContactActivity : ComponentActivity() {

    private val db by lazy {

        Room.databaseBuilder(
            applicationContext,
            ContactsDatabase::class.java,
            "contacts_database"
        ).build()
    }

    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIdesign2Theme {

                val state by viewModel.state.collectAsState()

                ContactScreen(state = state, onEvent = viewModel::onEvent)


            }
        }
    }
}




