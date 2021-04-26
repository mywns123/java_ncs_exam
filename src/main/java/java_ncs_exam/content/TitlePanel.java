package java_ncs_exam.content;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.EmptyTfException;
import java_ncs_exam.exception.InValidationException;

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
		
		JLabel lblNo = new JLabel("��ȣ");
		lblNo.setFont(new Font("����", Font.BOLD, 12));
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNo);
		
		tfNo = new JTextField();		
		tfNo.setColumns(10);		
		panel_4.add(tfNo);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblName = new JLabel("��å");
		lblName.setFont(new Font("����", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblName);
		
		tfName = new JTextField();		
		tfName.setColumns(10);		
		panel_5.add(tfName);
	}

	
	public void setItem(Title title) {
		tfNo.setText(title.getNo()+"");
		tfName.setText(title.getName()+"");
	}
	
	public Title getItem() {
		validCheck();
		check();
		int no = Integer.parseInt(tfNo.getText().trim());
		String name = tfName.getText().trim();
		return new Title(no, name);
	}

	private void check() {
		Pattern p =Pattern.compile("^[가-힣]*$");
		String s = tfName.getText();		
		Matcher m = p.matcher(s);
		if(!m.find()) {
			throw new InValidationException();
		}
		
		Pattern p1 =Pattern.compile("^[0-9]*$");
		String n =tfNo.getText();
		Matcher m1 = p1.matcher(n);
		if(!m1.find()|n.length()>3) {
			throw new InValidationException();
		}		
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
