import javax.swing.*;

public class lowMedicine {
	static JFrame lMedicine;
	JLabel sHeading;

	public lowMedicine() {
		lMedicine = new JFrame("Low Stock Medicines");
		lMedicine.setSize(500, 500);
		lMedicine.setBounds(700,300,400,400);
		sHeading = new JLabel("Low Stock Medicines");
		sHeading.setBounds(50, 50, 150, 50);
		lMedicine.add(sHeading);
		lMedicine.setLayout(null);
		lMedicine.setVisible(true);
		lMedicine.setResizable(false);
	}

	public static void main(String args[]) {
		
		new lowMedicine();
		lMedicine.dispose();
	}
}
