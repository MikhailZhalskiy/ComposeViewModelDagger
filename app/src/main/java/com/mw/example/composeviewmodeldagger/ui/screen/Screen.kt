package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen {

    protected abstract val route: String
    abstract fun route(): String

    object EmailList : Screen() {

        override val route: String = "email_list"

        override fun route(): String = route
    }

    object EmailDetail : Screen() {

        override val route: String = "email_detail"
        private const val emailArg = "email"

        override fun route(): String = "$route/{$emailArg}"

        fun createRouteWithArgs(email: String): String = "$route/$email"

        fun arguments(): List<NamedNavArgument> {
            return listOf(
                navArgument(emailArg) { type = NavType.StringType }
            )
        }

        data class Arg(
            val email: String
        )

        fun getArg(handle: SavedStateHandle): Arg {
            return Arg(
                email = handle.get<String>(emailArg).orEmpty()
            )
        }
    }

    object Other : Screen() {

        override val route: String = "other_screen"
        private const val otherArg = "other_arg"

        override fun route(): String = "$route/{$otherArg}"

        fun createRouteWithArgs(other: String): String = "$route/$other"

        fun arguments(): List<NamedNavArgument> {
            return listOf(
                navArgument(otherArg) { type = NavType.StringType }
            )
        }

        data class Arg(
            val other: String
        )

        fun getArg(handle: SavedStateHandle): Arg {
            return Arg(
                other = handle.get<String>(otherArg).orEmpty()
            )
        }
    }
}