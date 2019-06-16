package tubespbo;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelNilai implements LabellMuka{
    @Override
    public Label getSifat() {
        Label Nilai = new Label();
        Nilai.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        return Nilai;
    }
}
