package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoExtraccion extends Movimiento{

	public MovimientoExtraccion(LocalDate fecha, double monto, boolean esDeposito) {
		super(fecha, monto, false);
	}
	
  public boolean fueExtraido(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }

  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() - getMonto();
  }

}
