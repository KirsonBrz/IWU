package com.kirson.iwu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.IWUTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kirson.iwu.components.IWULogo
import com.kirson.iwu.entities.NavigationItem
import com.kirson.iwu.screens.ChatScreen
import com.kirson.iwu.screens.LoginScreen
import com.kirson.iwu.screens.PetsScreen
import com.kirson.iwu.screens.ProfileScreen
import com.kirson.iwu.screens.ReactionsScreen
import com.kirson.iwu.screens.RegistrationScreen
import com.kirson.iwu.screens.ServicesScreen
import com.kirson.iwu.ui.theme.md_theme_dark_background
import com.kirson.iwu.ui.theme.md_theme_light_background
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            IWUTheme {
                TransparentSystemBars()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = !useDarkIcons
        )
        systemUiController.setNavigationBarColor(
            color = if (!useDarkIcons) md_theme_light_background else md_theme_dark_background,
            darkIcons = !useDarkIcons,
            navigationBarContrastEnforced = false
        )


    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val title = remember { mutableStateOf("") }
    val showTopBar = remember { mutableStateOf(false) }

    val getTitle: (String) -> Unit = { screenTitle ->
        title.value = screenTitle
    }
    val isNotPetScreen: (Boolean) -> Unit = { isNotPetScreen ->
        showTopBar.value = isNotPetScreen
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AnimatedVisibility(visible = showTopBar.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                CenterAlignedTopAppBar(
                    title = { Text(
                        text = title.value,
                        style = TextStyle(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.secondary
                                )
                            ),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 28.sp
                        ),
                    ) },
                    navigationIcon = {
                        IWULogo()
                    },
                    scrollBehavior = scrollBehavior
                )
            }

        },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(bottom = padding.calculateBottomPadding())) {
                Navigation(topPadding = padding.calculateTopPadding(), navController = navController, getTitle, isNotPetScreen)
            }
        },
        // Set background color to avoid the white flashing when you switch between screens
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    IWUTheme {
        MainScreen()
    }
}

@Composable
fun Navigation(
    topPadding: Dp,
    navController: NavHostController,
    sendTitle: (String) -> Unit,
    isNotPetScreen: (Boolean) -> Unit,
    viewModel: MainModel = hiltViewModel()
) {
    NavHost(navController, startDestination = NavigationItem.Login.route) {



        composable(NavigationItem.Login.route) {
            sendTitle("")
            isNotPetScreen(true)
            LoginScreen(navController, topPadding)
        }

        composable(NavigationItem.Registration.route) {
            sendTitle("")
            isNotPetScreen(true)
            RegistrationScreen(navController, topPadding)
        }

        composable(NavigationItem.Pets.route) {

            sendTitle("")
            isNotPetScreen(false)
            PetsScreen(viewModel)
        }
        composable(NavigationItem.Services.route) {

            sendTitle("Сервисы")
            isNotPetScreen(true)
            ServicesScreen(viewModel,topPadding = topPadding)
        }
        composable(NavigationItem.Reactions.route) {
            sendTitle("Реакции")
            isNotPetScreen(true)
            ReactionsScreen(viewModel,topPadding = topPadding)
        }
        composable(NavigationItem.Chat.route) {

            sendTitle("Чат")
            isNotPetScreen(true)
            ChatScreen(viewModel, topPadding = topPadding)
        }
        composable(NavigationItem.Profile.route) {

            sendTitle("Профиль")
            isNotPetScreen(true)
            ProfileScreen(viewModel, topPadding = topPadding)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },

        )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Pets,
        NavigationItem.Services,
        NavigationItem.Reactions,
        NavigationItem.Chat,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.navigationBarsPadding(),

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(

                icon = {
                    Icon(
                        modifier = Modifier.padding(6.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title, style = MaterialTheme.typography.labelSmall) },
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    // BottomNavigationBar()
}