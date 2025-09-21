package com.example.simplefactapp.presentation.navgraph



sealed class Routes (val route: String){
    object OnBoardingScreen: Routes("onBoardingScreen")
    object HomeScreen: Routes("homeScreen")
    object SearchScreen:Routes("searchScreen")
    object BookMarkScreen:Routes("BookmarkScreen")
    object DetailsScreen:Routes("detailsScreen")
    object AppStartNavigation:Routes("appStartNavigation")
    object NewsNavigation:Routes("newsNavigation")
    object NewsNavigationScreen:Routes("newsNavigationScreen")


}