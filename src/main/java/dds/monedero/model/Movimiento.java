package dds.monedero.model;

import java.time.LocalDate;

 abstract public class Movimiento {
  private LocalDate fecha;
  private double monto;
  

  public Movimiento(LocalDate fecha, double monto) {
    this.fecha = fecha;
    this.monto = monto;
  }

  public double getMonto() {
    return monto;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public boolean esDeLaFecha(LocalDate fecha) {
    return this.fecha.equals(fecha);
  }
  
  abstract public double calcularValor(Cuenta cuenta);

  abstract public void agregateA(Cuenta cuenta);
}
