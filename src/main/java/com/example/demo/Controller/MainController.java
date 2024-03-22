package com.example.demo.Controller;

import com.example.demo.MainApplication;
import com.example.demo.Model.RecebimentoModel;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.*;
import java.time.Duration;
import java.util.ResourceBundle;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class MainController implements Initializable {

@FXML
private TextField textFieldFornecedor, textFieldMaterial,textFieldQuantidade, textFieldNumeroLote;
@FXML
private DatePicker datePickerDataRecebimento;
@FXML
private ComboBox<String> comboBoxRecebidoPor;
@FXML
private Text textAviso;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        try(Connection connection1 = DriverManager.getConnection(MainApplication.DATABASE_URL)){

            String query = "SELECT nome FROM Recebedores";

            Statement statement = connection1.createStatement();

            try(ResultSet resultSet = statement.executeQuery(query)){

                    while (resultSet.next()){

                            comboBoxRecebidoPor.getItems().add(resultSet.getString("nome"));

                    }
                }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
@FXML
    public void salvaRecebimento() {

        if(textFieldFornecedor.getText().isEmpty() || datePickerDataRecebimento.toString().isEmpty() || textFieldMaterial.getText().isEmpty() || textFieldQuantidade.getText().isEmpty() || textFieldNumeroLote.getText().isEmpty())
        {
            // Show the textAviso and schedule its disappearance after 2 seconds
            this.textAviso.setVisible(true);


        }else {

            RecebimentoModel recebimento = new RecebimentoModel(Integer.parseInt(
                    textFieldFornecedor.getText()),
                    textFieldMaterial.getText(),
                    Date.valueOf(datePickerDataRecebimento.getValue()),
                    comboBoxRecebidoPor.getValue(),
                    Integer.parseInt(textFieldQuantidade.getText()),
                    Integer.parseInt(textFieldNumeroLote.getText()));

            recebimento.insereRecebimento();



        }
    }
}