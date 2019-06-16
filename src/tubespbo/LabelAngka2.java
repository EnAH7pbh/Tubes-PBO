package tubespbo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelAngka2 implements LabellMuka {
    @Override
    public Label getSifat() {
        Label angka2 = new Label();
        angka2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        angka2.setText("A");
        return angka2;
    }
}
