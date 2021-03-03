package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
