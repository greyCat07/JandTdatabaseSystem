package jnt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Adminboard extends JFrame {

	
	private JTextField textField_Track;
	private JTextField textField_SName;
	private JTextField textField_SAdd;
	private JTextField textField_SContact;
	private JTextField textField_RName;
	private JTextField textField_RAddress;
	private JTextField textField_RContact;
	private JTextField textField_sp;
	private JTextField textField_WeightSI;
	private JTextField textField_quantity;
	private JTextField textField_MOP;
	private JTextField textField_DelPer;
	private JTextField textField_status;
	private JTextField textField_13;
	private JTextField textField_Name;
	private JTextField textField_Contact;
	private JTextField textField_Area;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Adminboard frame = new Adminboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the Database
	 */
	public Adminboard() {
		initialize();
		Connect();
		table_load();
		}
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		private JButton btnSearch;
		private JTable table_1;
		public void Connect() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/jtdatabase", "root",
		"admin");
		JOptionPane.showMessageDialog(null, "Connected");
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Connection Error");
		}
		}

		public void table_load() {
		try {

		pst = con.prepareStatement("select * from customer_details");
		pst = con.prepareStatement("select * from shipping_information");
		pst = con.prepareStatement("select * from payment_st");
		pst = con.prepareStatement("select * from payment_information");
		pst = con.prepareStatement("select * from shipping_transaction");
		

		rs = pst.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}



	/**
	 * Create the frame.
	 */
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("J&T ADMIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/icons.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 892, 275);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"Tracking No", "Sender Name", 
				"Sender Address", "Sender Contact", "Receiver Name",
				"Receiver Address", "Receiver Contact", "Status"
				}));
				table_1.getColumnModel().getColumn(0).setPreferredWidth(97);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(150);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(95);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(95);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(95);
				table_1.getColumnModel().getColumn(5).setPreferredWidth(95);
				table_1.getColumnModel().getColumn(6).setPreferredWidth(95);
				table_1.getColumnModel().getColumn(7).setPreferredWidth(95);
				table_1.setFont(new Font("Arial", Font.PLAIN, 12));
				scrollPane.setViewportView(table);


		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(10, 11, 892, 260);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Admin", null, panel, null);
		panel.setLayout(null);

		JButton btnNewButton_Search = new JButton("Search");
		btnNewButton_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_Search.setBounds(281, 25, 89, 23);
		panel.add(btnNewButton_Search);

		JButton btnNewButton_ViewAll = new JButton("View All Orer");
		btnNewButton_ViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_ViewAll.setBounds(445, 21, 140, 30);
		panel.add(btnNewButton_ViewAll);

		JLabel lblNewLabel_Track = new JLabel("Track Order");
		lblNewLabel_Track.setBounds(20, 12, 161, 14);
		panel.add(lblNewLabel_Track);
		
		textField_Track = new JTextField();
		textField_Track.setBounds(30, 26, 241, 20);
		panel.add(textField_Track);
		textField_Track.setColumns(10);

		JButton btnNewButton_Exit = new JButton("Log-out");
		btnNewButton_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Exit.setBounds(616, 21, 140, 30);
		panel.add(btnNewButton_Exit);

		JButton btnNewButton_3 = new JButton("CREATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Sender_Name, Sender_Add, Receiver_Name,Receiver_Add, Payment_Type;
						LocalDateTime Payment_Date;
						int Quantity_SI;
						float Weight_SI, Ship_Amount;
						double sc, rc;
						
						
						Quantity_SI = Integer.parseInt(textField_quantity.getText());
						Sender_Name = textField_SName.getText();
						Sender_Add = textField_SAdd.getText();
						Receiver_Name = textField_RName.getText();
						Receiver_Add = textField_RAddress.getText();
						Payment_Type = textField_MOP.getText();
						sc = Double.parseDouble(textField_SContact.getText());
						rc = Double.parseDouble(textField_RContact.getText());
						Weight_SI = Float.parseFloat(textField_WeightSI.getText());
						Payment_Date = LocalDateTime.now();
						Ship_Amount = Weight_SI * 85;
						

						
						try {
							pst = con.prepareStatement(" INSERT INTO customer_details(Sender_Name, Sender_Add, Sender_Contact)values(?,?,?)");
							
							pst.setString(1, Sender_Name);
							pst.setString(2, Sender_Add);
							pst.setDouble(3, sc);
							
							pst = con.prepareStatement(" INSERT INTO shipping_information(Quantity_SI, Weight_SI, Rceiver_Name, Receiver_Add, Receiver_Contact)values(?,?,?,?,?,?)");
							
							pst.setInt(4,Quantity_SI);
							pst.setFloat(5, Weight_SI);
							pst.setString(6, Receiver_Name);
							pst.setString(7, Receiver_Add);
							pst.setDouble(8, rc);
							
							pst = con.prepareStatement(" INSERT INTO payment_st(Ship_Amount, Payment_Type, Payment_Date)values(?,?,?)");
							
							pst.setFloat(9, Ship_Amount);
							pst.setString(10, Payment_Type);
							pst.setObject(11, Payment_Date);

							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Record Added Successfully");
							table_load();
							
							textField_quantity.setText("");
							textField_SName.setText("");
							textField_SAdd.setText("");
							textField_SContact.setText("");
							textField_RName.setText("");
							textField_RAddress.setText("");
							textField_RContact.setText("");
							textField_WeightSI.setText("");

						}
						catch (SQLException e1) {
							e1.printStackTrace();
							
						}
					}
				});
			}
		});
		btnNewButton_3.setBounds(20, 89, 99, 23);
		panel.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("UPDATE");
		btnNewButton_3_1.setBounds(20, 124, 99, 23);
		panel.add(btnNewButton_3_1);

		JButton btnNewButton_3_1_1 = new JButton("DELETE");
		btnNewButton_3_1_1.setBounds(20, 158, 99, 23);
		panel.add(btnNewButton_3_1_1);

		textField_SName = new JTextField();
		textField_SName.setBounds(129, 90, 178, 20);
		panel.add(textField_SName);
		textField_SName.setColumns(10);

		textField_SAdd = new JTextField();
		textField_SAdd.setColumns(10);
		textField_SAdd.setBounds(129, 150, 178, 20);
		panel.add(textField_SAdd);

		textField_SContact = new JTextField();
		textField_SContact.setColumns(10);
		textField_SContact.setBounds(129, 201, 178, 20);
		panel.add(textField_SContact);

		textField_RName = new JTextField();
		textField_RName.setColumns(10);
		textField_RName.setBounds(317, 90, 178, 20);
		panel.add(textField_RName);

		textField_RAddress = new JTextField();
		textField_RAddress.setColumns(10);
		textField_RAddress.setBounds(317, 150, 178, 20);
		panel.add(textField_RAddress);

		textField_RContact = new JTextField();
		textField_RContact.setColumns(10);
		textField_RContact.setBounds(317, 201, 178, 20);
		panel.add(textField_RContact);

		textField_sp = new JTextField();
		textField_sp.setColumns(10);
		textField_sp.setBounds(505, 90, 178, 20);
		panel.add(textField_sp);

		textField_WeightSI = new JTextField();
		textField_WeightSI.setColumns(10);
		textField_WeightSI.setBounds(505, 150, 178, 20);
		panel.add(textField_WeightSI);

		textField_quantity = new JTextField();
		textField_quantity.setColumns(10);
		textField_quantity.setBounds(505, 201, 178, 20);
		panel.add(textField_quantity);

		textField_MOP = new JTextField();
		textField_MOP.setColumns(10);
		textField_MOP.setBounds(693, 90, 178, 20);
		panel.add(textField_MOP);

		textField_DelPer = new JTextField();
		textField_DelPer.setColumns(10);
		textField_DelPer.setBounds(693, 150, 178, 20);
		panel.add(textField_DelPer);

		textField_status = new JTextField();
		textField_status.setColumns(10);
		textField_status.setBounds(693, 201, 178, 20);
		panel.add(textField_status);

		JLabel lblNewLabel_SName = new JLabel("Sender Name");
		lblNewLabel_SName.setBounds(129, 71, 132, 14);
		panel.add(lblNewLabel_SName);

		JLabel lblNewLabel_SAdd = new JLabel("Sender Address");
		lblNewLabel_SAdd.setBounds(129, 133, 132, 14);
		panel.add(lblNewLabel_SAdd);

		JLabel lblNewLabel_SContact = new JLabel("Sender Contact");
		lblNewLabel_SContact.setBounds(129, 183, 132, 14);
		panel.add(lblNewLabel_SContact);

		JLabel lblNewLabel_RName = new JLabel("Recipient Name");
		lblNewLabel_RName.setBounds(317, 71, 132, 14);
		panel.add(lblNewLabel_RName);

		JLabel lblNewLabel_RAdd = new JLabel("Recipient Address");
		lblNewLabel_RAdd.setBounds(317, 133, 132, 14);
		panel.add(lblNewLabel_RAdd);

		JLabel lblNewLabel_RContact = new JLabel("Recipient Contact ");
		lblNewLabel_RContact.setBounds(317, 183, 132, 14);
		panel.add(lblNewLabel_RContact);

		JLabel lblNewLabel_ShipPrice = new JLabel("Shipping Price");
		lblNewLabel_ShipPrice.setBounds(505, 71, 132, 14);
		panel.add(lblNewLabel_ShipPrice);

		JLabel lblNewLabel_Weight = new JLabel("Weight");
		lblNewLabel_Weight.setBounds(505, 133, 132, 14);
		panel.add(lblNewLabel_Weight);

		JLabel lblNewLabel_Quantity = new JLabel("Quantity");
		lblNewLabel_Quantity.setBounds(505, 183, 132, 14);
		panel.add(lblNewLabel_Quantity);

		JLabel lblNewLabel_ModePay = new JLabel("Type of Payment");
		lblNewLabel_ModePay.setBounds(692, 71, 132, 14);
		panel.add(lblNewLabel_ModePay);

		JLabel lblNewLabel_DelPer = new JLabel("Delivery Personnel");
		lblNewLabel_DelPer.setBounds(693, 133, 132, 14);
		panel.add(lblNewLabel_DelPer);

		JLabel lblNewLabel_Status = new JLabel("Status");
		lblNewLabel_Status.setBounds(693, 183, 132, 14);
		panel.add(lblNewLabel_Status);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delivery Personnel", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_Per = new JLabel("Enter Personel ID");
		lblNewLabel_Per.setBounds(10, 11, 151, 14);
		panel_1.add(lblNewLabel_Per);

		textField_13 = new JTextField();
		textField_13.setBounds(10, 30, 310, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);

		JButton btnNewButton_SearchPer = new JButton("Search");
		btnNewButton_SearchPer.setBounds(325, 29, 89, 23);
		panel_1.add(btnNewButton_SearchPer);

		JButton btnNewButton_View = new JButton("View All");
		btnNewButton_View.setBounds(467, 29, 151, 23);
		panel_1.add(btnNewButton_View);

		JButton btnNewButton_logout = new JButton("Exit");
		btnNewButton_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_logout.setBounds(648, 29, 151, 23);
		panel_1.add(btnNewButton_logout);

		JButton btnNewButton_Create = new JButton("Create");
		btnNewButton_Create.setBounds(147, 160, 130, 23);
		panel_1.add(btnNewButton_Create);

		JButton btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.setBounds(325, 160, 130, 23);
		panel_1.add(btnNewButton_Update);

		JButton btnNewButton_Delete = new JButton("Delete");
		btnNewButton_Delete.setBounds(488, 160, 130, 23);
		panel_1.add(btnNewButton_Delete);

		textField_Name = new JTextField();
		textField_Name.setBounds(34, 120, 226, 20);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Contact = new JTextField();
		textField_Contact.setColumns(10);
		textField_Contact.setBounds(270, 120, 226, 20);
		panel_1.add(textField_Contact);

		textField_Area = new JTextField();
		textField_Area.setColumns(10);
		textField_Area.setBounds(506, 120, 226, 20);
		panel_1.add(textField_Area);

		JLabel lblNewLabel_Name = new JLabel("Name");
		lblNewLabel_Name.setBounds(34, 102, 112, 14);
		panel_1.add(lblNewLabel_Name);

		JLabel lblNewLabel_Contact = new JLabel("Contact");
		lblNewLabel_Contact.setBounds(270, 102, 112, 14);
		panel_1.add(lblNewLabel_Contact);

		JLabel lblNewLabel_Area = new JLabel("Area");
		lblNewLabel_Area.setBounds(506, 102, 112, 14);
		panel_1.add(lblNewLabel_Area);



	}

}
