package simples_tests_sans_junit;

import utilitaires.FichierUtilitaires;
import utilitaires.InputUtilitaires;

import java.io.File;
import java.util.SortedSet;

import structures.ListeMatricesChiffrement;
import structures.VecteurDeCaracteres;
import utilitaires.MatriceUtilitaires;
import structures.MessageChiffrerDechiffrer;

public class MessageChiffrerDechiffrer_SimpleTest 
{
	private static final int MIN = 1;
	private static final int MAX = 20;
	private static final int DIM_MAT = 4;

	private static VecteurDeCaracteres vecCaracteres = new VecteurDeCaracteres();
	private static ListeMatricesChiffrement listeDeMatricesCandidates = null;
	private static SortedSet<String> dico = FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt"));

	public static void main(String[] args) 
	{
		String message = "";
		MessageChiffrerDechiffrer mesChiffrerDechiffrer = null;

		if ((message = InputUtilitaires.saisirString("Entrez un message à chiffrer (sans accent)",
				"Saisir message")) != null) 
		{
			listeDeMatricesCandidates = new ListeMatricesChiffrement(MIN, MAX, DIM_MAT, vecCaracteres.getTaille());

			mesChiffrerDechiffrer = new MessageChiffrerDechiffrer(vecCaracteres, listeDeMatricesCandidates, dico);

			System.out.println("Vecteur de caractères utilisé : " + vecCaracteres);
			System.out.println("Nombre de matrices " + listeDeMatricesCandidates.getDimension() + " X "
					+ listeDeMatricesCandidates.getDimension() + " candidates : "
					+ listeDeMatricesCandidates.getNombreMatricesCandidates());

			System.out.println();
			System.out.println(
					"Message à chiffrer : [" + message + "] - d'une longueur de " + message.length() + " caractères.");

			System.out.println();
			message = mesChiffrerDechiffrer.encoder(message);
			System.out.println("Matrice choisie au hasard, pour le chiffrement, parmi les matrices candidates :\n"
					+ MatriceUtilitaires.toStringMat(mesChiffrerDechiffrer.getMatriceCourante()));
			System.out.println(
					"Message encodé: [" + message + "] - d'une longueur de " + message.length() + " caractères.");

			System.out.println();
			if ((message = mesChiffrerDechiffrer.decoder(message)) != null) 
			{
				System.out.println("Matrice trouvée, pour le déchiffrement, parmi les matrices candidates :\n"
						+ MatriceUtilitaires.toStringMat(mesChiffrerDechiffrer.getMatriceCourante()));

				System.out.println(
						"Message decodé: [" + message + "] - d'une longueur de " + message.length() + " caractères.");
			} 
			else
				System.out.println("Aucune matrice trouvée pour déchiffrer le message...");

		} 
		else
			System.out.println("Aucun message à chiffrer...");
	}

	/**
	 * Sortie selon les valeurs d'origine : MIN = 1, MAX = 20, DIM_MAT = 4
	 * 
	 * <pre>
	 * Vecteur de caractères utilisé : TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * Nombre de matrices 4 X 4 candidates : 924
	 * 
	 * Message à chiffrer : [Un petit message pour le codage] - d'une longueur de 31 caractères.
	 * 
	 * Matrice choisie au hasard, pour le chiffrement, parmi les matrices candidates :
	 * [1, 2, 4, 5]
	 * [6, 7, 9, 10]		//Peut être différente car choisie au hasard
	 * [12, 13, 14, 15]	
	 * [16, 17, 18, 20]
	 * 
	 * Message encodé: [BHSVB-UPQIKQGGYAQ-XHVDAMRSTGDADS] - d'une longueur de 32 caractères.
	 * 
	 * Matrice trouvée, pour le déchiffrement, parmi les matrices candidates :
	 * [1, 2, 4, 5]
	 * [6, 7, 9, 10]		//Peut être différente car choisie au hasard
	 * [12, 13, 14, 15]
	 * [16, 17, 18, 20]
	 * 
	 * Message decodé: [UN PETIT MESSAGE POUR LE CODAGE ] - d'une longueur de 32 caractères.
	 *
	 *
	 *  Sortie selon les valeurs:  MIN = 1, MAX = 10, DIM_MAT = 3
	 *
	 * Vecteur de caractères utilisé : Table De Correspondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * Nombre de matrices 3 X 3 candidates : 4
	 *
	 * Message à chiffrer : [bonjour les amis] - d'une longueur de 16 caractères.
	 *
	 * Matrice choisie au hasard, pour le chiffrement, parmi les matrices candidates :
	 * [1, 2, 3]
	 * [4, 5, 6]
	 * [7, 9, 10]
	 *
	 * Message encoder: [MMLNCZSMPGKCUYUIWE] - d'une longueur de 18 caractères.
	 *
	 * Matrice trouvée, pour le déchiffrement, parmi les matrices candidates :
	 * [1, 2, 3]
	 * [4, 5, 6]
	 * [7, 9, 10]
	 *
	 * Message decoder: [BONJOUR LES AMIS  ] - d'une longueur de 18 caractères.
	 *
	 * </pre>
	 */
}
