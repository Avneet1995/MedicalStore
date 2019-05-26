import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home implements ActionListener {
	JLabel nName;
	JButton option1;
	JButton option2;
	JButton option3;
	JButton option4;
	JFrame Medicore;

	public Home() {
		Medicore= new JFrame("Medicore");
		Medicore.setBounds(720,300,400,400);
		nName = new JLabel("MEDICORE");
		option1 = new JButton("1 Search or Sell medicine");
		option2 = new JButton("2 Add new Medicine");
		option3 = new JButton("3 Expired Medicines");
		option4 = new JButton("4 Low Stock Medicines");
		nName.setBounds(125, 10, 100, 50);
		option1.setBounds(10, 50, 300, 50);
		option2.setBounds(10, 100, 300, 50);
		option3.setBounds(10, 150, 300, 50);
		option4.setBounds(10, 200, 300, 50);
		option1.addActionListener(this);
		option2.addActionListener(this);
		option3.addActionListener(this);
		option4.addActionListener(this);
		Medicore.add(nName);
		Medicore.add(option1);
		Medicore.add(option2);
		Medicore.add(option3);
		Medicore.add(option4);
		//Medicore.setSize(700, 700);
		Medicore.setLayout(null);
		Medicore.setVisible(true);
		Medicore.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == option1) {
			System.out.println("Option1");
			Medicore.dispose();
			new Search_med();
		} else if (e.getSource() == option2) {
			System.out.println("Option2");
			Medicore.dispose();
			new add_med();
		} else if (e.getSource() == option3) {
			System.out.println("option3");
			Medicore.dispose();
			new expMedicine();
		} else if (e.getSource() == option4) {
			System.out.println("option4");
			Medicore.dispose();
		new lowMedicine();
		}
	}

	public static void main(String args[]) {
		new Home();
	}
}
