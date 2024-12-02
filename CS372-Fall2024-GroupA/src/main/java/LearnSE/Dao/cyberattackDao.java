package LearnSE.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import LearnSE.dbConnection;
import LearnSE.Model.CyberModel;

public class cyberattackDao {

    // Method to scrape data and insert into the database
    public void scrapeData() throws IOException {
        dbConnection conn = null;
        Connection cnn = null;

        final String sturl = "https://horizon.netscout.com/?atlas=summary";

        try {
            // Initialize database connection
            conn = new dbConnection("cs372_2024db", "root", "Passw0rd");
            cnn = conn.create_connection_string();

            // Connect to the website and parse the HTML
            final Document document = Jsoup.connect(sturl).get();

            // Extract the month and year
            String dateText = document.select(".summary-air-ui--app-air--date").text();
            String[] dateParts = dateText.split(" ");
            String month = dateParts.length > 0 ? dateParts[0] : "Unknown";
            String year = dateParts.length > 1 ? dateParts[1] : "Unknown";

            // Prepare data for insertion
            String[][] srcDest = new String[5][4];

            // Scrape top source and destination countries
            for (int i = 0; i < 5; i++) {
                String srcCountry = document.select("#source-count-sum-country--table--row" + i + "--label").text();
                String srcCount = document.select("#source-count-sum-country--table--row" + i + "--count").text().replace(",", "");
                String destCountry = document.select("#dest-count-sum-country--table--row" + i + "--label").text();
                String destCount = document.select("#dest-count-sum-country--table--row" + i + "--count").text().replace(",", "");

                // Validate and store the data
                if (!srcCountry.isEmpty() && !srcCount.isEmpty() && !destCountry.isEmpty() && !destCount.isEmpty()) {
                    srcDest[i][0] = srcCountry;
                    srcDest[i][1] = srcCount;
                    srcDest[i][2] = destCountry;
                    srcDest[i][3] = destCount;
                } else {
                    System.out.println("Skipping row " + i + " due to missing data.");
                }
            }

            // Insert data into the database
            String insertQuery = "INSERT INTO cyberattacks (srccountry, srcno_attack, targetcountry, targetno_attack, month, year) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preStmt = cnn.prepareStatement(insertQuery);

            for (int j = 0; j < 5; j++) {
                if (srcDest[j][0] != null) { // Only process valid rows
                    preStmt.setString(1, srcDest[j][0]);
                    preStmt.setInt(2, Integer.parseInt(srcDest[j][1]));
                    preStmt.setString(3, srcDest[j][2]);
                    preStmt.setInt(4, Integer.parseInt(srcDest[j][3]));
                    preStmt.setString(5, month);
                    preStmt.setString(6, year);
                    preStmt.addBatch();
                }
            }

            // Execute batch insert
            preStmt.executeBatch();
            System.out.println("Data successfully inserted into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnn != null) {
					cnn.close();
				}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to retrieve data from the database
    public ArrayList<CyberModel> getCyberData() {
        ArrayList<CyberModel> cyberDataList = new ArrayList<>();
        dbConnection conn = null;
        Connection cnn = null;

        try {
            // Initialize database connection
            conn = new dbConnection("cs372_2024db", "root", "Passw0rd");
            cnn = conn.create_connection_string();

            // Query to retrieve data
            String query = "SELECT * FROM cyberattacks";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                CyberModel record = new CyberModel(
                    rs.getString("srccountry"),
                    rs.getInt("srcno_attack"),
                    rs.getString("targetcountry"),
                    rs.getInt("targetno_attack"),
                    rs.getString("month"),
                    rs.getString("year")
                );
                System.out.println("Retrieved record: " + record.toString());
                cyberDataList.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnn != null) {
					cnn.close();
				}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cyberDataList;
    }
}
