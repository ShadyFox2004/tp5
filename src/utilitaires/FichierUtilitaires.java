package utilitaires;

import java.io.File;
import java.util.SortedSet;

import javax.swing.JFileChooser;

/**
 * Classe utilitaires pour la gestion de fichiers
 *
 * @author Vos noms
 */
public class FichierUtilitaires
{

	/**
	 * Enregistrer un message (une chaîne) dans un fichier (PrintWriter)
	 *
	 * @param message: le message à enregistrer
	 * @param nomFichier: un objet File, le fichier dans lequel il faut
	 *            enregistrer le message
	 *
	 * @return vrai si le message a été enregistré.
	 */
	// TODO enregistrerMessage - Compléter le code de la méthode
	public static boolean enregistrerMessage(String message, File nomFichier)
	{
		return true;
	}

	/**
	 * Lire seulement la première ligne (une chaîne) du fichier reçu
	 *
	 * @param nomFichier, un File dans lequel lire.
	 *
	 * @return la ligne lue
	 */
	// TODO lireMessage - Compléter le code de la méthode
	public static String lireMessage(File nomFichier)
	{
		return "";
	}

	/**
	 * Lire un fichier de mots. Chaque mot est sur une ligne différente. Chaque
	 * mot doit être mis en minuscule et on doit enlever les espaces de chaque
	 * bout (voir la classe String). Il faut aussi éliminer les doublons.
	 *
	 * @param nomDic le nom du fichier dictionnaire
	 *
	 * @return un SortedSet des mots du dictionnaire ou null s'il n'y a pas de mot
	 *         dans le fichier.
	 */
	// TODO lireDictionnaire - Compléter le code de la méthode
	public static SortedSet<String> lireDictionnaire(File nomDic)
	{
		return null;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 * 
	 * @param option: le nom du bouton principal
	 * 
	 * @return un File, le fichier sélectionné ou null
	 */
	// TODO obtenirNomFichier - Compléter le code de la méthode
	public static File obtenirNomFichier(String option)
	{
		return null;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 *
	 * @param option: le nom du bouton principal
	 * @param fichier: le nom du fichier pré-sélectionné
	 *
	 * @return un File, le fichier sélectionné ou null
	 */
	public static File obtenirNomFichier(String option, File fichier)
	{
		File f = null;
		JFileChooser chooser = new JFileChooser(".");
		chooser.setSelectedFile(fichier);

		if (chooser.showDialog(null, option) == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();

		return f;
	}
}
