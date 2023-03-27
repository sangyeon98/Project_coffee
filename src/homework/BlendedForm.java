package homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlendedForm extends JFrame implements ActionListener {

	public DatabaseClass2 db;

	private JTextField nameField;
	private JTextField priceField;
	private JTextField sizeField;
	private JTextField typeField;
	private JTextField whereField;
	private JButton addButton;
	private JButton closeButton;

	public BlendedForm() {

	}

	public BlendedForm(DatabaseClass2 db) {
		this.db = db;

		nameField = new JTextField(15);
		priceField = new JTextField(15);
		sizeField = new JTextField(15);
		typeField = new JTextField(15);
		whereField = new JTextField(15);

		JLabel nameLabel = new JLabel("메뉴 :");
		JLabel priceJLabel = new JLabel("가격:");
		JLabel sizeJLabel = new JLabel("사이즈:");
		JLabel typeJLabel = new JLabel("HOT/ICE");
		JLabel whereJLabel = new JLabel("일회용/머그");

		addButton = new JButton("메뉴 추가");
		addButton.addActionListener(this);

		closeButton = new JButton("닫기");
		closeButton.addActionListener(this);

		JPanel mainJPanel = new JPanel();
		mainJPanel.setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();

		inputPanel.setLayout(new GridLayout(5, 2));
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(priceJLabel);
		inputPanel.add(priceField);
		inputPanel.add(sizeJLabel);
		inputPanel.add(sizeField);
		inputPanel.add(typeJLabel);
		inputPanel.add(typeField);
		inputPanel.add(whereJLabel);
		inputPanel.add(whereField);

		mainJPanel.add(inputPanel, BorderLayout.CENTER);
		mainJPanel.add(closeButton, BorderLayout.EAST);
		mainJPanel.add(addButton, BorderLayout.SOUTH);

		setTitle("블렌디드 메뉴판 생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainJPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {

			String name = nameField.getText();
			int price = Integer.parseInt(priceField.getText());
			String size = sizeField.getText();
			String type = typeField.getText();
			String where = whereField.getText();

			Coffee coffee = new Coffee(name, price, size, type, where);
			this.db.addCoffee(coffee);

			JOptionPane.showMessageDialog(this, "등록완료");

			System.out.println("메뉴 등록 완료 갯수 " + db.getCoffeeCount());

			nameField.setText("");
			priceField.setText("");
			sizeField.setText("");
			typeField.setText("");
			whereField.setText("");

		} else if (e.getSource() == closeButton) {
			this.dispose();
			// 다시 메인창으로 보내줌
			//MainMenu mainMenu = new MainMenu(db);
			//mainMenu.setVisible(true);
		}

	}

	public static void main(String[] args) {
		new BlendedForm(new DatabaseClass2());
	}

}
