package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarClinica {

    @FXML
    private Button cadastrarClinicaButton;

    @FXML
    private TextField cnpjField;

    @FXML
    private TextField enderecoField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    void cadastrarClinica(ActionEvent event) {
        Clinica clinica = new Clinica(nomeField.getText(), cnpjField.getText(), telefoneField.getText(), enderecoField.getText());
        TxTOperations.salvarTxt(clinica.toString(), "src/main/resources/com/andre/projetolpoo/Data/Clinicas.txt");
        ((Stage) cadastrarClinicaButton.getScene().getWindow()).close();
    }
}
