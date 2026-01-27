package Modelo.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import Modelo.javabean.Camion;
import Modelo.javabean.Empleado;
import Modelo.javabean.Furgoneta;
import Modelo.javabean.Ruta;
import Modelo.javabean.Vehiculo;
import interfazes.IGestionRutas;

public class GestionRutas implements IGestionRutas {

	List<Ruta> rutas;

	public GestionRutas() {
		
		rutas = new ArrayList<Ruta>();
		cargaDatos();
		
	}
	
	// Helper para cargar datos inicializados
	public void cargaDatos() {
		
		Camion camion1 = new Camion("4634FRT", "Man", "TGM+", 146_400.0, 24.4, 8_400.0, 4_300.30, 4);
		Camion camion2 = new Camion("5637HSF", "Man", "TGM", 175_300.0, 26.4, 8_400.0, 4_300.30, 4);
		Camion camion3 = new Camion("2324HDS", "DAF", "XG+", 172_200.0, 25.3, 7_600.0, 5_223.34, 4);
		Camion camion4 = new Camion("1231MDF", "Mercedes", "Econic", 134_200.0, 20.3, 5_600.0, 5_600.0, 3);
		Camion camion5 = new Camion("0944LGS", "DAF", "XB", 572_200.0, 21.3, 2_200.0, 2_092.0, 3);
		Furgoneta furgon1 = new Furgoneta("2323MGA", "Iveco", "Daily", 24_400.0, 8.2, 7.0, 4.5);
		Furgoneta furgon2 = new Furgoneta("4528FSB", "Volkswagen", "Transporter", 274_300.0, 9.2, 5.0, 4.9);
		Furgoneta furgon3 = new Furgoneta("7234LSB", "Mercedes", "Sprinter", 122_400.0, 12.2, 8.0, 7.1);
		Furgoneta furgon4 = new Furgoneta("6233LFX", "Peugeot", "Crafter", 102_400.0, 13.6, 8.0, 8.0);
		Empleado empleado1 = new Empleado("56232425b", "Antonio", "Ramírez", "aramirez@gmail.com", "H");
		Empleado empleado2 = new Empleado("65745344b", "Sandra", "Maqueda", "smaqueda@gmail.com", "M");
		Empleado empleado3 = new Empleado("34242334b", "Javier", "Expósito", "jexposito@gmail.com", "H");
		Empleado empleado4 = new Empleado("27920572b", "Daniela", "Sanchez", "dsanchez@gmail.com", "M");
       	
		// Rutas!
		rutas.add(new Ruta(1, LocalDate.of(2025, 11, 15), "Cádiz", "Madrid", camion1, empleado2, 654.3, 2_322));
		rutas.add(new Ruta(2, LocalDate.of(2025, 11, 15), "Madrid", "Barcelona", camion2, empleado1, 654.3, 2_322));
		rutas.add(new Ruta(3, LocalDate.of(2025, 11, 20), "Barcelona", "Valencia", furgon1, empleado2, 350.5, 1_850));
		rutas.add(new Ruta(4, LocalDate.of(2025, 11, 22), "Valencia", "Sevilla", camion3, empleado3, 520.8, 2_100));
		rutas.add(new Ruta(5, LocalDate.of(2025, 12, 1), "Sevilla", "Bilbao", furgon2, empleado4, 890.2, 3_250));
		rutas.add(new Ruta(6, LocalDate.of(2025, 12, 5), "Bilbao", "Zaragoza", camion4, empleado1, 320.7, 1_680));
		rutas.add(new Ruta(7, LocalDate.of(2025, 12, 8), "Zaragoza", "Alicante", furgon3, empleado2, 425.3, 2_030));
		rutas.add(new Ruta(8, LocalDate.of(2025, 12, 12), "Alicante", "Granada", camion5, empleado3, 380.9, 1_920));
		rutas.add(new Ruta(9, LocalDate.of(2025, 12, 15), "Granada", "Málaga", furgon4, empleado4, 125.6, 780));
		rutas.add(new Ruta(10, LocalDate.of(2025, 12, 18), "Málaga", "Córdoba", camion2, empleado1, 165.4, 950));
		rutas.add(new Ruta(11, LocalDate.of(2026, 1, 2), "Córdoba", "Cádiz", furgon1, empleado2, 180.7, 1_120));
		rutas.add(new Ruta(12, LocalDate.of(2026, 1, 05), "Cádiz", "Huelva", camion3, empleado3, 210.3, 1_350));
		rutas.add(new Ruta(13, LocalDate.of(2026, 1, 8), "Huelva", "Badajoz", furgon2, empleado4, 145.8, 890));
		rutas.add(new Ruta(14, LocalDate.of(2026, 1, 12), "Badajoz", "Cáceres", camion4, empleado1, 85.2, 520));
		rutas.add(new Ruta(15, LocalDate.of(2026, 1, 15), "Cáceres", "Salamanca", furgon3, empleado2, 195.6, 1_180));
		rutas.add(new Ruta(16, LocalDate.of(2026, 1, 18), "Salamanca", "Valladolid", camion5, empleado3, 110.9, 680));
		rutas.add(new Ruta(17, LocalDate.of(2026, 1, 22), "Valladolid", "Madrid", furgon4, empleado4, 185.4, 1_100));
	};
	
	
	// Añadido por mí para poder listar todas las rutas	
	@Override
	public List<Ruta> getRutas() {
		return rutas;
	}
	
	@Override
	public void addRuta(Ruta ruta) {
		if (!rutas.contains(ruta)) {
			rutas.add(ruta);	
		}
	}

	@Override
	public Ruta eliminarRuta(Ruta ruta) {
		Ruta rutaEliminar = ruta;
		rutas.remove(ruta);
		return rutaEliminar;
	}

	@Override
	public int eliminarRuta(int idRuta) {
		for(Ruta ruta: rutas) {
			if(ruta.getIdRuta() == idRuta) {
				rutas.remove(ruta);
				return idRuta;
			}
		}
		return idRuta;
	}

	@Override
	public List<Ruta> rutasPorEmpleado(String dni) {
		List<Ruta> rutasEmpleado = new ArrayList<Ruta>();
		for(Ruta ruta: rutas) {
			if(ruta.getEmpleado().getDni().equals(dni)) {
				rutasEmpleado.add(ruta);
			}
		}
		return rutasEmpleado;
	}

	@Override
	public List<Ruta> rutasPorVehiculo(String matricula) {
		List<Ruta> rutasVehiculo = new ArrayList<Ruta>();
		for(Ruta ruta: rutas) {
			if(ruta.getVehiculoUsado().getMatricula().equals(matricula)) {
				rutasVehiculo.add(ruta);
			}
		}
		return rutasVehiculo;
	}

	@Override
	public Map<String, Long> totalKmPorVehiculo() {
		// devuelve un mapa de matricula:km
		Map<String, Long> mapaVehiculosKm = new HashMap<String, Long>();
		for(Ruta ruta: rutas) {
			Vehiculo vehiculoUsado = ruta.getVehiculoUsado();
			long kmNuevos = (long) (vehiculoUsado.getKilometrosTotales() + ruta.getKmRecorridos());
			mapaVehiculosKm.put(vehiculoUsado.getMatricula(), kmNuevos);
		}
		return mapaVehiculosKm;
	}

	@Override
	public List<Ruta> rutasPorDestino(String destino) {
		List<Ruta> rutasDestino = new ArrayList<Ruta>();
		for(Ruta ruta: rutas) {
			if(ruta.getDestino().equals(destino)) {
				rutasDestino.add(ruta);
			}
		}
		return rutasDestino;
	}

	@Override
	public List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin) {
		List<Ruta> rutasEntreFechas = new ArrayList<Ruta>();
		for(Ruta ruta: rutas) {
			LocalDate fechaRuta = ruta.getFecha();
			if(fechaRuta.isAfter(inicio) && fechaRuta.isBefore(fin)) {
				rutasEntreFechas.add(ruta);
			}
		}
		return rutasEntreFechas;
	}

	@Override
	public Map<String, Long> totalKmPorTipoVehiculo() {
		// devuelve un mapa de matricula:km
		Map<String, Long> mapaTipoVehiculosKm = new HashMap<String, Long>();
		long kmMasRuta = 0;
		long kmTotalesFurgonetas = 0;
		long kmTotalesCamiones = 0;
		for(Ruta ruta: rutas) {
			Vehiculo vehiculoTipoUsado = ruta.getVehiculoUsado();
			kmMasRuta = (long) (vehiculoTipoUsado.getKilometrosTotales() + ruta.getKmRecorridos());
			if (vehiculoTipoUsado instanceof Camion) {
				kmTotalesCamiones += kmMasRuta;
			} else if (vehiculoTipoUsado instanceof Furgoneta) {
				kmTotalesFurgonetas += kmMasRuta;
			}
			vehiculoTipoUsado.setKilometrosTotales(kmMasRuta);
			kmTotalesFurgonetas += kmMasRuta;
		}
		mapaTipoVehiculosKm.put("Camiones", kmTotalesCamiones);
		mapaTipoVehiculosKm.put("Furgonetas", kmTotalesFurgonetas);
		return mapaTipoVehiculosKm;
	}

}
