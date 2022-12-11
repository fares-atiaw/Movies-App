package com.example.simplemoviesdetails.data.model

data class MovieResponse(
    val Response: String, // True
    val Search: List<Movie>,
    val totalResults: String // 5388
)

data class Movie(
    val Poster: String, // https://m.media-amazon.com/images/M/MV5BMTg4MDk1ODExN15BMl5BanBnXkFtZTgwNzIyNjg3MDE@._V1_SX300.jpg
    val Title: String, // The Lego Movie
    val Type: String, // movie
    val Year: String, // 2014
    val imdbID: String // tt1490017
)
