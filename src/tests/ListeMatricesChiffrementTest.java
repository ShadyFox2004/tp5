package tests;

import org.junit.Before;
import org.junit.Test;
import structures.ListeMatricesChiffrement;

import static org.junit.Assert.*;

/**
 * @author Henri
 */

public class ListeMatricesChiffrementTest {
    ListeMatricesChiffrement listMat1, listmat2, listMat3;
    @Before
    public void setUp() throws Exception {
        listMat1 = new ListeMatricesChiffrement(1, 10, 3, 28);
    }

    @Test
    public void getNombreMatricesCandidates() {
        System.out.println(listMat1.getNombreMatricesCandidates());
    }

    @Test
    public void choisirMatriceCourante() {
    }

    @Test
    public void testChoisirMatriceCourante() {
    }

    @Test
    public void getCopieMatriceCourante() {

    }

    @Test
    public void getMatriceCouranteInverseHill() {

    }
}