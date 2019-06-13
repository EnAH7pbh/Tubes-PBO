/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 * @author hanif
 */
public class MainNInterface extends Application {

    Komponen unduh = new Komponen();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Permainan Hitung Hitungan");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);

        Label Operator = unduh.getOperator();
        Label angka1 = unduh.getAngka();
        Label angka2 = unduh.getAngka2();
        Label equal = new Label("=");
        TextField answer = unduh.setJawab();
        Button Menjawab = unduh.Jawab();
        Label score1 = unduh.getNilai();

        answer.setPrefWidth(40);

        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);

        HBox hb = new HBox(20);
        hb.setAlignment(Pos.CENTER);

        hb.getChildren().addAll(angka1, Operator, angka2, equal, answer, Menjawab);

        vb.setPrefWidth(scene.getWidth());
        vb.getChildren().addAll( score1, hb);
        vb.setLayoutY(30);

        root.getChildren().add(vb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
