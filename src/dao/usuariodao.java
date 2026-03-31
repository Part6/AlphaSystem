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
                              // Criando consulta parametrizada
                              String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
                              Usuario UsuarioEncontrado = null;
                              //resolver isso !!!!!!!!!!!!!!!!!
                              try {
                                  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_exemplo", "root", "Gustavobh10192008");
                                  PreparedStatement statement = conexao.prepareStatement(sql);
                                  
                                  // Atribuindo os valores na consulta
                                  statement.setString(1, Usuario.getLogin());
                                  statement.setString(2, Usuario.getSenha());
                                  ResultSet rs = statement.executeQuery();
                      
                                  while (rs.next()) {
                                      UsuarioEncontrado = new Usuario();
                                      UsuarioEncontrado.setId(rs.getInt("id"));
                                      UsuarioEncontrado.setNome(rs.getString("nome"));
                                      UsuarioEncontrado.setLogin(rs.getString("login"));
                                      UsuarioEncontrado.setSenha(rs.getString("senha"));
                                      UsuarioEncontrado.setTipo(rs.getString("tipo"));
                                  }
                              } catch (SQLException ex) {
                                  System.out.println("Sintaxe de comando invalida");
                              }
                              
                              return UsuarioEncontrado;
                          }
}
