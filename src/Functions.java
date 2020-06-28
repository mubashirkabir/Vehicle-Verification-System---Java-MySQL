import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Functions  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Functions() {

		getContentPane().setLayout(null);
		
		JButton btnInsert = new JButton("Insert ");
		btnInsert.setBounds(306, 166, 89, 23);
		getContentPane().add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insert();
			}
		});
		
		JButton button = new JButton("Update ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
		});
		button.setBounds(306, 200, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Delete ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		button_1.setBounds(306, 234, 89, 23);
		getContentPane().add(button_1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("D:\\Workspace\\DB\\Untitled-1.png"));
		label.setBounds(233, 81, 262, 74);
		getContentPane().add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(306, 267, 89, 23);
		getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Verification();
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

	void insert(){
		this.setVisible(false);
		Insert a = new Insert();
	}
	
	void delete(){
		this.setVisible(false);
		delete a= new delete();
	}
		
	void update(){
		this.setVisible(false);
	    update a = new update();
	}
}
