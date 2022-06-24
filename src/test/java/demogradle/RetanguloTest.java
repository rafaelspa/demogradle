package demogradle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {

    Retangulo retangulo;
    Retangulo retanguloBaseUmAlturaDois;

    @BeforeEach
    public void setUp() {
        retangulo = new Retangulo();
        retanguloBaseUmAlturaDois = new Retangulo(1,2);
    }

    @Test
    public void construirRetanguloRetornaUmObjetoDoTipoRetangulo() {
        // Assert
        assertInstanceOf(Retangulo.class, retangulo);
    }

    @Test
    public void construirRetanguloComArgumentosUmeDoisRetornaUmObjetoTipoRetanguloComBaseUmeAlturaDois() {
        // arrange
        // Act

        // Assert
        assertInstanceOf(Retangulo.class, retanguloBaseUmAlturaDois);
        assertEquals(1, retanguloBaseUmAlturaDois.getBase());
        assertEquals(2, retanguloBaseUmAlturaDois.getAltura());
    }

    @Test
    public void calcularAreaDeRetanguloDeBaseUmEAlturaDoisRetornaDois() {
        // Arrange
        // Act
        // Assert
        assertEquals(2, retanguloBaseUmAlturaDois.calcularArea());
    }

    @Test
    public void calcularPerimetroDeRetanguloDeBaseUmEAlturaDoisRetornaSeis() {
        // Arrange
        // Act
        // Assert
        assertEquals(6, retanguloBaseUmAlturaDois.calcularPerimetro());
    }

    @Test
    public void setarBaseComValorPositivoModificaABaseDoRetanguloComOValor() {
        // Arrange
        // Act
        retangulo.setBase(1);
        // Assert
        assertEquals(1, retangulo.getBase());
    }

    @Test
    public void setarBaseComZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    retangulo.setBase(0);
                });
    }

    @Test
    public void setarBaseComValorNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    retangulo.setBase(-1);
        });
    }

    @Test
    public void setarAlturaComValorPositivoModificaAAlturaDoRetanguloComOValor() {
        // Arrange
        // Act
        retangulo.setAltura(2);
        // Assert
        assertEquals(2, retangulo.getAltura());
    }

    @Test
    public void setarAlturaComZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    retangulo.setAltura(0);
                });
    }

    @Test
    public void setarAlturaComValorNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    retangulo.setBase(-1);
                });
    }

    @Test
    public void pegarBaseRetornaOValorDaBase() {
        // Arrange
        // Act
        // Assert
        assertEquals(1, retanguloBaseUmAlturaDois.getBase());
    }

    @Test
    public void pegarAlturaRetornaOValorDaAltura() {
        // Arrange
        // Act
        // Assert
        assertEquals(2, retanguloBaseUmAlturaDois.getAltura());
    }
}