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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dragon
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * DragonDetailActivity displays dinosaur details.
 *
 * @author Yang Han
 * @since 2021/3/3
 */
class DragonDetailActivity : AppCompatActivity() {
    private val dragon by lazy { intent.getSerializableExtra("dragon") as Dragon }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                DetailScreen()
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = dragon.dragonName) },
                    navigationIcon = {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            },

            content = {
                DetailContent(dragon)
            }
        )
    }

    @Composable
    private fun DetailContent(pet: Dragon) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(pet.dragonImageId),
                contentDescription = null, // decorative
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = pet.dragonDescribe,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}
