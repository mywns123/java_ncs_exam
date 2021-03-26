package java_ncs_exam.control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java_ncs_exam.content.TitlePanel;
import javax.swing.BoxLayout;
import java_ncs_exam.content.TitleTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Management extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Management() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("직책 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		TitlePanel panel = new TitlePanel();
		BorderLayout borderLayout = (BorderLayout) panel.getLayout();
		borderLayout.setVgap(0);
		borderLayout.setHgap(0);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setFont(new Font("굴림", Font.BOLD, 12));
		panel_1.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setFont(new Font("굴림", Font.BOLD, 12));
		panel_1.add(btnClear);
		
		TitleTable panel_2 = new TitleTable();
		contentPane.add(panel_2);
	}

}
