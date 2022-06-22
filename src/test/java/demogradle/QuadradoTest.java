package demogradle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class QuadradoTest extends TestCase {

    @Test
    public void construtorCriaInstanciaDeQuadrado() {
        Quadrado quadrado = new Quadrado();
        assertTrue(quadrado instanceof Quadrado);
    }

    @Test
    public void contrutorCriaInstanciaDeQuadradoComLadoUm() {
        Quadrado quadrado = new Quadrado(1.0);
        assertTrue(quadrado instanceof Quadrado);
        assertEquals(1.0, quadrado.getLado());
    }

    @Test
    public void construtorDeLadoNegativoRetornaIllegalArgumentException() {
        Assert.assertThrows(
                "O lado do quadrado deve ser maior que zero.",
                IllegalArgumentException.class,
                () -> {
                    Quadrado quadrado = new Quadrado(-1.0);
                }
        );
    }

    @Test
    public void areaDeQuadradoDeLadoUmEMeioRetornaDoisPontoDoisCinco() {
        Quadrado quadrado = new Quadrado(1.5);
        assertEquals(2.25, quadrado.calcularArea());
    }

    @Test
    public void perimetroDeQuadradoDeLadoUmEMeioRetornaSeis() {
        Quadrado quadrado = new Quadrado(1.5);
        assertEquals(6.0, quadrado.calcularPerimetro());
    }

    @Test
    public void setarLadoDeQuadradoComValorPositivoRetornaOValor() {
        Quadrado quadrado = new Quadrado();
        quadrado.setLado(1.0);
        assertEquals(1.0, quadrado.getLado());
    }

    @Test
    public void setarLadoDeQuadradoComZeroRetornaIllegalArgumentException() {
        Quadrado quadrado = new Quadrado();
        Assert.assertThrows(
                "O lado do quadrado deve ser maior que zero.",
                IllegalArgumentException.class,
                () -> {
                    quadrado.setLado(0);
                }
        );
    }

    @Test
    public void setarLadoDeQuadradoComValorNegativoRetornaIllegalArgumentException() {
        Quadrado quadrado = new Quadrado();
        Assert.assertThrows(
                "O lado do quadrado deve ser maior que zero.",
                IllegalArgumentException.class,
                () -> {
                    quadrado.setLado(-1.0);
                }
        );
    }

    @Test
    public void pegarLadoDeQuadradoDeLadoCincoRetornaCinco() {
        Quadrado quadrado = new Quadrado(5.0);
        assertEquals(5.0, quadrado.getLado());
    }





}