package demogradle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ContaTest extends TestCase {

    @Test
    public void construtorCriaContaSemArgumento() {
        Conta conta = new Conta();
        Assert.assertTrue(conta instanceof Conta);
    }

    @Test
    public void construtorCriaContaComCodigoUmELimiteUm() {
        Conta conta = new Conta(1,1.0);
        assertTrue( conta instanceof Conta);
        assertEquals(1, conta.getCodigo());
        assertEquals(1.0, conta.getLimite());
    }

    @Test
    public void consultarSaldoDeContaRetornaCodigoESaldo() {
        Conta conta = new Conta(1,1.0);
        conta.depositar(1.0);
        assertEquals("\nConta: 1\nSaldo: 1.0", conta.consultarSaldo());
    }

    @Test
    public void depositarValorPositivoRetornaTrue() {
        Conta conta = new Conta();
        assertTrue(conta.depositar(1.0));
        assertEquals(1.0, conta.getSaldo());
    }

    @Test
    public void depositarZeroRetornaFalse() {
        Conta conta = new Conta();
        assertFalse(conta.depositar(0));
    }

    @Test
    public void depositarValorNegativoRetornaFalse() {
        Conta conta = new Conta();
        assertFalse(conta.depositar(-1.0));
    }

    @Test
    public void sacarComValorAcimadoSaldoRetornaTrue() {
        Conta conta = new Conta();
        conta.depositar(10.0);
        assertTrue(conta.sacar(5.0));
        assertEquals(5.0, conta.getSaldo());
    }

    @Test
    public void sacarComValorIgualAoSaldoRetornaTrue() {
        Conta conta = new Conta();
        conta.depositar(10.0);
        assertTrue(conta.sacar(10.0));
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    public void sacarComValorAcimaDoSaldoEMenorQueOLimiteRetornaTrue() {
        Conta conta = new Conta(1,5.0);
        conta.depositar(10.0);
        assertTrue(conta.sacar(12.0));
        assertEquals(-2.0, conta.getSaldo());
        assertEquals(3.0, conta.getLimite());
    }

    @Test
    public void sacarComValorAbaixoDoSaldoRetornaFalse() {
        Conta conta = new Conta(1,5.0);
        conta.depositar(10.0);
        assertFalse(conta.sacar(16.0));
    }

    @Test
    public void transferirComValorAcimaDoSaldoRetornaTrue() {
        Conta conta1 = new Conta(1,5.0);
        Conta conta2 = new Conta(1,5.0);

        conta1.depositar(10.0);
        assertTrue(conta1.transferir(conta2,10.0));
        assertEquals(0.0, conta1.getSaldo());
        assertEquals(10.0, conta2.getSaldo());
    }

    @Test
    public void transferirComValorAcimaDoSaldoEMenorQueOLimiteRetornaTrue() {
        Conta conta1 = new Conta(1,5.0);
        Conta conta2 = new Conta(1,5.0);

        conta1.depositar(10.0);
        assertTrue(conta1.transferir(conta2,12.0));
        assertEquals(-2.0, conta1.getSaldo());
        assertEquals(12.0, conta2.getSaldo());
    }

    @Test
    public void transferirComValorAbaixoDoSaldoRetornaFalse() {
        Conta conta1 = new Conta(1,5.0);
        Conta conta2 = new Conta(1,5.0);

        conta1.depositar(10.0);
        assertFalse(conta1.transferir(conta2,16.0));
    }

    @Test
    public void setarCodigoComValorDoisMudaOCodigoParaDois() {
        Conta conta = new Conta(1,1.0);
        conta.setCodigo(2);
        assertEquals(2, conta.getCodigo());
    }

    @Test
    public void setarCodigoComValorAbaixoOuIgualAZeroRetornaIllegalArgumentException() {
        Conta conta = new Conta(1,1.0);
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            conta.setCodigo(0);
        });
    }

    @Test
    public void getCodigoUmRetornaCodigoUm() {
        Conta conta = new Conta(1, 1.0);
        assertEquals(1, conta.getCodigo());
    }

    @Test
    public void setarLimiteComValorDoisMudaOLimiteParaDois() {
        Conta conta = new Conta(1,5.0);
        conta.setLimite(2.0);
        assertEquals(2.0, conta.getLimite());
    }

    @Test
    public void setarLimiteComValorIgualOuAbaixoDeZeroRetornaIllegalArgumentException() {
        Conta conta = new Conta(1, 5.0);
        Assert.assertThrows(
                "O limite da conta deve ser maior que zero.",
                IllegalArgumentException.class,
                () -> {
                    conta.setLimite(0);
                });
    }

    @Test
    public void pegarLimiteIgualACincoRetornaCinco() {
        Conta conta = new Conta(1, 5.0);
        assertEquals(5.0, conta.getLimite());
    }

    @Test
    public void pegarSaldoIgualADezRetornaDez() {
        Conta conta = new Conta(1,5.0);
        conta.depositar(10.0);
        assertEquals(10.0, conta.getSaldo());
    }




}