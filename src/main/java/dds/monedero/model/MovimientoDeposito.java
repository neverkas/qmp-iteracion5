package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoDeposito extends Movimiento{

	public boolean fueDepositado(LocalDate fecha) {
    return isDeposito() && esDeLaFecha(fecha);
  }

  public boolean isDeposito() {
    return esDeposito;
  }
  
  @Override
  public double calcularValor(Cuenta cuenta) {
      return cuenta.getSaldo() + getMonto();
  }
}
