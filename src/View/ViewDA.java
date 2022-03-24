package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connJDBC.connJDBCda;
import model.dean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ViewDA extends JFrame {

	private JPanel contentPane;
	private JTextField txtMADA;
	private JTextField txtTENDA;
	private JTextField txtDIADIEMDA;
	private JTextField txtMAPB;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDA frame = new ViewDA();
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
	public ViewDA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u1EC1 \u00C1n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(469, 10, 201, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 \u0110\u1EC1 \u00C1n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 96, 167, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn \u0110\u1EC1 \u00C1n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 189, 167, 33);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u1ECBa \u0110i\u1EC3m \u0110\u1EC1 \u00C1n");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(503, 96, 167, 33);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("M\u00E3 Ph\u00F2ng Ban");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(503, 189, 167, 33);
		contentPane.add(lblNewLabel_1_3);

		txtMADA = new JTextField();
		txtMADA.setBounds(201, 98, 216, 33);
		contentPane.add(txtMADA);
		txtMADA.setColumns(10);

		txtTENDA = new JTextField();
		txtTENDA.setColumns(10);
		txtTENDA.setBounds(201, 189, 216, 33);
		contentPane.add(txtTENDA);

		txtDIADIEMDA = new JTextField();
		txtDIADIEMDA.setColumns(10);
		txtDIADIEMDA.setBounds(718, 98, 216, 33);
		contentPane.add(txtDIADIEMDA);

		txtMAPB = new JTextField();
		txtMAPB.setColumns(10);
		txtMAPB.setBounds(718, 191, 216, 33);
		contentPane.add(txtMAPB);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 293, 1040, 168);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
						"M\u00E3 \u0110\u1EC1 \u00C1n", "T\u00EAn \u0110\u1EC1 \u00C1n", "\u0110\u1ECBa \u0110i\u1EC3m \u0110\u1EC1 \u00C1n", "M\u00E3 Ph\u00F2ng Ban"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(26);
		table.getColumnModel().getColumn(1).setPreferredWidth(194);
		table.getColumnModel().getColumn(2).setPreferredWidth(124);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		showData(connJDBCda.findAll());

		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dean da= new dean();
				da.setMADA(txtMADA.getText());
				da.setTENDA(txtTENDA.getText());
				da.setDIADIEMDA(txtDIADIEMDA.getText());
				da.setMAPB(txtMAPB.getText());
				connJDBCda.insert(da);
			    JOptionPane.showMessageDialog(null, "Thêm thành công!");
				showData(connJDBCda.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(71, 565, 142, 40);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dean da = new dean();
				da.setMADA(txtMADA.getText());
				da.setTENDA(txtTENDA.getText());
				da.setDIADIEMDA(txtDIADIEMDA.getText());
				da.setMAPB(txtMAPB.getText());
				connJDBCda.update(da);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				showData(connJDBCda.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSa.setBounds(442, 565, 142, 40);
		contentPane.add(btnSa);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dean da = new dean();
				da.setMADA(txtMADA.getText());
				connJDBCda.delete(da);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				showData(connJDBCda.findAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXa.setBounds(836, 565, 142, 40);
		contentPane.add(btnXa);
	}
	public void showData(List<dean>deanlt) {
		List<dean>listdean = new ArrayList<>();
		listdean = deanlt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listdean.forEach((dean)-> {
			tableModel.addRow(new Object [] {
					dean.getMADA(),dean.getTENDA(),dean.getDIADIEMDA(),dean.getMAPB()
			});
		});
	}
}
