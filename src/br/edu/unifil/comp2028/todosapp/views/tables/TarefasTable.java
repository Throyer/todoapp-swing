package br.edu.unifil.comp2028.todosapp.views.tables;

import javax.swing.table.AbstractTableModel;

public class TarefasTable extends AbstractTableModel{

	private String[] columnNames = {"#", "descrição", "prazo", "categorias", "feita?"};

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}
		

	@Override
	public String getColumnName(int column) {		
		return columnNames[column];
	}
	
}
