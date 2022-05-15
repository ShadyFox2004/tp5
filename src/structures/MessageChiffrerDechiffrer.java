package structures;

import java.util.SortedSet;
import java.util.StringTokenizer;

import exceptions.ConstructeurException;
import utilitaires.MathUtilitaires;
import utilitaires.MatriceUtilitaires;

/**
 * Cette classe sert a chiffrer et dechiffrer les strings reçuent
 *
 * @author Henry Baillargeon
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
    // TODO validerMessageSelonDico - Compléter le code de la méthode
    public boolean validerMessageSelonDico(String message,
                                           float pourcentageDeReussite)
    {
        return true;
    }

    @Override
    public String ajusterMessageBrute(String message, int longVoulue)
    {
        String reponse = message;

        while(reponse.length() < longVoulue) reponse += " ";

        return reponse;
    }

    @Override
    // TODO encoder - Compléter le code de la méthode
    public String encoder(String message)
    {
        return "";
    }

    @Override
    // TODO decoder - Compléter le code de la méthode
    public String decoder(String message)
    {
        return "";
    }
}
