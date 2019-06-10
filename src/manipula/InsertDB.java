package manipula;

import conecta.ModuloConexao;
import java.sql.*;

import javax.swing.JOptionPane;
/**
 *
 * @author Hotts
 */
public class InsertDB {

	public static void main(String[] args) {
		
		ModuloConexao bd = new ModuloConexao();
		
		if (bd.getConnection() ) {
			
			try {
				
				String sql = "INSERT INTO crud (id, nome, senha, email, sexo , estado) VALUES (? , ? , ? , ? , ? , ?)";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
                                String id = JOptionPane.showInputDialog(null, "Informe seu Código id");
				String nome = JOptionPane.showInputDialog(null, "Informe o nome");
				String senha = JOptionPane.showInputDialog(null, "Informe sua senha");
                                String email = JOptionPane.showInputDialog(null, "Informe seu email");
                                String sexo = JOptionPane.showInputDialog(null, "Informe seu sexo");
                                String estado = JOptionPane.showInputDialog(null, "Informe seu Estado");
				
				// preparo a passagem de parametros 
				stmt.setString(1, id);
                                stmt.setString(1, nome);
				stmt.setString(2, senha);
                                stmt.setString(3, email);
                                stmt.setString(4, sexo);
                                stmt.setString(5, estado);
								
				int LinhasInseridas = stmt.executeUpdate();
				if (LinhasInseridas != 0) {
					System.out.println("Registro inserido com sucesso");
				}				
				
				stmt.close();
				bd.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
			
		} else {
			System.out.println("Erro ao conectar");
		}
		
	}
	
}
