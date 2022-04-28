package structures;

import java.util.*;

import exceptions.ConstructeurException;

import javax.security.auth.callback.CallbackHandler;

/**
 * Classe qui permet de produire une liste de caractères selon une constante ou
 * selon un tableau de caractères reçu.
 *
 * @author Samuel Nguyen-Phok
 */
public class VecteurDeCaracteres
{

    private static final char[] TAB_CHAR_DEFAUT =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-'};

    private List<Character> tableCaracteres = null;

    /**
     * Constructeur sans paramètre. Permet de remplir un tableau indexé de
     * caractères avec les caractères de A à Z, l'espace et le "-". Met tous les
     * caractères en majuscule.
     * <p>
     * Utilise le constructeur avec paramètres
     *
     * @throws ConstructeurException
     */
    public VecteurDeCaracteres() throws ConstructeurException
    {
        try
        {
            // creer le tableau a ajouter dans l'attribut
            List<Character> tableau = new ArrayList<>();

            // remplir le tableau avec le tableau par defaut
            for (char caractere : TAB_CHAR_DEFAUT)
            {
                tableau.add(new Character(caractere));
            }
            // setter le tableau en tant qu'attribut
            setTableCaracteres(tableau);
        } catch (ConstructeurException e)
        {
            throw e;
        }

    }

    /**
     * Constructeur avec paramètre. Permet d'instancier et de remplir l'attribut
     * tableCaracteres, un tableau indexé de caractères à partir du tableau de
     * "char" reçu. Met tous les caractères en majuscule. Il faut que le tableau
     * de caractères contienne au moins 1 caractère.
     *
     * @throws ConstructeurException si tabChar est invalide
     */
    public VecteurDeCaracteres(char[] tabChar) throws ConstructeurException
    {
        // le tableau recu doit avoir au moins 1 caractere
        if (tabChar.length >= 1)
        {
            List<Character> tab = new ArrayList<>();
            for (char caractere : tabChar)
            {
                tab.add(new Character(caractere));
            }
            setTableCaracteres(tab);
        } else
        {
            throw new ConstructeurException("tableau recu ne possede pas asser de caractere");
        }
    }

    /**
     * Retourne le caractère présent à l'index reçu
     *
     * @param index: l'index du caractère
     * @return le caractère selon l'index
     * @throws ArrayIndexOutOfBoundsException
     */
    public char getCaractere(int index) throws ArrayIndexOutOfBoundsException
    {
        return getTableCaracteres().get(index);
    }

    /**
     * Retourne l'indice, dans le vecteur de caractères, du caractère reçu
     *
     * @param car le caractère à trouver
     * @return l'indice du caractère ou -1 si le caractère n'est pas trouvé
     */
    public int getIndice(char car)
    {
        return getTableCaracteres().indexOf(new Character(car));
    }

    /**
     * La taille du vecteur de caractères
     *
     * @return la taille
     */
    public int getTaille()
    {
        return getTableCaracteres().size();
    }

    /**
     * Retourne le tableau de caractere
     *
     * @return tableCaractere
     */
    public List<Character> getTableCaracteres()
    {
        return tableCaracteres;
    }

    /**
     * etablie le tableau de caractere
     *
     * @param tableCaracteres tableauCaractere
     */
    public void setTableCaracteres(List<Character> tableCaracteres)
    {
        this.tableCaracteres = tableCaracteres;
    }

    /**
     * Permet de construire une chaîne de caractères structurée pour afficher les
     * infos d'un objet VecteurDeCaracteres
     *
     * <pre>
     * Exemple de sortie voulue:
     *
     * TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
     * </pre>
     */
    //TODO I didn't code this the teacher did
    @Override
    public String toString()
    {
        return "Table de correspondance = " + this.tableCaracteres;
    }
}
