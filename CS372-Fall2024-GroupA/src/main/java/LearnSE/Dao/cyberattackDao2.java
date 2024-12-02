/**package LearnSE.Dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import LearnSE.Model.CyberModel;

public class cyberattackDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cs372_2024db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Passw0rd";
    private static final String SCRAPE_URL = "https://horizon.netscout.com/?atlas=summary";

    // Scrape data from the website and save it to the database
    public void scrapeData() throws IOException {
        Connection conn = null;
        PreparedStatement preStmt = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Connect to the website and parse the HTML
            Document document = Jsoup.connect(SCRAPE_URL).get();

            // Extract the month and year
            String monthYearText = document.select("div.summary-air-ui--app-air--section h2").text();
            System.out.println("Scraped Month and Year: " + monthYearText);

            // Parse month and year
            String[] monthYearParts = monthYearText.split(" ");
            String month = monthYearParts.length > 0 ? monthYearParts[0] : "";
            String year = monthYearParts.length > 1 ? monthYearParts[1] : "";

            System.out.println("Month: " + month);
            System.out.println("Year: " + year);

            // Prepare the SQL insert statement
            String insertQuery = "INSERT INTO cyberattacks (srccountry, srcno_attack, targetcountry, targetno_attack, month, year) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            preStmt = conn.prepareStatement(insertQuery);

            // Loop to extract and process top 5 source and destination countries
            for (int i = 0; i < 5; i++) {
                String srcCountrySelector = "#source-count-sum-country--table--row" + i + "--label";
                String srcCountSelector = "#source-count-sum-country--table--row" + i + "--count";

                String destCountrySelector = "#dest-count-sum-country--table--row" + i + "--label";
                String destCountSelector = "#dest-count-sum-country--table--row" + i + "--count";

                String srcCountry = document.select(srcCountrySelector).text();
                String srcCount = document.select(srcCountSelector).text().replace(",", "");
                String destCountry = document.select(destCountrySelector).text();
                String destCount = document.select(destCountSelector).text().replace(",", "");

                // Validate extracted data
                if (srcCountry.isEmpty() || srcCount.isEmpty() || destCountry.isEmpty() || destCount.isEmpty()) {
                    System.out.println("Skipping invalid data row: " + srcCountry + ", " + srcCount + ", " + destCountry + ", " + destCount);
                    continue;
                }

                System.out.println("Row: " + srcCountry + ", " + srcCount + ", " + destCountry + ", " + destCount);

                // Insert data into the database
                preStmt.setString(1, srcCountry);
                preStmt.setInt(2, Integer.parseInt(srcCount)); // Convert attack counts to integers
                preStmt.setString(3, destCountry);
                preStmt.setInt(4, Integer.parseInt(destCount));
                preStmt.setString(5, month);
                preStmt.setString(6, year);
                preStmt.addBatch(); // Batch for better performance
            }

            // Execute the batch insert
            preStmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preStmt != null) preStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Retrieve the data from the database and return it as an ArrayList of CyberModel objects
    public ArrayList<CyberModel> getCyberData() throws IOException {
        ArrayList<CyberModel> cyberArray = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            // Query to retrieve the latest data
            String query = "SELECT * FROM cyberattacks ORDER BY year DESC, month DESC";
            rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                CyberModel cyberModel = new CyberModel(
                        rs.getString("srccountry"),
                        rs.getInt("srcno_attack"),
                        rs.getString("targetcountry"),
                        rs.getInt("targetno_attack"),
                        rs.getString("month"),
                        rs.getString("year")
                );
                cyberArray.add(cyberModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cyberArray;
    }
}
*/