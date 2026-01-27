package interfazes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import Modelo.javabean.Ruta;

public interface IGestionRutas {
	
	List<Ruta> getRutas();

	void addRuta(Ruta ruta);

	Ruta eliminarRuta(Ruta ruta);

	int eliminarRuta(int idRuta);
	
	List<Ruta> rutasPorEmpleado(String dni);

	List<Ruta> rutasPorVehiculo(String matricula);

	Map<String, Long> totalKmPorVehiculo();

	List<Ruta> rutasPorDestino(String destino);

	List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin);

	Map<String,Long> totalKmPorTipoVehiculo();
}
