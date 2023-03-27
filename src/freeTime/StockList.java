package freeTime;

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

public class StockList extends JFrame implements ActionListener {
	
	public StockBase sb;
	private JTable table;
	private DefaultTableModel tableModel;
	
	public StockList() {
		// TODO Auto-generated constructor stub
	}
	
	public StockList(StockBase sb) {
		this.sb = sb;
		
		String[] colun = {"종목이름", "코드", "가격"};
		List<Stock> stockList = sb.getStockList();
		Object[][] data = new Object[stockList.size()][3];
		
		for (int i = 0; i < stockList.size(); i++) {
			Stock stock = stockList.get(i);
			data[i][0] = stock.getName();
			data[i][1] = stock.getCode();
			data[i][2] = stock.getPrice();
		}
		
		tableModel = new DefaultTableModel(data,colun);
		table = new JTable(tableModel);
		
		JButton closeButton = new JButton("닫기");
		closeButton.addActionListener(this);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//JPanel inputPanel = new JPanel();
		//inputPanel.setLayout(new GridLayout(5,2));
		
		//mainpanel.add(inputPanel, BorderLayout.SOUTH);
		mainpanel.add(closeButton, BorderLayout.SOUTH);
		
		setTitle("국내 주식 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
	public static void main(String[] args) {
		new StockList(new StockBase());
	}
	
	

}
