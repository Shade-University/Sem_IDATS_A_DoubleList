package gui;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import mereni.TypSenzoruEnum;

/**
 *
 * @author Tomáš Vondra
 */
public class VlozMereniDialog extends Dialog<VlozMereniDialogParametry> {

    private TextField txtId;
    private TextField txtDen;
    private TextField txtHodina;
    private TextField txtSpotreba;

    public VlozMereniDialog() {
        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label lblTypSenzozur = new Label("Typ senzoru: ");
        ComboBox<TypSenzoruEnum> typ = new ComboBox<>();
        typ.getItems().setAll(TypSenzoruEnum.values());
        typ.getSelectionModel().select(0);

        Label idSenzoru = new Label("Id senzoru: ");
        txtId = new TextField("0");

        Label denLabel = new Label("Den: ");
        txtDen = new TextField("01");

        Label hodinaLabel = new Label("Hodina: ");
        txtHodina = new TextField("00");

        Label spotrebaLabel = new Label("Spotřeba: ");
        txtSpotreba = new TextField("01");

        dialogPane.setContent(new HBox(5,
                lblTypSenzozur, typ,
                idSenzoru, txtId,
                denLabel, txtDen,
                hodinaLabel, txtHodina,
                spotrebaLabel, txtSpotreba));

        Platform.runLater(txtId::requestFocus);
        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                if (validate()) {
                    
                    LocalDateTime casMereni = LocalDateTime.of(
                            LocalDateTime.now().getYear(),
                            LocalDateTime.now().getMonth(),
                            Integer.parseInt(txtDen.getText()),
                            Integer.parseInt(txtHodina.getText()),
                            LocalDateTime.now().getSecond()
                    ); //Vytvoří čas z daného dne a hodiny
                    
                    return new VlozMereniDialogParametry(Integer.parseInt(txtId.getText()),
                            typ.getValue(),
                            casMereni,
                            Integer.parseInt(txtSpotreba.getText())
                    );
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Chyba validace");
                    alert.setHeaderText("Chybně zadané parametry");
                    alert.setContentText("");
                    alert.showAndWait();
                }
            }
            return null;
        });
    }

    private boolean validate() {
        try {
            Integer.parseInt(txtId.getText());
            Integer.parseInt(txtDen.getText());
            Integer.parseInt(txtHodina.getText());
            Integer.parseInt(txtSpotreba.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
