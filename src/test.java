import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class test implements ActionListener {
	JLabel l;
	JFrame f;
	static JTextField t1;
	static JPasswordField t2;
	JButton b;
	static String c;
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/avneet";
	static String user = "root";
	static String pass = "root";

	public test() {
		l = new JLabel();
		f = new JFrame("Login");
		t1 = new JTextField();
		t2 = new JPasswordField("");
		b = new JButton("Login");
		b.addActionListener(this);
		l.setBounds(10, 10, 100, 50);
		t1.setBounds(50, 50, 100, 50);
		t2.setBounds(150, 50, 100, 50);
		b.setBounds(50, 100, 100, 50);
		f.add(l);
		f.add(t1);
		f.add(t2);
		f.add(b);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String userNameUI =  t1.getText();

		if(e.getSource() == b) {
			try {
//				System.out.println( t1.getText()+"-----"+String.valueOf(t2.getPassword()));
				System.out.println(userNameUI);
				String passUi =  String.valueOf(t2.getPassword()).trim();
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement("select * from medicore where Med_name=? and manufacturer=?");
				pst.setString(1,userNameUI);
				pst.setString(2,passUi);
				ResultSet rs = pst.executeQuery();
				
				while (rs.next()) {
					System.out.println("Yes");
					JOptionPane.showMessageDialog(f, "Login Succesfull ", "Admin", 1);

				}

			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		new test();

	}
}
