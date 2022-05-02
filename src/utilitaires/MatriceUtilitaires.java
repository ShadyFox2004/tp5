package utilitaires;

import java.util.Iterator;
import java.util.SortedSet;

/**
 * Classe utilitaires pour la gestion des matrices carrées
 *
 * @author Henri Baillargeon
 */
public class MatriceUtilitaires
{

	/**
	 * Permet de produire une chaîne de caractères pour l'affichage d'une
	 * matrice N X M dans la console. Très utile pour faire des tests.
	 *
	 * <pre>
	 *  Exemple d'affichage voulu:
	 *
	 *  [6, 1, -5]
	 *  [-2, -5, 4]
	 *  [-3, 3, -1]
	 * </pre>
	 *
	 * @param mat la matrice N X M à afficher
	 *
	 * @return la chaîne de caractères
	 */

	public static String toStringMat(int[][] mat)
	{
		String str = "";
		for(int i = 0; i < mat.length; i++){
			str += "[";
			for(int j = 0; j < mat[0].length; j++){
				str += mat[i][j];

				if(j < mat[0].length- 1) {
					str += ", ";
				}
			}
			str += "]\n";
		}
		return str;
	}

	/**
	 * Retourne la matrice carrée M X N transposée à partir d'une matrice carrée
	 * N X M reçue.
	 *
	 * La matrice transposée d'une matrice est obtenue en échangeant les lignes
	 * et les colonnes.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée M X N transposée
	 */

	public static int[][] getMatTranspose(int[][] mat) {
		int[][] Tmat = null;
		Tmat = new int[mat[0].length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				Tmat[j][i] = mat[i][j];
			}
		}
		return Tmat;
	}

	/**
	 * Retourne la matrice carrée (N-1) X (N-1) mineure d'une matrice carrée N X
	 * N reçue.
	 *
	 * Est la matrice carrée résultante, lorsque l'on supprime toutes les
	 * valeurs de la ligne et de la colonne reçues, à partir la matrice
	 * d'origine reçue.
	 *
	 * @param mat la matrice d'origine
	 * @param ligne la ligne de valeurs à supprimer
	 * @param col la colonne de valeurs à supprimer
	 *
	 * @return la matrice carrée (N-1) X (N-1) mineure résultante
	 *
	 */

	private static int[][] getMatMineur(int[][] mat, int ligne, int col)
	{
		int iM = 0;
		int jM = 0;
		int limiteL = mat.length;
		int limiteC = mat[0].length;
		int[][] mineur = new int[mat.length -1][mat[0].length -1];

		//si la derniere ligne ou colonne est celle choisie, nous devons efficacement les sauté
		if(ligne == mat.length-1 || mat.length == 2) {
			limiteL = mat.length-1;
		}
		if(col == mat[0].length-1 || mat[0].length == 2) {
			limiteC = mat[0].length -1;
		}

		//construction de le matrice mineur. si le compteur de ligne est égale a la ligne prise en argument
		//il vas la sauté. c,est la même chose pour les colonnes
		for(int i = 0; i < limiteL; i++){
			if(i == ligne){
				i++;
			}
			for(int j = 0; j < limiteC; j++){
				if(j == col){
					j++;
				}
				mineur[iM][jM] = mat[i][j];
				jM++;

			}
			jM = 0;
			iM++;
		}
		return mineur;
	}

	/**
	 * Retourne une matrice N X M résultant de la multiplication d'un scalaire
	 * reçu avec chaque élément d'une matrice N X M reçue. Pas d'arrondi (partie
	 * entière)
	 *
	 * @param mat la matrice d'origine
	 * @param scalaire le scalaire
	 *
	 * @return la matrice résultante de la multiplication avec un scalaire
	 */

	public static int[][] getMatMultScalaire(int[][] mat, float scalaire)
	{
		int[][] matB = new int[mat.length][mat[0].length];
		for(int i = 0; i < mat.length; i ++){
			for(int j = 0; j < mat[0].length; j++){
				matB[i][j] = (int) Math.floor(mat[i][j]*scalaire);
			}
		}
		return matB;
	}

	/**
	 * Retourne une matrice N X M résultant de l'application d'un modulo reçu,
	 * sur chaque élément d'une matrice N X M reçue. Utilise la méthode modulo
	 * de MathUtilitaires.
	 *
	 * @param mat la matrice d'origine
	 * @param mod le modulo à appliquer
	 *
	 * @return la matrice résultante de l'application d'un modulo
	 */
	public static int[][] getMatModuloX(int[][] mat, int mod)
	{
		int[][] matB = new int[mat.length][mat[0].length];
		for(int i = 0; i < mat.length; i ++){
			for(int j = 0; j < mat[0].length; j++){
				matB[i][j] = MathUtilitaires.modulo(mat[i][j],mod);
			}
		}
		return matB;
	}

	/**
	 * Calcule le déterminant d'une matrice carrée de N X N.
	 *
	 * ATTENTION ; Il existe plusieurs façons de calculer un déterminant, il
	 * faut faire de la recherche.
	 *
	 * Devrait être une méthode récursive...
	 *
	 * @param mat la matrice carrée pour les calculs.
	 *
	 * @return le déterminant de la matrice.
	 */
	public static int getDeterminant(int[][] mat)
	{
		int det = 0;
		if(mat.length > 1) {
			for (int j = 0; j < mat.length; j++) {
				//recursion puisque la methode getCofact appeal de nouveau getDeterminant
				//Il est bien de savoir que le cofacteur de Matrice 2x2 ne sera pas utiliser
				// car il ne respecte pas la grandeur minimale. nous passeron donc au 'else{}'
				det += getCofact(0,j,mat) * mat[0][j];
				//det += symbole(0, j) * mat[0][j] * getDeterminant(getMatMineur(mat, 0, j));
			}
		}
		else{
			det = mat[0][0];
		}
		return det;
	}

	/**
	 * donne le cofacteur (-1)^(i+j)*|M|
	 * ou |M| = au determinant de la matrice mineur
	 *
	 * tres utile pour trouver le determinant d'une matrice et pour trouver la Matrice cofecteur
	 * @param i rang
	 * @param j colonne
	 * @param mat matrice carree qui sera utilisee
	 * @return le cofacteur de la valeur de la matrice a la position (i, j)
	 */
	private static int getCofact(int i,int j, int[][] mat){
		return (int)(Math.pow(-1,(i +j)) * getDeterminant(getMatMineur(mat, i, j)));
	}


	/**
	 * Retourne la matrice carrée des cofacteurs N X N d'une matrice carrée N X
	 * N reçue, utile pour déterminer la matrice adjointe.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée des cofacteurs de la matrice d'origine
	 */
	public static int[][] getMatCofacteurs(int[][] mat)
	{
		int[][] cmat = new int[mat.length][mat[0].length];
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				cmat[i][j] = getCofact(i,j,mat);
			}
		}
		return cmat;
	}

	/**
	 * Retourne la matrice N X N adjointe à partir d'une matrice N X N reçue.
	 *
	 * Est la matrice transposée des cofacteurs de la matrice d'origine.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée N X N adjointe
	 */
	public static int[][] getMatAdjointe(int[][] mat)
	{
		return getMatTranspose(getMatCofacteurs(mat));
	}

	/**
	 * Calcule le déterminant inverse du chiffre de Hill selon la force brute.
	 *
	 * @param valDet déterminant de la matrice d'origine
	 * @param valMod la valeur du modulo pour le calcul
	 *
	 * @return la valeur du déterminant inverse ou 0
	 */
	public static int getDeterminantInverseHill(int valDet, int valMod)
	{
		int detInv = 0;
		SortedSet<Integer> premierEntreEux = MathUtilitaires.xPremierEntreEux(0,
				valMod);

		Iterator<Integer> it = premierEntreEux.iterator();
		Integer nb = 0;

		while (it.hasNext() && (detInv == 0))
		{
			nb = it.next();
			if (MathUtilitaires.modulo((valDet * nb), valMod) == 1)
			{
				detInv = nb;
			}
		}

		return detInv;
	}

}
