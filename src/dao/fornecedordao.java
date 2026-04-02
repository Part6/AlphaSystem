/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Fornecedor> listar() {
    List<Fornecedor> lista = new ArrayList<>();
    String sql = "SELECT * FROM Fornecedor";

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Fornecedor f = new Fornecedor();
            f.setId(rs.getInt("Id"));
            f.setNome(rs.getString("Nome"));
            f.setLocal(rs.getString("Local"));

            lista.add(f);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
}
