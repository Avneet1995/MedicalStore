
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;

public class Test_name {
	JFrame log_in;
	JLabel heading;
	JLabel name;
	JLabel pass;
	JTextField cName;
	JPasswordField cPass;
	JButton cLogin;

	public Test_name() {
		log_in = new JFrame("Login Page");
		heading = new JLabel("Please enter your username and password");
		name = new JLabel("Name");
		pass = new JLabel("Password");
		cName = new JTextField();
		cPass = new JPasswordField();

		heading.setBounds(50, 20, 100, 50);
		name.setBounds(20, 50, 75, 50);
		cName.setBounds(100, 50, 75, 50);
		pass.setBounds(20, 100, 75, 50);
		cPass.setBounds(100, 100, 75, 50);
		cLogin.setBounds(20, 150, 75, 50);

		log_in.add(heading);
		log_in.add(name);
		log_in.add(cName);
		log_in.add(pass);
		log_in.add(cPass);
		log_in.add(cLogin);
		log_in.setSize(500, 500);
		log_in.setLayout(null);
		log_in.setVisible(true);
	}

	public static void main(String args[]) {
		new Test_name();
	}
}
