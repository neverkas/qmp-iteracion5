package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonederoTest {
  private Cuenta cuenta;

  @BeforeEach
  void init() {
    cuenta = new Cuenta(0);
  }

  @Test
  void Poner() {
    cuenta.poner(1500);
    
    assertEquals(1500, cuenta.getSaldo());
  }

  @Test
  void PonerMontoNegativo() {
    assertThrows(MontoNegativoException.class, () -> cuenta.poner(-1500));
  }

  @Test
  void TresDepositos() {
    cuenta.poner(1500);
    cuenta.poner(456);
    cuenta.poner(1900);
    
    assertEquals(3, cuenta.cantidadDepositos());
  }

  @Test
  void TresExtracciones() {
  	cuenta.poner(300);
    cuenta.sacar(100);
    cuenta.sacar(100);
    cuenta.sacar(100);
    
    assertEquals(3, cuenta.cantidadExtracciones());
  }

  @Test
  void DosDepositosTresExtracciones() {
  	cuenta.poner(300);
  	cuenta.poner(300);
  	cuenta.sacar(100);
    cuenta.sacar(100);
    cuenta.sacar(100);
    
    assertEquals(5, cuenta.cantidadMovimientos());
  }

  @Test
  void MasDeTresDepositos() {
    assertThrows(MaximaCantidadDepositosException.class, () -> {
          cuenta.poner(1500);
          cuenta.poner(456);
          cuenta.poner(1900);
          cuenta.poner(245);          
    });
  }

  @Test
  void ExtraerMasQueElSaldo() {
    assertThrows(SaldoMenorException.class, () -> {
          cuenta.setSaldo(90);
          cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMasDe1000() {
    assertThrows(MaximoExtraccionDiarioException.class, () -> {
      cuenta.setSaldo(5000);
      cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMontoNegativo() {
    assertThrows(MontoNegativoException.class, () -> cuenta.sacar(-500));
  }

  @Test
  public void LaCuentaQuedaVaciaSiDepositamosYExtraemosMismaCantidad() {
  	cuenta.poner(500);
  	cuenta.sacar(500);
  	assertEquals(0, cuenta.getSaldo());
  }
  
  @Test
  public void SiNoDepositamosLaCuentaQuedaVacia() {
  	assertEquals(0, cuenta.getSaldo());
  }
 
}