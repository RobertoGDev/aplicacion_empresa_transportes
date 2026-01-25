package Testing;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Modelo.javabean.Camion;
import Modelo.javabean.Empleado;
import Modelo.javabean.Furgoneta;
import Modelo.javabean.Ruta;

import Modelo.negocio.GestionRutas;

public class TestGestionRutas {

//    private static IGestionRutas irutas;
    private static Scanner leer;
	private static Ruta ruta;
	private static GestionRutas gestion;

	static {
		gestion = new GestionRutas();
	}

    
    public static void main(String[] args) {
    	
    	// Ruta para test
    	Camion camion4 = new Camion("4523MDF", "Volvo", "FM/FH", 123_300.0, 22.3, 5_600.0, 3_600.0, 3);
    	Empleado empleado1 = new Empleado("34234423b", "Santiago", "Cucudrulu", "acucudrulu@gmail.com", "H");
    	ruta = new Ruta(17, LocalDate.of(2025, 1, 25), "Madrid", "Badajoz", camion4, empleado1, 354.3, 1_322);
        
    	// Probar los métodos
    	
//    	testVerRutas(); // Ejecutar este método a demanda, para poder comparar los resultados
//		testAddRuta();
//		testEliminarRutaObjeto();
//		testEliminarRutaId();
//		testRutasPorEmpleado();
//		testRutasPorVehiculo();
//		testTotalKmPorVehiculo();
//		testRutasPorDestino();
//		testRutasIntervaloFechas();
//		testTotalKmPorTipoVehiculo();
    	
    	testTipoRuta();
//    	testCalcularConsumoMedio();
        
    }
    
    // Método para inyectar la ruta extra
    private static void creaRutaTest() {
    	gestion.addRuta(ruta);
	}
    private static void testVerRutas() {
    	for(Ruta rut:gestion.listaRutas){
        	System.out.println(rut);
        }
    }
    // Método para imprimir rutas
    private static void imprimeRutas(String tipo) {
    	if(tipo == "antes")
    		System.out.println("\nRUTAS ANTERIORMENTE DEFINIDAS ::::::::::::\n");
    		else if (tipo == "despues")
    			System.out.println("\nRUTAS ACTUALIZADAS ::::::::::::\n");  
    	
    	testVerRutas();
    }

    
	// Método para probar addRuta
    public static void testAddRuta() {
    	imprimeRutas("antes");
        
    	creaRutaTest();
    	
    	imprimeRutas("despues");

    }

	// Método para probar eliminarRuta(Ruta)
    public static void testEliminarRutaObjeto() {   	
    	// Crea el objeto
    	creaRutaTest();
    	
    	imprimeRutas("antes");
        
        // Elimina
    	gestion.eliminarRuta(ruta);
    	
    	imprimeRutas("despues");
    }

    // Método para probar eliminarRuta(int)
    public static void testEliminarRutaId() {
    	
    	leer = new Scanner(System.in);
    	
    	int primerIndiceRutas = gestion.listaRutas.getFirst().getIdRuta();
    	int ultimoIndiceRutas = gestion.listaRutas.getLast().getIdRuta();
    	
    	System.out.println("Eliminar ruta por id");    	
    	System.out.println("Introduzca un id [" + primerIndiceRutas + "-" + ultimoIndiceRutas + "]"); 
    	
    	int indice = leer.nextInt();
    	
    	imprimeRutas("antes");
        
    	gestion.eliminarRuta(indice);
    	
    	imprimeRutas("despues");
    }

    
    // Método para probar rutasPorEmpleado
    public static void testRutasPorEmpleado() {

    	// Para facilitar la búsqueda de usuarios
    	ArrayList<String> listaDnis = new ArrayList<String>();
    	for(Ruta rut: gestion.listaRutas) {
    		String dni = rut.getEmpleado().getDni();
    		if (!listaDnis.contains(dni)) {
    			listaDnis.add(dni);
    		}
    	}
    	
    	System.out.println("Busque rutas por empleado:");
    	System.out.println("Introduzca un DNI del listado:");
    	for (String dni:listaDnis) {
    		System.out.println(dni);
    	}
    	
    	leer = new Scanner(System.in);
    	String dni = leer.next();
    	System.out.println("\nRESULTADOS ::::::::::::::");    	
    	for(Ruta el: gestion.rutasPorEmpleado(dni)) {
    		System.out.println(el);
    	}
    	leer.close();
    	
    }

    // Método para probar rutarPorVehiculo
    public static void testRutasPorVehiculo() {
    	
    	// Para facilitar la búsqueda de vehiculos
    	ArrayList<String> listaVehiculos = new ArrayList<String>();
    	for(Ruta rut: gestion.listaRutas) {
    		String matricula = rut.getVehiculoUsado().getMatricula();
    		if (!listaVehiculos.contains(matricula)) {
    			listaVehiculos.add(matricula);
    		}
    	}
    	
    	System.out.println("Busque rutas por vehículo:");
    	System.out.println("Introduzca una matrícula del listado:");
    	for (String mat:listaVehiculos) {
    		System.out.println(mat);
    	}
    	
    	leer = new Scanner(System.in);
    	String tipo = leer.next();
    	System.out.println("\nRESULTADOS PARA "+ tipo +"::::::::::::::");    	
    	for(Ruta el: gestion.rutasPorVehiculo(tipo)) {
    		System.out.println(el);
    	}
    	leer.close();
    }

    // Método para probar totalKmPorVehiculo
    public static void testTotalKmPorVehiculo() {
    	
    	System.out.println("TOTAL KM POR VEHICULO");    	
    	
    	gestion.totalKmPorVehiculo().forEach((matricula, km) -> {
    		System.out.println(matricula + " tiene: " + km + "km");
    	});;
    	
    }

    // Método para probar rutasPorDestino
    public static void testRutasPorDestino() {
    	
    	// Para facilitar la búsqueda de vehiculos
    	ArrayList<String> listaDestinos = new ArrayList<String>();
    	for(Ruta rut: gestion.listaRutas) {
    		String destino = rut.getDestino();
    		if (!listaDestinos.contains(destino)) {
    			listaDestinos.add(destino);
    		}
    	}
    	
    	
    	System.out.println("Busque rutas por destino:");
    	System.out.println("Introduzca un destino del listado:");
    	for (String des:listaDestinos) {
    		System.out.println(des);
    	}
    	
    	leer = new Scanner(System.in);
    	String destino = leer.next();
    	System.out.println("\nRESULTADOS PARA "+ destino.toUpperCase() +"::::::::::::::");    	
    	for(Ruta el: gestion.rutasPorDestino(destino)) {
    		System.out.println(el);
    	}
    	leer.close();
    }

    // Método para probar rutasIntervaloFechas
    public static void testRutasIntervaloFechas() {
    	
    	System.out.println("Busque rutas entre fechas:");
    	System.out.println("Introduzca la fecha de inicio (dd/MM/yyyy):");
    	leer = new Scanner(System.in);
    	String fechainicio = leer.next();
    	System.out.println("Introduzca la fecha de fin (dd/MM/yyyy):");
    	String fechafin = leer.next();
    	
    	// Así facilitamos las fechas a la española
    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	
    	LocalDate fechaInicioParsed = LocalDate.parse(fechainicio, formateador);
    	LocalDate fechaFinParsed = LocalDate.parse(fechafin, formateador);
    	
    	for(Ruta rut: gestion.rutasIntervaloFechas(fechaInicioParsed, fechaFinParsed)) {
    		System.out.println(rut);
    	}
    	leer.close();    	
    	
    }

    // Método para probar totalKmPorTipoVehiculo
    public static void testTotalKmPorTipoVehiculo() {
    	
    	System.out.println("\nTotal de Km por tipo de vehiculo:\n");
    	;
    	gestion.totalKmPorTipoVehiculo().forEach((tipo, km) -> {
    		System.out.println(tipo + " acumulan " + km + "km" );
    	});
    }
    
    
    public static void testTipoRuta() {
    	System.out.println("\nDistancia literal de ruta:\n");
    	for(Ruta el: gestion.listaRutas) {
    		System.out.println(el.getOrigenDestino() + ": " + el.tipoRuta());
    	}
    }
    
    public static void testCalcularConsumoMedio() {
    	System.out.println("\nConsumo medio por cada ruta:\n");
    	for(Ruta el: gestion.listaRutas) {
    		System.out.println(el.calcularConsumoEstimado());
    	}
    }
}
