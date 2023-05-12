package model;

public class Cliente {
	public String cpf;
	public String nome;
	public int idade;
	public double limiteCredito;

	public String toString() {
		return (cpf + ";" + nome + ";" + idade + ";" + limiteCredito);
	}
}
