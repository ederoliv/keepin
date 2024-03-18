package com.example.demo.Controller;

import com.example.demo.Model.RecebimentoModel;
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

        //System.out.println(textFieldFornecedor.getText() + " " + localDate.toString() + " " +
            //     textFieldMaterial.getText() + " " + textFieldQuantidade.getText() + " " + textFieldNumeroLote.getText());

        if(textFieldFornecedor.getText().isEmpty() || localDate.toString().isEmpty() || textFieldMaterial.getText().isEmpty() || textFieldQuantidade.getText().isEmpty() || textFieldNumeroLote.getText().isEmpty())
        {
            System.out.println("Todos os campos devem ser preenchidos!");
        }else { RecebimentoModel.insereRecebimento(textFieldFornecedor.getText(), textFieldMaterial.getText(), textFieldQuantidade.getText(), textFieldNumeroLote.getText()); }
        //String codigoFornecedor, String material, String quantidade, String numeroLote



    }
}