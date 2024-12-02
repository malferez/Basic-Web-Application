package LearnSE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import LearnSE.Model.mainEntryModel;

public class daoService {

    // Add main page content method
    public void addMainContent(mainEntryModel fieldsEntry) throws SQLException
    	{
    		LearnSE.dbConnection conn = new LearnSE.dbConnection("cs372_2024db", "root", "Passw0rd"); /**create an instance of the database-connection
    		class with the database name, username, and the password*/
    		Connection cnn = conn.create_connection_string();//execute the connection to the database
    		//getting the datas from the model
    		String strTitle= fieldsEntry.getContentTitle();
    		String strDetails = fieldsEntry.getContentDetails();
    		//creating SQL insert statement
    		String insertContent = "INSERT INTO main_p_content (section_title, content) VALUES(?,?)";
    			try
    			{
    				PreparedStatement prestmt = cnn.prepareStatement(insertContent);
    				prestmt.setString(1, strTitle);
    				prestmt.setString(2, strDetails);
    				prestmt.execute();//execute statement
    			}
    			catch(Exception ex) //catch error if found
    			{
    			}
    			//cnn.close(); //close the connection
    }

	public ArrayList<LearnSE.Model.processtypedata> getprocesstypedata()
	{
		Statement stmt = null;
		ResultSet rs;
		ArrayList<LearnSE.Model.processtypedata> processdataarray = new ArrayList<>();
		try
		{
			LearnSE.dbConnection conn = new LearnSE.dbConnection("cs372_2024db", "root", "Passw0rd");
			/**create an instance of the database-connection class with the database name, username, and the password*/
			Connection cnn = conn.create_connection_string();//execute the connection to the database
			String getprocessestypes = "SELECT * FROM main_p_content";
			stmt= cnn.createStatement();
			rs = stmt.executeQuery(getprocessestypes);
			// System.out.println(getprocessestypes);
			while(rs.next())
				{
					LearnSE.Model.processtypedata settypesdata = new LearnSE.Model.processtypedata();
					settypesdata.setTitletypetext(rs.getString(1));
					settypesdata.setDetailtypetext(rs.getString(2));
					processdataarray.add(settypesdata);

				}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		//Collections.sort(processdataarray);
		return processdataarray;


	}
}
