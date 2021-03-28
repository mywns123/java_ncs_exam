package java_ncs_exam;

import java.awt.EventQueue;

import java_ncs_exam.control.Management;

public class TitleMain{	

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

}
