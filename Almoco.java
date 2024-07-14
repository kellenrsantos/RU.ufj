/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testesdoru;

public class Almoco extends Menu {
    private String salada;
    private String proteina;
    private String acompanhamentos;
    private String suco;
    private String sobremesa;
    
    public Almoco(String salada, String proteina, String acompanhamentos, String suco, String sobremesa) {
        super(new String[]{"Salada: " + salada, "Proteína: " + proteina, "Acompanhamentos: " + acompanhamentos, "Suco: " + suco, "Sobremesa: " + sobremesa});
        this.salada = salada;
        this.proteina = proteina;
        this.acompanhamentos = acompanhamentos;
        this.suco = suco;
        this.sobremesa = sobremesa;
    }

    // Getters e Setters para os atributos específicos

    public String getSalada() {
        return salada;
    }

    public String getProteina() {
        return proteina;
    }

    public String getAcompanhamentos() {
        return acompanhamentos;
    }

    public String getSuco() {
        return suco;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public void setAcompanhamentos(String acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    public void setSuco(String suco) {
        this.suco = suco;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }
    
}


