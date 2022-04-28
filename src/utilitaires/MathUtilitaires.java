package utilitaires;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe utilitaires pour les calculs mathématiques
 *
 * @author Vos noms
 */
public class MathUtilitaires
{

    /**
     * Calcul de la factorielle d'une valeur > ou = à 1. Doit être récursif.
     *
     * @param valFact la valeur
     * @return la valeur de la factorielle pour la valeur reçue. 1 si la valeur
     * reçue n'est pas valide.
     */
    public static double fact(int valFact)
    {
        if (valFact <= 1)
        {
            valFact = 1;
        } else
        {
            valFact = (int) (valFact * fact(valFact - 1));
        }
        return valFact;
    }

    /**
     * Retourne le modulo (selon sa définition mathématique) de valeurs positives
     * ou négatives reçues. L'opérateur % peut être utilisé.
     * <p>
     * Attention : Vérifier vos résultats surtout pour des valeurs négatives!!!
     * Voir la définition mathématique (partie entière E) sur wiki
     * https://fr.wikipedia.org/wiki/Modulo_(op%C3%A9ration)
     * <p>
     * Ce calculateur donne les bons résultats:
     * https://www.miniwebtool.com/modulo-calculator/
     *
     * @param pVal la valeur
     * @param pMod le modulo
     * @return la valeur du modulo.
     * @throws ArithmeticException pour la division par zéro.
     */
    // TODO modulo - Compléter le code de la méthode
    public static int modulo(int pVal, int pMod) throws ArithmeticException
    {
        double division = pVal / pMod;
        int divisionModulo = pVal%pMod;
        int division_tronque;
        if(divisionModulo == 0 || division > 0){
            division_tronque = (int) Math.floor(division);
        }
        else{
            division_tronque = (int)(division -1);
        }
        return pVal - (division_tronque * pMod);
    }

    /**
     * Retourne un ensemble des diviseurs positifs distincts d'une valeur
     * entière positive ou négative. Utilise méthode modulo. Ex. 12 ou -12
     * donnerait 1,2,3,4,6,12
     *
     * @param pVal: la valeur
     * @return un ensemble de diviseurs positifs ou null si la valeur est 0
     * (infinité de valeurs).
     */
    // TODO diviseursDe - Compléter le code de la méthode
    public static SortedSet<Integer> diviseursDe(int pVal)
    {
        Set<Integer> diviseur = new HashSet<Integer>();
        int end = (int) Math.sqrt(Math.abs(pVal));
        for(int i = 1; i< end; i++)
        {
            if( modulo(pVal,i) == 0 )
            {
                diviseur.add(i);
            }

        }
        diviseur.add(Math.abs(pVal));

        return new TreeSet<Integer>(diviseur);
    }

    /**
     * Retourne vrai si la valeur reçue est un nombre premier.
     * <p>
     * Un nombre premier est plus grand que 1 et admet exactement deux diviseurs
     * distincts entiers et positifs qui sont alors 1 et lui-même.
     *
     * @param pVal , la valeur
     * @return vrai si la valeur reçue est un nombre premier, faux sinon
     */
    // TODO estPremier - Compléter le code de la méthode
    public static boolean estPremier(int pVal)
    {
        return diviseursDe(pVal).size() == 2;
    }

    /**
     * Retourne un ensemble des X nombres premiers entre 1 et la valeur reçue.
     *
     * @param pVal la valeur
     * @return un ensemble des X nombres premiers ou null si aucun nombre
     * premier trouvé.
     */
    // TODO xPremier - Compléter le code de la méthode
    public static SortedSet<Integer> xPremier(int pVal)
    {
        Set<Integer> tabVals = new HashSet<Integer>();
        for(int i = 0; i < pVal; i++){
            if(estPremier(i)){
                tabVals.add(i);
            }
        }
        if(tabVals.size()==0){
            tabVals = null;
        }
        return new TreeSet<Integer>(tabVals);
    }

    /**
     * Retourne le Plus Grand Commun Diviseur entre deux nombres. Utilise la
     * méthode modulo et la récursivité.
     * <p>
     * Il est possible d'utiliser la division euclidienne récursive pour trouver
     * le PGCD (Plus Grand Commun Diviseur)
     *
     * @param pVal1 une valeur
     * @param pVal2 une autre valeur
     * @return le PGCD ou 0
     */
    // TODO PGCD - Compléter le code de la méthode
    public static int PGCD(int pVal1, int pVal2)
    {
        return 0;
    }

    /**
     * Retourne l'ensemble des nombres qui sont "premier entre eux" avec la
     * valeur valRef reçue. La valeur valDepart reçue étant la valeur de départ
     * de la recherche de ces nombres.
     * <p>
     * En mathématiques, on dit que 2 entiers a et b sont premiers entre eux, si
     * leur plus grand commun diviseur (PGCD) est égal à 1 ; en d'autres termes, s'ils
     * n'ont aucun diviseur autre que 1 et –1 en commun. De manière équivalente,
     * ils sont premiers entre eux si, et seulement si, ils n'ont aucun facteur
     * premier en commun.
     * <p>
     * Exemple : l'ensemble des nombres qui sont "premier entre eux" avec 26 en
     * partant de 1 est {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25}
     *
     * @param valDepart la valeur de départ. Avant de chercher les "premier
     *                  entre eux" , si valDepart est négative, la mettre à 1.
     * @param valRef    la valeur de référence.
     * @return un ensemble des X nombres "premiers entres eux" avec valRef à
     * partir de valDepart reçue ou null.
     */
    // TODO xPremierEntreEux - Compléter le code de la méthode
    public static SortedSet<Integer> xPremierEntreEux(int valDepart, int valRef)
    {
        return null;
    }

    /**
     * Retourne aléatoirement une valeur entière entre 2 valeurs reçues. Inverse
     * le min et le max s'ils ne sont pas corrects (en ordre).
     *
     * @param pMin une valeur
     * @param pMax une autre valeur
     * @return la valeur générée aléatoirement.
     */
    // TODO alea - Compléter le code de la méthode
    public static int alea(int pMin, int pMax)
    {
        // si les val min/max sont incorrecte ont les permutes
        if (pMax < pMin)
        {
            int temp = 0;
            temp = pMin;
            pMin = pMax;
            pMax = temp;
        }
        return (int) Math.floor(Math.random() * (pMax - pMin + 1) + pMin);
    }

    /**
     * Calcule le nombre de combinaisons différentes possibles si l'on choisit
     * un nombre d'éléments dans un ensemble sans remise, sans tenir compte de
     * l'ordre et sans répétition.
     * <p>
     * Voir "Wikipédia" : https://fr.wikipedia.org/wiki/Combinatoire
     *
     * @param nbrElement     le nombre d'éléments dans l'ensemble
     * @param nbrElementPris longueur des combinaisons ou le nombre d'éléments
     *                       pris pour chaque combinaison.
     * @return le nombre de combinaisons possible.
     */
    public static int nbrCombinaison(int nbrElement, int nbrElementPris)
    {
        return (int) ((MathUtilitaires.fact(nbrElement)
                / MathUtilitaires.fact(nbrElement - nbrElementPris))
                / MathUtilitaires.fact(nbrElementPris));
    }

}
