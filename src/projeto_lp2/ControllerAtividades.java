package projeto_lp2;

import java.util.HashMap;
import java.util.Map;

public class ControllerAtividades extends Validacao {
	
	private Map<String, Atividade> atividades;
	private int proximoId;
	
	public ControllerAtividades() {
		
		this.atividades = new HashMap<String, Atividade>();
		this.proximoId = 1;
		
	}
	
	public String cadastrarAtividade(String descricao, String risco, String descricaoRisco, int id) {
		
		this.atividades.put("A" + id, new Atividade(descricao, risco, descricaoRisco, id));
		return "A" + id;
		
	}
	
	public String exibirAtividade(String id) {
		
		super.validaString(id, "Campo codigo nao pode ser nulo ou vazio.");
		
		return this.atividades.get(id).toString();
		
	}
	
	public void cadastrarItem(String id, String descricao) {
		
		super.validaString(id, "Campo codigo nao pode ser nulo ou vazio.");
		
		this.atividades.get(id).cadastrarItem(descricao);
		
	}
	
	public void apagaAtividade(String id) {
		
		super.validaString(id, "Campo codigo nao pode ser nulo ou vazio.");
		
		this.atividades.remove(id);
		
	}
	
	public int contaItensPendentes(String id) {
		
		super.validaString(id, "Campo codigo nao pode ser nulo ou vazio.");
		
		return this.atividades.get(id).contaItensPendentes();
		
	}
	
	public int contaItensRealizados(String id) {
		
		super.validaString(id, "Campo codigo nao pode ser nulo ou vazio.");
		
		return this.atividades.get(id).contaItensRealizados();
		
	}
	
}
