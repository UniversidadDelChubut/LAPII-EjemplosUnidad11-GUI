package TableModel;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class VentanaAlumnos extends JFrame {

	List <Alumno> alumnos;
	
	public VentanaAlumnos(List <Alumno> alumnos) {
		super("Alumnos");
		this.alumnos = alumnos;
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		JTable tabla = new JTable( new MyTableModel() );
		
		panel.add(tabla);
		this.setContentPane(panel);
		
		this.setSize(450, 450);
		
		this.setVisible(true);
	
	///Me dibujo
		
		
		
		
	}

	
	private void mostrarError(String error){
		JOptionPane.showMessageDialog(this, "ERROR: " +  error);
	}
	
	
	class MyTableModel implements TableModel{

		@Override
		public int getRowCount() {
			return VentanaAlumnos.this.alumnos.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
				case 0: return "Nombre";
				case 1: return "Legajo";
				case 2: return "Promedio";
				default: return null;
			}
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
				case 0: return String.class;
				case 1: return Integer.class;
				case 2: return Double.class;
				default: return null;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 2)
				return true;
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Alumno alumno = VentanaAlumnos.this.alumnos.get(rowIndex);
			switch (columnIndex) {
				case 0: return alumno.getNombre();
				case 1: return alumno.getLegajo();
				case 2: return alumno.getNotaPromedio();
				default: return null;
			}
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			Alumno alumno = VentanaAlumnos.this.alumnos.get(rowIndex);
			if (columnIndex != 2)
				return;
			Double valor = (Double) aValue;
			
			
			try {
				alumno.setNotaPromedio(valor);
			} catch (EscuelaException e) {
				
				VentanaAlumnos.this.mostrarError(e.getMessage());
				
			}
			
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}


