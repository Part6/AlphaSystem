/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Desktop
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class coneccao {
    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root", "Gustavobh10192008");
    private static final String URL = "\"jdbc:mysql://localhost:3306/AlphaSystemDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Gustavobh10192008";

    public static Connection conectar() throws Exception {

        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
