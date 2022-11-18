package TPEspecial;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		//Punto 4 a)
		Comparator<Integer> compInt = new ComparadorInteger();
		ListaVinculada<Integer> listaInt = new ListaVinculada<Integer>(compInt);
		
		Integer int1 = 10;
		Integer int2 = 21;
		Integer int3 = 1;
		Integer int4 = 5;
		Integer int5 = 11;
		
		listaInt.insertar(int1);
		listaInt.insertar(int2);
		listaInt.insertar(int3);
		listaInt.insertar(int4);
		listaInt.insertar(int5);
		
		//Punto 4b)
        for (Integer i:listaInt) 
            System.out.println(i);
        System.out.println("---------------------------");
        
        //Punto 4 c)
        listaInt.eliminarEnPosicion(0);
        listaInt.eliminarTodasOcurrencias(5);
        listaInt.eliminarTodasOcurrencias(11);
      
        for (Integer i:listaInt)
            System.out.println(i);
        
        System.out.println("---------------------------");
        
        //Punto 4 d)
		String pal1="Facil";
		String pal2 = "Es";
		String pal3 = "Parcial";
		String pal4 = "Prog 2";
		
		Comparator<String> compString = new ComparadorString();
		ListaVinculada<String> lista = new ListaVinculada<String>(compString);
		
		lista.insertar(pal1);
		lista.insertar(pal2);
		lista.insertar(pal3);
		lista.insertar(pal4);
		
		//Punto 4 e)
		for (String i:lista) {
            System.out.println(i);
		}
		System.out.println("---------------------------");
		
		//Punto 4 f)
		System.out.println("posicion de palabra 'Parcial': "+lista.obtenerPosElem("Parcial"));
		
		//Punto 4 g)
		System.out.println("posicion de palabra 'Recuperatorio': "+lista.obtenerPosElem("Recuperatorio"));
		System.out.println("---------------------------");
		
		
		//Punto 4 h)
		Comparator<String> compNot2 = new ComparadorNotGenerico<String>(compString);
		lista.setComparador(compNot2);
		
		for (String i:lista) {
            System.out.println(i);
		}
		System.out.println("---------------------------");
		
		//Punto 4 i)
		//------Composite 1
		
		Alumno a1 = new Alumno("Federico", "Lopez", 35999888, 25);
		a1.addInteres("redes");
		a1.addInteres("php");
		a1.addInteres("java");
		a1.addInteres("Python");
		
		Alumno a2 = new Alumno("Juana", "Garcia", 27123455, 34);
		a2.addInteres("programacion");
		a2.addInteres("php");
		a2.addInteres("java");
		
		Grupo exactas = new Grupo("Exactas");
		exactas.addElem(a1);
		exactas.addElem(a2);
		
		Alumno a3 = new Alumno("Flora", "Rivas", 34555111, 33);
		a3.addInteres("historia");
		a3.addInteres("antigua");
		
		Alumno a4 = new Alumno("Martin", "Gomez", 34111222, 22);
		a4.addInteres("romanos");
		a4.addInteres("egipcios");
		a4.addInteres("griegos");
		
		Alumno a5 = new Alumno("Roman", "Bazan", 32555111, 44);
		a5.addInteres("argentina");
		
		Grupo historia = new Grupo("Historia");
		historia.addElem(a3);
		historia.addElem(a4);
		historia.addElem(a5);

		Alumno a6 = new Alumno("Mora", "Diaz", 37124425, 32);
		a6.addInteres("psicologia");
		a6.addInteres("Freud");
		
		Grupo humanas = new Grupo("Humanas");
		
		humanas.addElem(a6);
		humanas.addElem(historia);

		Alumno a7 = new Alumno("John", "Doe", 1200000, 39);
		a7.addInteres("intercambio");
		
		Grupo unicen = new Grupo("Unicen");
		
		unicen.addElem(exactas);
		unicen.addElem(humanas);
		unicen.addElem(a7);
		
		//---Composite 2
		
		Alumno a8 = new Alumno("Juan", "Juarez", 33222444, 44);
		a8.addInteres("sucesiones");
		a8.addInteres("algebra");
		
		Alumno a9 = new Alumno("Julio", "Cesar", 33222111, 34);
		a9.addInteres("sucesiones");
		a9.addInteres("algebra");
		
		Grupo matea2 = new Grupo("Matea2");
		matea2.addElem(a8);
		matea2.addElem(a9);
		
		Alumno a10 = new Alumno("Bernardino", "Rivas", 30987654, 35);
		a10.addInteres("matematicas");
		
		Alumno a11 = new Alumno("Jose", "Paso", 33322112, 24);
		a11.addInteres("problemas");
		a11.addInteres("sucesiones");
		
		Alumno a12 = new Alumno("Isaac", "Newton", 12343565, 33);
		a12.addInteres("sucesiones");
		
		Grupo losFibo = new Grupo("LosFibo");
		losFibo.addElem(a10);
		losFibo.addElem(a11);
		losFibo.addElem(a12);
		
		Grupo olimpiadasMatematicas = new Grupo("OlimpiadasMatematicas");
		olimpiadasMatematicas.addElem(losFibo);
		olimpiadasMatematicas.addElem(matea2);
		
		Comparator<ElementoUniversidad> cantAlumnos = new ComparadorCantAlumnos();
		ListaVinculada<ElementoUniversidad> listaUniversidad = new ListaVinculada<>(cantAlumnos);
		
		listaUniversidad.insertar(olimpiadasMatematicas);
		listaUniversidad.insertar(unicen);
		
		//Aunque no se pedia imprimo los elementos de la lista vinculada ordenada de mayor a menor segun
		//la cantidad de alumnos
		System.out.println(listaUniversidad);
		
	}

}