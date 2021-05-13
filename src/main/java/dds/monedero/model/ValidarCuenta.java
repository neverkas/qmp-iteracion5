package dds.monedero.model;

import java.time.LocalDate;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

public class ValidarCuenta {
	Cuenta cuenta;
	
	public ValidarCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
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
	  if (cuenta.getSaldo() - cuanto < 0) {
	    throw new SaldoMenorException("No puede sacar mas de " + cuenta.getSaldo() + " $");
	  }		
	}

	public void validarExtraccionMaximo(double cuanto) {
	  double montoExtraidoHoy = cuenta.getMontoExtraidoA(LocalDate.now());
	  
	  double limite = 1000 - montoExtraidoHoy;
	  if (cuanto > limite) {
	    throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + 1000
	        + " diarios, límite: " + limite);
	  }		
	}

}
