import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Used_Cars extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DefaultTableModel model =null;
	private JScrollPane scrollPane;
	private Connection c = null;
	private PreparedStatement p=null;
	private ResultSet r=null;
	int j=0;
	
	
	public Used_Cars(){	
		
		getContentPane().setLayout(null);
		
		JLabel lblMaker = new JLabel("Maker");
		lblMaker.setBounds(287, 108, 46, 14);
		getContentPane().add(lblMaker);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(287, 133, 46, 14);
		getContentPane().add(lblModel);
		
		textField = new JTextField();
		textField.setBounds(343, 105, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(343, 130, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(259, 158, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(358, 158, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pechay();
			}
		});
		getContentPane().add(btnBack);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("D:\\Workspace\\DB\\main.png"));
		label.setBounds(191, 11, 343, 119);
		getContentPane().add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 195, 729, 246);
		getContentPane().add(scrollPane);
		
		JButton btnVerification = new JButton("Verification ");
		btnVerification.setBounds(621, 11, 98, 23);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veri();
			}
		});
		getContentPane().add(btnVerification);
		
		this.setSize(735, 463);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setFocusable(true);
		this.setSize(745,480);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	
	void veri(){
		this.setVisible(false);
		new Verification();
		
	}
	
	void pechay(){
			this.setVisible(false);
			new Main_Window();
			
		}

		void search(){
			if(j==0){
				table = new JTable(new DefaultTableModel(new Object[]{"Maker","Model", "Color","Engine Capacity","Engine Number","Body Type","Assembly","Registration Number","Mileage","Price"}, getDefaultCloseOperation()));
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				scrollPane.setViewportView(table);
			}
			if(j>0){
				model= (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
			String a=textField.getText();
			String b=textField_1.getText();
			int i=0;
			try {
				VerificationDAO();
				p = c.prepareStatement("Select * from cars, used_cars where Maker like '%"+a+"%' and  Model like '%"+b+"%' and `Registration Number` is not null and cars.id=used_cars.id");
				r = p.executeQuery();			
				while(r.next()){
					Object[] row = { r.getString("Maker"),r.getString("Model"),r.getString("Color") ,r.getString("Engine Capacity"), r.getString("Engine Number"),r.getString("Body Type"), r.getString("Assembly"), r.getString("Registration Number"), r.getString("Mileage"),r.getString("Price")};
				    model.addRow(row);	
					i=1;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			if(i!=1){
				JOptionPane.showMessageDialog(this, "No record Found!!");
			}
		} 
		
		

		@SuppressWarnings("unused")
		private void VerificationDAO() throws SQLException{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_database?useSSL=false","root","Mubashirkk97");
			
		}
}
