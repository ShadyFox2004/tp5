package utilitaires;

import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;

/**
 * Classe utilitaires pour la gestion de fichiers
 *
 * @author Samuel Nguyen-Phok
 */
public class FichierUtilitaires
{

    /**
     * Enregistrer un message (une chaîne) dans un fichier (PrintWriter)
     *
     * @param message:    le message à enregistrer
     * @param nomFichier: un objet File, le fichier dans lequel il faut
     *                    enregistrer le message
     * @return vrai si le message a été enregistré.
     */
    public static boolean enregistrerMessage(String message, File nomFichier)
    {
        boolean isSaved = true;
        try
        {
            PrintWriter write = new PrintWriter(new FileWriter(nomFichier));
            write.println(message);
            write.flush();
            write.close();
        } catch (IOException e)
        {
            isSaved = false;
        }
        return isSaved;
    }

    /**
     * Lire seulement la première ligne (une chaîne) du fichier reçu
     *
     * @param nomFichier, un File dans lequel lire.
     * @return la ligne lue
     */
    public static String lireMessage(File nomFichier)
    {
        String msg = "";
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader(nomFichier));
            msg = buff.readLine();
            buff.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * Lire un fichier de mots. Chaque mot est sur une ligne différente. Chaque
     * mot doit être mis en minuscule et on doit enlever les espaces de chaque
     * bout (voir la classe String). Il faut aussi éliminer les doublons.
     *
     * @param nomDic le nom du fichier dictionnaire
     * @return un SortedSet des mots du dictionnaire ou null s'il n'y a pas de mot
     * dans le fichier.
     */
    public static SortedSet<String> lireDictionnaire(File nomDic) {
        FileInputStream inputStream = null;
        Scanner scan = null;
        Set<String> set = new HashSet<>();
        try {
            inputStream = new FileInputStream(nomDic);
            scan = new Scanner(inputStream, "UTF-8");
            while (scan.hasNextLine()) {
                set.add(scan.nextLine());
            }

            if (scan.ioException() != null) {
                throw scan.ioException();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scan != null) {
                scan.close();
            }
        }

        return new TreeSet<>(set);
    }

    /**
     * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
     * dialogue graphique.
     *
     * @param option: le nom du bouton principal
     * @return un File, le fichier sélectionné ou null
     */
    public static File obtenirNomFichier(String option)
    {
        JFileChooser chooser = new JFileChooser(".");
        chooser.showDialog(null, option);
        return chooser.getSelectedFile();
    }

    /**
     * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
     * dialogue graphique.
     *
     * @param option:  le nom du bouton principal
     * @param fichier: le nom du fichier pré-sélectionné
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
