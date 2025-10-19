package org.example.firstcmpproject

import androidx.compose.ui.window.ComposeUIViewController
import org.example.firstcmpproject.core.persistence.getDatabaseBuilderIOS

fun MainViewController() = ComposeUIViewController {


    val databaseBuilder = getDatabaseBuilderIOS()

    App(databaseBuilder)
}