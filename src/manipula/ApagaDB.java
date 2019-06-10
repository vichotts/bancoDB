package manipula;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conecta.ModuloConexao;

public class ApagaDB {
	
	public static void main(String[] args) {
		
		ModuloConexao bd = new ModuloConexao();
		
		if (bd.getConnection() ) {
			
			try {
				
				String sql = "DELETE FROM pessoa WHERE id = ?";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				String id = JOptionPane.showInputDialog(null, "Informe o código da pessoa");
				
				// preparo a passagem de parametros 
				stmt.setString(1, id);
								
				int LinhasAlteradas = stmt.executeUpdate();
				if (LinhasAlteradas != 0) {
					System.out.println("Registro alterado com sucesso");
				} else {
					System.out.println("Registro não encontrado");
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
