package latripstats_repo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.glass.events.WindowEvent;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
* @author Glenn Kurumthottickal 
* @version 1.0
*/
public class MasterOverview extends JFrame {
	private static final Connect connect = new Connect();

	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public MasterOverview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 100, 1300, 500);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 14, 20, 20));
		
		JLabel lblNewLabel = new JLabel("Kategorie");
		lblNewLabel.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PLZ");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ort");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Besitzer");
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefon");
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kontaktperson");
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setToolTipText("Kontaktperson");
		
		JLabel lblNewLabel_8 = new JLabel("Raumzahl");
		lblNewLabel_8.setForeground(SystemColor.textHighlight);
		lblNewLabel_8.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Bettenzahl");
		lblNewLabel_9.setForeground(SystemColor.textHighlight);
		lblNewLabel_9.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Familienfreundlich");
		lblNewLabel_10.setForeground(SystemColor.textHighlight);
		lblNewLabel_10.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setToolTipText("Familienfreundlich");
		
		JLabel lblNewLabel_11 = new JLabel("Hundefreundlich");
		lblNewLabel_11.setForeground(SystemColor.textHighlight);
		lblNewLabel_11.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_11);
		lblNewLabel_11.setToolTipText("Hundefreundlich");
		
		JLabel lblNewLabel_12 = new JLabel("Spa");
		lblNewLabel_12.setForeground(SystemColor.textHighlight);
		lblNewLabel_12.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Fitness");
		lblNewLabel_13.setForeground(SystemColor.textHighlight);
		lblNewLabel_13.setFont(new Font("Rockwell", Font.ITALIC, 14));
		panel.add(lblNewLabel_13);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOverview = new JMenu("Overview");
		menuBar.add(mnOverview);
		
		JMenu mnTrans = new JMenu("Statistik");
		menuBar.add(mnTrans);
		mnTrans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StatistikOverview so = new StatistikOverview();
				so.setVisible(true);
				
			}
		});
		
		
		
		JMenu mnUpdate = new JMenu("Update");
		menuBar.add(mnUpdate);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		   

		
		
		
		Connection con = null;
		Statement st;
		ResultSet rs = null;
		
		/*
		 * Overview 
		 * 
		 */
		
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
			String famfreundlich = "";
			String hfreundlich = "";
			String spa = "";
			String fit = "";
			
			String s = "select * from eigenschaften" ;
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
				famfreundlich = rs.getString(12);
				hfreundlich = rs.getString(13);
				spa = rs.getString(14);
				fit = rs.getString(15);
				
				
				JLabel namen = new JLabel(name);
				JLabel kat = new JLabel(kategorie);
				JLabel add = new JLabel(adresse);
				JLabel postzahl = new JLabel(plz);
				JLabel city = new JLabel(stadt);
				JLabel owner = new JLabel(besitzer);
				JLabel tel = new JLabel(telefon);
				JLabel kon = new JLabel(kontakt);
				JLabel raumz = new JLabel(raumzahl);
				JLabel bettz = new JLabel(bettenzahl);
				JLabel famf = new JLabel(famfreundlich);
				JLabel hf = new JLabel(hfreundlich);
				JLabel sp = new JLabel(spa);
				JLabel fi = new JLabel(fit);
				
				namen.setToolTipText(name);
				add.setToolTipText(adresse);
				city.setToolTipText(stadt);
				kon.setToolTipText(kontakt);
				
	
				
				panel.add(kat);
				panel.add(namen);
				panel.add(add);
				panel.add(postzahl);
				panel.add(city);
				panel.add(owner);
				panel.add(tel);
				panel.add(kon);
				panel.add(raumz);
				panel.add(bettz);
				panel.add(famf);
				panel.add(hf);
				panel.add(sp);
				panel.add(fi);
				
				
			
			}
			

			
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
