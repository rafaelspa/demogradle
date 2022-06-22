package demogradle;

import junit.framework.TestCase;
import org.junit.Test;

public class CirculoTest extends TestCase {

    @Test
    public void testeDeConstrutorSemArgumento() {
        Circulo circulo = new Circulo();
        assertTrue(circulo instanceof Circulo);
    }

    @Test
    public void testeDeConstrutorComRaioUm() {
        Circulo circulo = new Circulo(1.0);
        assertTrue(circulo instanceof Circulo);
        assertEquals(1.0, circulo.getRaio());
    }

    @Test
    public void circuloDeRaioUmTemAreaIgualAPI() {
        Circulo circulo = new Circulo(1.0);
    }

}