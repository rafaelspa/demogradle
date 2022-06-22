package demogradle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

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


}