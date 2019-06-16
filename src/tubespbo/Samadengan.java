package tubespbo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Samadengan implements LabellMuka {
    @Override
    public Label getSifat() {
        Label sama = new Label();
        sama.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        sama.setText("Y");
        return sama;
    }
}
