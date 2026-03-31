/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import persistencia.Venda;

/**
 *
 * @author Desktop
 */
public class vendadao {
    public void inserir(Venda v) {
        String sql = "insert into Venda (IdCliente, Observacoes, Data) VALUES (?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, v.getCliente().getId());
            stmt.setString(2, v.getObservacoes());
            stmt.setDate(3, v.getData());


            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
}
