/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bryan
 */
public abstract class Criaturas {
    
    //----------------------Declaração de atributos----------------------\\
    protected int   con, modCon, forca, modForca, des, modDes, 
                    intel, modIntel, sab, modSab, car, modCar;
    protected int   pm, pv, pericia , nivel;
    protected String habilidade;

    //----------------------Métodos Construtores----------------------\\
    protected Criaturas(){}
    
    protected Criaturas(int con, int forca, int des, int intel, int sab, int car, String habilidade) {
        this.con = con;
        this.forca = forca;
        this.des = des;
        this.intel = intel;
        this.sab = sab;
        this.car = car;
        this.habilidade = habilidade;
        this.definirModificadores();
        //para melhor leitura do código a definição de modificadores foi feita
        //a partir de um método
    }

    //----------------------Getters e Setters----------------------\\
    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getModCon() {
        return modCon;
    }

    public void setModCon(int modCon) {
        this.modCon = modCon;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getModForca() {
        return modForca;
    }

    public void setModForca(int modForca) {
        this.modForca = modForca;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getModDes() {
        return modDes;
    }

    public void setModDes(int modDes) {
        this.modDes = modDes;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getModIntel() {
        return modIntel;
    }

    public void setModIntel(int modIntel) {
        this.modIntel = modIntel;
    }

    public int getSab() {
        return sab;
    }

    public void setSab(int sab) {
        this.sab = sab;
    }

    public int getModSab() {
        return modSab;
    }

    public void setModSab(int modSab) {
        this.modSab = modSab;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getModCar() {
        return modCar;
    }

    public void setModCar(int modCar) {
        this.modCar = modCar;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
    
    //----------------------Métodos criados----------------------\\
    protected int calculoModificador (int valor){
        int mod;
        mod = (valor - 10) / 2;
        System.out.println((valor - 10) / 2);
        return mod;
    }
    
    protected void definirModificadores(){
        this.setModCon(calculoModificador(con));
        this.setModForca(calculoModificador(forca));
        this.setModDes(calculoModificador(des));
        this.setModIntel(calculoModificador(intel));
        this.setModSab(calculoModificador(sab));
        this.setModCar(calculoModificador(car));
    }
    
    protected int calcBonusPericia(int modAtributo, boolean treinado, int bonusPericia){
        /*
        O bônus de percícia é determinado pelo nível da criatura, que por sua 
        vez é determinado pelo tipo dela (Animais, constructos e etc.), assim
        é impossível esta classe (Criaturas) saber o bônus e deve recebê-lo para
        calcular
        */
        int pericia;
        if (treinado)   pericia = modAtributo + (nivel / 2) + bonusPericia;
        else            pericia = modAtributo + (nivel / 2);
        return pericia;
    }
    
}
