package tests;

import org.junit.Before;
import org.junit.Test;
import structures.ListeCombinatoire;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe test les methodes de la classe ListeCombinatoire
 *
 * @author Samuel Nguyen-Phok
 */
public class ListeCombinatoireTest {
    private ListeCombinatoire smallList;

    @Before
    public void setUp() throws Exception {
        smallList = new ListeCombinatoire(0, 2, 3);
    }

    @Test
    public void testInvalide() {

    }

    @Test
    public void genererEnsembleValeurs() {
         smallList.genererEnsembleValeurs();

        List<Integer> resultExpected = new ArrayList<>();
        // genereEnsembleValeurs doit genere un ensemble de valeur entre les deux borne predefinies incluse

         for (int i = smallList.getDebutEns(); i <= smallList.getFinEns(); i++)
             resultExpected.add(i);

         assertEquals(resultExpected ,smallList.genererEnsembleValeurs());
    }

    @Test
    public void testToString() {
        System.out.println(smallList.toString());
        assertEquals("Limite de l'ensemble : [0, 2]\n" +
                "Longueur combinaison : 3\n" +
                "Ensemble : [0, 1, 2]\n" +
                "Voici les 1 combinaisons : [[0, 1, 2]]", smallList.toString());
    }
}