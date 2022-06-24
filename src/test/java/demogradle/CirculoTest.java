package demogradle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CirculoTest {

    Circulo circulo;
    Circulo circuloDeRaioUm;
    Circulo circuloDeRaioDoisEMeio;

    @BeforeEach
    public void setUp() {
        circulo = new Circulo();
        circuloDeRaioUm = new Circulo(1.0);
        circuloDeRaioUm = new Circulo(2.5);
    }

    @Test
    public void construirCirculoRetornaCirculo() {
        // Arrange
        // Act
        // Assert
        assertInstanceOf(Circulo.class, circulo);
    }

    @Test
    public void construirCirculoComRaioUmRetornaCirculoDeRaioUm() {
        // Arrange
        // Act
        // Assert
        assertInstanceOf(Circulo.class, circuloDeRaioUm);
        assertEquals(1.0, circuloDeRaioUm.getRaio());
    }

    @Test
    public void construirCirculoComRaioNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Circulo circuloDeRaioNegativo = new Circulo(-1.0);
                },
                "O raio do círculo deve ser maior que zero."
        );
    }

    @Test
    public void calcularAreaDeCirculoDeRaioUmRetornaAreaIgualAPi() {
        // Arrange
        // Act
        // Assert
        assertEquals(3.141592653589793, circuloDeRaioUm.calcularArea(), 0.0001);
    }

    @Test
    public void calcularAreaDeCirculoDeDoisEMeioRetornaAreaDezenovePontoSeisTresQuatroEtc() {
        // Arrange
        // Act
        // Assert
        assertEquals(19.634954085, circuloDeRaioDoisEMeio.calcularArea(),0.0000001);
    }

    @Test
    public void calcularPerimetroDeUmCirculoDeRaioUmRetornaPerimetro2Pi () {
        // Arrange
        // Act
        // Assert
        assertEquals(6.283185307, circuloDeRaioUm.calcularPerimetro(), 0.0000001);
    }

    @Test
    public void calcularPerimetroDeUmCirculoDeRaioDoisEMeioTemPerimetroQuinzePontoSeteZeroSeteNoveEtc () {
        // Arrange
        // Act
        // Assert
        assertEquals(15.707963268, circuloDeRaioDoisEMeio.calcularPerimetro(), 0.0000001);
    }

    @Test
    public void setarRaioComUmNumeroPositivoRetornaCirculoComRaioIgualAoValor() {
        // Arrange
        // Act
        circulo.setRaio(1.0);
        // Assert
        assertEquals(1.0, circulo.getRaio());
    }

    @Test
    public void setarRaioComNumeroNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            circulo.setRaio(-1.0);
        },
            "O raio do círculo deve ser maior que zero."
        );
    }

    @Test
    public void pegarORaioDeUmCirculoDeRaioUmRetornaOValorDoRaio() {
        // Arrange
        // Act
        // Assert
        assertEquals(1.0, circuloDeRaioUm.getRaio());
    }

}