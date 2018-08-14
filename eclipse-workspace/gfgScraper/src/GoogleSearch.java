

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleSearch implements Variables {
	
	static Scanner scanner ;
	public static void main(String[] args) throws IOException {
		scanner = new Scanner(System.in);
		
		String ch = "Y" ;
		while ( ch.equals("y")|| ch.equals("Y") ) {
			ThisFunctionToExecute() ;
			System.out.println("Want To Search More ? : " );
			ch = scanner.nextLine() ; 
		} 
		scanner.close(); 
	}
	
	public static void ThisFunctionToExecute() throws IOException {
		
		System.out.println("Please enter the search term.");
		String searchTerm = scanner.nextLine();
		int num = 1 ; 
		String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		
		Elements results = doc.select("h3.r > a");
		if ( results.size() == 0 ) {
			System.out.println("Enter Another Search : " ); 
		} else {
			if ( results.first().attr("href").contains("geeksforgeeks")) {
				DoTheScrapingHere.Scrape( results , searchTerm );
			} else {
				System.out.println("Please Enter A valid Search ! Even google isnt able to find it !! ");
				return ;
			}
		}
	}
}