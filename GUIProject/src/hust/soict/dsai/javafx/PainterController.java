package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private VBox drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;
    
    @FXML
    private RadioButton eraserRadioButton;
    
    @FXML
    private ToggleGroup toolGroup;
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle;

        if (penRadioButton.isSelected()) {
            // Nếu Pen được chọn, vẽ bằng màu đen
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        } else if (eraserRadioButton.isSelected()) {
            // Nếu Eraser được chọn, "vẽ" bằng màu trắng
            newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
        } else {
            return;
        }
        drawingAreaPane.getChildren().add(newCircle);
    }
}
