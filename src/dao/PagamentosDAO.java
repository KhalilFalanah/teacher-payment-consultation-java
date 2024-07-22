package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import model.Professor;
import model.ProfessorDE;
import model.ProfessorHorista;

public class PagamentosDAO {
	private Connection con;

	public PagamentosDAO() {
		con = ConexaoMySQL.abrirConexaoMySQL();
	}

	public boolean cadastraProfessor(Professor p) {
		PreparedStatement prepS = null;
		ResultSet res = null;
		String sql = null;

		try {
			String verificaMatriculaDE = "SELECT * FROM ProfessorDE WHERE matricula = ?";
			prepS = con.prepareStatement(verificaMatriculaDE);
			prepS.setInt(1, p.getMatricula());
			res = prepS.executeQuery();

			if (res.next()) {
				System.out.println("Matrícula já existe. Não é possível cadastrar.");
				return false;
			}

			res.close();
			prepS.close();

			String verificaMatriculaHorista = "SELECT * FROM ProfessorHorista WHERE matricula = ?";
			prepS = con.prepareStatement(verificaMatriculaHorista);
			prepS.setInt(1, p.getMatricula());
			res = prepS.executeQuery();

			if (res.next()) {
				System.out.println("Matrícula já existe. Não é possível cadastrar.");
				return false;
			}

			res.close();
			prepS.close();

			if (p instanceof ProfessorDE) {
				sql = "INSERT INTO ProfessorDE values(?,?,?,?,?)";
				prepS = con.prepareStatement(sql);

				prepS.setInt(1, p.getMatricula());
				prepS.setString(2, p.getNome());
				prepS.setDouble(3, ((ProfessorDE) p).getSalarioBase());
				prepS.setString(4, p.getDataPagamento());
				prepS.setDouble(5, ((ProfessorDE)p).getSalarioTotal());

			} else if (p instanceof ProfessorHorista) {
				sql = "INSERT INTO ProfessorHorista values(?,?,?,?,?,?)";
				prepS = con.prepareStatement(sql);

				prepS.setInt(1, p.getMatricula());
				prepS.setString(2, p.getNome());
				prepS.setInt(3, ((ProfessorHorista) p).getHorasTrabalhadas());
				prepS.setDouble(4, ((ProfessorHorista) p).getValorHora());
				prepS.setString(5, p.getDataPagamento());
				prepS.setDouble(6, ((ProfessorHorista)p).getSalarioTotal());
			}
			int result = prepS.executeUpdate();
			if (result > 0) {
				System.out.println("Professor cadastrado com sucesso.");
				return true;
			} else {
				System.out.println("Falha ao cadastrar professor.");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar SQL: " + e.getMessage());
			return false;
		}
	}

	public boolean consultaPagamentos(Professor p) {
		PreparedStatement prepS = null;
		String nome = null, dataPagamento = null;
		int matricula = 0, horasTrabalhadas = 0;
		double valorHora = 0, salarioBase = 0, salarioTotal = 0;
		String sql;
		ResultSet res;
		
		

		try {
			if(p instanceof ProfessorDE) {
				sql = "SELECT * FROM ProfessorDE WHERE matricula LIKE ?";
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, p.getMatricula());
				res = prepS.executeQuery();

				if (res.next()) {
					nome = res.getString(2);
					salarioBase = res.getDouble(3);
					dataPagamento = res.getString(4);
					salarioTotal = res.getDouble(5);

					p.setNome(nome);
					((ProfessorDE) p).setSalarioBase(salarioBase);
					p.setDataPagamento(dataPagamento);
					((ProfessorDE) p).setSalarioTotal(salarioTotal);
					return true;
				}
			}
			else if(p instanceof ProfessorHorista) {
				sql = "SELECT * FROM ProfessorHorista WHERE matricula LIKE ?";
				
				prepS = con.prepareStatement(sql);
				prepS.setInt(1, p.getMatricula());
				res = prepS.executeQuery();

				if (res.next()) {
					nome = res.getString(2);
					horasTrabalhadas = res.getInt(3);
					valorHora = res.getDouble(4);
					dataPagamento = res.getString(5);
					salarioTotal = res.getDouble(6);

					p.setNome(nome);
					((ProfessorHorista) p).setHorasTrabalhadas(horasTrabalhadas);
					((ProfessorHorista)p ).setValorHora(valorHora);
					p.setDataPagamento(dataPagamento);
					((ProfessorHorista) p).setSalarioTotal(salarioTotal);
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}


