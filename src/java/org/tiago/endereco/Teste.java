/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.parg.viacep;

import java.util.Scanner;

public class Teste implements ViaCEPEvents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Teste().run();
    }

    public void run() {
        ViaCEP viaCEP = new ViaCEP(this);
        String cep;
        Scanner scan = new Scanner(System.in);

        System.out.println(Teste.class.getName() + " - digite sair para fechar o teste!");

        do {
            System.out.print("Digite um cep: ");
            cep = scan.next();
            // consulta
            if (!cep.equals("sair")) {
                try {
                    viaCEP.buscar(cep);
                } catch (ViaCEPException ex) {
                    System.err.println("Ocorreu um erro na classe " + ex.getClasse() + ": " + ex.getMessage());
                }
            }
        } while (!cep.equals("sair"));
    }

    @Override
    public void onCEPSuccess(ViaCEP cep) {
        System.out.println();
        System.out.println("CEP " + cep.getCep() + " encontrado!");
        System.out.println("Logradouro: " + cep.getLogradouro());
        System.out.println("Complemento: " + cep.getComplemento());
        System.out.println("Bairro: " + cep.getBairro());
        System.out.println("Localidade: " + cep.getLocalidade());
        System.out.println("UF: " + cep.getUf());
        System.out.println("Gia: " + cep.getGia());
        System.out.println("Ibge: " + cep.getIbge());
        System.out.println();
    }

    @Override
    public void onCEPError(String cep) {
        System.out.println();
        System.out.println("Não foi possível encontrar o CEP " + cep + "!");
        System.out.println();
    }

}