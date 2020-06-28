import javax.swing.*;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class delete extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Connection c = null;
	private Connection c1 = null;
	private PreparedStatement p=null;
	private ResultSet r=null;
	
	public delete(){

	getContentPane().setLayout(null);
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.setBounds(219, 201, 89, 23);
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			delete_button();
		}
	});
	getContentPane().add(btnDelete);
	
	JButton button = new JButton("Cancel");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cancel();
		}
	});
	button.setBounds(330, 201, 89, 23);
	getContentPane().add(button);
	
	textField = new JTextField();
	textField.setBounds(336, 160, 83, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel label = new JLabel(" ");
	label.setIcon(new ImageIcon("D:\\Workspace\\DB\\Untitled-1.png"));
	label.setBounds(189, 82, 290, 77);
	getContentPane().add(label);
	
	JLabel lblEnterReg = new JLabel("Enter Reg #: ");
	lblEnterReg.setBounds(236, 157, 72, 27);
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
	 
	void cancel(){
		 this.setVisible(false);
		 new Functions(); 
	 }
	
	
	void delete_button(){
		int i=0;
		try {
			VerificationDAO();
			String q =textField.getText();
			p=c.prepareStatement("Select * from `verification` where `Reg_Number`like '%" + q + "%' ");
			r = p.executeQuery();
			q=null;
			while(r.next()){
				q=r.getString("Reg_Number");
			}
			if(q!=null){
				java.sql.Statement s= c1.createStatement();	
				s.executeUpdate("DELETE FROM `verification` WHERE `Reg_Number` = '" + q + "'");
				i=1;
				JOptionPane.showMessageDialog(this,"Deleted successfully !!!");	
			}
			
			close(c, p, r, p, r);
			
		} catch (SQLException e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
		if(i==0){ 
			JOptionPane.showMessageDialog(this,"No such record found !!");	
		}
		
		
		
	}
	
	
	
	private void close(Connection c2, PreparedStatement p2, ResultSet r2, PreparedStatement p12, ResultSet r12) {
		
	}

	@SuppressWarnings("unused")
	private void VerificationDAO() throws SQLException{
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
		c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
	}
}