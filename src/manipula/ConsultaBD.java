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
		
		if (bd.abreConexao() ) {
			
			try {
				
				String sql = "SELECT id, nome,senha,email,sexo,estado FROM crud WHERE id >= ? ORDER BY id";
				PreparedStatement stmt = bd.con.prepareStatement(sql);
				
				stmt.setString(1, "2");
								
				ResultSet rs = stmt.executeQuery();
				
				System.out.println("ID        NOME                        SENHA");
				System.out.println("--------  -------------------------   ------");
				
				while (rs.next()) {
					String id = rs.getString("id");
					String nome = rs.getString("nome");
                                        String senha = rs.getString("senha");
					System.out.println(id + "        " + nome + "                         " + senha);
				}
				
				rs.close();
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
