package demogradle;

import junit.framework.TestCase;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class CirculoTest extends TestCase {

    @Test
    public void testeDeConstrutorSemArgumento() {
        Circulo circulo = new Circulo();
        assertTrue(circulo instanceof Circulo);
    }

    @Test
    public void testeDeConstrutorComRaioPositivo() {
        Circulo circulo = new Circulo(1.0);
        assertTrue(circulo instanceof Circulo);
        assertEquals(1.0, circulo.getRaio());
    }

    @Test
    public void testeDeConstrutorComRaioNegativo() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Circulo(-1.0));
    }

    @Test
    public void circuloDeRaioUmTemAreaIgualAPi() {
        Circulo circulo = new Circulo(1.0);
        assertEquals(3.141592653589793, circulo.calcularArea(), 0.0001);
    }

    @Test
    public void circuloDeDoisEMeioUmTemAreaIgualDezenovePontoSeisTresQuatroEtc() {
        Circulo circulo = new Circulo(2.5);
        assertEquals(19.634954085, circulo.calcularArea(),0.0000001);
    }

    @Test
    public void circuloDeRaioUmTemPerimetro2Pi () {
        Circulo circulo = new Circulo(1.0);
        assertEquals(6.283185307, circulo.calcularPerimetro(), 0.0000001);
    }

    @Test
    public void circuloDeRaioDoisEMeioTemPerimetroQuinzePontoSeteZeroSeteNoveEtc () {
        Circulo circulo = new Circulo(2.5);
        assertEquals(15.707963268, circulo.calcularPerimetro(), 0.0000001);
    }

    @Test
    public void setaRaioParaUmNumeroPositivo() {
        Circulo circulo = new Circulo();
        circulo.setRaio(1.0);
        assertEquals(1.0, circulo.getRaio());
    }

    @Test
    public void setaRaioParaNumeroNegativo() {
        Circulo circulo = new Circulo();
        Assert.assertThrows(IllegalArgumentException.class, () -> circulo.setRaio(-1.0));
    }

    @Test
    public void pegaORaioDeUmCirculoDeRaioUm() {
        Circulo circulo = new Circulo(1.0);
        assertEquals(1.0, circulo.getRaio());
    }

}