package com.lucassimoesmartins.myretrofitexample.model

data class PopularMovies(
    val page: Int,
    val results: List<PopularMoviesResult>,
    val total_pages: Int,
    val total_results: Int
)