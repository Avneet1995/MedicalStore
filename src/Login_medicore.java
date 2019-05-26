import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Login_medicore implements ActionListener {
	JFrame log_in;
	JLabel heading;
	JLabel name;
	JLabel pass1;
	JTextField cName;
	JPasswordField cPass;
	JButton cLogin;
	static String url = "jdbc:mysql://localhost:3306/avneet";
	static String user = "root";
	static String pass = "root";
	static Connection con;
	static String uName2;
	static String realpass;

	public Login_medicore() {
		log_in = new JFrame("Login Page");
		heading = new JLabel("Please enter your username and password");
		name = new JLabel("Name");
		pass1 = new JLabel("Password");
		cName = new JTextField();
		cLogin = new JButton("Login");
		cPass = new JPasswordField();
		log_in.setBounds(720, 300, 300, 300);
		log_in.setResizable(false);
		heading.setBounds(0, 20, 300, 50);
		name.setBounds(20, 70, 75, 50);
		cName.setBounds(100, 70, 75, 50);
		pass1.setBounds(20, 120, 75, 50);
		cPass.setBounds(100, 120, 75, 50);
		cLogin.setBounds(20, 200, 75, 50);
		log_in.add(heading);
		log_in.add(name);
		log_in.add(cName);
		log_in.add(pass1);
		log_in.add(cPass);
		log_in.add(cLogin);
		cLogin.addActionListener(this);
//		log_in.setSize(500, 500);
		log_in.setLayout(null);
		log_in.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cLogin) {
			char[] pfConversion = cPass.getPassword();
			uName2 = cName.getText();
			realpass = new String(pfConversion);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass); // establishes the connection
				PreparedStatement pstmnt = con
						.prepareStatement("select * from userdetails where userName=? and password=?");
				pstmnt.setString(1, uName2);
				pstmnt.setString(2, realpass);
			
				ResultSet s = pstmnt.executeQuery();
				while (s.next()) {
					JOptionPane.showMessageDialog(log_in, "Login Successful", "Admin", 1);
					System.out.print("Login");
					log_in.dispose();
					new Home();
				 
				}
			} catch (Exception exc) {

			}
		}
	}

	/**
	 * if ((realpass.equals(rightpass)) && (uName2.equals(uName))) {
	 * System.out.println("match"); } else System.out.println("Wrong password"); }
	 **/

	public static void main(String args[]) {
		new Login_medicore();

	}
}
