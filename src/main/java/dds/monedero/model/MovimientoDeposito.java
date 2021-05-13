package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoDeposito extends Movimiento{

	public MovimientoDeposito(LocalDate fecha, double monto, boolean esDeposito) {
		super(fecha, monto, esDeposito);
		// TODO Auto-generated constructor stub
	}

	public boolean fueDepositado(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }
  
  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() + getMonto();
  }
}
