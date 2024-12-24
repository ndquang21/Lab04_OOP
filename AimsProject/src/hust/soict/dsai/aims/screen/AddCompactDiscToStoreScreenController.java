package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCompactDiscToStoreScreenController {
    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtCost;

    @FXML
    void addCD(ActionEvent event) {
        String title = txtTitle.getText();
        String category = txtCategory.getText();
        float cost = Float.parseFloat(txtCost.getText());
        // Gọi logic thêm sách vào Store (cần thêm logic ở đây)
        System.out.println("CD added: " + title + ", " + category + ", " + cost);
    }
}
