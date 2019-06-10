package manipula;

import conecta.ModuloConexao;
import java.sql.*;

import javax.swing.JOptionPane;
/**
 *
 * @author Hotts
 */
public class AlteraDB {

	public static void main(String[] args) {
		
		ModuloConexao bd = new ModuloConexao();
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "UPDATE crud SET nome = ? WHERE id = ?";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				String id = JOptionPane.showInputDialog(null, "Informe o código da pessoa");
				String nome = JOptionPane.showInputDialog(null, "Informe o nome");
				
				// preparo a passagem de parametros 
				stmt.setString(1, nome);
				stmt.setString(2, id);
								
				int LinhasInseridas = stmt.executeUpdate();
				if (LinhasInseridas != 0) {
					System.out.println("Registro alterado com sucesso");
				}				
				
				stmt.close();
				bd.fechaConexao();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
			
		} else {
			System.out.println("Erro ao conectar");
		}
        }
}
		