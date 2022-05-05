package tests;

import org.junit.Before;
import org.junit.Test;
import utilitaires.MathUtilitaires;

import java.util.SortedSet;

import static org.junit.Assert.*;

/**
 * Cette classe test la classe MathUtilitaire
 *
 * @author Samuel Nguyen-Phok et Henri Baillargeon
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
        assertEquals("[1, 2, 3, 4, 6, 12]", MathUtilitaires.diviseursDe(12).toString());
        assertEquals("[1, 2, 4, 5, 10, 20]", math.diviseursDe(20).toString());
        assertEquals( "[1, 3, 11, 33]", math.diviseursDe(33).toString());
        assertEquals("[1, 2, 13, 26]", math.diviseursDe(26).toString());

    }

    @Test
    public void estPremier()
    {
        assertFalse(math.estPremier(1));
        assertTrue(math.estPremier(2));
        assertTrue(math.estPremier(3));
        assertFalse(math.estPremier(4));
        assertTrue(math.estPremier(5));
        assertFalse(math.estPremier(6));
        assertTrue(math.estPremier(7));
        assertFalse(math.estPremier(8));
        assertFalse(math.estPremier(9));
        assertFalse(math.estPremier(10));
        assertTrue(math.estPremier(23));
        assertFalse(math.estPremier(100));
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
        assertEquals(6, MathUtilitaires.PGCD(366, 60));
        assertEquals(2, math.PGCD(-24, 2));
        assertEquals(24, math.PGCD(24,0));
    }

    @Test
    public void xPremierEntreEux()
    {
        assertEquals( "[1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]",
                math.xPremierEntreEux(1,26).toString());

        assertEquals("[7, 9]", math.xPremierEntreEux(5, 10).toString());

        assertEquals("[1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]"
                ,math.xPremierEntreEux(-29,26).toString() );
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

}