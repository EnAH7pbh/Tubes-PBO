/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * @author hanif
 */
public class Komponen {

    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private Label timerLabel;
    private Label angka;
    private Label operator;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    Random rand = new Random();

    public Button Tombol_start() {
        Button button = new Button();
        button.setText("Start");
        button.setOnAction((ActionEvent event) -> {
            Waktu();
        });
        return button;
    }

    public void Waktu() {
        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }

    public Label getTimerLabel() {
        timerLabel = new Label();
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        return timerLabel;
    }

    public Label getOperator() {
        operator = new Label();
        int acak = rand.ints(1,(4+1)).findFirst().getAsInt();
        switch (acak) {
            case 1:
                    operator.setText("+");
                break;
            case 2:
                    operator.setText("-");
                break;
            case 3:
                    operator.setText("*");
                break;
            case 4:
                    operator.setText(":");
                break;
            default:
                    operator.setText("null");
                break;
        }
        return operator;
    }

    public Label getAngka(){
        angka = new Label();
        int acak = rand.ints(1,(100+1)).findFirst().getAsInt();
        angka.setText(""+acak);
        return angka;
    }

    public Button Generate(){
        Button generate = new Button();
        generate.setText("Rand");
        generate.setOnAction((ActionEvent event) -> {
            getAngka();
        });
        return generate;
    }
}
