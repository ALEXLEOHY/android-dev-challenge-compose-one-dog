package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import java.io.Serializable

/**
 * Dragon data model.
 *
 * @author Yang Han
 * @since 2021/3/3
 */
data class Dragon(
    //恐龙名字
    val dragonName: String,

    //恐龙描述
    val dragonDescribe: String,

    //捕获恐龙
    val catch: Boolean,

    @DrawableRes val dragonImageId: Int
) : Serializable
