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
        String sql = "Insert into Cliente(Nome, Cpf, Email, EnderecoID) VALUES (?, ?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEnderecoId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }

public Cliente search(String nome) {
    String sql = "SELECT * FROM Cliente WHERE Nome = ?";

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // 🔥 ESSENCIAL
            Cliente c = new Cliente();
            c.setId(rs.getInt("Id"));
            c.setNome(rs.getString("Nome"));
            c.setCpf(rs.getString("CPF"));
            c.setEmail(rs.getString("Email"));

            c.setEnderecoId(rs.getInt("EnderecoID"));
            return c;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}
