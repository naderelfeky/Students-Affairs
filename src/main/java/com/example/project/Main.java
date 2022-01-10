package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    private static String username=null;
    private static String password=null;
    public static void getUserAndPass() throws Exception{       // get user and pass from file
        File file = new File("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\keepSignInFile.txt");
        Scanner sc = new Scanner(file);
        if(sc.hasNextLine()){
            username =sc.nextLine();
        }if(sc.hasNextLine()){
            password=sc.nextLine();
        }

    }

    @Override
    public void start(Stage stage) throws IOException {
        if(username==null||password==null){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image logo=new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
            stage.getIcons().add(logo);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Insert.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image logo=new Image("C:\\Users\\nader\\Desktop\\project\\src\\main\\resources\\com\\example\\project\\images\\logo.jpg");
            stage.getIcons().add(logo);
            stage.setTitle("insert");
            stage.setScene(scene);
            stage.show();

        }

    }

    public static void main(String[] args) throws Exception {
        getUserAndPass();
        launch();
    }
}