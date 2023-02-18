package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.nio.file.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Controller {
    //sample.fxml
    @FXML
    Button insertBtn;
    @FXML
    Button teamDetailsBtn;
    @FXML
    Button deleteBtn;
    @FXML
    Button updateBtn;
    @FXML
    Button matchBtn;

    //InsertTeam.fxml
    @FXML
    TextField tName;
    @FXML
    TextField p1Name;
    @FXML
    TextField p2Name;
    @FXML
    TextField p3Name;
    @FXML
    TextField p4Name;
    @FXML
    TextField p5Name;
    @FXML
    TextField p6Name;
    @FXML
    TextField p7Name;
    @FXML
    TextField p8Name;
    @FXML
    TextField p9Name;
    @FXML
    TextField p10Name;
    @FXML
    TextField p11Name;
    @FXML
    Button insertTeamDetails;
    @FXML
    Button insertBackBtn;

    //TeamDetails.fxml
    @FXML
    TextArea teamDetailsTextArea;
    @FXML
    Button teamDetailsBackBtn;

    //Delete.fxml
    @FXML
    TextArea teamNames;
    @FXML
    Button showTeamsBtn;
    @FXML
    Button deleteBackBtn;

    //Update.fxml
    @FXML
    Button updateBackBtn;

    //Match.fxml
    @FXML
    Button randomMatchWindowBtn;
    @FXML
    Button summaryWindowBtn;

    //RandomMatch.fxml
    @FXML
    Button GRMBtn;
    @FXML
    TextArea RMTextArea1;
    @FXML
    TextArea RMTextArea2;
    @FXML
    Button GRMBackBtn;

    //Summary.fxml
    @FXML
    Button summaryBackBtn;
    @FXML
    TextArea summaryTextArea;
    @FXML
    Button showSummaryBtn;


    public void insertTeamDetails(){
        Team t = new Team();

        String[] teamDetailsArray = new String[12];

        teamDetailsArray[0] = tName.getText();
        teamDetailsArray[1] = p1Name.getText();
        teamDetailsArray[2] = p2Name.getText();
        teamDetailsArray[3] = p3Name.getText();
        teamDetailsArray[4] = p4Name.getText();
        teamDetailsArray[5] = p5Name.getText();
        teamDetailsArray[6] = p6Name.getText();
        teamDetailsArray[7] = p7Name.getText();
        teamDetailsArray[8] = p8Name.getText();
        teamDetailsArray[9] = p9Name.getText();
        teamDetailsArray[10] = p10Name.getText();
        teamDetailsArray[11] = p11Name.getText();

        t.setTeamDetails(teamDetailsArray);
    }


    //To open window
    public void insertTeamWindow() throws IOException {
        Stage stage = (Stage) insertBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("InserTeam.fxml"));

        primaryStage.setTitle("Insert Team");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

    public void showTeamDetailsWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) teamDetailsBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("TeamDetails.fxml"));

        primaryStage.setTitle("Show Team Details");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();


    }

    public void openDeleteWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) deleteBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));

        primaryStage.setTitle("Show Delete Window");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void openUpdateWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) updateBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));

        primaryStage.setTitle("Show Update Window");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void openMatchWindow(ActionEvent actionEvent) throws IOException {
        //Set A Team and B Team
        int lineNumber;
        String line = "";

        FileReader readfile = new FileReader("Team.txt");
        BufferedReader readbuffer = new BufferedReader(readfile);

        //A Team
        for (lineNumber = 1; lineNumber < 5; lineNumber++) {
            try {
                line = readbuffer.readLine();
                line = line + "\n";
                File_Writer fw = new File_Writer("A.txt", line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //B Team
        for (lineNumber = 5; lineNumber < 9; lineNumber++) {
            try {
                line = readbuffer.readLine();
                line = line + "\n";
                File_Writer fw = new File_Writer("B.txt", line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Match status
        File_Writer fw = new File_Writer("A&B.txt", "A1");

        //ophen Match Window
        Stage stage = (Stage) matchBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Match.fxml"));

        primaryStage.setTitle("Show Match Window");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

    }

    public void openRandomMatchWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) randomMatchWindowBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("RandomMatch.fxml"));

        primaryStage.setTitle("Show Random Match Window");
        primaryStage.setScene(new Scene(root, 850, 1000));
        primaryStage.show();
    }

    public void openSummaryWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) summaryWindowBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Summary.fxml"));

        primaryStage.setTitle("Show Summary Window");
        primaryStage.setScene(new Scene(root, 850, 800));
        primaryStage.show();
    }

    //for team detail button
    public void showTeamDetails(ActionEvent actionEvent) {
        File f = new File("Team.txt");
        String details = new String();
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()){
                details += sc.nextLine()+"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        teamDetailsTextArea.setText(details);
    }

    public void insertTeamBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) insertBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Show Main Menu");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void TeamDetailsBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) teamDetailsBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Show Main Menu");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void GRMBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) GRMBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Match.fxml"));

        primaryStage.setTitle("Show Match Window");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

    public void summaryBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) summaryBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Match.fxml"));

        primaryStage.setTitle("Show Match Window");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

    public void deleteBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) deleteBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Show Main Menu");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void updateBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) updateBackBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Show Main Menu");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
    //for delete
    public void showTeamNames(ActionEvent actionEvent) {
        File f = new File("Team.txt");
        String details = new String();
        String line;
        int i=0;
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()){
                ++i;
                line = sc.nextLine();
                String reLine1 = line.replace("[","");
                String reLine2 = reLine1.replace("]","");
                String reLine3 = reLine2.replace(" ","");
                String[] splitLine = reLine3.split(",");
                details += i+") "+splitLine[0]+"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        teamNames.setText(details.toString());
    }


    public void generateMatch(ActionEvent actionEvent) {
        String[] team1 = new String[12];
        String[] team2 = new String[12];
        File f = new File("Team.txt");
        String details = new String();
        String line;
        int i=0;
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()){

                line = sc.nextLine();
                String reLine1 = line.replace("[","");
                String reLine2 = reLine1.replace("]","");
                String reLine3 = reLine2.replace(" ","");
                String[] splitLine = reLine3.split(",");
                if (i == 0){
                    team1 = splitLine;
                }
                else {
                    team2 = splitLine;
                }
                ++i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Match Ining = new Match(team1,team2);
        Ining.firstInning();
        RMTextArea1.setText(Ining.outputF);
        Ining.secondInning();
        RMTextArea2.setText(Ining.outputS);
    }


    public void showSummary(ActionEvent actionEvent) throws IOException {
        String lines = String.valueOf(Files.readAllLines(Paths.get("Summary.txt")));
        summaryTextArea.setText(String.valueOf(lines));

    }



}
