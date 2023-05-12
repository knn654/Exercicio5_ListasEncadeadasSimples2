package view;

import controller.ModificacaoCadastroController;

public class Principal {
	public static void main(String[] args) throws Exception {
		ModificacaoCadastroController modCadastro = new ModificacaoCadastroController();
		System.out.println("Iniciando geração de arquivos");
		modCadastro.novoCadastro(41, 60, 8000.00);
		modCadastro.novoCadastro(31, 40, 5000.00);
		modCadastro.novoCadastro(21, 30, 3000.00);
		

	}

}
