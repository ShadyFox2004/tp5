package tests;

import org.junit.Before;
import org.junit.Test;
import utilitaires.FichierUtilitaires;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe test la classe FichierUtilitaire
 *
 * @author Samuel Nguyen-Phok
 */
public class FichierUtilitairesTest
{
    private FichierUtilitaires file;

    @Before
    public void setUp() throws Exception
    {
        file = new FichierUtilitaires();
    }

    @Test
    public void enregistrerMessage()
    {
        File fileObject = new File("text1");
        file.enregistrerMessage("Hello World !", new File("text1"));
        assertEquals(true, fileObject.exists());
    }

    @Test
    public void lireMessage()
    {
        File f = new File("text2");
        file.enregistrerMessage("Hello World !", f);
        assertEquals("Hello World !", file.lireMessage(f));
    }

    @Test
    public void lireDictionnaire() throws FileNotFoundException
    {
        // filepath specific a l,ordi de l'école
        SortedSet<String> dict = file.lireDictionnaire(new File("/home/wildsource/IdeaProjects/tp5/dictionnaire.txt"));
        System.out.println(dict.toString());
    }

    @Test
    public void obtenirNomFichier()
    {
        // filepath specific a mon ordi
        File compare = new File("/home/wildsource/IdeaProjects/tp5/dictionnaire.txt");
        assertEquals(compare, file.obtenirNomFichier("click dictionaire"));
        assertEquals(null, file.obtenirNomFichier("return null test click cancel"));
    }
}