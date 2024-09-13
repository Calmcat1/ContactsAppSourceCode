package com.example.uidesign2.ContactComposableUIElements


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uidesign2.ContactViewModel.ContactEvents
import com.example.uidesign2.ContactViewModel.ContactStates
import kotlinx.coroutines.flow.MutableStateFlow





@Composable
fun ContactDialog(
    state : ContactStates,
    onEvent : (ContactEvents) -> Unit,



){



    AlertDialog(onDismissRequest = { 
        onEvent(ContactEvents.HideDialog)
    },
        confirmButton = { /*TODO*/ },
        modifier = Modifier,
        text = {

            LazyColumn(
                contentPadding = PaddingValues(10.dp)
            ) {

                item {

                    TextField(
                        label = { Text(text = "firstName") },
                        value = state.firstName,
                        onValueChange = { onEvent(ContactEvents.SetFirstName(it)) },
                        modifier = Modifier
                            .padding(bottom = 20.dp))

                }

                item {
                    TextField(
                        label = { Text(text = "lastName") },
                        value = state.lastName,
                        onValueChange = { onEvent(ContactEvents.SetLastName(it)) },
                        modifier = Modifier
                            .padding(bottom = 20.dp))



                }

                item {

                    TextField(
                        label = { Text(text = "phoneNumber") },
                        value = state.phoneNumber,
                        onValueChange = {
                            onEvent(ContactEvents.SetPhoneNumber(it)) },
                                modifier = Modifier
                                .padding(bottom = 20.dp)
                    )

                }

                item {
                    Button(onClick = {
                        onEvent(ContactEvents.SaveContact)
                    }) {
                        Text(text = "Save")
                    }
                }

            }
        }




            )





}