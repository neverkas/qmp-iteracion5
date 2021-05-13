package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoDeposito extends Movimiento{

	public boolean fueDepositado(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }
  
  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() + getMonto();
  }
}
