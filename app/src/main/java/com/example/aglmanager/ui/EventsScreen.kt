package com.example.aglmanager.ui

import AGLManagerViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aglmanager.AGLManagerScreen

data class TableRow(val name: String, val location: String)

@Composable
fun HomeScreen(
    viewModel: AGLManagerViewModel = viewModel(),
    navController: NavController
) {
    val uiState = viewModel.uiState.collectAsState().value

    val fakeData = listOf(
        TableRow("Nogomet", "Stožice"),
        TableRow("Rokomet",  "Dvorana DIF"),
        TableRow("Košarka",  "Dvorana DIF"),
        TableRow("Nogomet #2",  "Stožice")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = uiState.message,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))


        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color.Gray.copy(alpha = 0.2f))
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Name",
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Location",
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }

            items(fakeData) { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color.White)
                        .border(1.dp, Color.Gray)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = row.name,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = row.location,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
