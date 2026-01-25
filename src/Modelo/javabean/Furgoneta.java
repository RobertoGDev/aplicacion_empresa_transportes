package Modelo.javabean;

public class Furgoneta extends Vehiculo {

	private double volumenCargaM3;
	private double volumenOcupadoM3;
	
	
	public Furgoneta(String matricula, String marca, String modelo, double kilometrosTotales, double consumoLitros100km,
			double volumenCargaM3, double volumenOcupadoM3) {
		super(matricula, marca, modelo, kilometrosTotales, consumoLitros100km);
		this.volumenCargaM3 = volumenCargaM3;
		this.volumenOcupadoM3 = volumenOcupadoM3;
	}

	public Furgoneta() {
		super();
	}

	public double getVolumenCargaM3() {
		return volumenCargaM3;
	}

	public void setVolumenCargaM3(double volumenCargaM3) {
		this.volumenCargaM3 = volumenCargaM3;
	}

	public double getVolumenOcupadoM3() {
		return volumenOcupadoM3;
	}

	public void setVolumenOcupadoM3(double volumenOcupadoM3) {
		this.volumenOcupadoM3 = volumenOcupadoM3;
	}

	@Override
	public String toString() {
		return "Furgoneta [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometrosTotales="
				+ kilometrosTotales + ", consumoLitros100km=" + consumoLitros100km + ", volumenCargaM3="
				+ volumenCargaM3 + ", volumenOcupadoM3=" + volumenOcupadoM3 + "]";
	}

	@Override
	public double cargaDisponible() {
		return Math.round((volumenCargaM3 - volumenOcupadoM3) * 100.0) / 100.0;
	}

	@Override
	public double getPorcentajeCarga() {
		return Math.round((volumenOcupadoM3 / volumenCargaM3) * 100);
	}

	@Override
	public boolean isLleno() {
		if(this.getPorcentajeCarga() == 100.0) { // Corregido el error
			return true;
		} else {			
			return false;
		}
	}
}
