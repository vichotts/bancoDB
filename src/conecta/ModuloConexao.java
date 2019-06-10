package conecta;
import java.sql.*;

public class ModuloConexao {

    public Connection con = null;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBNAME = "crud"; 
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "root";
    private final String SENHA = "1234567";

    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Classe BD - Conectou");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Classe BD - Driver nao encontrado" + e.toString());
            return false;
        } catch (SQLException e) {
            System.out.println("Classe BD - Falha ao conectar" + e.toString());
            return false;
        }
    }

    public void close() {
        try {
            con.close();
            System.out.println("Classe BD - Desconectou");
        } catch (SQLException e) {
        }
    }
}