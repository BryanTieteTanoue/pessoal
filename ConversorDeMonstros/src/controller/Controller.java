/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Criaturas;

/**
 *
 * @author Bryan
 */
public class Controller {
    
    //----------------------Declaração de atributos----------------------\\
    private Criaturas cri;
    
    //----------------------Métodos Construtores----------------------\\
    public Controller(){
    }
    
    //----------------------Métodos criados----------------------\\
    public void transformar(String conString, String forcaString, String desString, 
            String intelString, String sabString, String carString, int tipo, 
            String dados, String modificadorVidaString){
        int con, forca, des, intel, sab, car, modificadorVida;
        con = Integer.parseInt(conString);
        forca = Integer.parseInt(forcaString);
        des = Integer.parseInt(desString);
        intel = Integer.parseInt(intelString);
        sab = Integer.parseInt(sabString);
        car = Integer.parseInt(carString);
        modificadorVida = Integer.parseInt(modificadorVidaString);
        
        cri = new Criaturas(con, forca, des, intel, sab, car, tipo, dados, modificadorVida);  
    }
    
    public String obterVida(){
        return cri.getPv() + "";
    }
    
    public String obterPm(){
        return cri.getPm() + "";
    }
    
    public String obterNivel(){
        return cri.getNivel() + "";
    }

    public int[] obterAtributos(){
        return cri.getVetModificadores();
    }
    
    public int[][] obterPericias(){
        return cri.bonusPericias();
    }

}
