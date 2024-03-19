package com.example.demo.Model;

import com.example.demo.MainApplication;

import java.sql.*;

import static java.lang.Integer.*;

public class RecebimentoModel {


    private String  material, recebidoPor;
    private Date dataRecebimento;
    private int fornecedor, quantidade, numeroLote;
    public RecebimentoModel (int fonecedor, String material, Date dataRecebimento, String recebidoPor, int quantidade, int numeroLote) {

        this.fornecedor = fonecedor;
        this.material = material;
        this.dataRecebimento = dataRecebimento;
        this.recebidoPor = recebidoPor;
        this.quantidade = quantidade;
        this.numeroLote = numeroLote;

    }

    public void insereRecebimento () {

        try(Connection connection = DriverManager.getConnection(MainApplication.DATABASE_URL)) {

            String sqlQuery = "INSERT into Recebimento (cod_for, cod_mat, dt_recebimento, recebido_por, quantidade, nro_lote)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, this.fornecedor);
            preparedStatement.setString(2, this.material);
            preparedStatement.setDate(3, this.dataRecebimento);
            preparedStatement.setString(4, this.recebidoPor);
            preparedStatement.setInt(5, this.quantidade);
            preparedStatement.setInt(6, this.numeroLote);


            int row = preparedStatement.executeUpdate();

            if(row > 0) System.out.println("A linha foi inserida com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
