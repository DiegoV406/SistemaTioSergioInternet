
package br.com.sistemaInternetTeste.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe que recebe os metodos de criptografia de dados
 *
 */
public class Criptografia {

    /**
     * Metodo para criptografar dados de uma variavel
     *
     * @param texto variavel com valor para criptografia
     * @return Retorna um hashtext com valor criptografado
     */
    public static String getMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(texto.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash MD5: " + e.getMessage(), e);
        }
    }
}
