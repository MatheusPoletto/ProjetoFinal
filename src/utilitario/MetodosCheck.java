package utilitario;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class MetodosCheck {
	MensagemErro erro = new MensagemErro();

	public void selecionaMensagemRetorno(String tela) {
		switch (tela) {
		case "cadastro_cliente":
			erro.erroCadastrarCliente();
			break;
		case "cadastro_corretor":
			erro.erroCadastrarCorretor();
			break;
		case "adicionar_jpg":
			erro.erroFormatoJpg();
			break;
		case "cadastro_imovel":
			erro.erroCadastroImovel();
			break;
		case "pesquisa_rg":
			erro.erroPesquisarRg();
			break;
		default:
			break;
		}
	}

	public Boolean verificaCampos(List<JTextField> componentes, String tela) {
		Boolean passou = true;
		for (JTextField cp : componentes) {
			if (cp.getText().equals("")) {
				passou = false;
			}
		}

		if (passou == false) {
			selecionaMensagemRetorno(tela);
		}
		return passou;
	}

	public List<JTextField> limpacampos(List<JTextField> componentes) {
		List<JTextField> retorno = new ArrayList<>();
		for (JTextField cp : componentes) {
			cp.setText("");
			retorno.add(cp);
		}
		return retorno;

	}

	public Boolean verificaExtensaoJpg(JFileChooser chooser, String tela) {
		Boolean isJpg = null;
		if (chooser.getSelectedFile().getAbsolutePath().toString().toLowerCase().endsWith(".jpg")) {
			isJpg = true;
		} else {
			isJpg = false;
			selecionaMensagemRetorno(tela);
		}

		return isJpg;

	}

}
