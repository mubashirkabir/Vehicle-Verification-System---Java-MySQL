import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Verification  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Connection a = null;
	private PreparedStatement b=null;
	private ResultSet c=null;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model =null;
	int i=0;
	
	
	public Verification(){
	
		getContentPane().setLayout(null);
		
		JButton btnVerify = new JButton("Check");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verify();
				
			}
		});
		btnVerify.setBounds(259, 140, 89, 23);
		getContentPane().add(btnVerify);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		button.setBounds(358, 140, 89, 23);
		getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(259, 106, 188, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("Admin");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin(); 
				
			}
		});
		button_1.setBounds(626, 11, 89, 23);
		getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Workspace\\DB\\logo.png"));
		lblNewLabel.setBounds(188, 11, 315, 98);
		getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 195, 729, 246);
		getContentPane().add(scrollPane);
		
		JButton btnUsedCars = new JButton("Used Cars");
		btnUsedCars.setBounds(626, 49, 89, 23);
		btnUsedCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				use();
				
			}
		});
		getContentPane().add(btnUsedCars);
		
		this.setSize(736, 463);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setFocusable(true);
		this.setSize(745,480);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	void back(){
		this.setVisible(false);
		new Main_Window();
	}
	void use(){
		this.setVisible(false);
		new Used_Cars();
	}
	
	private void verify(){		
		int j=0;
		if(i==0){
			table = new JTable(new DefaultTableModel(new Object[]{"Reg #","Model", "Owner","Owner Address","Color","Stolen","Token Paid upto","Number of Owners"}, getDefaultCloseOperation()));
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			scrollPane.setViewportView(table);
		}
		if(i>0){
			model= (DefaultTableModel) table.getModel();
			model.setRowCount(0);
		}
		try{
			
			VerificationDAO();
			String k = textField.getText();
			b = a.prepareStatement("Select * from `verification` where `Reg_Number`like '%" + k + "%' ");
			c = b.executeQuery();			
			while(c.next()){
				Object[] row = { c.getString("Reg_Number"),c.getString("Model") ,c.getString("Current Owner"), c.getString("Owner Address"),c.getString("Color"), c.getString("Stolen"), c.getString("Token Paid upto"),c.getString("Number of owners") };
			    model.addRow(row);
			  i++;
			  j=1;
			}
			close(a,b,c);
		 if(j==0){
			 JOptionPane.showMessageDialog(this, "Error 404. No data found.");
		}	
			}catch (Exception e) {
			System.out.println(e);	
		}
		
	}
	
	private void admin(){		
		this.setVisible(false);
		new main_Admin();
	}
	
	private void close(Connection a2, PreparedStatement b, ResultSet c) {
		
	}


	@SuppressWarnings("unused")
	private void VerificationDAO() throws SQLException{
		a = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
		
	}
}
