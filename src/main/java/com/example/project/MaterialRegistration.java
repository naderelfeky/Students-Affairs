package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class MaterialRegistration implements Initializable {
    @FXML
    ChoiceBox<String> selectChoiceBox1;
    @FXML
    ChoiceBox<String> selectChoiceBox2;
    @FXML
    ChoiceBox<String> selectChoiceBox3;
    @FXML
    ChoiceBox<String> selectChoiceBox4;
    @FXML
    ChoiceBox<String> selectChoiceBox5;
    @FXML
    ChoiceBox<String> selectChoiceBox6;
    @FXML
    TextField idChoiceMaterialTextField;
    @FXML
    Label choiceMaterialLabel;
    public HashMap<String, String> MATERIAL = new HashMap<String, String>();  //to save name of material and it's code
    public HashMap<String, String> MAP = new HashMap<String, String>();        //to save code of material and code of material which is dependent in

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

    {
        MAP.put("CS313", "IS212");
        MAP.put("MA213", "MA112");
        MAP.put("CS232", "CS212");
        MAP.put("ST291", "ST190");
        MAP.put("OD251", "OD213");
        MAP.put("IT383", "CS233");
        MAP.put("IT384", "IS251");
        MAP.put("IS324", "IS221");
        MAP.put("IS373", "IS111");

        //cs

        MAP.put("CS321", "CS233");
        MAP.put("CS352", "CS251");
        MAP.put("CS362", "CS261");
        MAP.put("CS334", "CS233");
        MAP.put("CS424", "CS321");
        MAP.put("CS323", "CS321");
        MAP.put("CS442", "CS362");
        MAP.put("CS471", "CS334");
        MAP.put("CS472", "CS321");
        MAP.put("CS443", "CS334");
        MAP.put("CS415", "IT211");
        MAP.put("CS482", "NoRequirements");///////////////////project
        MAP.put("CS336", "IT181");
        MAP.put("CS322", "CS321");
        MAP.put("CS314", "CS233");
        MAP.put("CS341", "CS233");
        MAP.put("CS437", "CS334");
        MAP.put("CS473", "CS352");
        MAP.put("CS474", "CS334");
        MAP.put("CS438", "CS334");
        MAP.put("CS425", "CS334");
        MAP.put("CS463", "CS362");
        MAP.put("CS426", "CS321");
        MAP.put("CS483", "CS334");
        MAP.put("CS484", "CS334");
        MAP.put("CS485", "CS334");

        //it
        MAP.put("IT341", "MA112");
        MAP.put("IT321", "IT371");
        MAP.put("IT313", "IT312");
        MAP.put("IT371", "MA112");
        MAP.put("IT431", "IT321");
        MAP.put("IT422", "IT431");
        MAP.put("IT472", "IT371");
        MAP.put("IT451", "IS251");
        MAP.put("IT444", "IT341");
        MAP.put("IT416", "IT312");
        MAP.put("IT342", "IT341");
        MAP.put("IT362", "IT261");
        MAP.put("IT314", "CS261");
        MAP.put("IT343", "IT341");
        MAP.put("IT315", "IT312");
        MAP.put("IT417", "IT211");
        MAP.put("IT418", "IT312");
        MAP.put("IT485", "IT312");
        MAP.put("IT486", "IT312");

        ///is

        MAP.put("IS322", "IS221");
        MAP.put("IS312", "IS212");
        MAP.put("IS331", "IS322");
        MAP.put("IS355", "IS221");
        MAP.put("IS463", "MA112");
        MAP.put("IS426", "IS322");
        MAP.put("IS465", "IS322");
        MAP.put("IS433", "IS322");
        MAP.put("IS435", "CS261");
        MAP.put("IS449", "IS111");
        MAP.put("IS462", "IS322");
        MAP.put("IS485", "NoRequirements");//////project
        MAP.put("IS341", "IS373");
        MAP.put("IS343", "IS111");
        MAP.put("IS375", "IS251");
        MAP.put("IS371", "IT261");
        MAP.put("IS437", "IS373");
        MAP.put("IS445", "OD332");
        MAP.put("IS447", "IS465");
        MAP.put("IS467", "IS322");
        MAP.put("IS469", "IS465");
        MAP.put("IS479", "IS465");
        MAP.put("IS381", "NoRequirements");
        MAP.put("IS482", "NoRequirements");
        MAP.put("IS483", "NoRequirements");

        ///or


        MAP.put("OD321", "OD211");
        MAP.put("OD331", "OD211");
        MAP.put("OD332", "OD331");
        MAP.put("OD341", "OD241");

        ///?????? ??? ??????

        MAP.put("OD451", "MA112");

        //****

        MAP.put("OD431", "OD332");
        MAP.put("OD452", "OD241");

        ///?????? ??? ??????

        MAP.put("OD453", "OD251");

        //*******

        ///?????? ??? ??????

        MAP.put("OD454", "OD251");

        ///***********

        MAP.put("OD322", "OD321");
        MAP.put("OD371", "Ma112");

        ///?????? ??? ??????


        MAP.put("OD372", "OD331");

        //*******

        MAP.put("OD342", "OD241");
        MAP.put("OD343", "ST190");
        MAP.put("OD352", "OD112");

        ///?????? ??? ??????

        MAP.put("OD353", "ST291");

        //*******

        MAP.put("OD455", "IS221");
        MAP.put("OD456", "IS221");
        MAP.put("OD432", "OD332");
        MAP.put("OD457", "OD453");
        MAP.put("OD472", "OD341");
        MAP.put("OD462", "OD461");
        MAP.put("OD381", "OD211");
        MAP.put("OD481", "OD211");
        MAP.put("OD482", "OD211");
    }

    public void signUp() {   // to clear file (user&pass)
        PrintWriter keepSignInFile = null;
        try {
            keepSignInFile = new PrintWriter("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\keepSignInFile.txt");
            keepSignInFile.flush();
        } catch (FileNotFoundException e) {

        } finally {
            keepSignInFile.close();
        }
    }

    public void logIn(ActionEvent event) throws Exception {
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

    public void insert(ActionEvent event) throws Exception {  //to move to insert page
        Parent root = FXMLLoader.load(getClass().getResource("Insert.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Insert ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void update(ActionEvent event) throws Exception {   //to move to update page
        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Update ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void display(ActionEvent event) throws Exception {   //to move to display page
        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void delete(ActionEvent event) throws Exception {   //to move to delete page
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Delete ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void materialRegistration(ActionEvent event) throws Exception {  //to move to term study materials page
        Parent root = FXMLLoader.load(getClass().getResource("MaterialRegistration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("termStudyMaterials ");
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

    public String getSelectMaterialChoiceBox(ChoiceBox choiceBox) { //return code of material name
        if (choiceBox.getValue() != null)
            for (Map.Entry<String, String> entry : MATERIAL.entrySet()) {
                if (choiceBox.getValue().equals(entry.getValue()))
                    return (entry.getKey());
            }
        return null;
    }

    public Connection studentConnection() {      //connect with database
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

    public boolean search(String id) {   //check if id is existed
        boolean existed = false;
        Connection conn = null;
        try {
            conn = studentConnection();
            String sql_query = "select id from students where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            existed = results.next();
            conn.close();
            return existed;
        } catch (SQLException e) {
            e.printStackTrace();
            return existed;
        }
    }

    public int numberOfMaterialRegister() {  // return max number of material student can register
        Connection conn = null;
        try {
            conn = studentConnection();
            String sql_query = "select * from students where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, idChoiceMaterialTextField.getText());
            ResultSet results = stmt.executeQuery();
            double sum = 0, num = 0, GPA = 0, numberOfMaterialStudentHasRecord = 0, numberOfMaterialRegister = 0;

            while (results.next()) {
                for (Map.Entry<String, String> entry : MATERIAL.entrySet()) {    //count GPA
                    if ((int) results.getInt(entry.getKey()) >= 0) {              //to check if student register this material or not
                        /*
                        if(result==-1) it is mean this material to register befour,
                        and if (result==-5) mean this material is register for this term in database
                         */
                        if (results.getInt(entry.getKey()) >= 50) {
                            if (results.getInt(entry.getKey()) >= 90) {
                                sum += 4;
                            } else if (results.getInt(entry.getKey()) >= 85) {
                                sum += 3.7;
                            } else if (results.getInt(entry.getKey()) >= 80) {
                                sum += 3.3;
                            } else if (results.getInt(entry.getKey()) >= 75) {
                                sum += 3;
                            } else if (results.getInt(entry.getKey()) >= 70) {
                                sum += 2.7;
                            } else if (results.getInt(entry.getKey()) >= 65) {
                                sum += 2.4;
                            } else if (results.getInt(entry.getKey()) >= 60) {
                                sum += 2.2;
                            } else if (results.getInt(entry.getKey()) >= 50) {
                                sum += 2;
                            }
                            numberOfMaterialStudentHasRecord += 1;
                            /*
                            number of material student has record mean sum of succeed material .
                              */
                        }

                        num++;
                           /*
                           num mean sum of succeed material and
                            number of material student has register and failed in.
                              */
                    } else if ((int) results.getInt(entry.getKey()) == -5) {
                        numberOfMaterialRegister += 1;
                    }
                }
                GPA = sum / num;
                if (((int) GPA) >= 2) {
                    return (6 - (int) (numberOfMaterialRegister));
                } else {
                    return (5 - (int) (numberOfMaterialRegister));
                }

            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void materialRegistrationStudent() {
        if (idChoiceMaterialTextField.getText().isEmpty()) {   //to check choice Box not empty
            choiceMaterialLabel.setText("id is Requirement !");
        } else {
            if (search(idChoiceMaterialTextField.getText())) {
                int num = numberOfMaterialRegister();
                int selectMaterialFormChoiceBox = 0;
                String[] material = new String[6];                        //get select material
                material[0] = getSelectMaterialChoiceBox(selectChoiceBox1);
                material[1] = getSelectMaterialChoiceBox(selectChoiceBox2);
                material[2] = getSelectMaterialChoiceBox(selectChoiceBox3);
                material[3] = getSelectMaterialChoiceBox(selectChoiceBox4);
                material[4] = getSelectMaterialChoiceBox(selectChoiceBox5);
                material[5] = getSelectMaterialChoiceBox(selectChoiceBox6);

                for (int i = 0; i < 6; i++) {        //count number of material student has select
                    if (material[i] != null) selectMaterialFormChoiceBox += 1;
                }

                Set<String> checkDuplicates = new HashSet<>(); //to check duplicates
                for (int i = 0; i < 6; i++) if (material[i] != null) checkDuplicates.add(material[i]);
                if (checkDuplicates.size() != selectMaterialFormChoiceBox) {  //to check if user select same material more than one time
                    choiceMaterialLabel.setText("You choice same material more than one time !");
                    return;
                }
                if (selectMaterialFormChoiceBox > num) {   //If the user selects more materials than allowed
                    choiceMaterialLabel.setText("You must choice " + num + "material !");
                    return;
                } else {
                    try {
                        Connection conn = studentConnection();
                        String sql_query = "select * from students where id=?";
                        PreparedStatement stmt = conn.prepareStatement(sql_query);
                        stmt.setString(1, idChoiceMaterialTextField.getText());
                        ResultSet results = stmt.executeQuery();
                        if (results.next()) {
                            for (int i = 0; i < 6; i++)   //for six materials of choice box
                                if (material[i] != null) {
                                    if (results.getInt(material[i]) < 50) { //to check if this material has register befour or not
                                        for (Map.Entry<String, String> entry : MAP.entrySet()) {
                                 /*
                                 loop for check if this material has dependents materials ,if it is has check if student has succeeded in it or not
                                  */
                                            if (material[i].equals(entry.getKey())) {
                                                if (entry.getValue().equals("NoRequirements")) return;
                                                if (results.getInt(entry.getValue()) < 50) {   //if student fail in dependent material or not register befour
                                                    if (i == 0)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox1.getValue() + " because it depend in anther material");
                                                    if (i == 1)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox2.getValue() + " because it depend in anther material");
                                                    if (i == 2)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox3.getValue() + " because it depend in anther material");
                                                    if (i == 3)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox4.getValue() + " because it depend in anther material");
                                                    if (i == 4)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox5.getValue() + " because it depend in anther material");
                                                    if (i == 5)
                                                        choiceMaterialLabel.setText("you can't register " + selectChoiceBox6.getValue() + " because it depend in anther material");
                                                    return;
                                                } else break;
                                            }
                                        }
                                    } else {          //student succeed this material or register this term
                                        choiceMaterialLabel.setText(material[i] + " is register befour !");
                                        return;
                                    }
                                }
                        }
                        //after check every thing is correct update date
                        //-5 which refer to this material register for this year
                        sql_query = "update students set ";
                        for (int i = 0; i < 6; i++) {
                            if (material[i] != null)
                                if (i != 5 && material[i + 1] != null)
                                    sql_query += material[i] + " =-5 ,";
                                else
                                    sql_query += material[i] + " =-5 ";
                        }
                        sql_query += " where id=" + idChoiceMaterialTextField.getText();
                        PreparedStatement stm = conn.prepareStatement(sql_query);
                        stm.executeUpdate();
                        choiceMaterialLabel.setText("done!");
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        choiceMaterialLabel.setText("There is a problem, please try again");
                    }

                }
            } else {
                choiceMaterialLabel.setText("id not found !");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Map.Entry<String, String> entry : MATERIAL.entrySet()) {
            selectChoiceBox1.getItems().addAll(entry.getValue());
            selectChoiceBox2.getItems().addAll(entry.getValue());
            selectChoiceBox3.getItems().addAll(entry.getValue());
            selectChoiceBox4.getItems().addAll(entry.getValue());
            selectChoiceBox5.getItems().addAll(entry.getValue());
            selectChoiceBox6.getItems().addAll(entry.getValue());
        }
    }
}
