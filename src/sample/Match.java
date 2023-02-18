package sample;
import java.util.Arrays;
import java.util.Random;

public class Match {
    private String[] Team1 = new String[12];
    private String[] Team2 = new String[12];
    String outputF = "";
    String outputS = "";
    String winToss;
    String summary = "";
    int target;

    public Match(String[] Team1, String[] Team2){
        this.Team1 = Team1;
        this.Team2 = Team2;
    }

    public void firstInning(){
        //Toss
        String tName1 = Team1[0];
        String tName2 = Team2[0];
        String[] teamNames = {tName1, tName2};
        winToss = randomSelect(teamNames);
        outputF += winToss + " win the toss and choose to bat first\n\n";
        summary += tName1+" and "+tName2+"\n"+winToss + " win the toss and choose to bat first\nFirst Inning\n";

        //Set player objects
        BatsMan battingPlayer1;
        BatsMan battingPlayer2;
        BatsMan battingPlayer3;
        BatsMan battingPlayer4;
        BatsMan battingPlayer5;
        BatsMan battingPlayer6;
        BatsMan battingPlayer7;
        BatsMan battingPlayer8;
        BatsMan battingPlayer9;
        BatsMan battingPlayer10;
        BatsMan battingPlayer11;

        Bawler bawler1;
        Bawler bawler2;
        Bawler bawler3;
        Bawler bawler4;
        Bawler bawler5;

        if (winToss == tName1){
            battingPlayer1 = new BatsMan(Team1[1]);
            battingPlayer2 = new BatsMan(Team1[2]);
            battingPlayer3 = new BatsMan(Team1[3]);
            battingPlayer4 = new BatsMan(Team1[4]);
            battingPlayer5 = new BatsMan(Team1[5]);
            battingPlayer6 = new BatsMan(Team1[6]);
            battingPlayer7 = new BatsMan(Team1[7]);
            battingPlayer8 = new BatsMan(Team1[8]);
            battingPlayer9 = new BatsMan(Team1[9]);
            battingPlayer10 = new BatsMan(Team1[10]);
            battingPlayer11 = new BatsMan(Team1[11]);

            bawler1 = new Bawler(Team2[7]);
            bawler2 = new Bawler(Team2[8]);
            bawler3 = new Bawler(Team2[9]);
            bawler4 = new Bawler(Team2[10]);
            bawler5 = new Bawler(Team2[11]);
        }
        else {
            battingPlayer1 = new BatsMan(Team2[1]);
            battingPlayer2 = new BatsMan(Team2[2]);
            battingPlayer3 = new BatsMan(Team2[3]);
            battingPlayer4 = new BatsMan(Team2[4]);
            battingPlayer5 = new BatsMan(Team2[5]);
            battingPlayer6 = new BatsMan(Team2[6]);
            battingPlayer7 = new BatsMan(Team2[7]);
            battingPlayer8 = new BatsMan(Team2[8]);
            battingPlayer9 = new BatsMan(Team2[9]);
            battingPlayer10 = new BatsMan(Team2[10]);
            battingPlayer11 = new BatsMan(Team2[11]);

            bawler1 = new Bawler(Team1[7]);
            bawler2 = new Bawler(Team1[8]);
            bawler3 = new Bawler(Team1[9]);
            bawler4 = new Bawler(Team1[10]);
            bawler5 = new Bawler(Team1[11]);
        }

        outputF += "Opening Batsman: " + battingPlayer1.getName() + " and " + battingPlayer2.getName()+"\n";
        outputF += "Ballers: "+bawler1.getName()+" , "+bawler2.getName()+" , "+bawler3.getName()+" , "+bawler4.getName()+" , "+bawler5.getName()+"\n\n";

        int wicketCount = 0;
        int totalScore = 0;
        int over = 1;
        int ballerCount = 0;
        int batsManCount = 0;
        String[] batsmen = {battingPlayer1.getName(),battingPlayer2.getName(),battingPlayer3.getName(),battingPlayer4.getName(),battingPlayer5.getName(),battingPlayer6.getName(),battingPlayer7.getName(),battingPlayer8.getName(),battingPlayer9.getName(),battingPlayer10.getName(),battingPlayer11.getName()};
        String[] ballers = {bawler1.getName(),bawler2.getName(),bawler3.getName(),bawler4.getName(),bawler5.getName()};
        int[] ballerWicketCount= {0,0,0,0,0};
        int[] batsmenScore = {0,0,0,0,0,0,0,0,0,0,0};
        String[] expectation = {"0", "1", "2", "3", "4", "5", "6", "NB", "WD", "W"};
        String[] wType = {"Runout", "Wicket", "Stump", "Lbw", "Catch"};

        while (over != 21){
            outputF += "over: " + over + " baller: " + ballers[ballerCount] + "\n";
            int ball = 1;

            while (ball < 7){
                String expect = randomSelect(expectation);

                switch (expect){
                    case "W":
                        wicketCount++;
                        String wicketType = randomSelect(wType);
                        outputF += batsmen[batsManCount] + " out   wicket type: " + wicketType +"\n";
                        batsManCount++;
                        ballerWicketCount[ballerCount] += 1;
                        if ((wicketCount == 10) || ((batsManCount == 10))) {
                            outputF += "All out \n";
                            break;
                        }
                        outputF += "new batsman: "+batsmen[batsManCount] + "\n";
                        break;

                    case "NB":
                        outputF += "No Ball\n";
                        ball--;
                        totalScore += 1;
                        break;

                    case "WD":
                        outputF += "Wide Ball\n";
                        ball--;
                        totalScore += 1;
                        break;

                    case "0":
                        outputF += "Dot Ball\n";

                    case "1":
                        outputF += "1 run\n";
                        int[] scoredPlayer = {batsManCount,batsManCount+1};
                        int playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 1;
                        totalScore += 1;
                        break;

                    case "2":
                        outputF += "2 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 2;
                        totalScore += 2;
                        break;

                    case "3":
                        outputF += "3 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 3;
                        totalScore += 3;
                        break;

                    case "4":
                        outputF += "4 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 4;
                        totalScore += 4;
                        break;

                    case "5":
                        outputF += "5 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 5;
                        totalScore += 5;
                        break;

                    case "6":
                        outputF += "6 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 6;
                        totalScore += 6;
                        break;
                }
                ball++;
                if ((wicketCount == 10) || ((batsManCount == 10))) {
                    break;
                }
            }
            ballerCount++;
            if (ballerCount == 5) {
                ballerCount = 0;
            }

            if ((wicketCount == 10) || ((batsManCount == 10))) {
                break;
            }
            outputF += "\n";
            over++;

        }
        outputF += "Total Score: "+totalScore+"\n";
        target = totalScore+1;
        summary += "\nballers,\n"+ Arrays.toString(ballers) +"\n"+ Arrays.toString(ballerWicketCount) +"\n"+"batsmen,\n"+ Arrays.toString(batsmen) +"\n"+ Arrays.toString(batsmenScore) +"Total Score:"+totalScore+"\nSecond Inning";
    }

    public void secondInning(){
        String tName1 = Team1[0];
        String tName2 = Team2[0];
        String batTeam;
        String ballerTeam;

        //Set player objects
        BatsMan battingPlayer1;
        BatsMan battingPlayer2;
        BatsMan battingPlayer3;
        BatsMan battingPlayer4;
        BatsMan battingPlayer5;
        BatsMan battingPlayer6;
        BatsMan battingPlayer7;
        BatsMan battingPlayer8;
        BatsMan battingPlayer9;
        BatsMan battingPlayer10;
        BatsMan battingPlayer11;

        Bawler bawler1;
        Bawler bawler2;
        Bawler bawler3;
        Bawler bawler4;
        Bawler bawler5;

        if (winToss == tName1){
            battingPlayer1 = new BatsMan(Team2[1]);
            battingPlayer2 = new BatsMan(Team2[2]);
            battingPlayer3 = new BatsMan(Team2[3]);
            battingPlayer4 = new BatsMan(Team2[4]);
            battingPlayer5 = new BatsMan(Team2[5]);
            battingPlayer6 = new BatsMan(Team2[6]);
            battingPlayer7 = new BatsMan(Team2[7]);
            battingPlayer8 = new BatsMan(Team2[8]);
            battingPlayer9 = new BatsMan(Team2[9]);
            battingPlayer10 = new BatsMan(Team2[10]);
            battingPlayer11 = new BatsMan(Team2[11]);

            bawler1 = new Bawler(Team1[7]);
            bawler2 = new Bawler(Team1[8]);
            bawler3 = new Bawler(Team1[9]);
            bawler4 = new Bawler(Team1[10]);
            bawler5 = new Bawler(Team1[11]);
            batTeam = tName2;
            ballerTeam = tName1;
        }
        else {
            battingPlayer1 = new BatsMan(Team1[1]);
            battingPlayer2 = new BatsMan(Team1[2]);
            battingPlayer3 = new BatsMan(Team1[3]);
            battingPlayer4 = new BatsMan(Team1[4]);
            battingPlayer5 = new BatsMan(Team1[5]);
            battingPlayer6 = new BatsMan(Team1[6]);
            battingPlayer7 = new BatsMan(Team1[7]);
            battingPlayer8 = new BatsMan(Team1[8]);
            battingPlayer9 = new BatsMan(Team1[9]);
            battingPlayer10 = new BatsMan(Team1[10]);
            battingPlayer11 = new BatsMan(Team1[11]);

            bawler1 = new Bawler(Team2[7]);
            bawler2 = new Bawler(Team2[8]);
            bawler3 = new Bawler(Team2[9]);
            bawler4 = new Bawler(Team2[10]);
            bawler5 = new Bawler(Team2[11]);
            batTeam = tName1;
            ballerTeam = tName2;
        }

        outputS += "Second Ining\n\n"+batTeam+"\n";
        outputS += "Opening Batsman: " + battingPlayer1.getName() + " and " + battingPlayer2.getName()+"\n";
        outputS += "Ballers: "+bawler1.getName()+" , "+bawler2.getName()+" , "+bawler3.getName()+" , "+bawler4.getName()+" , "+bawler5.getName()+"\n\n";

        int wicketCount = 0;
        int totalScore = 0;
        int over = 1;
        int ballerCount = 0;
        int batsManCount = 0;
        String[] batsmen = {battingPlayer1.getName(),battingPlayer2.getName(),battingPlayer3.getName(),battingPlayer4.getName(),battingPlayer5.getName(),battingPlayer6.getName(),battingPlayer7.getName(),battingPlayer8.getName(),battingPlayer9.getName(),battingPlayer10.getName(),battingPlayer11.getName()};
        String[] ballers = {bawler1.getName(),bawler2.getName(),bawler3.getName(),bawler4.getName(),bawler5.getName()};
        int[] ballerWicketCount= {0,0,0,0,0};
        int[] batsmenScore = {0,0,0,0,0,0,0,0,0,0,0};
        String[] expectation = {"0", "1", "2", "3", "4", "5", "6", "NB", "WD", "W"};
        String[] wType = {"Runout", "Wicket", "Stump", "Lbw", "Catch"};

        while (over != 21){
            outputS += "over: " + over + " baller: " + ballers[ballerCount] + "\n";
            int ball = 1;

            while (ball < 7){
                String expect = randomSelect(expectation);

                switch (expect){
                    case "W":
                        wicketCount++;
                        String wicketType = randomSelect(wType);
                        outputS += batsmen[batsManCount] + " out   wicket type: " + wicketType +"\n";
                        batsManCount++;
                        ballerWicketCount[ballerCount] += 1;
                        if ((wicketCount == 10) || ((batsManCount == 10))) {
                            outputS += "All out \n";
                            break;
                        }
                        outputS += "new batsman: "+batsmen[batsManCount] + "\n";
                        break;

                    case "NB":
                        outputS += "No Ball\n";
                        ball--;
                        totalScore += 1;
                        break;

                    case "WD":
                        outputS += "Wide Ball\n";
                        ball--;
                        totalScore += 1;
                        break;

                    case "0":
                        outputS += "Dot Ball\n";

                    case "1":
                        outputS += "1 run\n";
                        int[] scoredPlayer = {batsManCount,batsManCount+1};
                        int playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 1;
                        totalScore += 1;
                        if (target<=totalScore){
                            break;
                        }
                        break;

                    case "2":
                        outputS += "2 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 2;
                        totalScore += 2;
                        if (target<=totalScore){
                            break;
                        }
                        break;

                    case "3":
                        outputS += "3 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 3;
                        totalScore += 3;
                        if (target<=totalScore){
                            break;
                        }
                        break;

                    case "4":
                        outputS += "4 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 4;
                        totalScore += 4;
                        if (target<=totalScore){
                            break;
                        }
                        break;

                    case "5":
                        outputS += "5 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 5;
                        totalScore += 5;
                        if (target<=totalScore){
                            break;
                        }
                        break;

                    case "6":
                        outputS += "6 run\n";
                        scoredPlayer = new int[]{batsManCount, batsManCount + 1};
                        playerIndex = randomSelectInt(scoredPlayer);
                        batsmenScore[playerIndex] += 6;
                        totalScore += 6;
                        if (target<=totalScore){
                            break;
                        }
                        break;
                }
                ball++;
                if ((wicketCount == 10) || ((batsManCount == 10))) {
                    break;
                }
            }
            ballerCount++;
            if (ballerCount == 5) {
                ballerCount = 0;
            }

            if ((wicketCount == 10) || ((batsManCount == 10))) {
                break;
            }
            if (target<=totalScore){
                break;
            }
            outputS += "\n";
            over++;

        }
        outputS += "Total Score: "+totalScore+"\n";
        summary += "\nballers,\n"+ Arrays.toString(ballers) +"\n"+ Arrays.toString(ballerWicketCount) +"\n"+"batsmen,\n"+ Arrays.toString(batsmen) +"\n"+ Arrays.toString(batsmenScore) +"Total Score:"+totalScore+"\n";
        if (target<=totalScore){
            outputS += batTeam+" win the match\n";
            summary += batTeam+" win the match\n\n";
        }
        else {
            outputS += ballerTeam+" win the match\n";
            summary += ballerTeam+" win the match\n\n";
        }
        File_Writer fw = new File_Writer("Summary.txt", summary);

    }

    public String randomSelect(String[] givenList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(givenList.length);
        return givenList[randomIndex];
    }
    public int randomSelectInt(int[] givenList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(givenList.length);
        return givenList[randomIndex];
    }


}
