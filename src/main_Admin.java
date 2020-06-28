import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class main_Admin  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	int a=0;
	private Connection c = null;
	private PreparedStatement p=null;
	private ResultSet r=null;
	private JPasswordField passwordField;
	
	@SuppressWarnings("static-access")
	public main_Admin() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(363, 148, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(267, 221, 89, 23);
		getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 login();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(363, 221, 89, 23);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Verification();
			}
		});
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\Workspace\\DB\\Untitled-1.png"));
		lblNewLabel.setBounds(218, 31, 370, 114);
		getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(363, 179, 86, 20);
		getContentPane().add(passwordField);
		
		JLabel lblAdminId = new JLabel("Admin Id");
		lblAdminId.setBounds(285, 151, 57, 14);
		getContentPane().add(lblAdminId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(285, 182, 71, 14);
		getContentPane().add(lblPassword);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setFocusable(true);
		this.setSize(745,480);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}

	void login(){
			String a=textField.getText();
			@SuppressWarnings("deprecation")
			String b=passwordField.getText();
			String a1=null;
			String b1=null;
			try{ 
				VerificationDAO();
				p = c.prepareStatement("Select * from `admin` where `Admin_id` = '" + a + "'");
				r = p.executeQuery();
				while(r.next()){
					 a1=r.getString("Admin_id");
					 b1=r.getString("Password");
				}
				if(a.equals("9512468")&&b.equals("MynewPassword")){
					JOptionPane.showMessageDialog(this,"Log in Successfully !!!");
					Thread.sleep(350);
					this.setVisible(false);
					new Functions();
				}
				if(!(a1.equals(a)&&b1.equals(b))){
					JOptionPane.showMessageDialog(this,"ID or password incorrect!!\nTry again.");	
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}	
		}	
	@SuppressWarnings("unused")
	private void VerificationDAO() throws SQLException{
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
		
	}
}
