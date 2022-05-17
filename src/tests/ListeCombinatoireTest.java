package tests;

import exceptions.ConstructeurException;
import org.junit.Before;
import org.junit.Test;
import structures.ListeCombinatoire;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe test les methodes de la classe ListeCombinatoire
 *
 * @author Samuel Nguyen-Phok et Antoine-Mathis Boudreau
 */
public class ListeCombinatoireTest {
    private ListeCombinatoire smallList, liste;

    @Before
    public void setUp() throws Exception {
        smallList = new ListeCombinatoire(0, 2, 3);
        liste = new ListeCombinatoire(0, 3, 3);
    }

    @Test
    public void testInvalide() {
        try {
            ListeCombinatoire test = new ListeCombinatoire(-5, 5, 3);
        }
        catch(ConstructeurException e) {
        }
        try {
            ListeCombinatoire test = new ListeCombinatoire(4, 51, 3);
        }
        catch(ConstructeurException e) {
        }
        try {
            ListeCombinatoire test = new ListeCombinatoire(5, 30, -1);
        }
        catch(ConstructeurException e) {
        }
    }

    @Test
    public void genererEnsembleValeurs() {
         smallList.genererEnsembleValeurs();

        List<Integer> resultExpected = new ArrayList<>();
        // genereEnsembleValeurs doit genere un ensemble de valeur entre les deux borne predefinies incluse

         for (int i = smallList.getDebutEns(); i <= smallList.getFinEns(); i++)
             resultExpected.add(i);

         assertEquals(resultExpected ,smallList.genererEnsembleValeurs());

         liste.genererEnsembleValeurs();

         List<Integer> resultExpected2 = new ArrayList<>();
        // genereEnsembleValeurs doit genere un ensemble de valeur entre les deux borne predefinies incluse

        for (int i = liste.getDebutEns(); i <= liste.getFinEns(); i++)
            resultExpected2.add(i);

        assertEquals(resultExpected2 ,liste.genererEnsembleValeurs());
    }

    @Test
    public void testToString() {
        System.out.println(smallList.toString());
        assertEquals("Limite de l'ensemble : [0, 2] \n" +
                "Longueur combinaison : 3\n" +
                "Ensemble : [0, 1, 2]\n" +
                "Voici les 1 combinaisons : [[0, 1, 2]]", smallList.toString());

        System.out.println(liste.toString());

        assertEquals("Limite de l'ensemble : [0, 3] \n" +
                "Longueur combinaison : 3\n" +
                "Ensemble : [0, 1, 2, 3]\n" +
                "Voici les 4 combinaisons : [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]]", liste.toString());
    }
}