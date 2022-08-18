
import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "191515");
			
			if(con != null) {
				System.out.println("Conexão bem sucedida");
			} else {
				System.out.println("Erro na conexão");
			}
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}

