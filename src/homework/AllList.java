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

public class AllList extends JFrame implements ActionListener{

	public DatabaseClass2 db;
	private JTable table;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	private DefaultTableModel tableModel3;
	
	public AllList() {
		
	}
	
	public AllList(DatabaseClass2 db) {
		
		this.db = db;
		
		String[] columnNames = { "메뉴", "가격", "사이즈", "HOT/ICE", "일회용/머그" };
		List<Coffee> coffeeList = db.getCoffeeList();
		List<Tea> teaList = db.getTeaList();
		List<Blended> blendedList = db.getBlendedList();
		List<Otherthings> otherthingsList = db.getOtherthingsList();
		
		Object[][] data = new Object[coffeeList.size()][5];
		Object[][] data1 = new Object[teaList.size()][5];
		Object[][] data2 = new Object[blendedList.size()][5];
		Object[][] data3 = new Object[otherthingsList.size()][2];
		
		for (int i = 0; i < coffeeList.size(); i++) {
			Coffee coffee = coffeeList.get(i);
			data[i][0] = coffee.getName();
			data[i][1] = coffee.getPrice();
			data[i][2] = coffee.getSize();
			data[i][3] = coffee.getType();
			data[i][4] = coffee.getWhere();
		}
		for (int i = 0; i < teaList.size(); i++) {
			Tea tea = teaList.get(i);
			data1[i][0] = tea.getName();
			data1[i][1] = tea.getPrice();
			data1[i][2] = tea.getSize();
			data1[i][3] = tea.getType();
			data1[i][4] = tea.getWhere();
		}
		for (int i = 0; i < blendedList.size(); i++) {
			Blended blended = blendedList.get(i);
			data2[i][0] = blended.getName();
			data2[i][1] = blended.getPrice();
			data2[i][2] = blended.getSize();
			data2[i][3] = blended.getType();
			data2[i][4] = blended.getWhere();
		}
		for (int i = 0; i <otherthingsList.size(); i++) {
			Otherthings otherthings = otherthingsList.get(i);
			data3[i][0] = otherthings.getName();
			data3[i][1] = otherthings.getPrice();	
		}
		
		System.out.println("2차원 배열 크기");
		System.out.println(data.length);
		System.out.println(data1.length);
		System.out.println(data2.length);
		System.out.println(data3.length);
		
		tableModel = new DefaultTableModel(data, columnNames);
		tableModel1 = new DefaultTableModel(data1, columnNames);
		tableModel2 = new DefaultTableModel(data2, columnNames);
		tableModel3 = new DefaultTableModel(data3, columnNames);
		
		table = new JTable(tableModel);
		table1 = new JTable(tableModel1);
		table2 = new JTable(tableModel2);
		table3 = new JTable(tableModel3);
		
		JButton closeButton = new JButton("닫기");
		closeButton.addActionListener(this);
		
//		JPanel mainPanel = new JPanel();
//		mainPanel.setLayout(new BorderLayout());
//		mainPanel.add(new JScrollPane(table), BorderLayout.NORTH);
//		mainPanel.add(new JScrollPane(table1), BorderLayout.SOUTH);
//		mainPanel.add(new JScrollPane(table2), BorderLayout.CENTER);
//		mainPanel.add(new JScrollPane(table3), BorderLayout.CENTER);
		
		//JPanel inputPanel = new JPanel();
		//inputPanel.setLayout(new GridLayout(5, 2));

		
	       JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new GridLayout(4, 1));
	        mainPanel.add(new JScrollPane(table));
	        mainPanel.add(new JScrollPane(table1));
	        mainPanel.add(new JScrollPane(table2));
	        mainPanel.add(new JScrollPane(table3));		
		

		setTitle("메뉴판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		// 현재 열려있는 학생 조회 화면을 닫음
		this.dispose();
	}
	public static void main(String[] args) {
		new AllList(new DatabaseClass2());
	}
	
}