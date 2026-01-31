package Modelo.javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Ruta {

	private int idRuta;
	private LocalDate fecha;
	private String origen;
	private String destino;
	private Vehiculo vehiculoUsado;
	private Empleado empleado;
	private double kmRecorridos;
	private double cargaTransportadaKg;

	public Ruta(int idRuta, LocalDate fecha, String origen, String destino, Vehiculo vehiculoUsado, Empleado empleado,
			double kmRecorridos, double cargaTransportadaKg) {
		super();
		this.idRuta = idRuta;
		this.fecha = fecha;
		this.origen = origen;
		this.destino = destino;
		this.vehiculoUsado = vehiculoUsado;
		this.empleado = empleado;
		this.kmRecorridos = kmRecorridos;
		this.cargaTransportadaKg = cargaTransportadaKg;
	}

	public Ruta() {
		super();
	}

	public int getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Vehiculo getVehiculoUsado() {
		return vehiculoUsado;
	}

	public void setVehiculoUsado(Vehiculo vehiculoUsado) {
		this.vehiculoUsado = vehiculoUsado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public double getCargaTransportadaKg() {
		return cargaTransportadaKg;
	}

	public void setCargaTransportadaKg(double cargaTransportadaKg) {
		this.cargaTransportadaKg = cargaTransportadaKg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRuta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ruta))
			return false;
		Ruta other = (Ruta) obj;
		return idRuta == other.idRuta;
	}

	@Override
	public String toString() {
		return "Ruta [idRuta=" + idRuta + ", fecha=" + fecha + ", origen=" + origen + ", destino=" + destino
				+ ", vehiculoUsado=" + vehiculoUsado + ", empleado=" + empleado + ", kmRecorridos=" + kmRecorridos
				+ ", cargaTransportadaKg=" + cargaTransportadaKg + "]";
	}

	public boolean isCargaCorrecta() {
		// Comprobar que esta carga no excede la del vehículo asignado.
		if (vehiculoUsado instanceof Camion camion) {
			// Usar el método de Camión
			if(camion.cargaDisponible() == 0) {
				return false;
			}
			
			if(camion.cargaDisponible() > cargaTransportadaKg) {
				return true;
			} else {
				return false;
			}
			
		} else if (vehiculoUsado instanceof Furgoneta furgoneta) {
			// Usar el método de Furgoneta
			if(furgoneta.isLleno()) {
				return false;
			};
			
			if(furgoneta.cargaDisponible() > cargaTransportadaKg) {
				return true;
			} else {
				return false;
			}
			
		}
		return false;
	}

	public void modificarKilometrosYConsumolVehiculo() {
		vehiculoUsado.setConsumoLitros100km(calcularConsumoEstimado());
		vehiculoUsado.setKilometrosTotales(vehiculoUsado.getKilometrosTotales() + getKmRecorridos());
	}

	public String getOrigenDestino() {
		// Devolver un String con origen – Destino – Kilometros
		return getOrigen() + " - " + getDestino() + " - " + getKmRecorridos(); 
	}

	public String tipoRuta() {
		// En función de los kilómetros(a tu criterio) CORTA/MEDIA/LARGA.
		double kmDistancia = getKmRecorridos();
		String distancia;
		
		if (kmDistancia < 200) {
			distancia = "CORTA";
		} else if (kmDistancia < 500) {
			distancia = "MEDIA";
		} else {
			distancia = "LARGA";
		}
		
		return distancia;
	}

	public double calcularConsumoEstimado() {
		// los km entre por el consumo entre 100
		return Math.round((getKmRecorridos() * vehiculoUsado.consumoLitros100km) / 100);
		
	}
}
