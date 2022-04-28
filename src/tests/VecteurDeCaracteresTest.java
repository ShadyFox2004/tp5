package tests;

import exceptions.ConstructeurException;
import org.junit.Before;
import org.junit.Test;
import structures.VecteurDeCaracteres;

import static org.junit.Assert.*;

/**
 * Cette classe teste la classe VecteurDeCaractere
 *
 * @author Samuel Nguyen-Phok
 */
public class VecteurDeCaracteresTest
{
    private VecteurDeCaracteres vecteurDefaut, vecteurParam;

    @Before
    public void setUp() throws Exception
    {
        vecteurDefaut = new VecteurDeCaracteres();
        vecteurParam = new VecteurDeCaracteres(new char[]{'Z', 'X', 'Y'});
    }

    @Test
    public void TestInvalide() throws ConstructeurException
    {
        try
        {
            VecteurDeCaracteres test = new VecteurDeCaracteres(new char[]{});
            fail("Constructeur defectueux");
        } catch (ConstructeurException e)
        {
        }
    }

    @Test
    public void getCaractere()
    {
        assertEquals('A', vecteurDefaut.getCaractere(0));
        assertEquals('Z', vecteurParam.getCaractere(0));
    }

    @Test
    public void getIndice()
    {
        assertEquals(1, vecteurDefaut.getIndice('B'));
        assertEquals(1, vecteurParam.getIndice('X'));
    }

    @Test
    public void getTaille()
    {
        assertEquals(28, vecteurDefaut.getTaille());
        assertEquals(3, vecteurParam.getTaille());
    }

    @Test
    public void testToString()
    {
        assertEquals("Table de correspondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]", vecteurDefaut.toString());
        assertEquals("Table de correspondance = [Z, X, Y]", vecteurParam.toString());
    }
}