/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.model.Dragon
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewmodel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                viewModel.pullData()
                viewModel.dogsLiveData.value?.let { AnimalList(dragons = it) }
            }
        }
    }
}

// Start building your app here!

//list
@Composable
fun AnimalList(
    dragons: List<Dragon>,
//    onSelected: (Dragon) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
//                        text = getString(R.string.app_name),
                        text = "Daragon",
                    )
                },
                backgroundColor = Color.Transparent, elevation = 0.dp
            )
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(dragons) { _, dragon ->
                DragonCard(dragon)
            }
        }
    }

}

@Composable
fun DragonCard(dragon: Dragon) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = dragon.dragonName,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
