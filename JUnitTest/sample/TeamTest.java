package sample;

import junit.framework.TestCase;
import org.junit.Test;

public class TeamTest extends TestCase {

    @Test
    public void testGetTeamDetails() {
        String[] teamDetails = {"SriLanka","a","b","c","d","e","f","g","h","i","j","k"};
        Team test = new Team();
        test.setTeamDetails(teamDetails);
        assertEquals(teamDetails,test.getTeamDetails());
    }
}