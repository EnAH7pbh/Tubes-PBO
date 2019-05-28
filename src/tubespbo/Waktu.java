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
 *
 * @author hanif
 */
public class Waktu {
    
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private final Label timerLabel = new Label();
    Label Soal = new Label();
    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    Random rand = new Random();
    int FirstNumb, SecondNumb, operator;
    String OP;
    int result;
    public Button Tombol_start() {
        Button button = new Button();
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
            FirstNumb = rand.nextInt(100);
            SecondNumb = rand.nextInt(100);
            operator = rand.nextInt(4);
        });
        return button;
    }

    public Label Teks_waktu() {
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        return timerLabel;
    }
    
    public Label getSoal(){
        switch (operator) {
            case 1:
                result=FirstNumb+SecondNumb;
                OP="+";
                break;
            case 2:
                result=FirstNumb-SecondNumb;
                OP="-";
                break;
            case 3:
                result=FirstNumb*SecondNumb;
                OP="*";
                break;
            case 4:
                result=FirstNumb/SecondNumb;
                OP="/";
                break;
            default:
                break;
        }
        Soal.setText(""+FirstNumb+" "+OP+" "+SecondNumb);
        return Soal;
    }
}
