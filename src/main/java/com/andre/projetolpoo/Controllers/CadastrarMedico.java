package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarMedico {
    String filePath = "src/main/resources/com/andre/projetolpoo/Data/Medicos.txt";
    @FXML
    private Button cadastrarMedicoButton;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField crmField;

    @FXML
    private TextField especialidadeField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    void cadastrarMedico(ActionEvent event) {
        if(TxTOperations.buscarMedicoPorCRM(filePath, crmField.getText()) == null && TxTOperations.buscarMedicoPorCPF(filePath, cpfField.getText()) == null){
            Medico medico = new Medico(nomeField.getText(), cpfField.getText(), crmField.getText(), telefoneField.getText(), especialidadeField.getText());
            TxTOperations.salvarTxt(medico.toString(), filePath);
            ((Stage) cadastrarMedicoButton.getScene().getWindow()).close();
        }else{
            System.out.println("Médico já cadastrado");
        }
    }

}
