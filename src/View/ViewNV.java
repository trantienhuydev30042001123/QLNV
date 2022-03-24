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

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import connJDBC.connJDBCnv;
import model.nhanvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewNV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMANV;
	private JTextField txtTENNV;
	private JTextField txtLUONG;
	private JTextField txtNGAYSINH;
	private JTextField txtDIACHI;
	private JTextField txtMAPB;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNV frame = new ViewNV();
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
	public ViewNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD Nh\u00E2n vi\u00EAn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(385, 10, 244, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 54, 115, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn Nh\u00E2n Vi\u00EAn");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 114, 115, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(351, 54, 115, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ng\u00E0y Sinh");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(351, 114, 115, 35);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00E3 Ph\u00F2ng Ban");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(662, 114, 115, 35);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(662, 54, 115, 35);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_6.setBounds(10, 174, 115, 35);
		contentPane.add(lblNewLabel_1_6);
		
		txtMANV = new JTextField();
		txtMANV.setBounds(135, 56, 206, 35);
		contentPane.add(txtMANV);
		txtMANV.setColumns(10);
		
		txtTENNV = new JTextField();
		txtTENNV.setColumns(10);
		txtTENNV.setBounds(135, 114, 206, 35);
		contentPane.add(txtTENNV);
		
		txtLUONG = new JTextField();
		txtLUONG.setColumns(10);
		txtLUONG.setBounds(438, 56, 206, 35);
		contentPane.add(txtLUONG);
		
		txtNGAYSINH = new JTextField();
		txtNGAYSINH.setColumns(10);
		txtNGAYSINH.setBounds(438, 116, 206, 35);
		contentPane.add(txtNGAYSINH);
		
		txtDIACHI = new JTextField();
		txtDIACHI.setColumns(10);
		txtDIACHI.setBounds(795, 56, 206, 35);
		contentPane.add(txtDIACHI);
		
		txtMAPB = new JTextField();
		txtMAPB.setColumns(10);
		txtMAPB.setBounds(795, 116, 206, 35);
		contentPane.add(txtMAPB);
		
		JComboBox CBGIOITINH = new JComboBox();
		CBGIOITINH.setFont(new Font("Tahoma", Font.BOLD, 18));
		CBGIOITINH.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		CBGIOITINH.setBounds(135, 174, 206, 35);
		contentPane.add(CBGIOITINH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 1001, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Gi\u1EDBi T\u00EDnh", "L\u01B0\u01A1ng", "Ng\u00E0y Sinh", "\u0110\u1ECBa Ch\u1EC9", "M\u00E3 Ph\u00F2ng Ban"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(2).setPreferredWidth(54);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(63);
		table.getColumnModel().getColumn(5).setPreferredWidth(154);
		scrollPane.setViewportView(table);
		showData(connJDBCnv.finALL());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 219, 1001, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien nv = new nhanvien();
				nv.setMANV(txtMANV.getText());
				nv.setTENNV(txtTENNV.getText());
				nv.setGIOITINH(CBGIOITINH.getSelectedIndex());
				nv.setLUONG(Float.parseFloat(txtLUONG.getText()));
				nv.setNGAYSINH(txtNGAYSINH.getText());
				nv.setDIACHI(txtDIACHI.getText());
				nv.setMAPB(txtMAPB.getText());
				connJDBCnv.insert(nv);
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				showData(connJDBCnv.finALL());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton.setBounds(70, 473, 130, 35);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien nv = new nhanvien();
				nv.setMANV(txtMANV.getText());
				nv.setTENNV(txtTENNV.getText());
				nv.setGIOITINH(CBGIOITINH.getSelectedIndex());
				nv.setLUONG(Float.parseFloat(txtLUONG.getText()));
				nv.setNGAYSINH(txtNGAYSINH.getText());
				nv.setDIACHI(txtDIACHI.getText());
				nv.setMAPB(txtMAPB.getText());
				connJDBCnv.update(nv);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				showData(connJDBCnv.finALL());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnSa.setBounds(438, 473, 130, 35);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien nv = new nhanvien();
				nv.setMANV(txtMANV.getText());
				connJDBCnv.delete(nv);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				showData(connJDBCnv.finALL());
				
			}
		});
		btnXa.setFont(new Font("Times NLew Roman", Font.BOLD, 23));
		btnXa.setBounds(812, 473, 130, 35);
		contentPane.add(btnXa);
	}
	public void showData(List<nhanvien>nhanvienlt) {
		List<nhanvien>listnhanvien = new ArrayList<>();
		listnhanvien = nhanvienlt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listnhanvien.forEach((nhanvien)-> {
			String GIOITINH;
			if (nhanvien.getGIOITINH()==0)GIOITINH="Nam";
			else{GIOITINH="Nữ";}
			tableModel.addRow(new Object [] {
					nhanvien.getMANV(),nhanvien.getTENNV(),GIOITINH,nhanvien.getLUONG(),nhanvien.getNGAYSINH(),nhanvien.getDIACHI(),nhanvien.getMAPB()
			});

		});
		this.setVisible(true);
	}
}
