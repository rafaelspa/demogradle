package demogradle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class QuadradoTest {

    Quadrado quadrado;
    Quadrado quadradoDeLadoUm;

    @BeforeEach
    public void setUp() {
        quadrado = new Quadrado();
        quadradoDeLadoUm = new Quadrado(1.0);
    }

    @Test
    public void construirQuadradoCriaInstanciaDeQuadrado() {
        // Arrange
        // Act
        // Assert
        assertInstanceOf(Quadrado.class, quadrado);
    }

    @Test
    public void construirQuadradoDeLadoZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Quadrado quadradoZero = new Quadrado(0);
                });
    }

    @Test
    public void construirQuadradoDeLadoNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Quadrado quadradoNegativo = new Quadrado(-1.0);
                });
    }

    @Test
    public void areaDeQuadradoDeLadoUmEMeioRetornaDoisPontoDoisCinco() {
        // Arrange
        Quadrado quadradoUmEMeio = new Quadrado(1.5);
        // Act
        // Assert
        assertEquals(2.25, quadradoUmEMeio.calcularArea());
    }

    @Test
    public void perimetroDeQuadradoDeLadoUmEMeioRetornaSeis() {
        // Arrange
        Quadrado quadradoUmEMeio = new Quadrado(1.5);
        // Act
        // Assert
        assertEquals(6.0, quadradoUmEMeio.calcularPerimetro());
    }

    @Test
    public void setarLadoDeQuadradoComValorPositivoRetornaOValor() {
        // Arrange
        // Act
        quadrado.setLado(1.0);
        // Assert
        assertEquals(1.0, quadrado.getLado());
    }

    @Test
    public void setarLadoDeQuadradoComZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    quadrado.setLado(0);
                }
        );
    }

    @Test
    public void setarLadoDeQuadradoComValorNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    quadrado.setLado(-1.0);
                }
                );
    }

    @Test
    public void pegarLadoDeQuadradoDeLadoUmRetornaUm() {
        // Arrange
        // Act
        // Assert
        assertEquals(1.0, quadradoDeLadoUm.getLado());
    }
}