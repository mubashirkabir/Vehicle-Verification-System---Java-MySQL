import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Insert extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Connection c = null;

	
	public Insert(){
	
	getContentPane().setLayout(null);
	
	textField = new JTextField();
	textField.setBounds(358, 109, 86, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(358, 140, 86, 20);
	getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(358, 171, 86, 20);
	getContentPane().add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(358, 202, 86, 20);
	getContentPane().add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(358, 233, 86, 20);
	getContentPane().add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(358, 264, 86, 20);
	getContentPane().add(textField_5);
	
	textField_6 = new JTextField();
	textField_6.setColumns(10);
	textField_6.setBounds(358, 295, 86, 20);
	getContentPane().add(textField_6);
	
	textField_7 = new JTextField();
	textField_7.setColumns(10);
	textField_7.setBounds(358, 326, 86, 20);
	getContentPane().add(textField_7);
	
	JButton btnInsert = new JButton("Insert");
	btnInsert.setBounds(247, 357, 89, 23);
	getContentPane().add(btnInsert);
	btnInsert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			insert_button();
		}
	});
	
	JButton button = new JButton("Cancel");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cancel();
		
		}
	});
	button.setBounds(358, 357, 89, 23);
	getContentPane().add(button);
	
	JLabel label = new JLabel(" ");
	label.setIcon(new ImageIcon("D:\\Workspace\\DB\\Untitled-1.png"));
	label.setBounds(202, 26, 234, 72);
	getContentPane().add(label);
	
	JLabel lblReg = new JLabel("Reg #: ");
	lblReg.setBounds(259, 112, 46, 14);
	getContentPane().add(lblReg);
	
	JLabel lblModel = new JLabel("Model");
	lblModel.setBounds(259, 143, 46, 14);
	getContentPane().add(lblModel);
	
	JLabel lblCurrentOwner = new JLabel("Current Owner");
	lblCurrentOwner.setBounds(247, 174, 77, 14);
	getContentPane().add(lblCurrentOwner);
	
	JLabel lblOwnerAddress = new JLabel("Owner Address");
	lblOwnerAddress.setBounds(237, 205, 86, 14);
	getContentPane().add(lblOwnerAddress);
	
	JLabel lblColor = new JLabel("Color");
	lblColor.setBounds(259, 236, 46, 14);
	getContentPane().add(lblColor);
	
	JLabel lblStolen = new JLabel("Stolen");
	lblStolen.setBounds(259, 267, 46, 14);
	getContentPane().add(lblStolen);
	
	JLabel lblTokenPaidUpto = new JLabel("Token Paid Upto");
	lblTokenPaidUpto.setBounds(247, 298, 89, 14);
	getContentPane().add(lblTokenPaidUpto);
	
	JLabel lblNoOfOwners = new JLabel("No of Owners");
	lblNoOfOwners.setBounds(247, 329, 77, 14);
	getContentPane().add(lblNoOfOwners);
	
	this.setSize(WIDTH, HEIGHT);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(true);
	this.setFocusable(true);
	this.setSize(745,480);
	this.setAlwaysOnTop(true);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
	
	}
	
	void cancel(){
		this.setVisible(false);
		new Functions();

		
	}

	void insert_button(){
		try {
			VerificationDAO();
			java.sql.Statement s= c.createStatement();	
			s.executeUpdate("INSERT INTO `verification` (`Reg_Number`, `Current Owner`, `Owner Address`, `Color`, `Stolen`, `Token Paid upto`, `Number of owners`, `Model`) VALUES ('"+textField.getText()+"', '"+textField_2.getText()+"', '"+textField_3.getText()+"', '"+textField_4.getText()+"', '"+textField_5.getText()+"', '"+textField_6.getText()+"', '"+textField_7.getText()+"', '"+textField_1.getText()+"')");		
			JOptionPane.showMessageDialog(this, "Insert Successfully !!");
			close(c);
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	


	private void close(Connection c2) {
		
	}


	@SuppressWarnings("unused")
	private void VerificationDAO() throws SQLException{
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
		
	}




}

