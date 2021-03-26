package java_ncs_exam.content;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.NotSelectedException;

import javax.swing.JScrollPane;
import java.awt.GridLayout;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TitleTable extends JPanel {
	private JTable table;
	private List<Title> list;
	
	public TitleTable() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setOpaque(false);
		table.setModel(getModel());
		scrollPane.setViewportView(table);		
	}
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel();
		return model;
	}

	public void loadData() {
		initList();
		setList();
	}
	
	public  void initList() {
		/*
		 * list = new Object[][] { {001, "사장"}, {002, "부장"}, {003, "과장"}, {004, "대리"},
		 * {005, "사원"}, {006, "인턴"}, };
		 */
	};
	
	public void setList() {
		Object[][] data = new Object[list.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		setAlignAndWidth();
	};
	
	protected void setAlignAndWidth() {
	// 컬럼내용 정렬
	setTableCellAlign(SwingConstants.CENTER, 0, 1);
	// 컬럼 너비 조정
	setTableCellWidth(100, 250);
	};
	protected void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public Object[] toArray(Title t) {
		return new Object[] { t.getNo(), t.getName() };
	}

	public String[] getColumnNames() {
		return new String[] { "번호", "직책" };
	}

	public Title getItem() {
		int row = table.getSelectedRow();
		int titleNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Title(titleNo)));
	}		
	
	public void setPopupMenu(JPopupMenu popMenu) {
		table.setComponentPopupMenu(popMenu);
	}	
	
	public Object[][] getData() {
		return new Object[][] { { null, null }, };
	}	
	
	private class CustomTableModel extends DefaultTableModel {
		public CustomTableModel() {
		}

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
		
}
