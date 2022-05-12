package structures;

public interface iCrypto
{

	/**
	 * Permet de valider un message avec les mots du dictionnaire. Évalue si les
	 * mots du message concordent avec les mots du dictionnaire selon un
	 * pourcentage reçu.
	 *
	 * @param message le message à valider.
	 * @param pourcentageDeReussite le pourcentage de réussite voulue.
	 *
	 * @return vrai si la concordance du message est >= au pourcentage reçu et
	 *         faux sinon.
	 */
	public boolean validerMessageSelonDico(String message,
			float pourcentageDeReussite);

	/**
	 * Ajuste la longueur du message pour qu'elle soit divisible sans reste par
	 * le paramètre "diviseur". Elle ajoute autant de caractères de complément
	 * qu'il faut pour obtenir le bon résultat.
	 *
	 * @param message le message à ajuster
	 * @param diviseur la valeur du diviseur pour établir la nouvelle longueur
	 *
	 * @return le message ajusté
	 */
	public String ajusterMessageBrute(String message, int longVoulue);

	/**
	 * Permet de chiffrer le message reçu en entrée. Cette méthode choisit une
	 * matrice au hasard dans l'ensemble des matrices candidates. Elle ajuste la
	 * longueur du message selon la dimension de la matrice choisie. Pour
	 * terminer elle encode le message selon le chiffrement de Hill à l'aide de
	 * la copie de la matrice choisie.
	 *
	 * @param message le message à chiffrer.
	 *
	 * @return le message chiffré.
	 */
	public String encoder(String message);

	/**
	 * Permet de déchiffrer le message reçu en entrée. Cette méthode essaie de
	 * trouver la matrice de chiffrement qui a servi à chiffrer le message reçu
	 * parmi toutes les matrices candidates disponibles. Elle itère en prenant
	 * l'inverse de Hill de chacune des matrices candidates et déchiffre le
	 * message. Une fois déchiffré elle valide les mots du message avec les mots
	 * du dictionnaire. Si la concordance des mots est bonne, la méthode conclut
	 * que le message est déchiffré et retourne ce dernier. Sinon elle passe à
	 * la prochaine matrice candidate. Si aucune matrice n'est trouvée la
	 * méthode retourne null.
	 *
	 * @param message le message à déchiffrer.
	 *
	 * @return le message déchiffré ou null.
	 */
	public String decoder(String message);
}
