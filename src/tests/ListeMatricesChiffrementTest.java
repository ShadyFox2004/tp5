package tests;

import org.junit.Before;
import org.junit.Test;
import structures.ListeMatricesChiffrement;
import utilitaires.*;

/**
 * @author Henri
 */

public class ListeMatricesChiffrementTest {
    ListeMatricesChiffrement listMat1;
    int[][] listmat2;
    ListeMatricesChiffrement listMat3;
    @Before
    public void setUp() throws Exception {
        listMat1 = new ListeMatricesChiffrement(0, 9, 3, 28);
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
        listMat1.choisirMatriceCourante();
        listmat2 = listMat1.getMatriceCouranteInverseHill();
        System.out.println(MatriceUtilitaires.toStringMat(listmat2));

    }

    @Test
    public void getMatriceCouranteInverseHillCopie()
    {
        int[][] matriceCourante = new int[][] {{1, 3, 4}, {5, 6, 7}, {8, 9, 10}};

        System.out.println(MatriceUtilitaires.toStringMat(MatriceUtilitaires.getMatModuloX(
                MatriceUtilitaires.getMatMultScalaire(
                        MatriceUtilitaires.getMatAdjointe(new int[][] {{1, 3, 4}, {5, 6, 7}, {8, 9, 10}}),
                        MatriceUtilitaires.getDeterminantInverseHill(
                                MatriceUtilitaires.getDeterminant(matriceCourante), 28)), 28)));
    }
}