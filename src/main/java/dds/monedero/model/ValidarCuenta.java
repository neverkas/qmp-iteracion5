package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MontoNegativoException;

public interface ValidarCuenta {

	public void validarMontoNegativo(double cuanto);
	
	public void validarDepositoMaximo(long cantidad);
	
	public void validarExtraccionMinimo(double cuanto);
}
