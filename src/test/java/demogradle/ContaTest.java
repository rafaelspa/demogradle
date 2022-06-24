package demogradle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest{

    Conta conta;
    Conta contaComCodigoUmELimiteCinco;

    @BeforeEach
    public void setUp() {
        conta = new Conta();
        contaComCodigoUmELimiteCinco = new Conta(1,5.0);
    }

    @Test
    public void construirContaCriaConta() {
        // Arrange
        // Act
        // Assert
        assertInstanceOf(Conta.class, conta);
    }

    @Test
    public void construirCriaContaComCodigoUmELimiteCinco() {
        // Arrange
        // Act
        // Assert
        assertInstanceOf(Conta.class, contaComCodigoUmELimiteCinco);
        assertEquals(1, contaComCodigoUmELimiteCinco.getCodigo());
        assertEquals(5.0, contaComCodigoUmELimiteCinco.getLimite());
    }

    @Test
    public void consultarSaldoDeContaRetornaCodigoESaldo() {
        // Arrange
        // Act
        contaComCodigoUmELimiteCinco.depositar(1.0);
        // Assert
        assertEquals("\nConta: 1\nSaldo: 1.0", contaComCodigoUmELimiteCinco.consultarSaldo());
    }

    @Test
    public void depositarValorPositivoRetornaTrue() {
        // Arrange
        // Act
        Boolean depositoComValorPositivo = conta.depositar(1.0);
        // Assert
        assertTrue(depositoComValorPositivo);
        assertEquals(1.0, conta.getSaldo());
    }

    @Test
    public void depositarZeroRetornaFalse() {
        // Arrange
        Boolean depositoComValorZero;
        // Act
        depositoComValorZero = conta.depositar(0);
        // Assert
        assertFalse(depositoComValorZero);
    }

    @Test
    public void depositarValorNegativoRetornaFalse() {
        // Arrange
        Boolean depositoComValorNegativo;
        // Act
        depositoComValorNegativo = conta.depositar(-1.0);
        // Assert
        assertFalse(depositoComValorNegativo);
    }

    @Test
    public void sacarComValorAcimadoSaldoRetornaTrue() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean saqueMenorQueOSaldo;
        // Act
        saqueMenorQueOSaldo = contaComCodigoUmELimiteCinco.sacar(5.0);
        // Assert
        assertTrue(saqueMenorQueOSaldo);
        assertEquals(5.0, contaComCodigoUmELimiteCinco.getSaldo());
    }

    @Test
    public void sacarComValorIgualAoSaldoRetornaTrue() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean saqueIgualAoSaldo;
        // Act
        saqueIgualAoSaldo = contaComCodigoUmELimiteCinco.sacar(10.0);
        // Assert
        assertTrue(saqueIgualAoSaldo);
        assertEquals(0.0, contaComCodigoUmELimiteCinco.getSaldo());
    }

    @Test
    public void sacarComValorAcimaDoSaldoEMenorQueOLimiteRetornaTrue() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean saqueMaiorQueOSaldoEMenorQueOLimite;
        // Act
        saqueMaiorQueOSaldoEMenorQueOLimite = contaComCodigoUmELimiteCinco.sacar(12.0);
        // Assert
        assertTrue(saqueMaiorQueOSaldoEMenorQueOLimite);
        assertEquals(-2.0, contaComCodigoUmELimiteCinco.getSaldo());
        assertEquals(3.0, contaComCodigoUmELimiteCinco.getLimite());
    }

    @Test
    public void sacarComValorAbaixoDoSaldoRetornaFalse() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean saqueMaiorQueOLimite;
        // Act
        saqueMaiorQueOLimite = contaComCodigoUmELimiteCinco.sacar(16.0);
        // Assert
        assertFalse(saqueMaiorQueOLimite);
    }

    @Test
    public void transferirComValorAcimaDoSaldoRetornaTrue() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean transferenciaMenorQueOSaldo;
        // Act
        transferenciaMenorQueOSaldo = contaComCodigoUmELimiteCinco.transferir(conta, 10.0);
        // Assert
        assertTrue(transferenciaMenorQueOSaldo);
        assertEquals(0.0, contaComCodigoUmELimiteCinco.getSaldo());
        assertEquals(10.0, conta.getSaldo());
    }

    @Test
    public void transferirComValorAcimaDoSaldoEMenorQueOLimiteRetornaTrue() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean transferenciaMaiorQueSaldoEMenorQueOLimite;
        // Act
        transferenciaMaiorQueSaldoEMenorQueOLimite = contaComCodigoUmELimiteCinco.transferir(conta,12.0);
        // Assert
        assertTrue(transferenciaMaiorQueSaldoEMenorQueOLimite);
        assertEquals(-2.0, contaComCodigoUmELimiteCinco.getSaldo());
        assertEquals(12.0, conta.getSaldo());
    }

    @Test
    public void transferirComValorAbaixoDoSaldoRetornaFalse() {
        // Arrange
        contaComCodigoUmELimiteCinco.depositar(10.0);
        Boolean transferenciaMaiorQueOLimite;
        // Act
        transferenciaMaiorQueOLimite = contaComCodigoUmELimiteCinco.transferir(conta,16.0);
        // Assert
        assertFalse(transferenciaMaiorQueOLimite);
    }

    @Test
    public void setarCodigoComValorDoisMudaOCodigoParaDois() {
        // Arrange
        // Act
        contaComCodigoUmELimiteCinco.setCodigo(2);
        // Assert
        assertEquals(2, contaComCodigoUmELimiteCinco.getCodigo());
    }

    @Test
    public void setarCodigoComValorZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    conta.setCodigo(0);
                },
                "O código da conta deve ser maior que zero."
                );
    }

    @Test
    public void setarCodigoComValorNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    conta.setCodigo(-1);
                },
                "O código da conta deve ser maior que zero."
        );
    }

    @Test
    public void pegarCodigoUmRetornaCodigoUm() {
        // Arrange
        // Act
        // Assert
        assertEquals(1, contaComCodigoUmELimiteCinco.getCodigo());
    }

    @Test
    public void setarLimiteComValorDoisMudaOLimiteParaDois() {
        // Arrange
        // Act
        contaComCodigoUmELimiteCinco.setLimite(2.0);
        // Assert
        assertEquals(2.0, contaComCodigoUmELimiteCinco.getLimite());
    }

    @Test
    public void setarLimiteComValorZeroRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert

        assertThrows(IllegalArgumentException.class,
                () -> {
                    contaComCodigoUmELimiteCinco.setLimite(0);
                },  "O limite da conta deve ser maior que zero.");
    }
    @Test
    public void setarLimiteComValorNegativoRetornaIllegalArgumentException() {
        // Arrange
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> {
                    contaComCodigoUmELimiteCinco.setLimite(-1.0);
                },  "O limite da conta deve ser maior que zero.");
    }

    @Test
    public void pegarLimiteIgualACincoRetornaCinco() {
        // Arrange
        // Act
        // Assert
        assertEquals(5.0, contaComCodigoUmELimiteCinco.getLimite());
    }

    @Test
    public void pegarSaldoIgualADezRetornaDez() {
        // Arrange
        conta.depositar(10.0);
        // Act
        // Assert
        assertEquals(10.0, conta.getSaldo());
    }
}