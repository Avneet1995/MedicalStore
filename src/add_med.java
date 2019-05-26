import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import javax.swing.*;

public class add_med implements ActionListener {
	static JFrame sMedicine;
	JLabel sHeading;
	JLabel name;
	JTextField cName;
	JLabel expiry;
	static JTextField mExpiry;
	JLabel quantity, l_mfd;
	JTextField cQuantity;
	JLabel where;
	JButton medAdd;
	static JTextField yExpiry, mstack, mrow, mfd;
	static String url = "jdbc:mysql://localhost:3306/avneet";
	static String user = "root";
	static String pass = "root";
	static Connection con;

	public add_med() {
		sMedicine = new JFrame("Add Medicine");
		sHeading = new JLabel("Add the medicine");
		name = new JLabel("Name:");
		expiry = new JLabel("Expiry:");
		mExpiry = new JTextField("mm");
		yExpiry = new JTextField("yyyy");
		mstack = new JTextField();
		mrow = new JTextField();
		mfd = new JTextField();
		l_mfd = new JLabel("Manufacturer:");
		cName = new JTextField();
		quantity = new JLabel("Quantity");
		cQuantity = new JTextField();
		medAdd = new JButton("ADD");
		where = new JLabel("Where:");
		expiry = new JLabel("Expiry");
		medAdd.addActionListener(this);
		expiry.setBounds(10, 100, 70, 50);
		mExpiry.setBounds(70, 100, 25, 50);
		yExpiry.setBounds(95, 100, 30, 50);
		sHeading.setBounds(50, 20, 150, 50);
		name.setBounds(10, 50, 50, 50);
		cName.setBounds(50, 60, 70, 25);
		quantity.setBounds(175, 60, 50, 25);
		cQuantity.setBounds(150, 60, 20, 25);
		medAdd.setBounds(70, 250, 100, 50);
		where.setBounds(10, 175, 50, 50);
		mstack.setBounds(60, 175, 50, 50);
		mrow.setBounds(110, 175, 50, 50);
		mfd.setBounds(270, 175, 75, 50);
		l_mfd.setBounds(175, 175, 100, 50);
		sMedicine.setBounds(700, 300, 400, 400);
		// search.addActionListener(this);
		// sold.addActionListener(this);
		// sMedicine.setSize(500, 500);
		sMedicine.setResizable(false);
		sMedicine.add(sHeading);
		sMedicine.add(name);
		sMedicine.add(cName);
		sMedicine.add(quantity);
		sMedicine.add(cQuantity);
		sMedicine.add(where);
		sMedicine.add(mstack);
		sMedicine.add(mrow);
		sMedicine.add(mfd);
		sMedicine.add(medAdd);
		sMedicine.add(expiry);
		sMedicine.add(mExpiry);
		sMedicine.add(yExpiry);
		sMedicine.add(l_mfd);
		medAdd.addActionListener(this);
		sMedicine.setLayout(null);
		sMedicine.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String med = cName.getText();
		String manu = mfd.getText();
		String med_stock = cQuantity.getText();
		String med_stack = mstack.getText();
		String med_row = mrow.getText();
		String med_yexp = yExpiry.getText();
		String med_mexp = mExpiry.getText();
		String y = yExpiry.getText();
		int yy2 = Integer.parseInt(y);
		String m = mExpiry.getText();
		Year yy1 = Year.now();
		int mm2 = Integer.parseInt(m);
		Month mm1 = Month.from(LocalDate.now());
		if (e.getSource() == medAdd) {
			if (yy2 < yy1.getValue()) {
				JOptionPane.showMessageDialog(sMedicine, "Medicine Expired", "Add Medicine Status", 0);
			} else if ((yy2 == yy1.getValue()) & (mm2 <= mm1.getValue()))

			{
				JOptionPane.showMessageDialog(sMedicine, "Medicine Expired", "Add Medicine Status", 0);

			} else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, user, pass);
					PreparedStatement pstm = con.prepareStatement(
							"insert into avneet.medicore (Med_name,manufacturer,stock,Stack,row,Year_exp,Month_exp)values(?,?,?,?,?,?,?)");
					pstm.setString(1, med);
					pstm.setString(2, manu);
					pstm.setString(3, med_stock);
					pstm.setString(4, med_stack);
					pstm.setString(5, med_row);
					pstm.setString(6, med_yexp);
					pstm.setString(7, med_mexp);
					pstm.executeQuery();
					
						JOptionPane.showMessageDialog(sMedicine, "Added", "Admin", 1);
						System.out.print(med+manu+med_stock+med_stack+med_row+med_yexp+med_mexp);
					}
				 catch (Exception exc) {
					 System.out.print("Exception!");

				}
			}
		}
	}
	public static void main(String args[]) {
		new add_med();
	}
}
