package com.example.demo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class MainController {

@FXML
private TextField textFieldFornecedor, textFieldMaterial,textFieldQuantidade, textFieldNumeroLote;
@FXML
private DatePicker datePickerDataRecebimento;
@FXML
private ComboBox<String> comboBoxRecebidoPor;
    @FXML
    public void salvaRecebimento() {

        LocalDate localDate = datePickerDataRecebimento.getValue();

        System.out.println(textFieldFornecedor.getText() + " " + localDate.toString() + " " +
                 textFieldMaterial.getText() + " " + textFieldQuantidade.getText() + " " + textFieldNumeroLote.getText());

    }
}