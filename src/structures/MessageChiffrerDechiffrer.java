package structures;

import java.util.*;

import exceptions.ConstructeurException;
import utilitaires.MathUtilitaires;

/**
 * Cette classe sert a chiffrer et dechiffrer les strings reçuent
 *
 * @author Henri Baillargeon et Antoine-Mathis Goudreau
 */
public class MessageChiffrerDechiffrer implements iCrypto
{
    // Si le caractère de remplacement est un espace on peut mettre au moins 80%
    public static final float POURCENTAGE_ACCEPTABLE = 0.8f;
    public static final char CAR_DE_COMPLEMENT = ' ';

    private VecteurDeCaracteres vecCaracteres = null;
    private ListeMatricesChiffrement listeMatricesCandidates = null;
    private SortedSet<String> dico = null;

    /**
     * Constructeur, permet d'affecter les différents attributs à partir des
     * objets reçus en entrée. Avant d'affecter les attributs de la classe avec
     * les objets reçus en entrée, il faut valider ces derniers (<> null et pas
     * vide).
     *
     * @param vecCars   la table de caractères pour la correspondance lors de
     *                  l'encodage et du décodage.
     * @param listeMats liste des matrices candidates.
     * @param dico      liste des mots pour la validation lors du décodage.
     * @throws ConstructeurException
     */
    // TODO MessageChiffrerDechiffrer - Compléter le code de la méthode
    public MessageChiffrerDechiffrer(VecteurDeCaracteres vecCars,
                                     ListeMatricesChiffrement listeMats, SortedSet<String> dico)
            throws ConstructeurException
    {
    }

    private void setVecCaracteres(VecteurDeCaracteres pVec)
    {
        if (validerVecCaracteres(pVec))
        {
            this.vecCaracteres = pVec;
        }
    }

    private void setMatsEncodage(ListeMatricesChiffrement listeMats)
    {
        if (validerMatsEncodage(listeMats))
        {
            this.listeMatricesCandidates = listeMats;
        }
    }

    private void setDico(SortedSet<String> dico)
    {
        if (validerDico(dico))
        {
            this.dico = dico;
        }
    }

    private static boolean validerVecCaracteres(VecteurDeCaracteres pVec)
    {
        return ((pVec != null) && (pVec.getTaille() > 0));
    }

    private static boolean validerMatsEncodage(
            ListeMatricesChiffrement listeMats)
    {
        return ((listeMats != null)
                && (listeMats.getNombreMatricesCandidates() > 0));
    }

    private static boolean validerDico(SortedSet<String> dico)
    {
        return ((dico != null) && !dico.isEmpty());
    }

    /**
     * Obtenir la matrice courante qui a été utilisée par l'encodage ou le
     * décodage. Très utile pour les tests.
     *
     * @return la matrice courante utilisée à partir de l'objet
     * "listeMatricesCandidates".
     */
    public int[][] getMatriceCourante()
    {
        return listeMatricesCandidates.getCopieMatriceCourante();
    }

    @Override
    // TODO faire les tests avec un dico
    public boolean validerMessageSelonDico(String message,
                                           float pourcentageDeReussite)
    {
        boolean passe;

        StringTokenizer messageTokenizer; // Will serve to iterate through the message; 
        int nbOfTokenMatching = 0;

        messageTokenizer = new StringTokenizer(message.toLowerCase(), " "); // Splits the String into tokens
        int tokenNb = messageTokenizer.countTokens(); // Creates a token count so it can create a percentage.

        while(messageTokenizer.hasMoreTokens())
            if(dico.contains(messageTokenizer.nextToken()))
                nbOfTokenMatching++;

        passe = (float)nbOfTokenMatching/(float)tokenNb >= pourcentageDeReussite;
    
        return passe;
    }

    @Override
    public String ajusterMessageBrute(String message, int longVoulue)
    {
        String reponse = message;

        while(reponse.length() < longVoulue) reponse += " ";

        return reponse;
    }

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
    @Override
    // TODO encoder - Compléter le code de la méthode
    public String encoder(String message)
    {
        if(MathUtilitaires.PGCD(3,message.length()) != 1) {
           int modulo = MathUtilitaires.modulo(message.length(), 3);
           for (int i = 0; i < modulo; i++){
               message += " ";
           }
        }

        int[] strTabval = new int[message.length()];
        for (int cptString = 0; cptString < message.length(); cptString++) {
            strTabval[cptString] = vecCaracteres.getIndice(message.charAt(cptString));
        }

        listeMatricesCandidates.choisirMatriceCourante();
        int[][] mat = listeMatricesCandidates.getCopieMatriceCourante();

        return chiffrementDeHill(mat, strTabval);

    }

    private String chiffrementDeHill(int[][] mat, int[] msgEnVal){
        String str = "";
        //initialisation du compteur des indice de la string.
        for (int cptString = 0; cptString < msgEnVal.length; cptString++) {

            // double boucle for pour naviguer dans le tableau
            for (int cptRang = 0; cptRang < 3; cptRang++) {

                //total du calcule
                int totale = 0;
                for (int cptCol = 0; cptCol < 3; cptCol++) {
                    //partie du calcule du charactere mystere
                    totale += mat[cptRang][cptCol] * msgEnVal[cptCol];
                }

                //addition du caractere mystere a la string.
                str += MathUtilitaires.modulo(vecCaracteres.getCaractere(totale),
                        listeMatricesCandidates.getCoefDansZ());

            }
        }
        return str;
    }


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
    @Override
    // TODO decoder - Compléter le code de la méthode
    public String decoder(String message) {

        //nombre de matrice possible
        int nbrMatC = listeMatricesCandidates.getNombreMatricesCandidates();

        //changer le message en valeur indicielle du vecteur de caractere contenue dans un tableaus
        int[] strTabval = new int[message.length()];
        for (int cptString = 0; cptString < message.length(); cptString++) {
            strTabval[cptString] = vecCaracteres.getIndice(message.charAt(cptString));
        }

        //initialisation de la string de retoure
        String str = null;

        for (int cptMat = 0; cptMat < nbrMatC; cptMat++) {

            //choisie la matrice qui sera tester
            listeMatricesCandidates.choisirMatriceCourante(cptMat);
            int[][] matHl = listeMatricesCandidates.getMatriceCouranteInverseHill();

            str = chiffrementDeHill(matHl, strTabval);
            //je ne voyait plus le bout du tunnel donc j'ai mis un break
            if (str != null && validerMessageSelonDico(str, 0.8f)) {
                break;
            }else{
                str = null;
            }
        }

        //retourne la string decripter ou null.
        return str;
    }
}
