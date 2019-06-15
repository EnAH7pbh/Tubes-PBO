/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;


/**
 * @author hanif
 */
public class Komponen {

    RandString unduh = new RandString();
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private Label timerLabel;
    private Label angka1;
    private Label angka2;
    private Label Nilai;
    private Label operator;
    private TextField jawab;
    private Button Menjawab;
    private int Nilaiint = 0;
    private Button Reset;
    Button button;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    //private IntegerProperty zero = new SimpleIntegerProperty(0);
    private BooleanBinding booleanBind;

    public Label getOperator() {
        operator = new Label();
        operator.setText(unduh.getOperator());
        operator.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        return operator;
    }

    public Label getAngka() {
        angka1 = new Label();
        angka1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        angka1.setText(unduh.getAngkaS());
        return angka1;
    }

    public Label getAngka2() {
        angka2 = new Label();
        angka2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        angka2.setText(unduh.getAngkaS());
        return angka2;
    }

    public Label getNilai() {
        Nilai = new Label();
        Nilai.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        return Nilai;
    }

    public Label getTimerLabel() {
        timerLabel = new Label();
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        timerLabel.setTextFill(Color.RED);
        return timerLabel;
    }

    public TextField setJawab() {
        booleanBind = timerLabel.textProperty().isEqualTo("0");
        jawab = new TextField();
        jawab.disableProperty().bind(booleanBind);
        jawab.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        return jawab;
    }

    public Button Tombol_start() {
        button = new Button();
        button.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        button.setText("Start");
        button.setOnAction((ActionEvent event) -> {
            if (timeline != null) {
                timeline.stop();
            }
            timeSeconds.set(STARTTIME);
            timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(STARTTIME + 1),
                            new KeyValue(timeSeconds, 0)));
            timeline.playFromStart();
            button.setDisable(true);
        });
        return button;
    }

    public Button Jawab() {
        booleanBind = jawab.textProperty().isEmpty();
        Menjawab = new Button();
        Menjawab.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        Menjawab.setText("jawab");
        Menjawab.disableProperty().bind(booleanBind);
        Menjawab.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator.getText().equals("+")) {
                    int nilai, bil1, bil2, jawaban;
                    bil1 = Integer.parseInt(angka1.getText());
                    bil2 = Integer.parseInt(angka2.getText());
                    nilai = bil1 + bil2;
                    jawaban = Integer.parseInt(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 50;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    } else {
                        Nilaiint += 100;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    }
                } else if (operator.getText().equals("-")) {
                    int nilai, bil1, bil2, jawaban;
                    bil1 = Integer.parseInt(angka1.getText());
                    bil2 = Integer.parseInt(angka2.getText());
                    nilai = bil1 - bil2;
                    jawaban = Integer.parseInt(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 50;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    } else {
                        Nilaiint += 100;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    }
                } else if (operator.getText().equals("X")) {
                    int nilai, bil1, bil2, jawaban;
                    bil1 = Integer.parseInt(angka1.getText());
                    bil2 = Integer.parseInt(angka2.getText());
                    nilai = bil1 * bil2;
                    jawaban = Integer.parseInt(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 50;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    } else {
                        Nilaiint += 100;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    }
                } else if (operator.getText().equals(":")) {
                    double nilai, bil1, bil2, jawaban;
                    bil1 = Double.parseDouble(angka1.getText());
                    bil2 = Double.parseDouble(angka2.getText());
                    nilai = bil1 / bil2;
                    jawaban = Double.parseDouble(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 50;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    } else {
                        Nilaiint += 100;
                        jawab.setText("");
                        angka1.setText(unduh.getAngkaS());
                        angka2.setText(unduh.getAngkaS());
                        operator.setText(unduh.getOperator());
                        Nilai.setText("" + Nilaiint);
                    }
                }
            }
        }));
        return Menjawab;
    }

    public Button Ulangi() {
        booleanBind = timerLabel.textProperty().isNotEqualTo("0");
        Reset = new Button();
        Reset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        Reset.setText("Reset");
        Reset.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Nilaiint = 0;
                Nilai.setText("");
                button.setDisable(false);
                timeSeconds.setValue(STARTTIME);
                timerLabel.textProperty().bind(timeSeconds.asString());
            }
        }));
        Reset.disableProperty().bind(booleanBind);
        return Reset;
    }
}
