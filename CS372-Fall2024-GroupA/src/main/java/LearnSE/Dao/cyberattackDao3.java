/**package LearnSE.Dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import LearnSE.dbConnection;
import LearnSE.Model.CyberModel;

public class cyberattackDao {

    public void scrapeData() throws IOException {
        // Declare database connection and statement variables
        dbConnection conn = null;
        Connection cnn = null;

        // JSoup connection URL
        final String sturl = "https://horizon.netscout.com/?atlas=summary";

        // ArrayList to store month and year
        ArrayList<String> monthYear = new ArrayList<>();

        try {
            // Initialize database connection
            conn = new dbConnection("cs372_2024db", "root", "Passw0rd");
            cnn= conn.create_connection_string();

            // Connect to the website and parse the HTML
            final Document document = Jsoup.connect(sturl).get();

            // Extract the month and year from the webpage
            Elements months = document.select("div.summary-air-ui--app-air--date, div");//.summary-air-ui--app-air--date
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
            for (Element el : document.select("div.summary-air-ui--topcountries--table.summary-air-ui--table--table span")) {
                String dtValue = el.select("span").text();

                // Only add non-empty values
                if (!dtValue.equals("")) {
                    srcTargetData.add(dtValue);
                }
            }

            // Get month and year from the ArrayList
            String month = monthYear.size() > 0 ? monthYear.get(0) : "";
            String year = monthYear.size() > 1 ? monthYear.get(1) : "";
            //first row
            srcDest[0][0]=srcTargetData.get(0).toString();
            srcDest[0][1]=srcTargetData.get(1).toString();
            srcDest[0][2]=srcTargetData.get(15).toString();
            srcDest[0][3]=srcTargetData.get(16).toString();

            //second row
            srcDest[1][0]=srcTargetData.get(3).toString();
            srcDest[1][1]=srcTargetData.get(4).toString();
            srcDest[1][2]=srcTargetData.get(18).toString();
            srcDest[1][3]=srcTargetData.get(19).toString();

            //third row
            srcDest[2][0]=srcTargetData.get(6).toString();
            srcDest[2][1]=srcTargetData.get(7).toString();
            srcDest[2][2]=srcTargetData.get(21).toString();
            srcDest[2][3]=srcTargetData.get(22).toString();

            //fourth row
            srcDest[3][0]=srcTargetData.get(9).toString();
            srcDest[3][1]=srcTargetData.get(10).toString();
            srcDest[3][2]=srcTargetData.get(24).toString();
            srcDest[3][3]=srcTargetData.get(25).toString();

            //fifth row
            srcDest[4][0]=srcTargetData.get(12).toString();
            srcDest[4][1]=srcTargetData.get(13).toString();
            srcDest[4][2]=srcTargetData.get(27).toString();
            srcDest[4][3]=srcTargetData.get(28).toString();

            // Insert the data into the database
            String insertAttacks = "INSERT INTO cyberattacks (srccountry, srcno_attack, targetcountry, targetno_attack, month, year) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preStmt = cnn.prepareStatement(insertAttacks);

            for (int i = 0; i < 5; i++) {
                preStmt.setString(1, srcDest[i][0]);
                preStmt.setString(2, srcDest[i][1]);
                preStmt.setString(3, srcDest[i][2]);
                preStmt.setString(4, srcDest[i][3]);
                preStmt.setString(5, month);
                preStmt.setString(6, year);
                preStmt.execute();
            }

        }
        catch (SQLException e) {
            e.printStackTrace(); // Log SQL exceptions
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
