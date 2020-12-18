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
public class Criaturas {
    
    //----------------------Declaração de atributos----------------------\\
    private int   con, modCon, forca, modForca, des, modDes, 
                    intel, modIntel, sab, modSab, car, modCar;
    private int   pm, pv, tipo, nivel;
    private int[] vetModificadores = new int[6];
    /*Tipos de criatura
    1 - Animais
    2 - Constructos
    3 - Espíritos
    4 - Humanoides
    5 - Monstros
    6 - Mortos-Vivos
    */

    //----------------------Métodos Construtores----------------------\\
    public Criaturas(){}
    
    public Criaturas(int con, int forca, int des, int intel, int sab, int car, int tipo, String dados, int modificadorVida) {
        this.con = con;
        this.forca = forca;
        this.des = des;
        this.intel = intel;
        this.sab = sab;
        this.car = car;
        this.definirModificadores();
        this.tipo = tipo;
        this.pv = calcularPV(dados, modificadorVida);
        this.nivel = calculoNivel();
        this.pm = getNivel();
        this.listaDeModificadores();
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getVetModificadores(int posicao) {
        return vetModificadores[posicao];
    }
    
    public int[] getVetModificadores(){
        return vetModificadores;
    }
    
    //----------------------Métodos criados----------------------\\
    private int calculoModificador (int valor){
        int mod;
        mod = (valor - 10) / 2;
        return mod;
    }
    
    private void definirModificadores(){
        this.setModCon(calculoModificador(con));
        this.setModForca(calculoModificador(forca));
        this.setModDes(calculoModificador(des));
        this.setModIntel(calculoModificador(intel));
        this.setModSab(calculoModificador(sab));
        this.setModCar(calculoModificador(car));
    }
    
    private int calcularPV(String dados, int modificadorVida){
        /*
        Este método irá receber a vida em "forma de dados", como "13d8 + 15".
        Ele retira o "d" de "13d8" e depois multiplica os números (após transforma-los
        em int)
        */
        String separado[] = dados.split("d");
        int num1 = Integer.parseInt(separado[0]);
        int num2 = Integer.parseInt(separado[1]);
        int pvMaximo = num1 * num2 + modificadorVida;
        int pvReal;
        switch(this.getTipo()){
            case 0: //Animais
                pvReal = Math.round(((float)pvMaximo / 100) * 60);
                break;
            case 1: //Constructos
                pvReal = Math.round(((float)pvMaximo / 100) * 70);
                break;
            case 2: //Espíritos
                pvReal = Math.round(((float)pvMaximo / 100) * 65);
                break;
            case 3: // Humanoides
                pvReal = Math.round(((float)pvMaximo / 100) * 65);
                break;
            case 4: //Monstros
                pvReal = Math.round(((float)pvMaximo / 100) * 80);
                break;
            case 5: //Mortos-Vivos
                pvReal = Math.round(((float)pvMaximo / 100) * 65);
                break;
            default:
                pvReal = 1;
        }
        return pvReal;
        /*Usar o pvMaximo deixaria a criatura muito forte, para fins de balalançeamento
        usamos apenas parte do pvMaximo, para cada tipo de criatura há uma 
        porcentagem que é mais balanceada
        */
    }
    
    private int calculoNivel(){
        int nivel;
        switch (this.getTipo()){
            case 0: //Animais
                nivel = getPv() / (4 + getModCon());               
                break;
            case 1: //Constructos
                nivel = getPv() / (5 + getModCon());
                break;
            case 2: //Espíritos
                nivel = getPv() / (4 + getModCon());
                break;
            case 3: // Humanoides
                nivel = getPv() / (2 + getModCon());
                break;
            case 4: //Monstros
                nivel = getPv() / (10 + getModCon());
                break;
            case 5: //Mortos-Vivos
                nivel = getPv() / (4 + getModCon());
                break;
            default:
                nivel = 1;
        }
        return nivel;
    }
    
    private void listaDeModificadores(){
        //usado para facilitar os calculos de pericias
        this.vetModificadores[0] = this.getModForca();
        this.vetModificadores[1] = this.getModDes();
        this.vetModificadores[2] = this.getModCon();
        this.vetModificadores[3] = this.getModIntel();
        this.vetModificadores[4] = this.getModSab();
        this.vetModificadores[5] = this.getModCar();
    }
    
    public int calcularBonusPericias(int atributo, boolean treinado){
        int bonus = 0;
        if (!treinado) bonus =      getNivel() / 2 + atributo ;
        else {
            if (getNivel() < 7)         bonus += ( (getNivel() / 2) + atributo + 2);
            else if (getNivel() < 15)   bonus += ( (getNivel() / 2) + atributo + 4);
            else                        bonus += ( (getNivel() / 2) + atributo + 6);
        }
        return bonus;
    }
    
    public int[][] bonusPericias(){
        //retorna todos os bonus de perícias em uma matriz, evita ter 
        //que chamar o método várias vezes
        int[][] pericias = new int[6][2];
        for(int i = 0; i < pericias.length; i++) {
            for(int j = 0; j < pericias[0].length; j++) {
                if (j == 0) pericias[i][j] = calcularBonusPericias(this.getVetModificadores(i), false);
                else        pericias[i][j] = calcularBonusPericias(this.getVetModificadores(i), true);
            }
        }
        return pericias;
    }
            
    @Override
    public String toString(){
        String msg = "";
        msg =       "+---------------------------+\n"
                +   "+Nível.......:            " + getNivel() + "+\n"
                +   "+PV:" + getPv() + " ---------------- " + "PM:" + getPm() + "+\n"
                +   "+Constituição: " + getCon() + " --- Mod: " + getModCon() + "+\n"
                +   "+Força.......: " + getForca()+ " --- Mod: " + getModForca() + "+\n"
                +   "+Destreza....: " + getDes() + " --- Mod: " + getModDes() + "+\n"
                +   "+Inteligência: " + getIntel() + " --- Mod: " + getModIntel() + "+\n"
                +   "+Sabedoria...: " + getSab() + " --- Mod: " + getModSab() + "+\n"
                +   "+Carisma.....: " + getCar() + " --- Mod: " + getModCar() + "+\n"
                +   "+---------------------------+\n"
                ;
        return msg;
    }
    
}
