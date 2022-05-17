package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import structures.ListeMatricesChiffrement;
import structures.MessageChiffrerDechiffrer;
import structures.VecteurDeCaracteres;
import utilitaires.FichierUtilitaires;

import java.io.File;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Henri Baillargeon
 */

public class MessageChiffrerDechiffrerTest {
    private MessageChiffrerDechiffrer messageChiffrerDechiffrer;
    
    @Before
    public void setUp() {
        SortedSet<String> dico = FichierUtilitaires.lireDictionnaire(new File("/home/henrib/tp5/text1"));
        VecteurDeCaracteres vecteurDeCaracteres = new VecteurDeCaracteres();
        ListeMatricesChiffrement listMat = new ListeMatricesChiffrement(1,15,3,28);
        messageChiffrerDechiffrer = new MessageChiffrerDechiffrer(vecteurDeCaracteres,listMat, dico);
    }

    @Test
    public void validerMessageSelonDico() {
        //Lower case
        System.out.println(messageChiffrerDechiffrer.validerMessageSelonDico("bonjour le monde", 100));
        
        //Upper case
        assertTrue(messageChiffrerDechiffrer.validerMessageSelonDico("BONJOUR LE MONDE", 100));
        assertFalse(messageChiffrerDechiffrer.validerMessageSelonDico("NULL", 40));
    }
    
    @Test
    public void ajusterMessageBrute() {
        String message = "My message";

        String expected = "My message  ";

        assertEquals(expected.toString(), messageChiffrerDechiffrer.ajusterMessageBrute(message, expected.length()));
    }

    @Test
    public void decoder(){

    }

    
}
