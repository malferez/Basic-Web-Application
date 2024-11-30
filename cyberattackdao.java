package project.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class cyberattackdao {

    public void scrapeData() throws IOException {
        // Declare database connection and statement variables
        Connection conn = null;
        Statement stmt = null;

        // JSoup connection URL
        final String sturl = "https://horizon.netscout.com/?atlas=summary";

        // ArrayList to store month and year
        ArrayList<String> monthYear = new ArrayList<>();

        try {
            // Initialize database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cs372_2024db", "root", "test111");

            // Connect to the website and parse the HTML
            final Document document = Jsoup.connect(sturl).get();

            // Extract the month and year from the webpage
            Elements months = document.select("div.summary-air-ui--app-air--section, div");
            String theMonth = months.select("h2").text();

            // Split month and year using Scanner
            Scanner scn = new Scanner(theMonth);
            while (scn.hasNext()) {
                monthYear.add(scn.next());
            }
            scn.close();

            // Create an ArrayList to hold scraped data
            ArrayList<String> srcTargetData = new ArrayList<>();

            // Create a 2D array to hold data (size 5x4 as described)
            String[][] srcDest = new String[5][4];

            // Scrape data from the table
            for (Element el : document.select("div.summary-air-ui--topcountries--table.summary-air-ui--table--tablespan")) {
                String dtValue = el.select("span").text();

                // Only add non-empty values
                if (!dtValue.isEmpty()) {
                    srcTargetData.add(dtValue);
                }
            }

            // Get month and year from the ArrayList
            String month = monthYear.size() > 0 ? monthYear.get(0) : "";
            String year = monthYear.size() > 1 ? monthYear.get(1) : "";

            // Populate the 2D array with the scraped data
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    int index = (i * 4) + j;
                    if (index < srcTargetData.size()) {
                        srcDest[i][j] = srcTargetData.get(index);
                    }
                }
            }

            // Insert the data into the database
            String insertAttacks = "INSERT INTO cyberattacks (srccountry, srcno_attack, targetcountry, targetno_attack, month, year) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preStmt = conn.prepareStatement(insertAttacks);

            for (int i = 0; i < 5; i++) {
                preStmt.setString(1, srcDest[i][0]);
                preStmt.setString(2, srcDest[i][1]);
                preStmt.setString(3, srcDest[i][2]);
                preStmt.setString(4, srcDest[i][3]);
                preStmt.setString(5, month);
                preStmt.setString(6, year);
                preStmt.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log SQL exceptions
        } finally {
            // Close database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
			