package com.example.perqaragames.presentation.perqara_app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.perqaragames.domain.model.GameQueries
import com.example.perqaragames.domain.model.toGameQueries
import com.example.perqaragames.presentation.discover.Discover
import com.example.perqaragames.presentation.favorites.Favorites
import com.example.perqaragames.presentation.filtered_games.FilteredGames
import com.example.perqaragames.presentation.game_details.GameDetailsPage
import com.example.perqaragames.presentation.search.Search

@Composable
fun Navigation(modifier: Modifier, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.BottomBarScreens.Discover.route
    ) {

        composable(Screens.BottomBarScreens.Discover.route) {
            Discover(navController = navController)
        }

        composable(Screens.BottomBarScreens.Search.route){
            Search(navController = navController)
        }

        composable(Screens.BottomBarScreens.Favorites.route){
            Favorites(navController = navController)
        }

        composable(
            Screens.GameDetailsScreen.withArgs("gameId"),
            arguments = Screens.GameDetailsScreen.arguments!!
        ){
            GameDetailsPage(
                navController = navController,
                gameId = it.arguments?.getInt("gameId") ?: 0
            )
        }


        composable(
            Screens.FilteredGamesScreen.withArgs("gameQueries"),
            arguments = Screens.FilteredGamesScreen.arguments!!
        ){
            FilteredGames(
                navController = navController,
                gameQueries = it.arguments?.getString("gameQueries")
                    ?.toGameQueries() ?: GameQueries()
            )
        }

    }


}