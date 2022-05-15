package tests;

import static org.junit.Assert.assertEquals;

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
    public void ajusterMessageBrute() {
        String message = "My message";

        String expected = "My message  ";

        assertEquals(expected.toString(), messageChiffrerDechiffrer.ajusterMessageBrute(message, expected.length()));
    }
}
