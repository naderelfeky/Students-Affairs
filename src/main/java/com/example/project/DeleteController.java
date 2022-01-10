package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class DeleteController {
    @FXML
    Label deleteLabel;
    @FXML
    TextField deleteTextField;

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

    public void logIn(ActionEvent event) throws Exception {  //to move to login page
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

    public void display(ActionEvent event) throws Exception { //to move to display page
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

    public void gPA(ActionEvent event) throws Exception {  //to move to gpa page
        Parent root = FXMLLoader.load(getClass().getResource("GPA.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void materialRegistration(ActionEvent event) throws Exception { //to move to study term materials page
        Parent root = FXMLLoader.load(getClass().getResource("MaterialRegistration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("termStudyMaterials ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Connection studentConnection() {   //connect with database
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

    public boolean search(String id) {  //check if id is existed
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

    public void deleteStudent() {
        if (deleteTextField.getText().isEmpty()) {   //check if text field is empty
            deleteLabel.setText("Enter the id ");
        } else if (deleteTextField.getText().length() == 14 || search(deleteTextField.getText())) {  //to check if id is found after check if id is 14 number
            try {
                Connection conn = studentConnection();
                String sql_query = "delete from students where id=?";
                PreparedStatement stmt = conn.prepareStatement(sql_query);
                stmt.setString(1, deleteTextField.getText());
                stmt.executeUpdate();
                deleteLabel.setText("Deleting is done");
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                deleteLabel.setText("There is a problem, please try again");
            }

        } else {
            deleteLabel.setText("the id not found ");
        }
    }
}

