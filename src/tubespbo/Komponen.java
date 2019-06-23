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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * @author hanif
 */
public class Komponen {

    private RandomGenerator unduh = new RandomGenerator();
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private Label timerLabel;
    private Button Menjawab;
    private TextField jawab;
    private int Nilaiint = 0;
    private Button Reset;
    private Button button;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    private BooleanBinding booleanBind;

    public TextField setJawab() {
        jawab = new TextField();
        booleanBind = timerLabel.textProperty().isEqualTo("0").or(timerLabel.textProperty().isEqualTo("60"));
        jawab.disableProperty().bind(booleanBind);
        jawab.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        jawab.setOnKeyTyped((KeyEvent event) -> {
            if ((event.getCharacter().matches("^[a-zA-Z]*$"))) {
                event.consume();
            }
        });
        return jawab;
    }

    public Label TimerLabel() {
        timerLabel = new Label();
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        timerLabel.setTextFill(Color.RED);
        return timerLabel;
    }

    public Button Tombol_start(Label Operator, Label angka1, Label angka2, Label sama) {
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
            Operator.setText(unduh.getOperator());
            angka1.setText(unduh.getAngkaS());
            angka2.setText(unduh.getAngkaS());
            sama.setText("=");
        });
        return button;
    }

    public Button Jawab(Label operator, Label angka1, Label angka2, Label Nilai) {
        booleanBind = jawab.textProperty().isEmpty();
        Menjawab = new Button();
        Menjawab.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        Menjawab.setText("jawab");
        Menjawab.disableProperty().bind(booleanBind);
        Menjawab.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (operator.getText().equals("+")) {
                    double nilai, bil1, bil2, jawaban;
                    bil1 = Double.parseDouble(angka1.getText());
                    bil2 = Double.parseDouble(angka2.getText());
                    nilai = bil1 + bil2;
                    jawaban = Double.parseDouble(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 100;
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
                    double nilai, bil1, bil2, jawaban;
                    bil1 = Double.parseDouble(angka1.getText());
                    bil2 = Double.parseDouble(angka2.getText());
                    nilai = bil1 - bil2;
                    jawaban = Double.parseDouble(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 100;
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
                    double nilai, bil1, bil2, jawaban;
                    bil1 = Double.parseDouble(angka1.getText());
                    bil2 = Double.parseDouble(angka2.getText());
                    nilai = bil1 * bil2;
                    jawaban = Double.parseDouble(jawab.getText());
                    if (nilai != jawaban) {
                        Nilaiint -= 100;
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
                        Nilaiint -= 100;
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

    public Button Ulangi(Label Operator, Label angka1, Label angka2, Label sama, Label Nilai, Label timerLabel) {
        booleanBind = timerLabel.textProperty().isNotEqualTo("0");
        Reset = new Button();
        Reset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        Reset.setText("Reset");
        Reset.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Notifications notificationBuilder = Notifications.create()
                        .title("Congratulation!")
                        .text("Your last game score is : " + Nilaiint)
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.CENTER);
                notificationBuilder.showInformation();
                Nilaiint = 0;
                angka1.setText("P");
                Operator.setText("L");
                angka2.setText("A");
                sama.setText("Y");
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
