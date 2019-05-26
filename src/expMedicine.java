import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.Year;

import javax.swing.*;

public class expMedicine {
	static JFrame eMedicine;
	JLabel sHeading;

	public expMedicine() {
		eMedicine = new JFrame("Expired Medicine");
		// eMedicine.setSize(500, 500);
		eMedicine.setBounds(700, 300, 400, 400);
		sHeading = new JLabel("Expired Medicines");
		sHeading.setBounds(50, 50, 150, 50);
		eMedicine.add(sHeading);
		eMedicine.setLayout(null);
		eMedicine.setVisible(true);
		eMedicine.setResizable(false);
		
		String url = "jdbc:mysql://localhost:3306/avneet";
		String user = "root";
		String pass = "root";
		Year yy1=Year.now();
		
//		Connection con;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement(); 
		st.execute("select * from avneet.medicore where ");
		
		if(Year_exp<yy1.getValue()) 
		{
			
		}
		
		
		}catch (Exception exc)
		{}
	}

	public static void main(String args[]) {
		eMedicine.dispose();
		new expMedicine();
		
	}
}
