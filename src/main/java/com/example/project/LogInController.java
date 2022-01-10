package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
public class LogInController {
    @FXML
    TextField userNameTextFiled;
    @FXML
    TextField passwordTextFiled;
    @FXML
    Label welcomeLabel;
    @FXML
    CheckBox rememberMeCheckBox;


    public static String user;
    public static String pass;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public  Connection userConnection(){
        final String DB_SERVER = "localhost";
        final String PORT = "3306";
        final String DB_NAME = "students_affairs";
        final String DB_URL = "jdbc:mysql://" + DB_SERVER + ":" + PORT + "/" + DB_NAME;
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        }catch (SQLException ex){
            return null;
        }
    }
    public  boolean search(String username, String password){
        boolean existed = false;
        Connection conn=null;
        try {
            conn = userConnection();
            String sql_query = "select username, password from users where username=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet results = stmt.executeQuery();
            existed = results.next();
            conn.close();
            return existed;
        } catch (SQLException e) {
            e.printStackTrace();
            return existed;
        }
    }
    public void rememberMe(){
        if(rememberMeCheckBox.isSelected()) {   //to check if user select check Box or not
            PrintWriter keepSignInFile = null;   //declaration file to write in it
            try {
                keepSignInFile = new PrintWriter("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\keepSignInFile.txt");
                keepSignInFile.println(userNameTextFiled.getText()); //to write username & password in file
                keepSignInFile.println(passwordTextFiled.getText());
            } catch (FileNotFoundException e) {
                welcomeLabel.setText(" Error saving recording ");
            } finally {
                keepSignInFile.close();
            }

        }
    }
    public  void loginIsValid(ActionEvent event) throws IOException {
         user= userNameTextFiled.getText();  //get value from TextField

         pass=passwordTextFiled.getText();   //get value from PasswordField

        if(userNameTextFiled.getText().isEmpty())  //check if textField is empty
            welcomeLabel.setText("username is required");

        else if(passwordTextFiled.getText().isEmpty()) //check if passwordField is empty
            welcomeLabel.setText("password is required");

        else{
                                                     //if textField and passwordField is not empty search at db
            boolean userIsFound = search(user,pass);

            if(userIsFound) {

                rememberMe();                         //to save login

                welcomeLabel.setText("success login");
                root = FXMLLoader.load(getClass().getResource("insert.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Image logo = new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
                stage.getIcons().add(logo);
                stage.setTitle("login ");
                stage.setX(0);
                stage.setY(0);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else
                welcomeLabel.setText("username not Found !");
            }
    }
    public void signUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Image logo=new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);   //to change logo
        stage.setTitle("Sign Up");
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}