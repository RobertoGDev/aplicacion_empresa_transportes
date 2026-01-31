package Testing;

import java.util.ArrayList;

import Modelo.javabean.Vehiculo;
import Modelo.javabean.Camion;
import Modelo.javabean.Furgoneta;

public class TestHerencia {
	

	static ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

	public static void main(String[] args) {
//		testlistarVehiculos();
//		testMostrarCarga();
		testMostrarCargaDisponible();
	}
	
	private static void crearListaVehiculos() {
	
		listaVehiculos.add(0, new Camion("5637HSF", "Man", "TGM", 175_300.0, 26.4, 8_400.0, 4_300.30, 4));
		listaVehiculos.add(new Camion("2324HDS", "DAF", "XG+", 172_200.0, 25.3, 7_600.0, 5_223.34, 4));
		listaVehiculos.add(new Camion("1231MDF", "Mercedes", "Econic", 134_200.0, 20.3, 5_600.0, 5_600.0, 3));
		listaVehiculos.add(new Camion("0944LGS", "DAF", "XB", 572_200.0, 21.3, 2_200.0, 2_092.0, 3));
		listaVehiculos.add(new Furgoneta("2323MGA", "Iveco", "Daily", 24_400.0, 8.2, 7.0, 4.5));
		listaVehiculos.add(new Furgoneta("4528FSB", "Volkswagen", "Transporter", 274_300.0, 9.2, 5.0, 4.9));
		listaVehiculos.add(new Furgoneta("7234LSB", "Mercedes", "Sprinter", 122_400.0, 12.2, 8.0, 7.1));
		listaVehiculos.add(new Furgoneta("6233LFX", "Peugeot", "Crafter", 102_400.0, 13.6, 8.0, 8.0));
		
	}
	
	private static void testlistarVehiculos() {
		
		crearListaVehiculos();
		
		System.out.println("LISTA DE VEHICULOS ::::::::::::::\n");
		for(Vehiculo veh: listaVehiculos) {
			System.out.println(veh);
		}
	}
	
	private static void testMostrarCarga() {
		
		crearListaVehiculos();
		
		System.out.println("\nCARGA DE LOS VEHÍCULOS ::::::::::::::\n");
		for(Vehiculo veh: listaVehiculos) {
			if(veh instanceof Camion cam) {				
				System.out.println("Camión: " + cam.getMatricula() +
						" | Carga en KG: " + cam.getCapacidadCargaKg() + "kg." + 
						" | Carga ocupada: " + cam.getCargaOcupadaKg() + "kg."
						);
			} else if (veh instanceof Furgoneta fur) {
				System.out.println(
						"Furgoneta: " + fur.getMatricula() + 
						" | Volumen m³: " + fur.getVolumenCargaM3() + "m³" + 
						" | Carga ocupada: " + fur.getVolumenOcupadoM3() + "m³." 
						);				
			}
		}
	}
	
	private static void testMostrarCargaDisponible() {
		
		crearListaVehiculos();
		
		System.out.println("\nCARGA DISPONIBLE ::::::::::::::\n");
		for(Vehiculo veh: listaVehiculos) {
			if(veh instanceof Camion cam) {				
				System.out.println(
						"Camión: " + cam.getMatricula() + 
						" | Carga disponible: " + cam.cargaDisponible() + "kg."
						);
			} else if (veh instanceof Furgoneta fur) {
				System.out.println(
						"Furgoneta: " + fur.getMatricula() + 
						" | Carga disponible: " + fur.cargaDisponible() + "m³."
						);				
			}
		}
	}
}
