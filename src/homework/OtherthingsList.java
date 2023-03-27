package homework;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OtherthingsList extends JFrame implements ActionListener {

	private DatabaseClass2 db;
	private JTable table;
	private DefaultTableModel tableModel;

	public OtherthingsList() {

	}

	public OtherthingsList(DatabaseClass2 db) {
		this.db = db;
		String[] columnNames = { "메뉴", "가격", };
		List<Otherthings> otherthingsList = db.getOtherthingsList();
		Object[][] data = new Object[otherthingsList.size()][2];
		for (int i = 0; i < otherthingsList.size(); i++) {
			Otherthings coffee = otherthingsList.get(i);
			data[i][0] = coffee.getName();
			data[i][1] = coffee.getPrice();
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

		setTitle("그외의 메뉴판");
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
		// MainMenu mainMenu = new MainMenu(db);
		// mainMenu.setVisible(true);
	}

	public static void main(String[] args) {
		new OtherthingsList(new DatabaseClass2());
	}
}
