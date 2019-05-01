package latripstats_repo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class StatistikOverview extends JFrame {
	private static final Connect connect = new Connect();
	

	/**
	 * Create the frame.
	 */
	public StatistikOverview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 20, 20));
		
		
		JLabel lblNewLabel = new JLabel("Kategorie");
		lblNewLabel.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Zimmer");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zimmerauslastung");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Betten");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bettenauslastung");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_4);
		
		
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel nameHotel = new JLabel("Hotel");
		panel_1.add(nameHotel);
		
		JComboBox hotelName = new JComboBox();
		panel_1.add(hotelName);
		
		JLabel jahr = new JLabel("Jahr");
		panel_1.add(jahr);
		
		JComboBox year = new JComboBox();
		panel_1.add(year);
		
		JLabel monat = new JLabel("Monat");
		panel_1.add(monat);
		
		JComboBox month = new JComboBox();
		panel_1.add(month);
		
		Connection con = null;
		Statement st;
		ResultSet hotelnameRs = null;
		ResultSet jahrRs = null;
		ResultSet monatRs = null;
		
		
		try {
			con = connect.getConnection();
			st = con.createStatement();
			
			String hotel = "";
			
			String s = "select Name from eigenschaften" ;
			 hotelnameRs = st.executeQuery(s);
			 
			 while (hotelnameRs.next()) {
				 hotel=hotelnameRs.getString(1);
				 
				 hotelName.addItem(hotel);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
