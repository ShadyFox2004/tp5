package utilitaires;

import javax.swing.JOptionPane;

/**
 * Classe utilitaire pour la saisie.
 * 
 */
public class InputUtilitaires
{
	/**
	 * Permet de saisir un entier. La saisie est non bloquante. Isole le try ...
	 * catch du parseInt
	 * 
	 * @param pQuestion chaîne permettant de poser une question.
	 * 
	 * @return Integer, un objet entier (Integer) permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 * 
	 */
	public static Integer saisirEntier(String pQuestion)
	{
		return InputUtilitaires.saisirEntier(pQuestion, "Saisir un entier");
	}

	/**
	 * Permet de saisir un entier. La saisie est non bloquante. Isole le try ...
	 * catch du parseInt
	 * 
	 * @param pQuestion chaîne permettant de poser une question.
	 * @param pTitre chaîne qui servira de titre à la boîte de dialogue
	 * 
	 * @return Integer, un objet entier (Integer) permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 * 
	 */
	public static Integer saisirEntier(String pQuestion, String pTitre)
	{
		Integer objetEntier = null;
		boolean valide = false;
		String reponse = "";

		// Saisir tant que pas valide
		do
		{
			// Boîte de dialogue de saisie
			reponse = JOptionPane.showInputDialog(null, pQuestion, pTitre,
					JOptionPane.QUESTION_MESSAGE);

			if (reponse != null)
			{
				try
				{
					objetEntier = new Integer(Integer.parseInt(reponse));
					valide = true;
				}
				catch (Exception e)
				{
					valide = false;
				}
			}
		}
		while (!valide && reponse != null);

		return objetEntier;
	}

	/**
	 * Permet de saisir une chaîne de caractères. La saisie est non bloquante.
	 * 
	 * @param pQuestion chaîne permettant de poser une question.
	 * 
	 * @return String un objet chaîne de caractères permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 */
	public static String saisirString(String pQuestion)
	{
		return InputUtilitaires.saisirString(pQuestion,
				"Saisir une chaîne de caractères");
	}

	/**
	 * Permet de saisir une chaîne de caractères. La saisie est non bloquante.
	 * 
	 * @param pQuestion chaîne permettant de poser une question.
	 * @param pTitre chaîne qui servira de titre à la boîte de dialogue
	 * 
	 * @return String un objet chaîne de caractères permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 */
	public static String saisirString(String pQuestion, String pTitre)
	{
		String stringTemp = null;
		boolean valide = false;
		String reponse = "";

		// Saisir tant que pas valide
		do
		{
			// Boîte de dialogue de saisie
			reponse = JOptionPane.showInputDialog(null, pQuestion, pTitre,
					JOptionPane.QUESTION_MESSAGE);

			if (reponse != null)
			{
				stringTemp = reponse;
				valide = true;
			}
		}
		while (!valide && reponse != null);

		return stringTemp;
	}
}
