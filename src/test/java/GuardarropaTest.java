import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import prenda.Atuendo;
import prenda.CategoriaPrenda;
import prenda.Guardaropa;
import prenda.Material;
import prenda.ModoDeUso;
import prenda.Prenda;
import prenda.TipoPrenda;
import prenda.Trama;
import usuario.Usuario;

class GuardarropaTest {

	@Test
	void 	unGuardarropaDeEntreCasaVacioNoTienePrendas() {
		Guardaropa guardaropa = guadaropaVacio();
		assertEquals(0, guardaropa.cantidadDePrendas());
	}

	@Test
	void unGuardarropaConVariasPrendasNoEstaVacio() {
		Guardaropa guardaropaDeEntreCasa = guadarropaConDosPrendas();
		assertTrue(guardaropaDeEntreCasa.cantidadDePrendas() > 0);
	}
	
	@Test
	void siCreaUnGuardaropaCompartidoConUnAmigoEsteDebeAparecer() {
		Usuario usuario = robertito();
		Usuario unAmigo = pepe();
		
		usuario.crearGuardaropaCompartido(unAmigo);
		
		assertTrue(usuario.compartenGuardaropa(unAmigo));
	}

	@Test
	void siCreaUnGuardaropaSinCompartirNingunoDeEllosEstaraCompartido() {
		Usuario usuario = robertito();
		Usuario unDesconocido = pepe();
		
		usuario.crearGuardaropaSinCompartir();
		
		assertFalse(usuario.compartenGuardaropa(unDesconocido));
	}

	@Test
	void siLeSugierenAgregarUnaPrendaLaPuedeAgregarDespues() {
		Usuario usuario = robertito();
		Usuario unDesconocido = pepe();
		Prenda prenda = prendaComun();
		
		usuario.sugerenciaDePrendaParaAgregar(unDesconocido, prenda);		
		assertTrue(usuario.leFueSugeridaParaAgregar(prenda));
	}

	@Test
	void siLeSugierenQuitarUnaPrendaLaPuedeQuitarDespues() {
		Usuario usuario = robertito();
		Usuario unDesconocido = pepe();
		Prenda prenda = prendaRara();
		
		usuario.sugerenciaDePrendaParaQuitar(unDesconocido, prenda);		
		assertTrue(usuario.leFueSugeridaParaQuitar(prenda));
	}

	
	private Usuario pepe() {
		return new Usuario();
	}

	private Usuario robertito() {
		return new Usuario();
	}

	private Guardaropa guadaropaVacio() {
		return new Guardaropa(ModoDeUso.DeEntrecasa);
	}

	private Guardaropa guadarropaConDosPrendas() {
		Guardaropa guardaropa = new Guardaropa(ModoDeUso.DeEntrecasa);
		guardaropa.agregarPrenda(prendaComun());
		guardaropa.agregarPrenda(prendaComun());
		
		return guardaropa;
	}
	
	private Prenda prendaComun() {
		return new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 30), Material.CUERO, new Color(255,255,255), null, Trama.LISA);
	}

	private Prenda prendaRara() {
		return new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 900), null, null, null, Trama.LISA);
	}
	
	private Atuendo ropaDeViaje() {
		return new Atuendo(
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 30), Material.CUERO, new Color(255,255,255), null, Trama.LISA),
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_INFERIOR, 30), Material.ALGODON, new Color(255,255,255), null, Trama.RAYADA),
				new Prenda(new TipoPrenda(CategoriaPrenda.CALZADO, 30), null, new Color(0,0,0), null, null),
				new Prenda(new TipoPrenda(CategoriaPrenda.ACCESORIO, 30), null, new Color(0,0,0), null, null)
				);		
	}
	
	private Atuendo ropaDeEntrecasa() {
		return new Atuendo(
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 10), Material.ALGODON, new Color(255,255,255), null, Trama.LISA),
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_INFERIOR, 10), Material.ALGODON, new Color(255,255,255), null, Trama.LISA),
				new Prenda(new TipoPrenda(CategoriaPrenda.CALZADO, 10), null, new Color(0,0,0), null, null),
				new Prenda(new TipoPrenda(CategoriaPrenda.ACCESORIO, 10), null, new Color(0,0,0), null, null)
				);		
	}

}
