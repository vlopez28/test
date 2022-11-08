package TPEspecial;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Comparator compInt = new ComparadorInteger();
		
		ListaVinculada listaInt = new ListaVinculada(compInt);
		Integer int1 = 10;
		Integer int2 = 21;
		Integer int3 = 1;
		Integer int4 = 5;
		Integer int5 = 5;
		Integer int6 = 5;
		Integer int7 = 5;
		Integer int8 = 19;
		listaInt.insertar(int1);
		listaInt.insertar(int2);
		listaInt.insertar(int3);
		listaInt.insertar(int4);
		listaInt.insertar(int5);
		listaInt.insertar(int6);
		listaInt.insertar(int7);
		listaInt.insertar(int8);

	//	System.out.println("pos: "+listaInt.obtenerPosElem(int7));
	
		//System.out.println(listaInt.verTamanio());
		System.out.println(listaInt.imprimirLista());
		
		
        for (Comparable i:listaInt)
            System.out.println(i+",");
    
		Comparator compIntDesc = new ComparadorIntDescendente();
		listaInt.setComparador(compIntDesc);
		System.out.println(listaInt.imprimirLista());
		
		listaInt.setComparador(compInt);
		System.out.println(listaInt.imprimirLista());
		//listaInt.eliminarTodasOcurrencias(5);
		//System.out.println(listaInt.imprimirLista()+"----------");

		//System.out.println(listaInt.verTamanio());
	//	listaInt.eliminarTodasOcurrencias(int1);
	//	System.out.println(listaInt.verTamanio());
		
		String pal1="Facil";
		String pal2 = "Es";
		String pal3 = "Parcial";
		String pal4 = "Prog 2";
		String pal5="Facil";
		String pal6="Facil";
		String pal7="Facil";
		String pal8="Facil";
		
		Comparator comp3 = new ComparadorStringAscendente();
		ListaVinculada lista = new ListaVinculada(comp3);
		
		//System.out.println(lista.estaVaciaLista());
		
		
		
		lista.insertar(pal1);
		lista.insertar(pal2);
		lista.insertar(pal3);
		lista.insertar(pal4);
		lista.insertar(pal5);
		lista.insertar(pal6);
		lista.insertar(pal7);
		lista.insertar(pal8);
		
		
		//System.out.println("tamanio "+lista.verTamanio());
		System.out.println(lista.imprimirLista());
		
		for (Comparable i:lista) {
            System.out.println(i+",");
		}
		//System.out.println("posicion: "+lista.obtenerPosElem(pal5));
		
		//lista.eliminarTodasOcurrencias("Facil");
	//	System.out.println(lista.imprimirLista()+"\n--------------");
		Comparator compStringDesc = new ComparadorStringDescendente();
		lista.setComparador(compStringDesc);
		System.out.println(lista.imprimirLista()+"\n--------------");
		
		//System.out.println(lista.eliminarEnPosicion(3));
		//System.out.println(lista.imprimirLista());
		//System.out.println("tamanio "+lista.verTamanio());
		//lista.eliminarTodasOcurrencias(pal5);
		//System.out.println(lista.imprimirLista());
		//System.out.println("tamanio "+lista.verTamanio());
		//System.out.println(lista.obtenerObjeto(0));
		//System.out.println(lista.obtenerObjeto(1));
		//System.out.println(lista.obtenerObjeto(2));
		//System.out.println(lista.obtenerObjeto(6));
		
		//System.out.println(lista.verTamanio());
		
		
		Alumno a1 = new Alumno("vicky", "lopez", 4567, 25);
		Alumno a2 = new Alumno("pepe", "lopez", 5432, 34);
		Alumno a3 = new Alumno("luis", "perez", 3333, 33);
		Alumno a4 = new Alumno("juan", "gomez", 2143, 22);
		Alumno a5 = new Alumno("pedro", "sanchez", 45745, 44);
		
		Comparator comp4 = new ComparadorEdad();
		ListaVinculada listaAlumno = new ListaVinculada(comp4);
		//listaAlumno.insertar(a1); // para que me inserte el alumno lo tuve que declarar comparable
		//listaAlumno.insertar(a5);//redefino el compareTo para q no falle pero ;luego solo usa el comparador
		//listaAlumno.insertar(a3);
		//listaAlumno.insertar(a4);
		
		
		//System.out.println(listaAlumno.imprimirLista());
		//listaAlumno.eliminarEnPosicionMejorado(0);
		//listaAlumno.eliminarTodasOcurrencias(a2);
		//System.out.println(listaAlumno.imprimirLista());
		//System.out.println("posicion: "+listaAlumno.obtenerPosElem(a5));
	}

}