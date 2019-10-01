package br.com.fiap.closerain.models;

public class IncidenteViewModel {


    private UsuarioViewModel usuario;
    private RegiaoViewModel regiao;

    public IncidenteViewModel() {
    }

    public IncidenteViewModel(UsuarioViewModel usuario, RegiaoViewModel regiao) {
        this.usuario = usuario;
        this.regiao = regiao;
    }

    public UsuarioViewModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioViewModel usuario) {
        this.usuario = usuario;
    }

    public RegiaoViewModel getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoViewModel regiao) {
        this.regiao = regiao;
    }
}
