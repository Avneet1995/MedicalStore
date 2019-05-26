import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class Search_med implements ActionListener {
	static JFrame sMedicine=new JFrame("Search and Sell");
	JLabel sHeading;
	JLabel name;
	static JTextField cName;
	JLabel quantity;
	static JTextField cQuantity;
	JButton search;
	JButton sold;
	JLabel quantity_left;
	JLabel where;
	static Connection con;
	JLabel dest, quant;
	static String user = "root";
	static String pass = "root";
	static String url = "jdbc:mysql://localhost:3306/avneet";

	public Search_med() {
		//sMedicine = new JFrame("Search and Sell");
		sHeading = new JLabel("Search or Sell Medicine");
		name = new JLabel("Name:");
		cName = new JTextField("");
		quantity = new JLabel("Quantity");
		cQuantity = new JTextField();
		search = new JButton("Search");
		sold = new JButton("Sold");
		quantity_left = new JLabel("Quantity left:");
		where = new JLabel("Where:");
		dest = new JLabel();
		quant = new JLabel();
		dest.setBounds(60, 150, 100, 50);
		quant.setBounds(100, 200, 100, 50);
		sHeading.setBounds(50, 20, 150, 50);
		name.setBounds(10, 50, 50, 50);
		cName.setBounds(50, 60, 70, 25);
		quantity.setBounds(200, 60, 50, 25);
		cQuantity.setBounds(250, 60, 20, 25);
		search.setBounds(10, 100, 75, 50);
		sold.setBounds(100, 100, 75, 50);
		where.setBounds(10, 150, 100, 50);
		quantity_left.setBounds(10, 200, 100, 50);
		sMedicine.setBounds(720, 300, 400, 400);
		
		sold.addActionListener(this);
		search.addActionListener(this);
		// sMedicine.setSize(500, 500);
		
		sMedicine.add(sHeading);
		sMedicine.add(name);
		sMedicine.add(cName);
		sMedicine.add(quantity);
		sMedicine.add(cQuantity);
		sMedicine.add(search);
		sMedicine.add(sold);
		sMedicine.add(quantity_left);
		sMedicine.add(dest);
		sMedicine.add(where);
		sMedicine.add(quant);
		sMedicine.setResizable(false);
		sMedicine.setLayout(null);
		sMedicine.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String cName2 = cName.getText().trim();
		String id, stock, stack, row;
		if (e.getSource() == search) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass); // establishes the connection
				PreparedStatement pstmt = con.prepareStatement("select * from medicore where Med_name=" + "'" +cName2+ "'");
				
				//pstmt.setString(1, cName2);  // this statement can be replaced by the above pstmt
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					id = rs.getString(1);
					stock = rs.getString(4);
					stack = rs.getString(5);
					row = rs.getString(6);
					JOptionPane.showMessageDialog(sMedicine, "Medicine found", "Result", 1);
					dest.setText("Stack: " + stack + " & " + "Row: " + row);
					quant.setText(stock);
					// String mfd = rs.getString(2);
					// System.out.println("" + name + "" + mfd);
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		if (e.getSource() == sold) {
			try {
				System.out.println(cName2);
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement("select * from medicore where Med_name = ?");
				pstmt.setString(1, cName2);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					stock = rs.getString(4);
					String qStock = cQuantity.getText();
					int cQuantity_int = Integer.parseInt(qStock);
					int str_int = Integer.parseInt(stock);
					if (cQuantity_int > str_int) {
						JOptionPane.showMessageDialog(sMedicine, "Not in Stock",
								"Given amount of medicines are not available!", 0);

					} else {
						int upd = str_int - cQuantity_int;
						String x = String.valueOf(upd);
						System.out.print(x);
						quant.setText(x);
					}
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {

		// sMedicine.dispose();
		new Search_med();
		// System.out.println(cName2);
	}
}
