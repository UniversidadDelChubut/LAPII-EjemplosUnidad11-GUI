package TableModel;

import java.util.LinkedList;
import java.util.List;


public class Principal {
	
	
	public static void main(String[] args) {
		List <Alumno> alumnos =  new LinkedList<Alumno>();
		
		
		alumnos.add( new Alumno ("Juan", 123, 9.12));
		alumnos.add( new Alumno ("Matias", 124, 7.00));
		alumnos.add( new Alumno ("Juiana", 144, 6.50));
		alumnos.add( new Alumno ("Andrea", 156, 8.28));
		
		
		
		
		new VentanaAlumnos(alumnos);
	}
	

}


