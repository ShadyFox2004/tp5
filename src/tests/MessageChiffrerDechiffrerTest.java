package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import structures.MessageChiffrerDechiffrer;

public class MessageChiffrerDechiffrerTest {
    private MessageChiffrerDechiffrer messageChiffrerDechiffrer;
    
    @Before
    public void setUp() {
        messageChiffrerDechiffrer = new MessageChiffrerDechiffrer(null, null, null);
    }

    @Test
    public void validerMessageSelonDico() {
        //Lower case
        assertTrue(messageChiffrerDechiffrer.validerMessageSelonDico("bonjour le monde", 100));
        
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

    
}
