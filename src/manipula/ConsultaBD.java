package manipula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conecta.ModuloConexao;
/**
 *
 * @author Hotts
 */
public class ConsultaBD {
    public static void main(String[] args) {
		
		ModuloConexao bd = new ModuloConexao();
		
		if (bd.getConnection() ) {
			
			try {
				
                                    String sql = "SELECT id, nome,senha,email,sexo,estado FROM pessoa, ORDER BY id";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
		
								
				ResultSet rs = stmt.executeQuery();
				
				System.out.println("ID        NOME                        SENHA");
				System.out.println("--------  -------------------------   ------");
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
                                        String senha = rs.getString("senha");
					System.out.println(id + "        " + nome + "                         " + senha+ "       ");
				}
				
				rs.close();
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
