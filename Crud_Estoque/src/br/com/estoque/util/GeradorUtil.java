/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.util;

/**
 *
 * @author Vítor
 */
public class GeradorUtil {
    public static String gerarToken() {
        String[] letras = {"a", "b",
            "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int tamanho = letras.length;
        String token = "";
        int indice;
        for (int i = 0; i < 4; i++) {
            indice = (int) (Math.random() * tamanho);
            token = token + letras[indice];
        }
        return token;
    }
}
