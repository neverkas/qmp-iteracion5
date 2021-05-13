package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoExtraccion extends Movimiento{
	
  public MovimientoExtraccion(LocalDate fecha, double monto) {
		super(fecha, monto);
	}

	public boolean fueExtraido(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }

  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() - getMonto();
  }
  
  @Override
  public void agregateA(Cuenta cuenta) {
  	cuenta.setSaldo(calcularValor(cuenta));
    cuenta.agregarExtraccion(this.getFecha(), this.getMonto());
  }
}
