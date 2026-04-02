/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Usuario;

/**
 *
 * @author Desktop
 */
public class usuariodao {
    
    public void inserir(Usuario p) {
        String sql = "Insert into Usuario (Nome,Login,Senha,Tipo) VALUES (?, ?, md5(?), ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getLogin());
            stmt.setString(3, p.getSenha());
            stmt.setString(4, p.getTipo());

            stmt.executeUpdate();
            
        } catch (Exception e) {
           System.out.println("Erro ao inserir usuário: " + e.getMessage());
        } 
   }
    
    public static Usuario validarUsuarioSeguro(Usuario Usuario) {
                             
    String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
    Usuario UsuarioEncontrado = null;
                             
    try (Connection conn = coneccao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
                                  
                                  
        stmt.setString(1, Usuario.getLogin());
        stmt.setString(2, Usuario.getSenha());
        ResultSet rs = stmt.executeQuery();
                      
        while (rs.next()) {
            UsuarioEncontrado = new Usuario();
            UsuarioEncontrado.setId(rs.getInt("Id"));
            UsuarioEncontrado.setNome(rs.getString("Nome"));
            UsuarioEncontrado.setLogin(rs.getString("Login"));
            UsuarioEncontrado.setSenha(rs.getString("Senha"));
            UsuarioEncontrado.setTipo(rs.getString("Tipo"));
        }
    } catch (Exception ex) {
        System.out.println("Sintaxe de comando invalida");
    }
                              
    return UsuarioEncontrado;
}
}
