package br.unb.unbsolidaria;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.unb.unbsolidaria.entidades.ValidaCadastro;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("br.unb.unbsolidaria", appContext.getPackageName());
    }
    @Test
    public void testValidCPF() throws  Exception {
        assertTrue(ValidaCadastro.isValidCPF("01115375502"));
    }
    @Test
    public void testValidCNPJ() throws  Exception {
        assertTrue(ValidaCadastro.isValidCNPJ("13642634756318"));
    }
    @Test
    public void testValidCEP() throws  Exception {
        assertTrue(ValidaCadastro.isValidCEP("12910-180"));
        assertTrue(ValidaCadastro.isValidCEP("12910180"));
    }
}
