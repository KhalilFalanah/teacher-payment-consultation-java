package dao;

//Classes necess�rias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//In�cio da classe de conex�o//
public class ConexaoMySQL
{
	private static String status;
	private static Connection connection = null;

	// M�todo Construtor da Classe//
	public ConexaoMySQL() 
	{

	}
	
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConexaoMySQL.connection = connection;
	}

	// M�todo de Conex�o//
	public static Connection abrirConexaoMySQL() {
		connection = null; // atributo do tipo Connection
		try {
			
			// Configurando a nossa conex�o com um banco de dados//
			String serverName = "localhost"; // caminho do servidor do BD
			String mydatabase = "pagamentos"; // nome do seu banco de dados
			String url = "jdbc:mysql://"+serverName+":3306/"+mydatabase;
			String username = "root"; // nome de um usu�rio de seu BD
			String password = "123456"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);

			// Testa sua conex�o//
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->N�o foi possivel realizar conex�o");
			}

			return connection;

		} catch (SQLException e) {
			// N�o conseguindo se conectar ao banco
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;
		}

	}

	// M�todo que retorna o status da sua conex�o//
	public static void obterStatusConexao()
	{
		System.out.println(status);
	}

	// M�todo que fecha sua conex�o//
	public static boolean fecharConexao()
	{

		try
		{
			System.out.println("conex�o encerrada");
			connection.close();

			return true;
		}
		catch (SQLException e)
		{
			return false;
		}

	}

	// M�todo que reinicia sua conex�o//
	public static Connection ReiniciarConexao()
	{
		fecharConexao();
		return ConexaoMySQL.abrirConexaoMySQL();
	}
	
	public static void main(String[] args) {
		
		ConexaoMySQL.abrirConexaoMySQL();
		ConexaoMySQL.obterStatusConexao();
	}

}