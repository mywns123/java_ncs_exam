package java_ncs_exam.content;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.EmptyTfException;
import java_ncs_exam.exception.InValidationException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {
	private JTextField tfNo;
	private JTextField tfName;	

	public TitlePanel() {
		initialize();		
	}

	private void initialize() {
		setLayout(new BorderLayout(10, 10));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblNo = new JLabel("¹øÈ£");
		lblNo.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(((JFormattedTextField)e.getSource()).getText().length()>2)
					throw new InValidationException();
			}
		});
		tfNo.setColumns(10);
		
		panel_4.add(tfNo);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblName = new JLabel("Á÷Ã¥");
		lblName.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblName);
		
		tfName = new JTextField();		
		/*
		 * tfName.addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) { char c = e.getKeyChar();
		 * 
		 * if (!Character.isDigit(c)) { e.consume(); return; } } });
		 */
		
		tfName.setColumns(10);
		
		panel_5.add(tfName);
	}

	
	public void setItem(Title title) {
		tfNo.setText(title.getNo()+"");
		tfName.setText(title.getName()+"");
	}
	
	public Title getItem() {
		validCheck();
		int no = Integer.parseInt(tfNo.getText().trim());
		String name = tfName.getText().trim();
		return new Title(no, name);
	}

	private void validCheck() {
		if (tfNo.getText().contentEquals("") || tfName.getText().equals("")) {
			throw new EmptyTfException(); 
		}		
	}
	
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
	}
}
