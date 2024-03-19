package com.example.demo.Model;

import com.example.demo.MainApplication;

import java.sql.*;

import static java.lang.Integer.*;

public class RecebimentoModel {

    /*
    private String fornecedor, material, numeroLote;
    private LocalDate dataRecebimento;
    private int quantidade;

    //private recebidoPor

     */

    public static void insereRecebimento (String codigoFornecedor, String material, Date dataRecebimento,String quantidade, String numeroLote) {

        try(Connection connection = DriverManager.getConnection(MainApplication.DATABASE_URL)) {

            String sqlQuery = "INSERT into Recebimento (cod_for, cod_mat, dt_recebimento, quantidade, nro_lote)" +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, parseInt(codigoFornecedor));
            preparedStatement.setString(2, material);
            preparedStatement.setDate(3, dataRecebimento);
            preparedStatement.setInt(4, parseInt(quantidade));
            preparedStatement.setInt(5, parseInt(numeroLote));


            int row = preparedStatement.executeUpdate();

            if(row > 0) System.out.println("A linha foi inserida com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
