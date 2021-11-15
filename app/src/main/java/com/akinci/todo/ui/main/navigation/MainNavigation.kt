package com.akinci.todo.ui.main.navigation

enum class MainNavigation {
    SplashPage,
    LoginPage,
    DashboardPage,
    NotePage;

    companion object {
        fun fromRoute(route: String?): MainNavigation =
            when (route?.substringBefore("/")) {
                SplashPage.name -> SplashPage
                LoginPage.name -> LoginPage
                DashboardPage.name -> DashboardPage
                NotePage.name -> NotePage
                null -> SplashPage  // For undefined route navigate to Splash
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }

}