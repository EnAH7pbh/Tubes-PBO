package tubespbo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelAngka1 implements LabellMuka {
    @Override
    public Label getSifat() {
        Label angka1 = new Label();
        angka1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        angka1.setText("P");
        return angka1;
    }
}
