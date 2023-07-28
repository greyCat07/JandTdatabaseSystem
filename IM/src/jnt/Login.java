package jnt;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("J&T Express");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/icons.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 338, 181);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imgs/download (1).png")));
		lblNewLabel.setBounds(51, 11, 209, 140);
		panel.add(lblNewLabel);

		Button button = new Button("Customer");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

				Customer custoin = new Customer();
				custoin.setVisible(true);

			}
		});
		button.setFont(new Font("Verdana", Font.BOLD, 14));
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(46, 244, 245, 39);
		contentPane.add(button);

		Button button_1 = new Button("Employee");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

				Adminlog info = new Adminlog();
				info.setVisible(true);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Verdana", Font.BOLD, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(46, 313, 245, 39);
		contentPane.add(button_1);

		JLabel lblNewLabel_1 = new JLabel("Log-in as:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(137, 213, 81, 14);
		contentPane.add(lblNewLabel_1);
	}
}
