package com.example.simplemoviesdetails.data

data class DetailsResponse(
    val Actors: String, // Tatiana Maslany, Ginger Gonzaga, Malia Arrayah
    val Awards: String, // 2 wins & 1 nomination
    val Country: String, // United States
    val Director: String, // N/A
    val Genre: String, // Action, Adventure, Comedy
    val Language: String, // English
    val Metascore: String, // N/A
    val Plot: String, // Jennifer Walters navigates the complicated life of a single, 30-something attorney who also happens to be a green 6-foot-7-inch superpowered Hulk.
    val Poster: String, // https://m.media-amazon.com/images/M/MV5BMjU4MTkxNzktNzUyYy00NDM2LWE5NGQtNjJlN2Q0N2MxZDAxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg
    val Rated: String, // TV-14
    val Ratings: List<Rating>,
    val Released: String, // 18 Aug 2022
    val Response: String, // True
    val Runtime: String, // N/A
    val Title: String, // She-Hulk: Attorney at Law
    val Type: String, // series
    val Writer: String, // Jessica Gao
    val Year: String, // 2022
    val imdbID: String, // tt10857160
    val imdbRating: String, // 5.2
    val imdbVotes: String, // 161,239
    val totalSeasons: String // N/A
)

data class Rating(
    val Source: String, // Internet Movie Database
    val Value: String // 5.2/10
)