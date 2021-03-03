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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.model.Dragon
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * MainActivity is the program entry.
 *
 * @author Yang Han
 * @since 2021/3/3
 */

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewmodel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                viewModel.pullData()
                viewModel.dogsLiveData.value?.let {
                    AnimalList(dragons = it, this)
                }
            }
        }
    }
}

// Start building your app here!
//list
@Composable
fun AnimalList(
    dragons: List<Dragon>,
    context: Context
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dragon",
                    )
                },
                backgroundColor = Color.Transparent, elevation = 0.dp
            )
        }
    ) {
        Column {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(dragons) { _, dragon ->
                    DragonCard(
                        dragon = dragon
                    ) {
                        Intent(context, DragonDetailActivity::class.java).apply {
                            this.putExtra("dragon", it)
                        }.run {
                            startActivity(context, this, this.extras)
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun DragonCard(
    dragon: Dragon,
    onClick: (Dragon) -> Unit
) {
    Row(
        Modifier
            .clickable { onClick(dragon) }
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Column {
            Image(
                painter = painterResource(dragon.dragonImageId),
                contentDescription = null, // decorative
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(80.dp, 80.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            Text(
                text = dragon.dragonName,
                style = MaterialTheme.typography.h5,
            )


        }
    }
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )

}
