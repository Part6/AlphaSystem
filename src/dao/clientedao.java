/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.Cliente;
import persistencia.Cliente;
/**
 *
 * @author Desktop
 */
public class clientedao {
public void inserir(Cliente cliente) {
        String sql = "Insert into Cliente(Nome,Categoria,Observacoes,Quantidade,Preco) VALUES (?, ?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEndereco().getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
}
