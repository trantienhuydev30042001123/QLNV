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

import connJDBC.connJDBCpc;
import model.phancong;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPC extends JFrame {

	private JPanel contentPane;
	private JTextField txtMANV;
	private JTextField txtMADA;
	private JTextField txtSOGIO;
	private  static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPC frame = new ViewPC();
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
	public ViewPC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ph\u00E2n C\u00F4ng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(456, 10, 136, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 69, 121, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 D\u1EF1 \u00C1n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 147, 121, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 Gi\u1EDD");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 234, 121, 28);
		contentPane.add(lblNewLabel_1_2);
		
		txtMANV = new JTextField();
		txtMANV.setBounds(206, 69, 233, 34);
		contentPane.add(txtMANV);
		txtMANV.setColumns(10);
		
		txtMADA = new JTextField();
		txtMADA.setColumns(10);
		txtMADA.setBounds(206, 147, 233, 34);
		contentPane.add(txtMADA);
		
		txtSOGIO = new JTextField();
		txtSOGIO.setColumns(10);
		txtSOGIO.setBounds(206, 234, 233, 34);
		contentPane.add(txtSOGIO);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 289, 1033, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 D\u1EF1 \u00C1n", "S\u1ED1 Gi\u1EDD"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setPreferredWidth(148);
		table.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane.setViewportView(table);
		showData(connJDBCpc.FindAll());
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phancong pc =  new phancong();
				pc.setMANV(txtMANV.getText());
				pc.setMADA(txtMADA.getText());
				pc.setSOGIO(Integer.parseInt(txtSOGIO.getText()));
				connJDBCpc.insert(pc);
				JOptionPane.showMessageDialog(null, "Them thanh cong");
				showData(connJDBCpc.FindAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(76, 504, 136, 42);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phancong pc = new phancong();
				pc.setMANV(txtMANV.getText());
				pc.setMADA(txtMADA.getText());
				pc.setSOGIO(Integer.parseInt(txtSOGIO.getText()));
				connJDBCpc.update(pc);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				showData(connJDBCpc.FindAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSa.setBounds(456, 504, 136, 42);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phancong pc = new phancong();
				pc.setMANV(txtMANV.getText());
				pc.setMADA(txtMADA.getText());
				connJDBCpc.delete(pc);
				JOptionPane.showMessageDialog(null, "Xóa Thành công");
				showData(connJDBCpc.FindAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXa.setBounds(845, 504, 136, 42);
		contentPane.add(btnXa);
	}
	public void showData(List<phancong>phanconglt) {
		List<phancong>listphancong = new ArrayList<>();
		listphancong = phanconglt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel= (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listphancong.forEach((phancong)->{
			tableModel.addRow(new Object [] {
					phancong.getMANV(),phancong.getMADA(),phancong.getSOGIO()
			});
		});
	}
}
