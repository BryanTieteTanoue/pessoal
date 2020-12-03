/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Animais extends Criaturas {
    
    //----------------------Declaração de atributos----------------------\\
    private final String habilidadeAnimal = "Valor de Inteligência 1 ou 2; visão na penumbra.";
    
    //----------------------Métodos Construtores----------------------\\
    public Animais(){}
    
    public Animais(int con, int forca, int des, int intel, int sab, int car, String habilidade, String dados, int modificadorVida){
        super(con, forca, des, intel, sab, car, habilidade);
        this.setPv(calcularPv(dados, modificadorVida));
        this.setNivel(calcularNivel());
        this.setPm(getNivel() * 0); //Cálculo de PM por nível
    }
    
    //----------------------Métodos criados----------------------\\
    private int calcularPv(String dados, int modificadorVida){
        /*
        Este método irá receber a vida em "forma de dados", como "13d8 + 15".
        Ele retira o "d" de "13d8" e depois multiplica os números (após transforma-los
        em int)
        */
        String separado[] = dados.split("d");
        int num1 = Integer.parseInt(separado[0]);
        int num2 = Integer.parseInt(separado[1]);
        int pvMaximo = num1 * num2 + modificadorVida;
        int pvReal = Math.round(((float)pvMaximo / 100) * 60); 
        /*Usar o pvMaximo deixaria a criatura muito forte, para este tipo de 
        inimigo o ideal é algo entorno de 60% do máximo. Por se tratar de contas
        com porcentagem usei a função de arredondar para tranformar em int. 
        O "pvMaximo" tem que ser usado com o cast, pois com números menores que 
        100 o código iria dar erro
        */
        return pvReal;
    }
    
    private int calcularNivel(){
        int nivel;
        nivel = getPv() / (4 + getModCon());
        // o nível é calculado usando a vida, dividimos usando a fórmula das regras
        return nivel;
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
    
    public static void main(String[] args) {
        Animais a = new Animais(11, 6, 8, 15, 19, 23, "dfgs", "5d6", 5);
        System.out.println(a);
    }
    
}
