import java.util.ArrayList;
import java.util.List;

public class ConcreteCinema implements Cinema {
    List<Movie> movies = new ArrayList<>();
    List<String> movieHall = new ArrayList<>();
    List<MovieHall> movieHallList = new ArrayList<>();

    @Override
    public void addMovieHall(int capacity) {
        MovieHall moviehall = new MovieHall(capacity);
        movieHallList.add(moviehall);
        movieHall.add(String.valueOf(capacity));
    }

    @Override
    public List<String> getAllMovieHallsCapacity() {
        return movieHall;
    }

    @Override
    public void addMovie(String name, int runtime, int hallNumber, double price, int type, Time startTime) {
        if(movieHallList.get(hallNumber - 1).getMovies() == null || timeCompare(movieHallList.get(hallNumber-1).getMovies(), startTime, runtime)) {
            int Left = movieHallList.get(hallNumber - 1).getId();
            if (type == 0) {
                Movie movie = new OrdinaryMovie(name, startTime, runtime, price, Left);
                movies.add(movie);
                movieHallList.get(hallNumber - 1).setMovies(movie);
            } else if (type == 1) {
                Movie movie = new ThreeDMovie(name, startTime, runtime, price, Left);
                movies.add(movie);
                movieHallList.get(hallNumber - 1).setMovies(movie);
            }
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> getMoviesFromMovieHallOrderByStartTime(int hallNumber) {
        return movieHallList.get(hallNumber-1).getSortMovies();
    }

    @Override
    public double reserveMovie(int movieId, int arg) {
        return movies.get(movieId-1).purchase(arg);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movies.get(movieId-1);
    }

    @Override
    public double getOneMovieIncome(int movieId) {
        return (movieHallList.get(movieId-1).getId()-getMovieById(movieId).ticketsLeft) * getMovieById(movieId).getPrice();
    }

    @Override
    public double getTotalIncome() {
        double total = 0;
        for( int i = 1; i <= movies.size(); i++ ){
            total += getOneMovieIncome(i);
        }
        return total;
    }

    @Override
    public List<Movie> getAvailableMoviesByName(Time currentTime, String name) {
        List<Movie> movieA = new ArrayList<>();
        for( int i = 0; i < movies.size(); i++ ){
            if( movies.get(i).getName().equals(name) && (movies.get(i).getStartTime().getHour() > currentTime.getHour() ||
                    (movies.get(i).getStartTime().getHour() == currentTime.getHour() &&
                            movies.get(i).getStartTime().getMinute() > currentTime.getMinute()))) {
                movieA.add(movies.get(i));
            }
        }
        for( int i = 0; i < movieA.size(); i++ ){
            for( int j = 0; j < movieA.size(); j++){
                if(movieA.get(i).getStartTime().getHour() > movieA.get(j).getStartTime().getHour()){
                    Movie movie1 = movieA.get(j);
                    Movie movie2 = movieA.get(i);
                    movieA.set(i, movie1);
                    movieA.set(j, movie2);
                }else if(movieA.get(i).getStartTime().getHour() == movieA.get(j).getStartTime().getHour()){
                    if(movieA.get(i).getStartTime().getMinute() > movieA.get(i).getStartTime().getMinute()){
                        Movie movie1 = movieA.get(j);
                        Movie movie2 = movieA.get(i);
                        movieA.set(i, movie1);
                        movieA.set(j, movie2);
                    }
                }
            }
        }
        return movieA;
    }

    public boolean timeCompare(List<Movie> a, Time b, int c){
        int STime2 = b.getHour() * 60 + b.getMinute();
        int ETime2 = STime2 + c;
        for( int i = 0; i < a.size(); i++ ) {
            int STime = a.get(i).getStartTime().getHour() * 60 + a.get(i).getStartTime().getMinute();
            int ETime = STime + a.get(i).getRuntime();
            if(STime2 > ETime && STime2 - ETime < 20) {
                return false;
            }
            if(STime > ETime2 && STime - ETime2 < 20){
                return false;
            }
            if(STime2 > STime && ETime2 < ETime) {
                return false;
            }
            if(STime > STime2 && ETime > ETime2) {
                return false;
            }
        }
        return true;
    }
}
