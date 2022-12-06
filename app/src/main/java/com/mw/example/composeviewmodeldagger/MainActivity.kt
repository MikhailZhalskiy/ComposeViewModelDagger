package com.mw.example.composeviewmodeldagger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mw.example.composeviewmodeldagger.extensions.Inject
import com.mw.example.composeviewmodeldagger.ui.screen.DetailEmailScreen
import com.mw.example.composeviewmodeldagger.ui.screen.EmailListScreen
import com.mw.example.composeviewmodeldagger.ui.screen.Screen
import com.mw.example.composeviewmodeldagger.ui.theme.ComposeViewModelDaggerTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeViewModelDaggerTheme {
                //The first way to use the Inject function
                Inject(App.instance.getFactoryViewModelAssistedFactory()) {
                    Scaffold {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.EmailList.route(),
                            Modifier.padding(it)
                        ) {

                            composable(route = Screen.EmailList.route()) { navBackStackEntry ->
                                navBackStackEntry.destination
                                EmailListScreen(
                                    navigateEmailDetailScreen = { email ->
                                        navController.navigate(Screen.EmailDetail.createRouteWithArgs(email))
                                    }
                                )
                            }

                            addDetailEmailScreen()
                        }
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.addDetailEmailScreen() {
    composable(
        route = Screen.EmailDetail.route(),
        arguments = Screen.EmailDetail.arguments()
    ) {
        //The second way to use the Inject function
        Inject(App.instance.getFactoryViewModelAssistedFactory()) {
            DetailEmailScreen()
        }
    }
}