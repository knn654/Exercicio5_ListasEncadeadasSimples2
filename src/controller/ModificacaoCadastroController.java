package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import model.Cliente;
import model.Lista;

public class ModificacaoCadastroController {

	private void novoArquivo(Lista lista, String nomeArquivo) throws Exception {
		String path = "C:\\Temp";
		File arq = new File(path, nomeArquivo);
		int i = 0;
		StringBuffer buffer = new StringBuffer();
		FileWriter abreArq = new FileWriter(arq, true);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		for (i = 0; i < lista.size(); i++) {
			Cliente c = (Cliente) lista.get(i);
			buffer.append(c.toString() + "\n");
		}
		escreveArq.write(buffer.toString());
		escreveArq.flush();
		escreveArq.close();
		abreArq.close();
		System.out.println("Arquivo gerado com sucesso!!");
	}

	public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito) throws Exception {
		Lista listaClientes = new Lista();
		String path = "C:\\Temp";
		String nomeArquivo = "cadastro.csv";
		File arq = new File(path, nomeArquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				Cliente c = new Cliente();
				c.cpf = vetLinha[0];
				c.nome = vetLinha[1];
				c.idade = Integer.parseInt(vetLinha[2]);
				c.limiteCredito = Double.parseDouble(vetLinha[3]);
				if (c.idade >= idadeMin && c.idade <= idadeMax) {
					if (c.limiteCredito > limiteCredito) {
						listaClientes.addLast(c);
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			novoArquivo(listaClientes, ("Idade" + idadeMin + idadeMax + "limite" + limiteCredito));
		} else {
			throw new Exception("Arquivo inválido");
		}

	}
}
