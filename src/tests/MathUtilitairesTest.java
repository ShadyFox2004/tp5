package tests;

import org.junit.Before;
import org.junit.Test;
import utilitaires.MathUtilitaires;

import java.util.SortedSet;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe test la classe MathUtilitaire
 *
 * @author Samuel Nguyen-Phok
 */
public class MathUtilitairesTest
{
    private MathUtilitaires math;

    @Before
    public void setUp() throws Exception
    {
        math = new MathUtilitaires();
    }

    @Test
    public void fact()
    {
        assertEquals(120, math.fact(5), 0);
        assertEquals(479001600, math.fact(12), 0);
    }

    @Test
    public void modulo()
    {
        assertEquals(15, math.modulo(117, 17));
        assertEquals(2, math.modulo(-117, 17));
        assertEquals(-2, math.modulo(117, -17));
        assertEquals(  -15, math.modulo(-117, -17));
    }

    @Test
    public void diviseursDe()
    {

    }

    @Test
    public void estPremier()
    {
        assertEquals(false, math.estPremier(1));
        assertEquals(true, math.estPremier(2));
        assertEquals(true, math.estPremier(3));
        assertEquals(false, math.estPremier(4));
        assertEquals(true, math.estPremier(5));
        assertEquals(false, math.estPremier(6));
        assertEquals(true, math.estPremier(7));
        assertEquals(false, math.estPremier(8));
        assertEquals(false, math.estPremier(9));
        assertEquals(false, math.estPremier(10));
        assertEquals(true, math.estPremier(23));
        assertEquals(false, math.estPremier(100));
    }

    @Test
    public void xPremier()
    {
        SortedSet<Integer> set1 = math.xPremier(10);
        assertEquals("[2, 3, 5, 7]", set1.toString());

        SortedSet<Integer> set2 = math.xPremier(100);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43," +
                " 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]", set2.toString());
    }

    @Test
    public void PGCD()
    {
    }

    @Test
    public void xPremierEntreEux()
    {
    }

    @Test
    public void alea()
    {
        // ce test marche et ne marche pas dependemment de la probabiliter
        // mais sa marche
        for (int i = 0; i < 10; i++)
        {
            int a = math.alea(0, 100);
            int b = math.alea(0, 100);
            assertEquals(false, a == b);
        }

    }

    @Test
    public void nbrCombinaison()
    {
    }
}