package jnt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;


public class Customer extends JFrame {

	private JTable table;
	private JTextField textField_SName;
	private JTextField textField_SContact;
	private JTextField textField_SAdd;
	private JTextField textField_RName;
	private JTextField textField_RAddress;
	private JTextField textField_RContact;
	private JTextField textField_weight;
	private JTextField textField_quantity;
	private JTextField textField_tracker;
	private JTextField textField_MOP;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
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

			
			pst = con.prepareStatement("select * from shipping_information");
			pst = con.prepareStatement("select * from payment_st");
			pst = con.prepareStatement("select * from payment_information");
			pst = con.prepareStatement("select * from shipping_transaction");
			pst = con.prepareStatement("select * from customer_details");
			
		rs = pst.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}



	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("J&T EXPRESS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/icons.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 559);
		getContentPane().setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 0, 0));
		contentPane = new JPanel();
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 389, 738, 120);
		getContentPane().add(scrollPane);
		
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
		tabbedPane.setBounds(10, 24, 502, 354);
		tabbedPane.setFont(new Font("Verdana", Font.BOLD, 11));
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(64, 0, 0));
		tabbedPane.setBackground(new Color(255, 0, 0));
		getContentPane().add(tabbedPane);

		JPanel panel_SI = new JPanel();
		panel_SI.setBackground(SystemColor.controlHighlight);
		panel_SI.setBorder(null);
		tabbedPane.addTab("Sender Information", null, panel_SI, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel_SI.setLayout(null);

		JLabel lblNewJgoodiesTitle_SI = DefaultComponentFactory.getInstance().createTitle("Sender Information");
		lblNewJgoodiesTitle_SI.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewJgoodiesTitle_SI.setBounds(10, 11, 158, 24);
		panel_SI.add(lblNewJgoodiesTitle_SI);

		JLabel lblNewLabel_SName = new JLabel("Name");
		lblNewLabel_SName.setBounds(10, 46, 91, 26);
		panel_SI.add(lblNewLabel_SName);

		textField_SName = new JTextField();
		textField_SName.setBounds(10, 76, 346, 32);
		panel_SI.add(textField_SName);
		textField_SName.setColumns(10);

		JLabel lblNewLabel_SContact = new JLabel("Contact No.");
		lblNewLabel_SContact.setBounds(10, 140, 91, 26);
		panel_SI.add(lblNewLabel_SContact);

		textField_SContact = new JTextField();
		textField_SContact.setBounds(10, 177, 346, 32);
		panel_SI.add(textField_SContact);
		textField_SContact.setColumns(10);

		JLabel lblNewLabel_SAdd = new JLabel("Address");
		lblNewLabel_SAdd.setBounds(10, 235, 91, 26);
		panel_SI.add(lblNewLabel_SAdd);

		textField_SAdd = new JTextField();
		textField_SAdd.setBounds(10, 272, 464, 32);
		panel_SI.add(textField_SAdd);
		textField_SAdd.setColumns(10);

		JPanel panel_RI = new JPanel();
		tabbedPane.addTab("Recipient Information", null, panel_RI, null);
		panel_RI.setLayout(null);

		JLabel lblNewJgoodiesTitle_RI = DefaultComponentFactory.getInstance().createTitle("Recipient Information");
		lblNewJgoodiesTitle_RI.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewJgoodiesTitle_RI.setBounds(10, 11, 158, 24);
		panel_RI.add(lblNewJgoodiesTitle_RI);

		JLabel lblNewLabel_RName = new JLabel("Name");
		lblNewLabel_RName.setBounds(10, 46, 91, 26);
		panel_RI.add(lblNewLabel_RName);

		textField_RName = new JTextField();
		textField_RName.setBounds(10, 76, 346, 32);
		panel_RI.add(textField_RName);
		textField_RName.setColumns(10);

		JLabel lblNewLabel_RContact = new JLabel("Contact No.");
		lblNewLabel_RContact.setBounds(10, 140, 91, 26);
		panel_RI.add(lblNewLabel_RContact);

		textField_RContact = new JTextField();
		textField_RContact.setColumns(10);
		textField_RContact.setBounds(10, 177, 346, 32);
		panel_RI.add(textField_RContact);

		JLabel lblNewLabel_RAdd = new JLabel("Address");
		lblNewLabel_RAdd.setBounds(10, 235, 91, 26);
		panel_RI.add(lblNewLabel_RAdd);

		textField_RAddress = new JTextField();
		textField_RAddress.setColumns(10);
		textField_RAddress.setBounds(10, 272, 464, 32);
		panel_RI.add(textField_RAddress);


		JPanel panel_BI = new JPanel();
		tabbedPane.addTab("Booking Information", null, panel_BI, null);
		panel_BI.setLayout(null);

		JLabel lblNewJgoodiesTitle_BI = DefaultComponentFactory.getInstance().createTitle("Booking Information");
		lblNewJgoodiesTitle_BI.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewJgoodiesTitle_BI.setBounds(10, 11, 158, 24);
		panel_BI.add(lblNewJgoodiesTitle_BI);

		JLabel lblNewLabel_quantity = new JLabel("Quantity");
		lblNewLabel_quantity.setBounds(10, 107, 46, 14);
		panel_BI.add(lblNewLabel_quantity);

		textField_quantity = new JTextField();
		textField_quantity.setColumns(10);
		textField_quantity.setBounds(10, 132, 222, 34);
		panel_BI.add(textField_quantity);

		JLabel lblNewLabel_Weight = new JLabel("Weight");
		lblNewLabel_Weight.setBounds(266, 107, 46, 14);
		panel_BI.add(lblNewLabel_Weight);

		textField_weight = new JTextField();
		textField_weight.setBounds(266, 132, 222, 34);
		panel_BI.add(textField_weight);
		textField_weight.setColumns(10);

		JLabel lblNewLabel_MOP = new JLabel("Type of Payment (E-Payment/Cash On Delivery)");
		lblNewLabel_MOP.setBounds(10, 190, 261, 14);
		panel_BI.add(lblNewLabel_MOP);
		
		textField_MOP = new JTextField();
		textField_MOP.setBounds(10, 215, 238, 34);
		panel_BI.add(textField_MOP);
		textField_MOP.setColumns(10);

		JButton btnNewButton_ConfirmBook = new JButton("CONFIRM BOOKING");
		btnNewButton_ConfirmBook.setBounds(522, 191, 213, 30);
		btnNewButton_ConfirmBook.addActionListener(new ActionListener() {
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
				Weight_SI = Float.parseFloat(textField_weight.getText());
				Payment_Date = LocalDateTime.now();
				Ship_Amount = Weight_SI * 85;
				

				
				try {
					pst = con.prepareStatement(" INSERT INTO customer_details(Sender_Name, Sender_Add, Sender_Contact)values(?,?,?)");
					
					pst.setString(2, Sender_Name);
					pst.setString(3, Sender_Add);
					pst.setDouble(4, sc);
					
					pst = con.prepareStatement(" INSERT INTO shipping_information(Quantity_SI, Weight_SI, Rceiver_Name, Receiver_Add, Receiver_Contact)values(?,?,?,?,?,?)");
					
					pst.setInt(2, Quantity_SI);
					pst.setFloat(3, Weight_SI);
					pst.setString(4, Receiver_Name);
					pst.setString(5, Receiver_Add);
					pst.setDouble(6, rc);
					
					pst = con.prepareStatement(" INSERT INTO payment_st(Ship_Amount, Payment_Type, Payment_Date,)values(?,?,?)");
					
					pst.setFloat(2, Ship_Amount);
					pst.setString(3, Payment_Type);
					pst.setObject(4, Payment_Date);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added Successfully");
					
					textField_quantity.setText("");
					textField_SName.setText("");
					textField_SAdd.setText("");
					textField_SContact.setText("");
					textField_RName.setText("");
					textField_RAddress.setText("");
					textField_RContact.setText("");
					textField_weight.setText("");

				}
				catch (SQLException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		getContentPane().add(btnNewButton_ConfirmBook);

		JButton btnNewButton_NewBook = new JButton("NEW BOOKING");
		btnNewButton_NewBook.setBounds(522, 232, 213, 30);
		btnNewButton_NewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField_quantity.setText("");
			textField_SName.setText("");
			textField_SAdd.setText("");
			textField_SContact.setText("");
			textField_RName.setText("");
			textField_RAddress.setText("");
			textField_RContact.setText("");
			textField_weight.setText("");
			}
			});
		getContentPane().add(btnNewButton_NewBook);

		JButton btnNewButton_exit = new JButton("EXIT");
		btnNewButton_exit.setBounds(522, 273, 213, 30);
		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton_exit);
		

		textField_tracker = new JTextField();
		textField_tracker.setBounds(522, 330, 213, 23);
		textField_tracker.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
			});
		getContentPane().add(textField_tracker);
		textField_tracker.setColumns(10);

		JLabel lblNewLabel_tracker = new JLabel("Track Your Parcel:");
		lblNewLabel_tracker.setBounds(522, 314, 181, 14);
		getContentPane().add(lblNewLabel_tracker);

		JButton btnNewButton_Search = new JButton("Search");
		btnNewButton_Search.setBounds(581, 355, 103, 23);
		btnNewButton_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			int TrackingNo = Integer.parseInt(textField_tracker.getText());
			pst = con.prepareStatement("select Sender_Name, Sender_Add, Sender_Contact, Rceiver_Name, Receiver_Add, Receiver_Contact, Status, from where TrackingNo = ?");
			pst.setInt(1, TrackingNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next() == true)
				
			{
				int TrackNo = rs.getInt(1);
				String Sender_Name = rs.getString(2);
				String Sender_Add = rs.getString(3);
				double Sender_Contact = rs.getDouble(4);
				String Rceiver_Name = rs.getString(5);
				String Rceiver_Add = rs.getString(6);
				double Receiver_Contact = rs.getDouble(7);
				String Status = rs.getString(8);
			
				String sn = String.valueOf(Sender_Name);
				String sa = String.valueOf(Sender_Add);
				String sc = String.valueOf(Sender_Contact);
				String rn = String.valueOf(Rceiver_Name);
				String ra = String.valueOf(Rceiver_Add);
				String rc = String.valueOf(Receiver_Contact);
				
				textField_SName.setText(sn);
				textField_SAdd.setText(sa);
				textField_SContact.setText(sc);
				textField_RName.setText(rn);
				textField_RAddress.setText(ra);
				textField_RContact.setText(rc);
				
				} else {
				JOptionPane.showMessageDialog(null, "Record does not exists!");
				}
				} catch (SQLException ex) {
				}
				}
				});
		getContentPane().add(btnNewButton_Search);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Customer.class.getResource("/imgs/download (4).png")));
		lblNewLabel.setBounds(512, 0, 246, 203);
		contentPane.add(lblNewLabel);


	}
}
