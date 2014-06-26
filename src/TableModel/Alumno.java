package TableModel;

public class Alumno {
	
	private String nombre;
	private Integer legajo;
	private Double notaPromedio;
	
	
	public Alumno(String nombre, Integer legajo, Double notaPromedio) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.notaPromedio = notaPromedio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public Double getNotaPromedio() {
		return notaPromedio;
	}
	public void setNotaPromedio(Double notaPromedio)  throws EscuelaException {
		
		if (notaPromedio <0 || notaPromedio > 10) {
			throw new EscuelaException("Nota no válida " + notaPromedio);
		}
		
		this.notaPromedio = notaPromedio;
	}
	
	
	
}
