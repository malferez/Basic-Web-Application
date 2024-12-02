/**package LearnSE.Dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import LearnSE.Model.CyberModel;

public class cyberattackDao {

	public void scrapeData() throws IOException {
	    Connection conn = null;

	    // JSoup connection URL
	    final String sturl = "https://horizon.netscout.com/?atlas=summary";

	    try {
	        // Database connection setup
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs372_2024db", "root", "Passw0rd");

	        // Connect to the website and parse the HTML
	        final Document document = Jsoup.connect(sturl).get();

	        // Extract the month and year
	        String monthYearText = document.select("div.summary-air-ui--app-air--section h2").text();
	        System.out.println("Scraped Month and Year: " + monthYearText);

	        // Parse month and year
	        String[] monthYearParts = monthYearText.split(" ");
	        String month = monthYearParts.length > 0 ? monthYearParts[0] : "";
	        String year = monthYearParts.length > 1 ? monthYearParts[1] : "";

	        System.out.println("Month: " + month);
	        System.out.println("Year: " + year);

	        // Prepare to collect scraped data
	        ArrayList<String[]> rows = new ArrayList<>();

	        for (int i = 0; i < 5; i++) { // Assuming 5 rows
	            // Source country and attacks
	            String srcCountrySelector = "#source-count-sum-country--table--row" + i + "--label";
	            String srcCountSelector = "#source-count-sum-country--table--row" + i + "--count";

	            // Destination country and attacks
	            String destCountrySelector = "#dest-count-sum-country--table--row" + i + "--label";
	            String destCountSelector = "#dest-count-sum-country--table--row" + i + "--count";

	            String srcCountry = document.select(srcCountrySelector).text();
	            String srcCount = document.select(srcCountSelector).text();
	            String destCountry = document.select(destCountrySelector).text();
	            String destCount = document.select(destCountSelector).text();

	            // Add row data
	            rows.add(new String[]{
	                srcCountry, srcCount.replace(",", ""), // Source country and attacks
	                destCountry, destCount.replace(",", "") // Destination country and attacks
	            });
	        }

	        // Debugging: Print the rows
	        for (String[] row : rows) {
	            System.out.println("Row: " + String.join(", ", row));
	        }

	        // Insert data into the database
	        String insertQuery = "INSERT INTO cyberattacks (srccountry, srcno_attack, targetcountry, targetno_attack, month, year) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement preStmt = conn.prepareStatement(insertQuery);

	        for (String[] row : rows) {
	            preStmt.setString(1, row[0]);
	            preStmt.setString(2, row[1]); // Already cleaned of commas
	            preStmt.setString(3, row[2]);
	            preStmt.setString(4, row[3]); // Already cleaned of commas
	            preStmt.setString(5, month);
	            preStmt.setString(6, year);
	            preStmt.executeUpdate();
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


    public ArrayList<CyberModel> getCyberData() throws IOException {
        ArrayList<CyberModel> cyberArray = new ArrayList<>();

        System.out.println("Scraping data...");
        scrapeData();

        return cyberArray;
    }
}
*/