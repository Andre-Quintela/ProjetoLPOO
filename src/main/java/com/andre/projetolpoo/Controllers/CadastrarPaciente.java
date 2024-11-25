package com.andre.projetolpoo.Controllers;

import com.andre.projetolpoo.Logical.TxTOperations;
import com.andre.projetolpoo.Models.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarPaciente {
    String filePath = "src/main/resources/com/andre/projetolpoo/Data/Pacientes.txt";

    @FXML
    private TextField alergiasField;

    @FXML
    private Button cadastrarPacienteButton;

    @FXML
    private TextField convenioField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField observacoesField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField tipoSanguinioField;

    @FXML
    void cadastrarPaciente(ActionEvent event) {
        if(TxTOperations.buscarPacientePorCPF(filePath, cpfField.getText()) == null){
            Paciente paciente = new Paciente(nomeField.getText(), cpfField.getText(), telefoneField.getText(), alergiasField.getText(), convenioField.getText(), observacoesField.getText(), tipoSanguinioField.getText());
            TxTOperations.salvarTxt(paciente.toString(), filePath);
            ((Stage) cadastrarPacienteButton.getScene().getWindow()).close();
        }else {
            System.out.println("Paciente já cadastrado");
        }
    }

}
