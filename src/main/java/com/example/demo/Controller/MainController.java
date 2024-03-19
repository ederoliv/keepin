package com.example.demo.Controller;

import com.example.demo.Model.RecebimentoModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

@FXML
private TextField textFieldFornecedor, textFieldMaterial,textFieldQuantidade, textFieldNumeroLote;
@FXML
private DatePicker datePickerDataRecebimento;
@FXML
private ComboBox<String> comboBoxRecebidoPor;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        comboBoxRecebidoPor.getItems().addAll("Eder", "Sara");

    }
@FXML
    public void salvaRecebimento() {

        if(textFieldFornecedor.getText().isEmpty() || datePickerDataRecebimento.toString().isEmpty() || textFieldMaterial.getText().isEmpty() || textFieldQuantidade.getText().isEmpty() || textFieldNumeroLote.getText().isEmpty())
        {
            System.out.println("Todos os campos devem ser preenchidos!");
        }else {

            LocalDate localDate = datePickerDataRecebimento.getValue();

            //Date dataSQL = Date.valueOf(localDate);

            RecebimentoModel recebimento = new RecebimentoModel(Integer.parseInt(
                    textFieldFornecedor.getText()),
                    textFieldMaterial.getText(),
                    Date.valueOf(localDate),
                    comboBoxRecebidoPor.getValue(),
                    Integer.parseInt(textFieldQuantidade.getText()),
                    Integer.parseInt(textFieldNumeroLote.getText()));

            recebimento.insereRecebimento();
            //(int fonecedor, String material, Date dataRecebimento, String recebidoPor, int quantidade, int numeroLote

        }
    }
}