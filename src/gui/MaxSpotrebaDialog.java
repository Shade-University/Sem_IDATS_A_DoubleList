package gui;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Tomáš Vondra
 */
public class MaxSpotrebaDialog extends Dialog<MaxSpotrebaDialogParametry> {

    private final TextField txtId;
    private final TextField txtDenOd;
    private final TextField txtHodinaOd;
    private final TextField txtDenDo;
    private final TextField txtHodinaDo;

    public MaxSpotrebaDialog() {

        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label id = new Label("id");
        Label denOd = new Label("Den od");
        Label denDo = new Label("Den do");
        Label hodinaOd = new Label("Hodina od");
        Label hodinaDo = new Label("Hodina do");

        txtId = new TextField();
        txtDenOd = new TextField();
        txtDenDo = new TextField();
        txtHodinaOd = new TextField();
        txtHodinaDo = new TextField();

        dialogPane.setContent(new HBox(5,
                id, txtId,
                denOd, txtDenOd,
                hodinaOd, txtHodinaOd,
                denDo, txtDenDo,
                hodinaDo, txtHodinaDo));

        Platform.runLater(txtId::requestFocus);
        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                if (validate()) {

                    LocalDateTime datumOd = LocalDateTime.of(
                            LocalDateTime.now().getYear(),
                            LocalDateTime.now().getMonth(),
                            Integer.parseInt(txtDenOd.getText()),
                            Integer.parseInt(txtHodinaOd.getText()),
                            LocalDateTime.now().getSecond()
                    );

                    LocalDateTime datumDo = LocalDateTime.of(
                            LocalDateTime.now().getYear(),
                            LocalDateTime.now().getMonth(),
                            Integer.parseInt(txtDenDo.getText()),
                            Integer.parseInt(txtHodinaDo.getText()),
                            LocalDateTime.now().getSecond()
                    ); //Vytvoř datumy z daného inputu

                    return new MaxSpotrebaDialogParametry(
                            Integer.parseInt(txtId.getText()),
                            datumOd, datumDo); //Vytvoř a vrať parametry
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Chyba validace");
                    alert.setHeaderText("Chybně zadané parametry");
                    alert.setContentText("");
                    alert.showAndWait(); //Alert na chybu
                }

            }
            return null;
        });

    }

    private boolean validate() {
        try {
            Integer.parseInt(txtId.getText());
            Integer.parseInt(txtDenOd.getText());
            Integer.parseInt(txtHodinaOd.getText());
            Integer.parseInt(txtDenDo.getText());
            Integer.parseInt(txtHodinaDo.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
