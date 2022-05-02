package tests;

import org.junit.Before;
import org.junit.Test;
import utilitaires.MatriceUtilitaires;
import static org.junit.Assert.*;

public class MatriceUtilitairesTest {
    int[][] mat1,mat2,mat3,mat4, mat5, mat6;

    @Before
    public void setUp() throws Exception{
        mat1 = new int[][]{{1, 2}, {3, 4}};
        mat2 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        mat3 = new int[][]{{1,2,3,13},{4,5,6,14},{7,8,9,15},{10,11,12,16}};
        mat4 = new int[][]{{-1,-2,-3},{-4,-5,-6},{-7,-8,-9}};
        mat5 = new int[][]{{5,5,5,5,5},{0,5,5,5,5},{0,0,5,5,5},{0,0,0,5,5},{0,0,0,0,5}};
        mat6 = new int[][]{{6,6,6,6,6,6},{0,6,6,6,6,6},{0,0,6,6,6,6},{0,0,0,6,6,6},{0,0,0,0,6,6},{0,0,0,0,0,6}};
    }

    @Test
    public void toStringMat() {
        System.out.println(MatriceUtilitaires.toStringMat(mat2));

    }

    @Test
    public void getMatTranspose() {
        int[][] matT = MatriceUtilitaires.getMatTranspose(mat2);
        assertEquals("[1, 4, 7]\n[2, 5, 8]\n[3, 6, 9]\n", 
                     MatriceUtilitaires.toStringMat(matT));


    }

    @Test
    public void getMatMultScalaire() {
        int[][] mat = MatriceUtilitaires.getMatMultScalaire(mat1,2);
        assertTrue(MatriceUtilitaires.toStringMat(mat).equals("[2, 4]\n[6, 8]\n"));
        mat = MatriceUtilitaires.getMatMultScalaire(mat2, -1.1f);
        assertTrue(MatriceUtilitaires.toStringMat(mat).equals("[-2, -3, -4]\n[-5, -6, -7]\n[-8, -9, -10]\n"));
    }

    @Test
    public void getMatModuloX() {
        int[][] mat = MatriceUtilitaires.getMatModuloX(mat1,2);
        assertTrue(MatriceUtilitaires.toStringMat(mat).equals("[1, 0]\n[1, 0]\n"));
        mat = MatriceUtilitaires.getMatModuloX(mat2, 5);
        assertTrue(MatriceUtilitaires.toStringMat(mat).equals("[1, 2, 3]\n[4, 0, 1]\n[2, 3, 4]\n"));
    }

    @Test
    public void getDeterminant() {
        int det = MatriceUtilitaires.getDeterminant(mat1);
        assertEquals(-2,det);
        det = MatriceUtilitaires.getDeterminant(mat2);
        assertEquals(0,det);
        det = MatriceUtilitaires.getDeterminant(mat3);
        assertEquals(0,det);
        det = MatriceUtilitaires.getDeterminant(mat5);
        System.out.println(det);
        assertEquals(3125,det);
        det = MatriceUtilitaires.getDeterminant(mat6);
        assertEquals(46656, det);
    }

    @Test
    public void getMatCofacteurs() {
        int[][] matCo = MatriceUtilitaires.getMatCofacteurs(mat1);
        assertEquals("[4, -3]\n[-2, 1]\n",
            MatriceUtilitaires.toStringMat(matCo));
        matCo = MatriceUtilitaires.getMatCofacteurs(mat4);
        assertEquals("[-3, 6, -3]\n[6, -12, 6]\n[-3, 6, -3]\n",
            MatriceUtilitaires.toStringMat(matCo));
    }

    @Test
    public void getMatAdjointe() {
        int[][] matA = MatriceUtilitaires.getMatAdjointe(mat1);
        assertEquals("[4, -2]\n[-3, 1]\n",
            MatriceUtilitaires.toStringMat(matA));
        matA = MatriceUtilitaires.getMatAdjointe(mat2);
        assertEquals("[-3, 6, -3]\n[6, -12, 6]\n[-3, 6, -3]\n",
            MatriceUtilitaires.toStringMat(matA));
        matA = MatriceUtilitaires.getMatAdjointe(mat3);
        assertEquals("[0, 0, 0, 0]\n[0, 0, 0, 0]\n[0, 0, 0, 0]\n[0, 0, 0, 0]\n",
            MatriceUtilitaires.toStringMat(matA));
    }

//    @Test
//    public void getMatriceMineur(){
//        int[][] mat = MatriceUtilitaires.getMatMineur(mat2, 2, 2);
//        System.out.println(MatriceUtilitaires.toStringMat(mat));
//    }
}
