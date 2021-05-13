package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoExtraccion extends Movimiento{

	public MovimientoDeposito(LocalDate fecha, double monto) {
		super(fecha, monto);
	}
	
  public boolean fueExtraido(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }

  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() - getMonto();
  }

}
