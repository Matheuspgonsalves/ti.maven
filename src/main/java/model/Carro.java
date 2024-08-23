package model;

public class Carro {
    private int codigo;
    private String modelo;
    private String ano;
    private String marca;

    public Carro(){
        this.codigo = -1;
        this.modelo = "";
        this.ano = "";
        this.marca = "";
    }

    public Carro(int codigo, String modelo, String ano, String marca){
        this.codigo = codigo;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return modelo;
    }

    public void setAno(String ano){
        this.ano = ano;
    }

    public String getAno(){
        return ano;
    }

    public void setMarca(String ano){
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
    }
}
