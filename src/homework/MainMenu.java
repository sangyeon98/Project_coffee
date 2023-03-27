package homework;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Redefinable;

public class MainMenu extends JFrame implements ActionListener {
	public DatabaseClass2 db;

	private JLabel titleLabel;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton blendedButton;
	private JButton otherthingsButton;
	private JButton coffeeListButton;
	private JButton teaListButton;
	private JButton blendedListButton;
	private JButton otherthingsListButton;
	private JButton allListButton;
	private JButton exitButton;

	public MainMenu(DatabaseClass2 db) {
		this.db = db;
		
		setLocation(700,250);
		//setLocationRelativeTo(null);  //창이 가운데?
		
		setTitle("메뉴 보드");
		setLayout(new GridLayout(11,1));
		setSize(400, 500);

		titleLabel = new JLabel("메뉴를 카테고리별로 만들어보자!!");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titleLabel);

		coffeeButton = new JButton("커피메뉴 등록버튼");
		coffeeButton.addActionListener(this);
		coffeeButton.setBackground(Color.orange);
		coffeeButton.setForeground(Color.red);
		add(coffeeButton);

		teaButton = new JButton("티 메뉴 등록버튼");
		teaButton.addActionListener(this);
		teaButton.setBackground(Color.orange);
		teaButton.setForeground(Color.RED);
		add(teaButton);

		blendedButton = new JButton("블렌디드 메뉴 등록버튼");
		blendedButton.addActionListener(this);
		blendedButton.setBackground(Color.ORANGE);
		blendedButton.setForeground(Color.RED);
		add(blendedButton);

		otherthingsButton = new JButton("그외의 메뉴 등록버튼");
		otherthingsButton.addActionListener(this);
		otherthingsButton.setBackground(Color.orange);
		otherthingsButton.setForeground(Color.red);
		add(otherthingsButton);

		coffeeListButton = new JButton("커피 메뉴 리스트");
		coffeeListButton.addActionListener(this);
		coffeeListButton.setBackground(Color.orange);
		coffeeListButton.setForeground(Color.red);
		add(coffeeListButton);

		teaListButton = new JButton("티 메뉴 리스트");
		teaListButton.addActionListener(this);
		teaListButton.setBackground(Color.orange);
		teaListButton.setForeground(Color.red);
		add(teaListButton);

		blendedListButton = new JButton("블렌디드 메뉴 리스트");
		blendedListButton.addActionListener(this);
		blendedListButton.setBackground(Color.orange);
		blendedListButton.setForeground(Color.red);
		add(blendedListButton);

		otherthingsListButton = new JButton("그외의 메뉴 리스트");
		otherthingsListButton.addActionListener(this);
		otherthingsListButton.setBackground(Color.orange);
		otherthingsListButton.setForeground(Color.red);
		add(otherthingsListButton);
		
		allListButton = new JButton("메뉴판!!!");
		allListButton.addActionListener(this);
		allListButton.setBackground(Color.orange);
		allListButton.setForeground(Color.red);
		add(allListButton);

		exitButton = new JButton("닫기");
		exitButton.addActionListener(this);
		exitButton.setBackground(Color.orange);
		exitButton.setForeground(Color.red);
		add(exitButton);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == coffeeButton) {
			System.out.println("커피 메뉴 등록");
			CoffeeForm coffeeForm = new CoffeeForm(db);
			coffeeForm.setVisible(true);
		} else if (e.getSource() == teaButton) {
			System.out.println("티 메뉴 등록");
			TeaForm teaForm = new TeaForm(db);
			teaForm.setVisible(true);
		} else if (e.getSource() == blendedButton) {
			System.out.println("블렌디드 메뉴 등록");
			BlendedForm blendedForm = new BlendedForm(db);
			blendedForm.setVisible(true);
		} else if (e.getSource() == otherthingsButton) {
			System.out.println("그외의 메뉴 등록");
			OtherthingsForm otherthingsForm = new OtherthingsForm(db);
			otherthingsForm.setVisible(true);
		} else if (e.getSource() == coffeeListButton) {
			System.out.println("커피 메뉴판");
			CoffeeList coffeeList = new CoffeeList(db);
			coffeeList.setVisible(true);
		} else if (e.getSource() == teaListButton) {
			System.out.println("티 메뉴판");
			TeaList teaList = new TeaList(db);
			teaList.setVisible(true);
		} else if (e.getSource() == blendedListButton) {
			System.out.println("블렌디드 메뉴판");
			BlendedList blendedList = new BlendedList(db);
			blendedList.setVisible(true);
		} else if (e.getSource() == otherthingsListButton) {
			System.out.println("그외의 메뉴판");
			OtherthingsList otherthingsList = new OtherthingsList(db);
			otherthingsList.setVisible(true);
		} else if (e.getSource() == allListButton) {
			System.out.println("메뉴판");
			AllList allList = new AllList(db);
			allList.setVisible(true);
		}
		else if (e.getSource() == exitButton) {
			System.exit(0);
			}
	}

	public static void main(String[] args) {
		new MainMenu(new DatabaseClass2());
	}

}
