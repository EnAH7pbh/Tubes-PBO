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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author hanif
 */
public class MainNInterface extends Application {

    Komponen unduh = new Komponen();
    LabellMuka matematika = new LabelOperatorMatematika();
    LabellMuka getAngka = new LabelAngka1();
    LabellMuka getAngka2 = new LabelAngka2();
    LabellMuka sama = new Samadengan();
    LabellMuka Nilai = new LabelNilai();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Permainan Hitung Hitungan");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);

        Label Operator = matematika.getSifat();
        Label angka1 = getAngka.getSifat();
        Label angka2 = getAngka2.getSifat();
        Label equal = sama.getSifat();
        Label score1 = Nilai.getSifat();
        Label Durasi = unduh.TimerLabel();

        TextField answer = unduh.setJawab();

        Button Menjawab = unduh.Jawab(Operator, angka1, angka2, score1);
        Button start = unduh.Tombol_start(Operator, angka1, angka2, equal);
        Button Ulangi = unduh.Ulangi(Operator, angka1, angka2, equal, score1, Durasi);

        answer.setPrefWidth(60);

        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);

        HBox hb = new HBox(20);
        hb.setAlignment(Pos.CENTER);

        hb.getChildren().addAll(angka1, Operator, angka2, equal, answer, Menjawab);

        vb.setPrefWidth(scene.getWidth());
        vb.getChildren().addAll(Durasi, score1, hb, Ulangi, start);
        vb.setLayoutY(30);

        root.getChildren().add(vb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
