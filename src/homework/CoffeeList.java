package homework;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.prism.Graphics;
import com.sun.prism.Image;

import sun.applet.Main;


public class CoffeeList extends JFrame implements ActionListener {
	

	public DatabaseClass2 db;
	private JTable table;
	private DefaultTableModel tableModel;

	public CoffeeList() {

	}

	public CoffeeList(DatabaseClass2 db) {
		this.db = db;

		String[] columnNames = { "메뉴", "가격", "사이즈", "HOT/ICE", "일회용/머그" };
		List<Coffee> coffeeList = db.getCoffeeList();
		Object[][] data = new Object[coffeeList.size()][5];

		for (int i = 0; i < coffeeList.size(); i++) {
			Coffee coffee = coffeeList.get(i);
			data[i][0] = coffee.getName();
			data[i][1] = coffee.getPrice();
			data[i][2] = coffee.getSize();
			data[i][3] = coffee.getType();
			data[i][4] = coffee.getWhere();
		}

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);

		JButton closeButton = new JButton("닫기");
		closeButton.addActionListener(this);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 2));

		mainPanel.add(inputPanel, BorderLayout.SOUTH);
		mainPanel.add(closeButton, BorderLayout.SOUTH);

		setTitle("커피 메뉴판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// 액션 리스너
	public void actionPerformed(ActionEvent e) {
		// 현재 열려있는 학생 조회 화면을 닫음
		this.dispose();

		MainMenu mainMenu = new MainMenu(db);
		mainMenu.setVisible(true);
	}


	public static void main(String[] args) {
		new CoffeeList(new DatabaseClass2());
	}

}
