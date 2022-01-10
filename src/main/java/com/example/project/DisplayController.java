package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class DisplayController implements Initializable {
    @FXML
    ChoiceBox<String> box;
    @FXML
    ListView<String> listView;
    @FXML
    Label reportLabel;
    public HashMap<String, String> MATERIAL = new HashMap<>(); //to save name of material and it's code

    public HashMap<Long, String> returnData = new HashMap<>();//to save return data (name of student and this grades)

    //
    {

        MATERIAL.put("GN170", "English Language-1");
        MATERIAL.put("GN112", "Fundamentals of Management");
        MATERIAL.put("HM110", "Human Rights");
        MATERIAL.put("GN160", "Quality");
        MATERIAL.put("GN150", "Fundamentals of Economics");
        MATERIAL.put("GN140", "Professional Ethics");
        MATERIAL.put("GN130", "Communication & Negotiation Skills");
        MATERIAL.put("GN120", "Innovation and entrepreneurship");
        MATERIAL.put("GN180", "Creative Thinking and Problem Solving");
        MATERIAL.put("MA111", "Mathematics-1");
        MATERIAL.put("OD111", "Discrete Mathematics");
        MATERIAL.put("CS131", "Fundamentals of Programming");
        MATERIAL.put("CS111", "Computer Introduction");
        MATERIAL.put("CS110", "Semiconductors");
        MATERIAL.put("IT181", "Introduction to Electronics");
        MATERIAL.put("MA112", "Mathematics-2");
        MATERIAL.put("IS111", "Introduction to IS");
        MATERIAL.put("ST190", "Statistics & Probabilities");
        MATERIAL.put("CS132", "Computer Programming � 1");
        MATERIAL.put("IT282", "Computer Organization");
        MATERIAL.put("IT261", "Multimedia-1");
        MATERIAL.put("CS233", "Computer Programming-2");
        MATERIAL.put("CS212", "Data Structure");
        MATERIAL.put("OD213", "Introduction to Operation Research & Decision Support");
        MATERIAL.put("IS212", "Systems Analysis & Design -1");
        MATERIAL.put("CS261", "Operating Systems-1");
        MATERIAL.put("CS251", "Software Engineering-1");
        MATERIAL.put("IS251", "Web Design and Development");
        MATERIAL.put("IS221", "Database Systems-1");
        MATERIAL.put("OD342", "Modeling & Simulation");
        MATERIAL.put("IT211", "Computer Networks-1");
        MATERIAL.put("CS313", "Analysis and Design of Algorithms");
        MATERIAL.put("MA213", "Mathematics-3");
        MATERIAL.put("CS232", "File Organization and Processing");
        MATERIAL.put("ST291", "Statistical Methods");
        MATERIAL.put("OD251", "DOperation Research Systems Applications");
        MATERIAL.put("IT383", "Scientific Programming");
        MATERIAL.put("IT384", "Web Services");
        MATERIAL.put("IS324", "Database Application Programming");
        MATERIAL.put("IS373", "E-Business");

        MATERIAL.put("CS321", "Artificial Intelligence");
        MATERIAL.put("CS352", "Software Engineering-2");
        MATERIAL.put("CS362", "Operating Systems-2");
        MATERIAL.put("CS334", "Computer Programming - 3");
        MATERIAL.put("CS424", "Knowledge Based Systems");
        MATERIAL.put("CS323", "Machine learning");
        MATERIAL.put("CS442", "Distributed Systems");
        MATERIAL.put("CS471", "Compiler Design");
        MATERIAL.put("CS472", "Natural Language processing");
        MATERIAL.put("CS443", "Parallel Programming");
        MATERIAL.put("CS415", "Computer Security");
        MATERIAL.put("CS482", "Project");
        MATERIAL.put("CS336", "Microprocessors and Assembly language");
        MATERIAL.put("CS322", "Advanced Artificial Intelligence");
        MATERIAL.put("CS314", "Formal Languages and Automata Theory");
        MATERIAL.put("CS341", "Internet Computing");
        MATERIAL.put("CS437", "Advanced Computer Programming");
        MATERIAL.put("CS473", "Human Computer Interaction");
        MATERIAL.put("CS474", "Computer Arabization");
        MATERIAL.put("CS438", "Mobile Application Programming");
        MATERIAL.put("CS425", "Game Programming");
        MATERIAL.put("CS463", "Embedded Systems");
        MATERIAL.put("CS426", "Robotics");
        MATERIAL.put("CS483", "Selected Topics in CS -1");
        MATERIAL.put("CS484", "Selected Topics in CS -2");
        MATERIAL.put("CS485", "Selected Topics in CS -3");

        MATERIAL.put("IT312", "Computer Networks-2");
        MATERIAL.put("IT341", "Computer Graphics-1");
        MATERIAL.put("IT321", "Image Processing-1");
        MATERIAL.put("IT313", "Computer Networks-3");
        MATERIAL.put("IT371", "Digital Signal Processing");
        MATERIAL.put("IT431", "Pattern Recognition-1");
        MATERIAL.put("IT422", "Computer Vision-1");
        MATERIAL.put("IT472", "Speech Recognition-1");
        MATERIAL.put("IT451", "Advanced Web Development");
        MATERIAL.put("IT444", "Virtual Reality-1");
        MATERIAL.put("IT416", "Wireless and Mobile Networks");
        MATERIAL.put("IT486", "Project");
        MATERIAL.put("IT342", "Computer Graphics-2");
        MATERIAL.put("IT362", "Multimedia-2");
        MATERIAL.put("IT314", "Network Operating Systems");
        MATERIAL.put("IT343", "Animations");
        MATERIAL.put("IT315", "Network Management and Analysis");
        MATERIAL.put("IT417", "Network Programming");
        MATERIAL.put("IT418", "Network Security");
        MATERIAL.put("IT487", "Information Technology Applications");
        MATERIAL.put("IT485", "Selected Topics in IT - 1");

        MATERIAL.put("IS322", "Database Systems-2");
        MATERIAL.put("IS312", "Systems Analysis and Design -2");
        MATERIAL.put("IS331", "Business Intelligence");
        MATERIAL.put("IS355", "Information Retrieval");
        MATERIAL.put("IS463", "Information Security");
        MATERIAL.put("IS426", "Modern Database Systems");
        MATERIAL.put("IS465", "Data Mining");
        MATERIAL.put("IS433", "Distributed Data Management");
        MATERIAL.put("IS435", "Cloud Computing");
        MATERIAL.put("IS449", "Enterprise Architecture");
        MATERIAL.put("IS462", "Geographic IS");
        MATERIAL.put("IS485", "Project");
        MATERIAL.put("IS341", "Enterprise Resource planning");
        MATERIAL.put("IS343", "IS Strategy, Management & Acquisition");
        MATERIAL.put("IS375", "Web Information Systems");
        MATERIAL.put("IS361", "Intelligent IS");
        MATERIAL.put("IS371", "Multimedia IS & Digital Libraries");
        MATERIAL.put("IS437", "Business Process Management");
        MATERIAL.put("IS445", "IS Project Management");
        MATERIAL.put("IS447", "Knowledge Management");
        MATERIAL.put("IS467", "Social Informatics");
        MATERIAL.put("IS469", "Bioinformatics");
        MATERIAL.put("IS479", "IS Innovation and New Technologies");
        MATERIAL.put("IS381", "Selected Topics in IS -1");
        MATERIAL.put("IS482", "Selected Topics in IS -2");
        MATERIAL.put("IS483", "Selected Topics in IS -3");

        MATERIAL.put("OD321", "Projects Management");
        MATERIAL.put("OD331", "Linear and Integer Programming");
        MATERIAL.put("OD332", "Dynamic & Nonlinear Programming");
        MATERIAL.put("OD341", "Stochastic Models");
        MATERIAL.put("OD451", "Decision and Game Theory");
        MATERIAL.put("OD431", "Multi-objective Programming");
        MATERIAL.put("OD452", "Strategic Management and Crisis Management");
        MATERIAL.put("OD453", "Inventory Control and Production Management");
        MATERIAL.put("OD454", "Geographic Information Systems for Decision Support");
        MATERIAL.put("OD471", "Project");
        MATERIAL.put("OD322", "Advanced Project Management");
        MATERIAL.put("OD371", "Problem Solving Strategies");
        MATERIAL.put("OD372", "Computer Languages for Modeling and OR");
        MATERIAL.put("OD343", "Queuing Systems");
        MATERIAL.put("OD352", "Logistics Management");
        MATERIAL.put("OD353", "Statistical Analysis for DS");
        MATERIAL.put("OD455", "Data Management in DS");
        MATERIAL.put("OD456", "Knowledge Based DSS");
        MATERIAL.put("OD432", "Network Optimization");
        MATERIAL.put("OD457", "Risk Management");
        MATERIAL.put("OD472", "Stochastic Programming");
        MATERIAL.put("OD462", "Advanced Topics in Intelligent Computational");
        MATERIAL.put("OD381", "Selected Topics in DS -1");
        MATERIAL.put("OD481", "Selected Topics in DS -2");
        MATERIAL.put("OD482", "Selected Topics in DS -3");

    }

    public void signUp() {    // to clear file (user&pass)
        PrintWriter keepSignInFile = null;
        try {
            keepSignInFile = new PrintWriter("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\keepSignInFile.txt");
            keepSignInFile.flush();
        } catch (FileNotFoundException e) {

        } finally {
            keepSignInFile.close();
        }
    }

    public void logIn(ActionEvent event) throws Exception {    //to move to login page
        signUp();  //call sign up to clear file which save username and password
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("login ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(600);
        stage.setY(200);
        stage.show();
    }

    public void insert(ActionEvent event) throws Exception {   //to move to insert page
        Parent root = FXMLLoader.load(getClass().getResource("Insert.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Insert ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void update(ActionEvent event) throws Exception {  //to move to update page
        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Update ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void display(ActionEvent event) throws Exception {    //to move to display page
        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void delete(ActionEvent event) throws Exception { //to move to delete page
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Delete ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gPA(ActionEvent event) throws Exception {    //to move to gpa page
        Parent root = FXMLLoader.load(getClass().getResource("GPA.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void materialRegistration(ActionEvent event) throws Exception {   //to move to term study materials page
        Parent root = FXMLLoader.load(getClass().getResource("MaterialRegistration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("termStudyMaterials ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Connection studentConnection() {  //connect with database
        final String DB_SERVER = "localhost";
        final String PORT = "3306";
        final String DB_NAME = "students_affairs";
        final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + PORT + "/" + DB_NAME;
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String getSelectMaterialChoiceBox() {  //return code of material name
        for (Map.Entry<String, String> entry : MATERIAL.entrySet()) {
            if (box.getValue().equals(entry.getValue()))
                return (entry.getKey());
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Map.Entry<String, String> entry : MATERIAL.entrySet())
            box.getItems().addAll(entry.getValue());
    }

    public void report() {
        if ((box.getValue() == null)) {     //to check choice box not empty
            reportLabel.setText("NO Material Is Select!");
        } else {
            Connection conn = null;
            try {
                conn = studentConnection();
                String colum = getSelectMaterialChoiceBox();  //code of selected material
                String sql_query = "select fullname ," + colum + " from students";
                PreparedStatement stmt = conn.prepareStatement(sql_query);
                ResultSet results = stmt.executeQuery();
                while (results.next()) {
                    if (results.getInt(colum) >= 0) {
                        returnData.put((long) results.getInt(colum), results.getString("fullname"));
                    }
                }
                conn.close();
                Map<Long, String> treeMap = new TreeMap<>(returnData);
                for (Map.Entry<Long, String> entry : treeMap.entrySet()) {
                    listView.getItems().add(entry.getValue() + "            " + entry.getKey());  //to push return data to tree map to be sorted
                }
            } catch (SQLException e) {
                reportLabel.setText("problem with connection ");
            }
        }
    }
}
