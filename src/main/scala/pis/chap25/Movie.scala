package pis.chap25

case class Movie(
    Plot:String, 
    Rated:String,
    Title:String,
    Poster:String,
    Writer:String,
    imdbRating:String,
    Director:String,
    Released:String,
    Actors:String,
    imdbVotes:String,
    Year:String,
    Genre:String,
    Runtime:String,
    imdbID:String) {

}

case class MovieContainer(movies:List[Movie]) {
  
}