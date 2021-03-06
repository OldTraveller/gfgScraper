

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DoTheScrapingHere  {

		public static void Scrape( Elements searchResults , String searchedForThis ) throws IOException {
			Element first = searchResults.first() ; 
			String url = first.attr("href") ;
			String exactLink = url.substring( 7 , url.indexOf("&" ) ) ;
			GotoTheWebsiteAndScrapeProgram( exactLink , searchedForThis ) ;
		}

		private static void GotoTheWebsiteAndScrapeProgram( String exactLink , String searchedForThis ) throws IOException {
			Document reachedWebsite = Jsoup.connect(exactLink).get() ;

			System.out.println("The Title is : " + reachedWebsite.title()  );
			Elements Program = reachedWebsite.getElementsByTag("pre") ;
			if ( Program != null ) {
				System.out.println("Below is the Program for Your Search : " + searchedForThis ) ; 
				System.out.println("----------------------------------------------");
				for ( Element ele : Program ) {
					System.out.println( ele.text() ); 
				}
				System.out.println("----------------------------------------------");
				
			} else {
				System.out.println("Try Again ! " ); 
			}
		}
}
