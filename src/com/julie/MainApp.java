package com.julie;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp extends JFrame implements Consideration{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnShowResult;
	private JComboBox<String> cbo1_1;
	private JComboBox<String> cbo1_2;
	private JComboBox<String> cbo2_1;
	private JComboBox<String> cbo2_2;
	private JComboBox<String> cbo3_1;
	private JComboBox<String> cbo3_2;
	private JComboBox<String> cbo4_1;
	private JComboBox<String> cbo4_2;
	private JComboBox<String> cbo5_1;
	private JComboBox<String> cbo5_2;
	private JComboBox<String> cbo6_1;
	private JComboBox<String> cbo6_2;
	private JList<String> lstResult;
	private ArrayList<JComboBox> list = new ArrayList<JComboBox>();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private int totalLease = 0, totalFinance = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	
	@Override
	public void getVehicleFrequency() {
		totalLease += Integer.parseInt(cbo1_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo1_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void getKilometres() {
		totalLease += Integer.parseInt(cbo2_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo2_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void getWarranty() {
		totalLease += Integer.parseInt(cbo3_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo3_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void getOwnership() {
		totalLease += Integer.parseInt(cbo4_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo4_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void getCustomization() {
		totalLease += Integer.parseInt(cbo5_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo5_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void getTaxAdvantage() {
		totalLease += Integer.parseInt(cbo6_1.getSelectedItem().toString()) * 10;
		totalFinance += Integer.parseInt(cbo6_2.getSelectedItem().toString()) * 10;
	}

	@Override
	public void display() {
		dlm.removeAllElements();
		if(totalLease>totalFinance) {
			dlm.addElement("Leasing is a good option for you");
		}else {
			dlm.addElement("Financing is a good option for you");
		}
	}
	
	public void defaultComboBox(JComboBox<String> cbo) {
		String cboDefault[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		for(int i = 0; i<=10; i++) {
			cbo.addItem(cboDefault[i]);
		}
	}
	
	public void createEvents() {
		dlm.removeAllElements();
		lstResult.setModel(dlm);
		
		list.add(cbo1_1);
		list.add(cbo1_2);
		list.add(cbo2_1);
		list.add(cbo2_2);
		list.add(cbo3_1);
		list.add(cbo3_2);
		list.add(cbo4_1);
		list.add(cbo4_2);
		list.add(cbo5_1);
		list.add(cbo5_2);
		list.add(cbo6_1);
		list.add(cbo6_2);
		
		for(JComboBox a : list) {
			defaultComboBox(a);
		}
		
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getVehicleFrequency();
				getKilometres();
				getWarranty();
				getOwnership();
				getCustomization();
				getTaxAdvantage();
				display();
			}
		});
	}
	
	public void setUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 1006);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_3 = new JLabel("[ Vehicle Frequency]   If you...");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JLabel lblNewLabel_4 = new JLabel("1) Like having a new vehicle every 3-4 years with the latest reatures");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo1_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_5 = new JLabel("Your points");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4_1 = new JLabel("2) Typically drive your vehicles for 5-10 years");
		lblNewLabel_4_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo1_2 = new JComboBox<String>();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(cbo1_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cbo1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5)))
					.addGap(91))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(cbo1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1)
						.addComponent(cbo1_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Leasing or Buying? ");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Try to answer the questions below, then you can get our recommendation!");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 709, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("2) Drive more than 24,000 kilometres annually");
		lblNewLabel_4_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo2_2 = new JComboBox<String>();
		
		JLabel lblNewLabel_4_2 = new JLabel("1) Drive less than 24,000 kilometres annually");
		lblNewLabel_4_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo2_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_3_1 = new JLabel("[Kilometres]   If you...");
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(cbo2_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_2)
							.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
							.addComponent(cbo2_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1, Alignment.LEADING))
					.addGap(91))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2)
						.addComponent(cbo2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1_1)
						.addComponent(cbo2_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("2) Do not mind your vehicle out of warranty");
		lblNewLabel_4_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo3_2 = new JComboBox<String>();
		
		JLabel lblNewLabel_4_2_1 = new JLabel("1) Like having your vehicle under warranty");
		lblNewLabel_4_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo3_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_3_1_1 = new JLabel("[Warranty]   If you...");
		lblNewLabel_3_1_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panel_2_1_1 = new GroupLayout(panel_2_1_1);
		gl_panel_2_1_1.setHorizontalGroup(
			gl_panel_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 766, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_1_1_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(cbo3_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_2_1)
							.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
							.addComponent(cbo3_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1_1, Alignment.LEADING))
					.addGap(91))
		);
		gl_panel_2_1_1.setVerticalGroup(
			gl_panel_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 104, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2_1)
						.addComponent(cbo3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel_2_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1_1_1)
						.addComponent(cbo3_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_2_1_1.setLayout(gl_panel_2_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("2) Usually keep your vehicle after the loan is paid off");
		lblNewLabel_4_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo4_2 = new JComboBox<String>();
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("1) Are not concerned with owning a vehicle");
		lblNewLabel_4_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo4_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("[Ownership]   If you...");
		lblNewLabel_3_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel(" -\r\nwant to own your vehicle outright");
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		GroupLayout gl_panel_2_1_1_1 = new GroupLayout(panel_2_1_1_1);
		gl_panel_2_1_1_1.setHorizontalGroup(
			gl_panel_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2_1_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_2_1_1)
							.addPreferredGap(ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
							.addComponent(cbo4_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(82))
						.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_3_1_1_1)
							.addContainerGap(624, Short.MAX_VALUE))
						.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_1_1_1_1, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNewLabel_4_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
					.addComponent(cbo4_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		gl_panel_2_1_1_1.setVerticalGroup(
			gl_panel_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2_1_1)
						.addComponent(cbo4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4_1_1_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbo4_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		panel_2_1_1_1.setLayout(gl_panel_2_1_1_1);
		
		JPanel panel_2_1_1_2 = new JPanel();
		panel_2_1_1_2.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("2) Like to modify or customize your vehicle's appearance");
		lblNewLabel_4_1_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo5_2 = new JComboBox<String>();
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("1) Keep your vehicle as delivered and will not customize it");
		lblNewLabel_4_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo5_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("[Customization]   If you...");
		lblNewLabel_3_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panel_2_1_1_2 = new GroupLayout(panel_2_1_1_2);
		gl_panel_2_1_1_2.setHorizontalGroup(
			gl_panel_2_1_1_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 766, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2_1_1_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2_1_1_2.createSequentialGroup()
							.addComponent(lblNewLabel_4_1_1_1_2, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cbo5_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1_1_2.createSequentialGroup()
							.addComponent(lblNewLabel_4_2_1_2, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
							.addComponent(cbo5_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1_1_2, Alignment.LEADING))
					.addGap(91))
		);
		gl_panel_2_1_1_2.setVerticalGroup(
			gl_panel_2_1_1_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 104, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1_1_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1_1_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2_1_2)
						.addComponent(cbo5_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel_2_1_1_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1_1_1_2)
						.addComponent(cbo5_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2_1_1_2.setLayout(gl_panel_2_1_1_2);
		
		JPanel panel_2_1_1_2_1 = new JPanel();
		panel_2_1_1_2_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("2) Do not qualify for tax advantages");
		lblNewLabel_4_1_1_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo6_2 = new JComboBox<String>();
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("1) Qualify for tax advantages when you lease as a business owner");
		lblNewLabel_4_2_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		cbo6_1 = new JComboBox<String>();
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("[Tax Advantage]   If you...");
		lblNewLabel_3_1_1_2_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panel_2_1_1_2_1 = new GroupLayout(panel_2_1_1_2_1);
		gl_panel_2_1_1_2_1.setHorizontalGroup(
			gl_panel_2_1_1_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 766, Short.MAX_VALUE)
				.addGap(0, 766, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_2_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2_1_1_2_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2_1_1_2_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cbo6_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2_1_1_2_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_2_1_2_1, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(cbo6_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1_1_2_1, Alignment.LEADING))
					.addGap(91))
		);
		gl_panel_2_1_1_2_1.setVerticalGroup(
			gl_panel_2_1_1_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 104, Short.MAX_VALUE)
				.addGap(0, 104, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1_1_2_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2_1_1_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_2_1_2_1)
						.addComponent(cbo6_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_panel_2_1_1_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4_1_1_1_2_1)
						.addComponent(cbo6_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2_1_1_2_1.setLayout(gl_panel_2_1_1_2_1);
		
		btnShowResult = new JButton("Show Result");
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 766, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(panel_2_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addGap(118))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(537, Short.MAX_VALUE)
					.addComponent(btnShowResult, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(512))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnShowResult, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
		);
		
		JLabel lblNewLabel_2 = new JLabel("Our recommendation is : ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		lstResult = new JList<String>();
		scrollPane.setViewportView(lstResult);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public MainApp() {
		setResizable(false);
		setBackground(SystemColor.window);
		setTitle("Lease a car VS Finance a car");
		setUp();
		createEvents();
		
	}
}
