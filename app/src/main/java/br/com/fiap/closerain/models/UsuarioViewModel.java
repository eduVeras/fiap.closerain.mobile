package br.com.fiap.closerain.models;

import java.util.Date;

public class UsuarioViewModel {

    private String Nome;
    private String Email;
    private String Senha;
    private String Nascimento;
    private String Telefone;

    public UsuarioViewModel(String nome, String email, String senha, String nascimento, String telefone) {
        Nome = nome;
        Email = email;
        Senha = senha;
        Nascimento = nascimento;
        Telefone = telefone;
    }

    public UsuarioViewModel() {
    }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String nascimento) {
        Nascimento = nascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
}
