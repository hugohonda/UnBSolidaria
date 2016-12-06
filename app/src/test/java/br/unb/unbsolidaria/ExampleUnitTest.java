package br.unb.unbsolidaria;

import org.junit.Test;

import br.unb.unbsolidaria.entities.RegisterValidation;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void ValidationCorrect() {
        assertTrue(RegisterValidation.isValidCPF("96913238932"));
        assertTrue(RegisterValidation.isValidCNPJ("00348003000110"));
    }

    @Test
    public void ValidaNome(){
        String valid[] = {
                "Jao",
                "Marcos M.",
                "César",
                "Henrique Paiva",
                "Éden aE",
                "NOME EM CAIXA ALTA"
        };
        String not_valid[] = {
                "VINTEVINTEVINTEVINTE1",
                "123",
                "1",
                "Ay",
                ""
        };

        for(String name : valid){
            boolean v= RegisterValidation.isValidName(name, true);
            if (!v) System.out.println("invalid:" + name);
            assertTrue(RegisterValidation.isValidName(name, true));
        }

        for(String name : not_valid){
            boolean v = RegisterValidation.isValidName(name, true);
            if (v) System.out.println("invalid: " + name);
            assertFalse(RegisterValidation.isValidName(name, true));
        }
    }

}