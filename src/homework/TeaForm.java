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

public class TeaForm extends JFrame implements ActionListener {

	public DatabaseClass2 db;

	private JTextField nameField;
	private JTextField priceField;
	private JTextField sizeField;
	private JTextField typeField;
	private JTextField whereField;
	private JButton addButton;
	private JButton closeButton;

	public TeaForm() {

	}

	public TeaForm(DatabaseClass2 db) {
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

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
		// 즉, 메인 패널 위에 inputPanel이 놓이게 됨.
		JPanel mainJPanel = new JPanel();
		mainJPanel.setLayout(new BorderLayout());

		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널
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
		mainJPanel.add(addButton, BorderLayout.SOUTH);
		mainJPanel.add(closeButton, BorderLayout.EAST);

		setTitle("티 메뉴판 생성");
		// setSize(1100, 1500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainJPanel);
		inputPanel.setBackground(Color.green);
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

			Tea tea = new Tea(name, price, size, type, where);
			this.db.addTea(tea);

			JOptionPane.showMessageDialog(this, "등록완료");

			System.out.println("메뉴 등록 완료 갯수 " + db.getTeaCount());

			nameField.setText("");
			priceField.setText("");
			sizeField.setText("");
			typeField.setText("");
			whereField.setText("");

		} else if (e.getSource() == closeButton) {

			this.dispose();
			//MainMenu mainMenu = new MainMenu(db);
			//mainMenu.setVisible(true);
		}

	}

	public static void main(String[] args) {
		new TeaForm(new DatabaseClass2());
	}

}
