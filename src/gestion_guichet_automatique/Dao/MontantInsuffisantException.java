/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_guichet_automatique.Dao;

/**
 *
 * @author Prechil_13
 */
public class MontantInsuffisantException extends Exception {

    public MontantInsuffisantException(String solde_insuffisant) {
        System.out.println(this);
    }

   
}
