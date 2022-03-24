package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connJDBC.connJDBCpb;
import model.nhanvien;
import model.phongban;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPB extends JFrame {

	private JPanel contentPane;
	private JTextField txtMAPB;
	private JTextField txtTENPB;
	private  static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPB frame = new ViewPB();
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
	public ViewPB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ph\u00F2ng ban");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(443, 10, 164, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Ph\u00F2ng Ban");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 69, 148, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn Ph\u00F2ng Ban");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 138, 148, 28);
		contentPane.add(lblNewLabel_1_1);

		txtMAPB = new JTextField();
		txtMAPB.setBounds(248, 72, 273, 28);
		contentPane.add(txtMAPB);
		txtMAPB.setColumns(10);

		txtTENPB = new JTextField();
		txtTENPB.setColumns(10);
		txtTENPB.setBounds(248, 145, 273, 28);
		contentPane.add(txtTENPB);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 1046, 168);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
						"M\u00E3 Ph\u00F2ng Ban", "T\u00EAn Ph\u00F2ng Ban"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(141);
		table.getColumnModel().getColumn(1).setPreferredWidth(397);
		scrollPane.setViewportView(table);
		showData(connJDBCpb.FindAll());

		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phongban pb = new phongban();
				pb.setMAPB(txtMAPB.getText());
				pb.setTENPB(txtTENPB.getText());
				connJDBCpb.insert(pb);
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
				showData(connJDBCpb.FindAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(72, 417, 148, 44);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phongban pb = new phongban();
				pb.setMAPB(txtMAPB.getText());
				pb.setTENPB(txtTENPB.getText());
				connJDBCpb.update(pb);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				showData(connJDBCpb.FindAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSa.setBounds(459, 417, 148, 44);
		contentPane.add(btnSa);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phongban pb = new phongban();
				pb.setMAPB(txtMAPB.getText());
				connJDBCpb.delete(pb);
					JOptionPane.showMessageDialog(null, "Xóa Thành công");
				showData(connJDBCpb.FindAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXa.setBounds(844, 417, 148, 44);
		contentPane.add(btnXa);
	}
	public void showData(List<phongban>phongbanlt) {
		List<phongban>listphongban = new ArrayList<>();
		listphongban = phongbanlt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listphongban.forEach((phongban)-> {
			tableModel.addRow(new Object [] {
					phongban.getMAPB(),phongban.getTENPB()
			});

		});
	}
}
