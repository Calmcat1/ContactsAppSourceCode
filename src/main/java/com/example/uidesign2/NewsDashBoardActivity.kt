package com.example.uidesign2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uidesign2.ui.theme.UIdesign2Theme

class NewsDashBoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIdesign2Theme {
               NewsDashBoardScreen()
            }
        }
    }
}

@Preview
@Composable
fun NewsDashBoardScreen(){

    var scrollState = rememberScrollState()

    // screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // News heading text
        Text(modifier = Modifier
            .padding(start = 20.dp, top = 40.dp),
            text = "News",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
            )

        // makes the elements scrollable
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(bottom = 20.dp)
        ) {

            // reusable NewsDashboardComponent
            for (i in 1..10) {
                NewsDashBoardElement(
                    "Hello",
                    "here is an example of a text, that is supposed to act as a description for this item"
                )
            }
        }

    }
}


@Composable

// parameters for {{the newsElementHeadings and the newsElementTexts}}
fun NewsDashBoardElement(NewsItemHeading : String, NewsItemText: String){


    // this box carries the row element responsible for housing the news Dashboard Elements
   Box(


       modifier = Modifier
           .fillMaxWidth()

   ){

      // row carrier for the Box{card}, Box{Heading text and Description text}
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(top = 20.dp, end = 30.dp),
           verticalAlignment = Alignment.CenterVertically
       ) {

           // this box carries the card
           Box() {

               // card acting as a placeholder for news images
               Card(
                   modifier = Modifier
                       .size(125.dp)
                       .padding(start = 20.dp, top = 20.dp)
               ) {

               }
           }

           // this box carries the NewsItemHeading and NewsItemText
           Box() {
               Text(
                   text = NewsItemHeading,
                   fontSize = 30.sp,
                   modifier = Modifier
                       .padding(start = 20.dp),
                   fontWeight = FontWeight.Bold
               )

               Text(
                   text = NewsItemText,
                   fontSize = 15.sp,
                   modifier = Modifier
                       .padding(top = 40.dp, start = 20.dp)
               )
           }

           //end
       }
   }

}

