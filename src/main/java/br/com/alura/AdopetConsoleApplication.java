package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AbrigoService abrigoService = new AbrigoService(client);
        PetService petService = new PetService(client);
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");
                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);
                switch (opcaoEscolhida) {
                    case 1:
                        abrigoService.listarAbrigos();
                        break;
                    case 2:
                        abrigoService.cadastrarAbrigo();
                        break;
                    case 3:
                        petService.listarPets();
                        break;
                    case 4:
                        petService.importarPets();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("NÚMERO INVÁLIDO!");
                        opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
