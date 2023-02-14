package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo 
{
	public static void main(String[] args) 
	{
		List<Movie> movieList = new ArrayList<Movie>();
		
		Movie movie1=new Movie();
		movie1.setName("Master");
		movie1.setActor("Vijay");
		movie1.setReleaseYear(2021);
		

		Movie movie2=new Movie();
		movie2.setName("valimai");
		movie2.setActor("ajith");
		movie2.setReleaseYear(2019);
		
		movieList.add(movie1);
		movieList.add(movie2);
		
		findMoviesIn2021(movieList);
		findMoviesByActor(movieList);
		getMovies(movieList, m -> m.getReleaseYear()==2019);
		getMovies(movieList, m -> m.getActor().equalsIgnoreCase("vijay"));
	}
	
	private static void findMoviesIn2021(List<Movie> movieList)
	{
		
		for(Movie movie : movieList)
		{
			if(movie.getReleaseYear()==2019)
			{
				System.out.println(movie.getName());
			}
		}
	
	}
	
	private static void findMoviesByActor(List<Movie> movieList)
	{
		
		for(Movie movie : movieList)
		{
			if(movie.getActor().equalsIgnoreCase("vijay"))
			{
				System.out.println(movie.getName());
			}
		}
	
	}
	
	private static void getMovies(List<Movie> movieList,Predicate<Movie> moviePredicate)
	{
		for(Movie movie:movieList)
		{
			if(moviePredicate.test(movie))
			{
				System.out.println(movie.getName());
			}
		}
	}
}
