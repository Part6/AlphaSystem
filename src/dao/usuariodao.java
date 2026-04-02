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
import persistencia.Usuario;

/**
 *
 * @author Desktop
 */
public class usuariodao {
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
