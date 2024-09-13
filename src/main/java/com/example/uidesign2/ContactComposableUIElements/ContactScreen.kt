package com.example.uidesign2.ContactComposableUIElements

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uidesign2.ContactViewModel.ContactEvents
import com.example.uidesign2.ContactViewModel.ContactStates
import com.example.uidesign2.ContactComposableUIElements.ContactDialog


@Composable
fun ContactScreen(
    state: ContactStates,
    onEvent: (ContactEvents) -> Unit
) {

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { onEvent(ContactEvents.ShowDialog) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contacts")
                    
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)


        ) { padding ->

            if(state.isAddingContact){
                ContactDialog(state = state, onEvent = onEvent)

            }


            // container 1
           LazyColumn(
                contentPadding = padding,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)

            ) {
               
               item{
                   Button(onClick = { Log.d("ContactScreen", state.contacts.toString())}) {
                       Text(text = "ArrayLog")
                   }
               }

               items(state.contacts) { contact ->
                   Row() {
                       Column(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(start = 10.dp, end = 10.dp, top = 20.dp)
                               .background(Color.White)
                       ) {


                           Text(
                               text = "${contact.firstName} ${contact.LastName}",
                               color = Color.Black,
                               fontSize = 25.sp,
                               modifier = Modifier
                                   .padding(start = 20.dp, top = 5.dp)

                           )

                           Text(
                               text = "${contact.phoneNumber}",
                               color = Color.Black,
                               fontSize = 20.sp,
                               modifier = Modifier
                                   .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
                           )


                       }

                       Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                   }
               }



            }

        }


}