package tubespbo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelOperatorMatematika implements LabellMuka {
    @Override
    public Label getSifat() {
        Label operator = new Label();
        operator.setText("L");
        operator.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        return operator;
    }
}
