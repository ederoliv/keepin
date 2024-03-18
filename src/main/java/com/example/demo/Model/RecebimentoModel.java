package com.example.demo.Model;

import com.example.demo.MainApplication;

import java.sql.*;
import java.time.LocalDate;

import static java.lang.Integer.*;

public class RecebimentoModel {

    private String fornecedor, material, numeroLote;
    private LocalDate dataRecebimento;
    private int quantidade;

    //private recebidoPor

    public static void insereRecebimento (String codigoFornecedor, String material, String quantidade, String numeroLote) {

        try(Connection connection = DriverManager.getConnection("jdbc:ucanaccess://G://Meu Drive//Projetos//Projeto Supp//supp-project//src//main//resources//supp_db.accdb")) {

            String sqlQuery = "INSERT into Recebimento (cod_for)" +
                    "VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, parseInt(codigoFornecedor));

            int row = preparedStatement.executeUpdate();

            if(row > 0) System.out.println("A linha foi inserida com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
