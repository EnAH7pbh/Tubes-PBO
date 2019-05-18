/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hanif
 */
public class TubesPBO extends Application {

    Waktu detik = new Waktu();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FX Timer with Binding");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);

        Button button = detik.Tombol_start();
        Label timerLabel = detik.Teks_waktu();
        Label soal = new Label("soal disini");
        Label score1 = new Label("score");

        VBox vb = new VBox(20);         
        vb.setAlignment(Pos.CENTER);      

        vb.setPrefWidth(scene.getWidth());
        vb.getChildren().addAll(timerLabel,score1,soal,button);
        vb.setLayoutY(30);

        root.getChildren().add(vb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
