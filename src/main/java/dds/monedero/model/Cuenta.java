package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta implements ValidarCuenta{

  private double saldo = 0;
  private List<Movimiento> movimientos = new ArrayList<>();
  private List<MovimientoDeposito> depositos = new ArrayList<>();
  private List<MovimientoExtraccion> extracciones = new ArrayList<>();

  public Cuenta() {
    saldo = 0;
  }

  public Cuenta(double montoInicial) {
    saldo = montoInicial;
  }

  public void setMovimientos(List<Movimiento> movimientos) {
    this.movimientos = movimientos;
  }

  public void poner(double cuanto) {
  	this.validarMontoNegativo(cuanto);  	
  	this.validarDepositoMaximo(this.cantidadDepositos());

    new MovimientoDeposito(LocalDate.now(), cuanto).agregateA(this);
  }

  public void sacar(double cuanto) {
  	this.validarMontoNegativo(cuanto);
  	this.validarExtraccionMinimo(cuanto);
  	this.validarExtraccionMaximo(cuanto);
  	  	
    new MovimientoDeposito(LocalDate.now(), cuanto).agregateA(this);
  }

  public void agregarMovimiento(LocalDate fecha, double cuanto) {
    Movimiento movimiento = new MovimientoDeposito(fecha, cuanto);
    movimientos.add(movimiento);
  }

  public double getMontoExtraidoA(LocalDate fecha) {
    return getExtracciones().stream()
        .filter(extraccion -> extraccion.getFecha().equals(fecha))
        .mapToDouble(Movimiento::getMonto)
        .sum();
  }

  public List<Movimiento> getMovimientos() {
    return movimientos;
  }

  public List<MovimientoDeposito> getDepositos() {
    return depositos;
  }

  public List<MovimientoExtraccion> getExtracciones() {
    return extracciones;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

	public void validarMontoNegativo(double cuanto) {
    if (cuanto <= 0) {
      throw new MontoNegativoException(cuanto + ": el monto a ingresar debe ser un valor positivo");
    }
	}

	public void validarDepositoMaximo(long cantidad) {
	  if (cantidad >= 3) {
	    throw new MaximaCantidadDepositosException("Ya excedio los " + 3 + " depositos diarios");
	  }		
	}

	public void validarExtraccionMinimo(double cuanto) {
	  if (this.getSaldo() - cuanto < 0) {
	    throw new SaldoMenorException("No puede sacar mas de " + getSaldo() + " $");
	  }		
	}

	public void validarExtraccionMaximo(double cuanto) {
	  double montoExtraidoHoy = getMontoExtraidoA(LocalDate.now());
	  
	  double limite = 1000 - montoExtraidoHoy;
	  if (cuanto > limite) {
	    throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + 1000
	        + " diarios, límite: " + limite);
	  }		
	}

	private long cantidadDepositos() {
		return getDepositos().stream().count();
	}
}
