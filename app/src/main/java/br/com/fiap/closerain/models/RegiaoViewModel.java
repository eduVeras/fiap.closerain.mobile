package br.com.fiap.closerain.models;

public class RegiaoViewModel {

    private int IdRegiao ;
    private String Cep ;
    private String Logradouro ;
    private int Numero ;
    private String Complemento ;
    private String Bairro ;
    private String Municipio ;
    private String Uf ;
    private double Latitude ;
    private double Longitude ;

    public RegiaoViewModel() {
    }

    public RegiaoViewModel(int idRegiao, String cep, String logradouro, int numero, String complemento, String bairro, String municipio, String uf, double latitude, double longitude) {

        IdRegiao = idRegiao;
        Cep = cep;
        Logradouro = logradouro;
        Numero = numero;
        Complemento = complemento;
        Bairro = bairro;
        Municipio = municipio;
        Uf = uf;
        Latitude = latitude;
        Longitude = longitude;
    }

    public int getIdRegiao() {
        return IdRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        IdRegiao = idRegiao;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String uf) {
        Uf = uf;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
