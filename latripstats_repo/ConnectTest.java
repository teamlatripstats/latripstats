package latripstats_repo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest {
	private static final Connect connect = new Connect();

	public static void main(String[] args) throws Exception {
		System.out.println(" *** Programm l�uft!");
		checkDB();
		auslesen();
	}

	public static void checkDB() {
		if (connect.checkConnection()) {
			System.out.println("Verbindungstest hat geklappt.");
		} else {
			System.out.println("Verbindungstest ist fehlgeschlagen.");
		}
	}
	
	
	public static void auslesen() {
		Connection con = null;
		//String statementSQL;
		Statement st;
		ResultSet rs = null;
		
		
		try {
			con = connect.getConnection();
			st = con.createStatement();
			
			String kategorie = "";
			String name = "";
			String adresse = "";
			String plz = "";
			String stadt = ""; 
			String besitzer = "";
			String telefon = "";
			String kontakt = "";
			String raumzahl = "";
			String bettenzahl = "";
			
			String s = "select * from eigenschaften";
			 rs = st.executeQuery(s);
			
			while (rs.next()) {
				kategorie = rs.getString(2);
				name = rs.getString(3);
				adresse = rs.getString(4);
				plz = rs.getString(5);
				stadt = rs.getString(6);
				besitzer = rs.getString(7);
				telefon = rs.getString(8);
				kontakt = rs.getString(9);
				raumzahl = rs.getString(10);
				bettenzahl = rs.getString(11);
				
				System.out.println(kategorie + "\t" + name + "\t" + adresse + "\t" + telefon );
			}
				
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void fehlerAusgabe(Exception e) {
		System.out.println(" !!! FEHLER !!! - " + e.getLocalizedMessage());
	}
}


