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
import javax.swing.ImageIcon;

public class Main_Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection c = null;
	private PreparedStatement p=null;
	private ResultSet r=null;
	
	public Main_Window() {
		getContentPane().setLayout(null);
		
		JButton btnNewUsed = new JButton("New Cars");
		btnNewUsed.setBounds(314, 166, 99, 23);
		getContentPane().add(btnNewUsed);
		btnNewUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUsed();
			}
		});
		
		JButton btnVerification = new JButton("Verification");
		btnVerification.setBounds(314, 234, 99, 23);
		btnVerification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				method_a();
			}
		});
		getContentPane().add(btnVerification);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(314, 268, 99, 23);
		getContentPane().add(button);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("D:\\Workspace\\DB\\main.png"));
		label.setBounds(188, 59, 390, 119);
		getContentPane().add(label);
		
		JButton button_1 = new JButton("Used Cars");
		button_1.setBounds(314, 200, 99, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Used();
			}
		});
		getContentPane().add(button_1);
	
		
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setFocusable(true);
		this.setSize(745,480);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	void method_a(){
		this.setVisible(false);
		new Verification();
		
	}
	
	void newUsed(){
		this.setVisible(false);
		new new_Cars();
		
	}
	
	void Used(){
		this.setVisible(false);
		new Used_Cars();
		
	}
	
	public static void main(String []args){
		new Main_Window();	
	}
}
