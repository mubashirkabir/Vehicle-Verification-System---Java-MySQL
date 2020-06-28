import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class update extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Connection c = null;
	private PreparedStatement p=null;
	private ResultSet r=null;
	
	
	public update(){
		
	getContentPane().setLayout(null);
	
	JLabel label = new JLabel(" ");
	label.setIcon(new ImageIcon("D:\\Workspace\\DB\\Untitled-1.png"));
	label.setBounds(190, 77, 342, 90);
	getContentPane().add(label);
	
	textField = new JTextField();
	textField.setBounds(338, 178, 86, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnUpdate = new JButton("Update");
	btnUpdate.setBounds(243, 210, 89, 23);
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Update_veiw();
		}
	});
	getContentPane().add(btnUpdate);
	
	JButton button = new JButton("Cancel");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new Functions();
		}
	});
	button.setBounds(338, 210, 89, 23);
	getContentPane().add(button);
	
	JLabel lblEnterReg = new JLabel("Enter Reg #");
	lblEnterReg.setBounds(258, 181, 70, 14);
	getContentPane().add(lblEnterReg);
	this.setSize(WIDTH, HEIGHT);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setResizable(true);
	this.setFocusable(true);
	this.setSize(745,480);
	this.setAlwaysOnTop(true);
	this.setLocationRelativeTo(null);
	this.setVisible(true);

	}

		void Update_veiw(){
			String a=textField.getText();
			int h=0;
			try {
				VerificationDAO();
				p=c.prepareStatement("Select * from `verification` where `Reg_Number`like '%" + a + "%' ");
				r = p.executeQuery();
				while(r.next()){
					a=r.getString("Reg_Number");
					JOptionPane.showMessageDialog(this, "Record Found!!!");
					this.setVisible(false);
					new Update_menu(a);
					
					h++;
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			if(h==0){
				JOptionPane.showMessageDialog(this, "No Record Found!!!");
				
			}
		}

		@SuppressWarnings("unused")
		private void VerificationDAO() throws SQLException{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
		}
		
}
