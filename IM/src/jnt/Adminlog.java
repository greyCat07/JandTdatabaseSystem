package jnt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Adminlog extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

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
	public Adminlog() {
		setTitle("J&T ADMIN");
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

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 192, 81, 14);
		contentPane.add(lblNewLabel_1);

		txtUsername = new JTextField();
		txtUsername.setBounds(24, 208, 291, 36);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(24, 268, 81, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String password = txtPassword.getText();
				String username = txtUsername.getText();

				if (password.contains("admin123") && username.contains("admin")) {
					txtPassword.setText(null);
					txtUsername.setText(null);

					dispose();

					Adminboard info = new Adminboard();
					info.setVisible(true);


				}

				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(127, 330, 89, 23);
		contentPane.add(btnNewButton);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(24, 284, 291, 35);
		contentPane.add(txtPassword);
	}
}
