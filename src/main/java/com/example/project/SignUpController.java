package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.*;

public class SignUpController {
    @FXML
    TextField userNameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    TextField confirmationTextField;
    @FXML
    TextField idTextField;
    @FXML
    Button signUpButton;
    @FXML
    Button logInButton;
    @FXML
    Label signUpLabel;


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
            String sql_query = "select USERNAME, PASSWORD from users where username=? and password=?";
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
    public  boolean search(String id) {
        boolean existed = false;
        Connection conn=null;
        try {
            conn = userConnection();
            String sql_query = "select username, password from users where id=?";
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
    public  void insert(String id,String username, String password) {
        Connection conn=null;
        try {
            boolean idSearch=search(id);
            boolean user_and_pass_search=search(username,password);
            boolean existed = idSearch||user_and_pass_search;
            if (existed||id.length()!=14) {
                if(idSearch||id.length()!=14) {
                   signUpLabel.setText("ID is wrong !");
                }else{
                    signUpLabel.setText(" username is already existed  !");
                }
            } else {
                conn = userConnection();
                String sql_query = "insert into users (id,username,password) values (?,?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql_query);
                stmt.setString(1, id);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.executeUpdate();
                userNameTextField.setText("");
                passwordTextField.setText("");
                confirmationTextField.setText("");
                idTextField.setText("");
                signUpLabel.setText("done");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            signUpLabel.setText("There is a problem, please try again");
        }

    }
    public void isValid(){

        if(userNameTextField.getText()!=null&&passwordTextField.getText()!=null&&confirmationTextField.getText().equals(passwordTextField.getText()))
         insert(idTextField.getText(),userNameTextField.getText(),passwordTextField.getText());
        else if(userNameTextField.getText()==null)
         signUpLabel.setText("Username is a requirement ! ");
        else if(passwordTextField.getText()==null)
            signUpLabel.setText("password is a requirement ! ");
        else if(confirmationTextField.getText()==null)
            signUpLabel.setText("confirmation is a requirement ! ");
        else
            signUpLabel.setText("password is not equal confirmation ! ");
    }
    public void logIn(ActionEvent event) throws Exception{
        Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Image logo=new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("login ");
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}