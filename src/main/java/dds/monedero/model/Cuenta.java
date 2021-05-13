package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta{

  private double saldo = 0;
  private List<MovimientoDeposito> depositos = new ArrayList<>();
  private List<MovimientoExtraccion> extracciones = new ArrayList<>();

  public Cuenta() {
    saldo = 0;
  }

  public Cuenta(double montoInicial) {
    saldo = montoInicial;
  }

  public void poner(double cuanto) {
  	ValidarCuenta validarCuenta = new ValidarCuenta(this);
  	  	
  	validarCuenta.validarMontoNegativo(cuanto);  	
  	validarCuenta.validarDepositoMaximo(this.cantidadDepositos());

    new MovimientoDeposito(LocalDate.now(), cuanto).agregateA(this);
  }

  public void sacar(double cuanto) {
  	ValidarCuenta validarCuenta = new ValidarCuenta(this);
  	
  	validarCuenta.validarMontoNegativo(cuanto);
  	validarCuenta.validarExtraccionMinimo(cuanto);
  	validarCuenta.validarExtraccionMaximo(cuanto);
  	  	
    new MovimientoExtraccion(LocalDate.now(), cuanto).agregateA(this);
  }

  public void agregarDeposito(LocalDate fecha, double cuanto) {
  	MovimientoDeposito deposito = new MovimientoDeposito(fecha, cuanto);
    depositos.add(deposito);
  }

  public void agregarExtraccion(LocalDate fecha, double cuanto) {
  	MovimientoExtraccion extraccion = new MovimientoExtraccion(fecha, cuanto);
    extracciones.add(extraccion);
  }

  public double getMontoExtraidoA(LocalDate fecha) {
    return getExtracciones().stream()
        .filter(extraccion -> extraccion.getFecha().equals(fecha))
        .mapToDouble(Movimiento::getMonto)
        .sum();
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

	public long cantidadDepositos() {
		return getDepositos().stream().count();
	}
	
	public long cantidadExtracciones() {
		return getExtracciones().stream().count();
	}
	
	public long cantidadMovimientos() {
		return this.cantidadDepositos() + this.cantidadExtracciones();
	}
}
