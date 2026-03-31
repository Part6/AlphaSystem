/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import persistencia.Fornecedor;

/**
 *
 * @author Desktop
 */
public class fornecedordao {
    public void inserir(Fornecedor f) {
        String sql = "Insert into Fornecedor(Nome,Local) VALUES (?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getLocal());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
}
