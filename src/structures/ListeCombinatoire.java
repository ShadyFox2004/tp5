package structures;

import exceptions.ConstructeurException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui permet de produire une liste de listes de combinaison d'entiers
 * sans remise sans tenir compte de l'ordre à partir d'une liste d'entiers de
 * départ.
 * <p>
 * Voir les combinatoires sur "Wikipédia" :
 * https://fr.wikipedia.org/wiki/Combinatoire
 *
 * @author Samuel Nguyen-Phok et Antoine-Mathis Boudreau
 */
public class ListeCombinatoire {
    public static final int VALEUR_ENS_MIN = 0;
    public static final int VALEUR_ENS_MAX = 50;
    public static final int LONGUEUR_COMBINAISON_MIN = 1;

    private int debutEns = 0;
    private int finEns = 0;
    private int longCombinaison = 0;
    private List<List<Integer>> listeDeCombinaisons = null;
    private List<Integer> ensembleValeurs = null;


    /**
     * Valide et initialise les attributs de la classe. Il génère le vecteur de
     * valeurs selon les bornes reçues. Il génère les listes combinatoires en
     * respectant la longueur voulue et le vecteur de valeurs.
     *
     * @param pValDebut        la borne min pour l'ensemble des valeurs
     * @param pValFin          la borne max pour l'ensemble des valeurs
     * @param pLongCombinaison la longueur des combinaisons
     * @throws ConstructeurException execption de constructeur
     */
    // TODO ListeCombinatoire - Compléter le code de la méthode
    public ListeCombinatoire(int pValDebut, int pValFin, int pLongCombinaison)
            throws ConstructeurException {
       List<Integer> combinaisonTemp = new ArrayList<Integer>();
       listeDeCombinaisons = new ArrayList<>();

        if (validerLimitesEns(pValDebut, pValFin) && validerLongCombinaison(pLongCombinaison, pValFin -pValDebut + 1)) {
            setLimitesEns(pValDebut, pValFin);
            setLongCombinaison(pLongCombinaison);
            setEnsembleValeurs(genererEnsembleValeurs());

            produireListeCombinaisons(ensembleValeurs, pLongCombinaison, combinaisonTemp);
        }
    }

    public int getDebutEns() {
        return debutEns;
    }

    public int getFinEns() {
        return finEns;

    }

    public int getLongCombinaison() {
        return longCombinaison;
    }

    private List<Integer> getEnsembleValeurs() {
        return ensembleValeurs;
    }

    public List<Integer> getCombinaison(int index) {
        return listeDeCombinaisons.get(index);
    }

    private List<List<Integer>> getListeDeCombinaisons() {
        return listeDeCombinaisons;
    }

    public int getTailleListeDeCombinaisons() {
        return listeDeCombinaisons.size();
    }

    private void setLimitesEns(int pDebutEns, int pFinEns) {
        // Au besoin, inversion des valeurs pour simplement éviter les
        // erreurs...
        boolean ok = validerLimitesEns(pDebutEns = Math.min(pDebutEns, pFinEns),
                pFinEns = Math.max(pDebutEns, pFinEns));

        if (ok) {
            this.debutEns = pDebutEns;
            this.finEns = pFinEns;
        }
    }

    private void setLongCombinaison(int pLongCombinaison) {
        boolean ok = validerLongCombinaison(pLongCombinaison,
                ((getFinEns() - getDebutEns()) + 1));

        if (ok) {
            this.longCombinaison = pLongCombinaison;
        }
    }

    private void setEnsembleValeurs(List<Integer> pEnsemble) {
        this.ensembleValeurs = pEnsemble;
    }

    private void setListeDeCombinaisons(List<List<Integer>> listeDeCombinaisons) {
        this.listeDeCombinaisons = listeDeCombinaisons;
    }

    private boolean validerLimitesEns(int pValDebut, int pValFin) {
        return ((pValDebut < pValFin)
                && (pValDebut >= ListeCombinatoire.VALEUR_ENS_MIN)
                && (pValDebut <= ListeCombinatoire.VALEUR_ENS_MAX)
                && (pValFin >= ListeCombinatoire.VALEUR_ENS_MIN)
                && (pValFin <= ListeCombinatoire.VALEUR_ENS_MAX));
    }

    private boolean validerLongCombinaison(int pLongCombinaison,
                                           int pLongEnsemble) {
        return ((pLongCombinaison >= ListeCombinatoire.LONGUEUR_COMBINAISON_MIN)
                && (pLongCombinaison <= pLongEnsemble));
    }

    /**
     * Génère la liste de valeurs entre les bornes début et de fin incluses.
     * Considérer cet ensemble comme référence pour produire les combinaisons.
     *
     * @return une liste d'entiers entre les bornes début et fin
     */
    public List<Integer> genererEnsembleValeurs()
    {
        List<Integer> ensembleValeurs = new ArrayList<Integer>();

        for (int i = debutEns; i <= finEns; i++) {
            ensembleValeurs.add(i);
        }

        return ensembleValeurs;
    }

    /**
     * Permet de produire les combinaisons sans remise.
     * <p>
     * Devrait être une méthode récursive.
     * <p>
     * Source : Voir sur le web, plusieurs algos disponibles.
     * <p>
     * Attention : Bien faire vos tests, c'est très facile de vous tromper...
     * <p>
     * intéressant : http://jm.davalan.org/mots/comb/comb/combalgo.html
     */
    private void produireListeCombinaisons(List<Integer> pEnsembleValeurs,
                                           int pLongueurRestante, List<Integer> pCombinaisonCourante) {
        // Backup de la taille de la liste de la combinaison courante
        int longCombinaisonCourante = pCombinaisonCourante.size();

        for (int i = 0, longEnsembleValeurs = pEnsembleValeurs.size();
             i < longEnsembleValeurs && pLongueurRestante <= longEnsembleValeurs - i; i++) {
            // Ajoute l'élément i à la combinaison courante
            pCombinaisonCourante.add(pEnsembleValeurs.get(i));

            // La combinaison courante est-elle complète
            if (pLongueurRestante == 1) {
                listeDeCombinaisons.add(new ArrayList<Integer>(pCombinaisonCourante));
            } else {
                // Demander une nouvelle combinaison avec le reste des valeurs
                // de l'ensemble
                produireListeCombinaisons(pEnsembleValeurs.subList(i + 1, longEnsembleValeurs),
                        pLongueurRestante - 1, pCombinaisonCourante);
            }

            // Ajuster le contenant de la combinaison courante pour enlever le
            // ou les valeurs de trop
            pCombinaisonCourante = pCombinaisonCourante.subList(0, longCombinaisonCourante);
        }
    }

    /**
     * Permet de construire une chaîne de caractères structurée pour afficher
     * les infos d'un objet ListeCombinatoire.
     * <p>
     * Évolue selon le développement...
     * <pre>
     * Exemple de sortie voulue:
     *
     * Limite de l'ensemble : [1, 20]
     * Longueur combinaison : 4
     * Ensemble : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
     * Voici les 4845 combinaisons : [[1, 2, 3, 4], [1, 2, 3, 5], [1, 2, 3, 6], [1, 2, 3, 7], ... , [16, 18, 19, 20], [17, 18, 19, 20]]
     *
     * </pre>
     */
    // TODO toString - Compléter le code de la méthode
    @Override
    public String toString() {
        return "Limite de l'ensemble : [" + this.getDebutEns() + ", " + this.getFinEns() + "] \n" +
                "Longueur combinaison : " + this.getLongCombinaison() + "\n" +
                "Ensemble : " + this.getEnsembleValeurs().toString() + "\n" +
                "Voici les " + this.getTailleListeDeCombinaisons() + " combinaisons : " + this.getListeDeCombinaisons().toString();
    }
}
