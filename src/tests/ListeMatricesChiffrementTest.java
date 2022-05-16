package tests;

import org.junit.Before;
import org.junit.Test;
import structures.ListeMatricesChiffrement;
import utilitaires.*;
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

    }

    @Test
    public void choisirMatriceCourante() {
        listMat1.choisirMatriceCourante(0);
        System.out.println(MatriceUtilitaires.toStringMat(listMat1.getCopieMatriceCourante()));
        listMat1.choisirMatriceCourante(1);
        System.out.println(MatriceUtilitaires.toStringMat(listMat1.getCopieMatriceCourante()));
        listMat1.choisirMatriceCourante(2);
        System.out.println(MatriceUtilitaires.toStringMat(listMat1.getCopieMatriceCourante()));
        System.out.print(listMat1.getNombreMatricesCandidates());
    }

    @Test
    public void getCopieMatriceCourante() {
        System.out.println(MatriceUtilitaires.toStringMat(listMat1.getCopieMatriceCourante()));

    }

    @Test
    public void getMatriceCouranteInverseHill() {
        assertEquals(listMat1.getMatriceCouranteInverseHill(), new int[][]{{27, 2, 27}, {2, 2, 23}, {27, 5, 25}});
    }
}