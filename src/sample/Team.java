package sample;

import java.util.Arrays;

public class Team {
    private String[] teamDetails = new String[12];

    public String[] getTeamDetails() {
        return teamDetails;
    }

    public void setTeamDetails(String[] teamDetails) {
        this.teamDetails = teamDetails;
        String stringTeamDetails = Arrays.toString(teamDetails);
        stringTeamDetails = stringTeamDetails + "\n";
        File_Writer fw = new File_Writer("Team.txt", stringTeamDetails);
    }
}
