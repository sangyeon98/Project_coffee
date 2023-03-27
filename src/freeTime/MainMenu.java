package freeTime;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.SealedObject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame implements ActionListener {
	
	private JLabel titleLabel;
	private JButton searchButton;
	private JButton searchURsButton;
	private JButton listButton;
	private JButton listUsButton;
	private JButton calcButton;
	private JButton calcUsButton;
	private JButton exitButton;
	
	public MainMenu() {
		
		setTitle("주식");
		setLayout(new GridLayout(7,1));
		setSize(500, 400);
		
		titleLabel = new JLabel("상연주식");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titleLabel);
		
		searchButton = new JButton("국내주식  등록");
		searchButton.addActionListener(this);
		add(searchButton);
		
		searchURsButton = new JButton("해외주식 등록");
		searchURsButton.addActionListener(this);
		add(searchURsButton);
		
		
		listButton = new JButton("국내주식 조회");
		listButton.addActionListener(this);
		add(listButton);
		
		listUsButton = new JButton("해외주식 조회");
		listUsButton.addActionListener(this);
		add(listUsButton);
		
		calcButton = new JButton("예상 금액확인");
		calcButton.addActionListener(this);
		add(calcButton);
		
		exitButton = new JButton("닫기");
		exitButton.addActionListener(this);
		add(exitButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
	}
	
	
	
}
