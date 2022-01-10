package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class InsertController {
    @FXML
    TextField idTextField;
    @FXML
    TextField nameTextField;
    @FXML
    TextField phoneTextField;
    @FXML
    TextField cityTextField;
    @FXML
    DatePicker birthdayDatePicker;
    @FXML
    Label insertLabel;

    public void signUp() {     // to clear file (user&pass)
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
        stage.setFullScreen(true);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void update(ActionEvent event) throws Exception {  //to move to update page
        Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setFullScreen(true);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void display(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void delete(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Delete ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gPA(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GPA.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Display.fxml ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void materialRegistration(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MaterialRegistration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("termStudyMaterials ");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Connection userConnection() {
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

    public boolean search(String id) {
        boolean existed = false;
        Connection conn = null;
        try {
            conn = userConnection();
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

    public boolean checkIsNumber(String string) {
        try {
            Long Value = Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void insertStudent() {

        Connection conn = null;
        try {


            if (idTextField.getText().isEmpty() || idTextField.getText().length() != 14||!checkIsNumber(idTextField.getText())) {
                insertLabel.setText("ID is wrong !");

            } else if (nameTextField.getText().isEmpty())
                insertLabel.setText("name is requirement !");
            else if (cityTextField.getText().isEmpty())
                insertLabel.setText("city is requirement !");
            else if (phoneTextField.getText().isEmpty())
                insertLabel.setText("phone is requirement !");
            else if (!search(idTextField.getText())) {
                conn = userConnection();
                String sql_query = "insert into students (id,fullname,city,phone,birthday) values (?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql_query);
                stmt.setString(1, idTextField.getText());
                stmt.setString(2, nameTextField.getText());
                stmt.setString(3, cityTextField.getText());
                stmt.setString(4, phoneTextField.getText());
                stmt.setDate(5, Date.valueOf(birthdayDatePicker.getValue()));
                stmt.executeUpdate();
                phoneTextField.setText("");
                cityTextField.setText("");
                nameTextField.setText("");
                idTextField.setText("");
                birthdayDatePicker.setValue(null);
                insertLabel.setText("done");
                conn.close();
            } else {
                insertLabel.setText(" username is already existed  !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            insertLabel.setText("There is a problem, please try again");
        }
    }
}
