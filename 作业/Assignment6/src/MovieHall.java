import java.util.ArrayList;
import java.util.List;

public class MovieHall{
    private int id;
    private List<Movie> movies = new ArrayList<>();
    private List<Movie> sortMovies = new ArrayList<>();

    public MovieHall( int id){
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Movie movie) {
        movies.add(movie);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Movie> getSortMovies(){
        sortMovies = movies;
        for( int i = 0; i < sortMovies.size(); i++ ){
            for( int j = i+1; j < sortMovies.size(); j++ ){
                if(sortMovies.get(i).getStartTime().getHour() > sortMovies.get(j).getStartTime().getHour()){
                    Movie movie1 = sortMovies.get(j);
                    Movie movie2 = sortMovies.get(i);
                    sortMovies.set(i, movie1);
                    sortMovies.set(j, movie2);
                }else if(sortMovies.get(i).getStartTime().getHour() == sortMovies.get(j).getStartTime().getHour()){
                    if(sortMovies.get(i).getStartTime().getMinute() > sortMovies.get(i).getStartTime().getMinute()){
                        Movie movie1 = sortMovies.get(j);
                        Movie movie2 = sortMovies.get(i);
                        sortMovies.set(i, movie1);
                        sortMovies.set(j, movie2);
                    }
                }
            }
        }
        return sortMovies;
    }

}
