package sample;

import junit.framework.TestCase;
import org.junit.Test;

public class PlayerTest extends TestCase {

    @Test
    public void testTestGetName() {
        String name = "Ridmika";
        Player testPlayer = new Player(name);
        assertEquals(name,testPlayer.getName());
    }
}