package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoDeposito extends Movimiento{

	public MovimientoDeposito(LocalDate fecha, double monto) {
		super(fecha, monto);
	}

	public boolean fueDepositado(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }
  
  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() + getMonto();
  }
}
