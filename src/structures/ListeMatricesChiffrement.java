package structures;

import exceptions.ConstructeurException;
import utilitaires.MathUtilitaires;
import utilitaires.MatriceUtilitaires;

import java.util.*;

/**
 * Classe qui permet de faire la gestion des matrices candidates pour le chiffre
 * de Hill. Les matrices sont produites à partir des combinaisons sans ordre et
 * sans remise sur un ensemble de valeurs prédéterminées.
 *
 * Utilise la classe "ListeCombinatoire" pour générer les combinaisons de
 * valeurs potentielles pour former les matrices.
 *
 * @author Henri Baillargeon
 *
 */
public class ListeMatricesChiffrement implements iMatrice
{

	/**
	 * Valeurs minimum et maximum composant les matrices de chiffrement, donc
	 * les listes combinatoires.
	 */
	private int borneInf = 0;
	private int borneSup = 0;

	/**
	 * Dimension des matrices de chiffrement, elles sont carrées.
	 */
	private int dimension = 0;

	/**
	 * Modulation, valeur en relation avec la longueur du vecteur de caractères
	 * "VecteurDeCaracteres" (table de correspondance) pour le chiffrement.
	 */
	private int coefDansZ = 0;

	/**
	 * Pointeur sur la matrice courante
	 */
	private int[][] matriceCourante = null;

	/**
	 * Liste de matrices candidates
	 */
	List<int[][]> listeMatricesCandidates = null;

	/**
	 * Constructeur, permet d'initialiser l'ensemble des attributs, de faire
	 * générer la liste des matrices candidates et de choisir au hasard une
	 * matrice parmi l'ensemble de matrices générées.
	 *
	 * @param pBorneInf valeur minimum pour construire les matrices à partir des
	 *            combinatoires
	 * @param pBorneSup valeur maximum pour construire les matrices à partir des
	 *            combinatoires
	 * @param pDimension dimension de la matrice [pDimension X pDimension]
	 * @param pCoefDansZ Modulation, valeur en relation avec la longueur du
	 *            vecteur de caractères (table de correspondance) pour le
	 *            chiffrement.
	 *
	 * @throws ConstructeurException
	 */
	public ListeMatricesChiffrement(int pBorneInf, int pBorneSup,
			int pDimension, int pCoefDansZ) throws ConstructeurException
	{
		//j'ai modifier les set pour qu'il retourne un boolean pour rendre la verification plus rapide.
		if(setDimension(pDimension)){
			throw new ConstructeurException("dimension invalide");
		}

		if (setBornes(pBorneInf, pBorneSup)) {
			throw new ConstructeurException("les bornes son invalide");
		}

		if(setCoefDansZ(pCoefDansZ)){
			throw new ConstructeurException("le coefficient est invalide");
		}
		genererListeMatrices(new ListeCombinatoire
				(pBorneInf, pBorneSup, (int) Math.pow(pDimension, 2)));
		choisirMatriceCourante();

	}

	public int getBorneInf()
	{
		return borneInf;
	}

	public int getBorneSup()
	{
		return borneSup;
	}

	public int getDimension()
	{
		return dimension;
	}

	public int getCoefDansZ()
	{
		return coefDansZ;
	}

	private int[][] getMatriceCourante()
	{
		return matriceCourante;
	}

	private boolean setBornes(int pBorneInf, int pBorneSup)
	{
		boolean ok = validerBornes(pBorneInf = Math.min(pBorneInf, pBorneSup),
				pBorneSup = Math.max(pBorneInf, pBorneSup));

		if (ok)
		{
			this.borneInf = pBorneInf;
			this.borneSup = pBorneSup;
		}
		return !ok;
	}

	private boolean setDimension(int pDimension)
	{
		boolean ok = validerDimension(pDimension);

		if (ok)
		{
			this.dimension = pDimension;
		}
		return !ok;
	}

	private boolean setCoefDansZ(int pCoefDansZ)
	{
		boolean ok = validerCoefDansZ(pCoefDansZ);

		if (ok)
		{
			this.coefDansZ = pCoefDansZ;
		}
		return !ok;
	}

	private void setMatriceCourante(int[][] pMat)
	{
		matriceCourante = pMat;
	}

	private boolean validerBornes(int pBorneInf, int pBorneSup)
	{
		return (pBorneInf >= 0) && (pBorneSup >= 0) && (pBorneInf <= pBorneSup);
	}

	private boolean validerDimension(int pDimension)
	{
		return (pDimension > 0);
	}

	private boolean validerCoefDansZ(int pCoefDansZ)
	{
		return (pCoefDansZ > 0);
	}

	private boolean validerIndex(int index)
	{
		return (index >= 0) && (index < getNombreMatricesCandidates());
	}

	/**
	 * Obtenir le nombre de matrices candidates pour le chiffrement
	 *
	 * @return le nombre de matrices candidates
	 */
	public int getNombreMatricesCandidates()
	{
		return listeMatricesCandidates.size();
	}

	/**
	 * Permet de choisir une matrice au hasard parmi les matrices disponibles
	 * dans une liste de matrices candidates, comme matrice courante ou null si
	 * la liste est vide.
	 */
	@Override
	public void choisirMatriceCourante() {
		choisirMatriceCourante(MathUtilitaires.alea(0, getNombreMatricesCandidates() - 1));
	}

	/**
	 * Choisir, selon l'index reçu, la matrice courante à partir d'une liste de
	 * matrices ou null si l'index est invalide
	 *
	 * @param index l'index de la matrice voulue
	 */
	@Override
	public void choisirMatriceCourante(int index)
	{
		matriceCourante = null;
		if (validerIndex(index)){
			setMatriceCourante(listeMatricesCandidates.get(index));
		}

	}

	/**
	 * Permet d'obtenir une copie de la matrice courante, pas le pointeur.
	 *
	 * @return une copie de la matrice courante ou null si pas de matrice
	 *         courante
	 */
	@Override
	public int[][] getCopieMatriceCourante()
	{
		int nbrRang = matriceCourante.length;
		int nbrColonne = matriceCourante[0].length;
		int[][] mCopie = new int[nbrRang][nbrColonne];

		for(int i = 0; i < nbrRang; i++){

			for(int j = 0; j < nbrColonne; j++){

				mCopie[i][j] = matriceCourante[i][j];

			}
		}

		return mCopie;
	}

	/**
	 * Permet d'obtenir la matrice inverse pour le chiffre de Hill basé sur une
	 * copie de la matrice courante. La matrice inverse de Hill est la matrice,
	 * résultant du produit scalaire de la matrice adjointe par le déterminant
	 * inverse, modulo la force brute (le coefficient dans Z)
	 *
	 * @return Le pointeur sur la matrice inverse pour le chiffre de Hill ou
	 *         null si pas de matrice courante.
	 */
	@Override
	public int[][] getMatriceCouranteInverseHill()
	{
//		int[][] inverse = MatriceUtilitaires.getMatAdjointe(getCopieMatriceCourante());
//		int detHill = MatriceUtilitaires.getDeterminantInverseHill
//				(MatriceUtilitaires.getDeterminant(matriceCourante), getCoefDansZ());

		return MatriceUtilitaires.getMatModuloX(MatriceUtilitaires.getMatMultScalaire
				(MatriceUtilitaires.getMatAdjointe
						(getCopieMatriceCourante()), MatriceUtilitaires.getDeterminantInverseHill
						(MatriceUtilitaires.getDeterminant(matriceCourante), getCoefDansZ())), getCoefDansZ());
	}

	/**
	 * À partir de liste des combinatoires reçue, cette méthode génère les
	 * matrices qui seront candidates pour le chiffrement de Hill et les place
	 * dans la liste de matrices candidates. (chaque combinaison devient une matrice)
	 *
	 * Pour qu'une matrice soit candidate, il faut que la valeur du déterminant
	 * de la matrice soit premier avec la valeur du coefficient dans Z
	 * ("modulo")
	 *
	 * Ou si vous voulez il faut que le PGCD entre le déterminant de la matrice
	 * et le coefficient dans Z soit égale à 1.
	 *
	 * @param pListe, la liste des combinatoires selon les données de l'objet...
	 */
	private void genererListeMatrices(ListeCombinatoire pListe)
	{
		List<int[][]> listeMatrices = new ArrayList<>();
		for(int i = 0; i < pListe.getLongCombinaison(); i ++ ){
			int[][] matTemp = listeAMatriceNxN(pListe.getCombinaison(i));
			if(estCanditate(matTemp)){
				listeMatrices.add(matTemp);
			}
		}
		listeMatricesCandidates = listeMatrices;
	}

	private int[][] listeAMatriceNxN(List<Integer> liste){
		int n = (int) Math.sqrt(liste.size());
		int[][] mat = new int[n][n];
		for (int i = 0; i< n; i++){
			for (int j=0; j< n; j++){
				mat[i][j] = liste.get(i+j);
			}
		}
		return mat;
	}

	private boolean estCanditate(int[][] mat){
		return MathUtilitaires.PGCD(MatriceUtilitaires.getDeterminant(mat),getCoefDansZ()) == 1;
	}
}
