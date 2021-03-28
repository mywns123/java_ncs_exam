package java_ncs_exam.control;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.content.TitleTable;
import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.EmptyTfException;
import java_ncs_exam.exception.InValidationException;
import java_ncs_exam.exception.NotSelectedException;
import java_ncs_exam.service.TitleService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Management extends JFrame implements ActionListener {

	private TitleService service;
	private JPanel contentPane;
	private JButton btnClear;
	private JButton btnAdd;
	private TitlePanel pPanel;
	private TitleTable pTable;	
	
	public Management() {
		setService();
		initialize();
		tableLoadData();		
	}
		
	private void initialize() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("��å ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pPanel = new TitlePanel();
		BorderLayout bl_pPanel = (BorderLayout) pPanel.getLayout();
		bl_pPanel.setVgap(0);
		bl_pPanel.setHgap(0);
		contentPane.add(pPanel);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("�߰�");		
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("����", Font.BOLD, 12));
		pBtn.add(btnAdd);
		
		btnClear = new JButton("���");	
		btnClear.addActionListener(this);
		btnClear.setFont(new Font("����", Font.BOLD, 12));
		pBtn.add(btnClear);
		
		pTable = new TitleTable();
		contentPane.add(pTable);
		
		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("�μ� ����");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("�μ� ����");
		deleteItem.addActionListener(this);
		popMenu.add(deleteItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("�μ� ����")) {
					actionPerformdMenuDelete();
				}
				if (e.getActionCommand().equals("�μ� ����")) {
					actionPerformdMenuUpdate();
				}				
			} else {
				if (e.getSource() == btnClear) {
					actionPerformedBtnClear(e);
				}
				if (e.getSource() == btnAdd) {
					if (e.getActionCommand().contentEquals("�߰�")) {
						actionPerformedBtnAdd(e);
					} else {
						actionPerformedBtnUpdate(e);
					}
				}
			}
		}catch (InValidationException | EmptyTfException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		}catch (NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void setService() {
		service = new TitleService();
	};

	protected void tableLoadData() {
		pTable.setService(service);
		pTable.loadData();
	};

	protected void actionPerformdMenuUpdate() {
		Title updateTitle = pTable.getItem();
		pPanel.setItem(updateTitle);
		btnAdd.setText("����");
	};

	protected void actionPerformdMenuDelete() {
		Title title = pTable.getItem();
		service.removeTitle(title);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, title + "���� �Ǿ����ϴ�.");
	};

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Title updateTitle = pPanel.getItem();
		service.modifyTitle(updateTitle);
		pTable.loadData();
		Title title = pPanel.getItem();
		pPanel.clearTf();
		btnAdd.setText("�߰�");
		JOptionPane.showMessageDialog(null, updateTitle + "��()��"+ title + "�� ����Ǿ����ϴ�.","INFORMATION_MESSAGE",  JOptionPane.INFORMATION_MESSAGE);
	};

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Title title = pPanel.getItem();
		service.addTitle(title);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, title + "��(��) �߰��Ǿ����ϴ�.","INFORMATION_MESSAGE",  JOptionPane.INFORMATION_MESSAGE);
	};

	protected void actionPerformedBtnClear(ActionEvent e) {
		pPanel.clearTf();

		if (btnAdd.getText().contentEquals("����")) {
			btnAdd.setText("�߰�");
		}
	}

}
