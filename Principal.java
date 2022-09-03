import java.util.Arrays;
import java.util.Scanner;

import academia.Academia;
import academia.Forca;
import academia.Jedi;
import academia.Planeta;
import academia.SabreLuz;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Forca[] forca = new Forca[4];
        SabreLuz[] sabre = new SabreLuz[4];
        Jedi[] jedi = new Jedi[8];
        Academia[] academia = new Academia[2];
        Planeta[] planeta = new Planeta[2];
        String[] forca_nome = { "Pulo", "Enforcar", "Empurro", "Puxar o sabre" };

        String cor, nome, lado, galaxia, local;
        int potencia, tamanho, populacao, lotacaoMaxima;
        double tamanho_planeta;

        for (int i = 0; i < sabre.length; i++) {

            System.out.print("Digite uma cor de sabre: ");
            cor = sc.nextLine();

            sabre[i] = new SabreLuz(cor);
        }

        for (int i = 0; i < jedi.length; i++) {

            System.out.println("|---------------------------------Cadastro Jedi[" + (i + 1)
                    + "]---------------------------------|");

            System.out.print("Nome do jedi: ");
            nome = sc.nextLine();

            System.out.print("Lado do jedi: ");
            lado = sc.nextLine();

            System.out.println(Arrays.toString(sabre));

            System.out.print("Escolha um sabre (1 a 4): ");
            int cor_sabre = sc.nextInt();

            for (int j = 0; j < forca.length; j++) {
                System.out.print("Intendidade da forca [" + forca_nome[j] + "]: ");
                potencia = sc.nextInt();
                sc.nextLine();// Limpa buffer
                forca[j] = new Forca(forca_nome[j], potencia);

            }

            jedi[i] = new Jedi(nome, lado, forca, sabre[cor_sabre - 1]);
            jedi[i].apertarBotaoSabre();
        }

        for (int i = 0; i < planeta.length; i++) {
            System.out.println("|---------------------------------Cadastro Planeta[" + (i + 1)
                    + "]---------------------------------|");

            System.out.print("Nome do planeta: ");
            nome = sc.nextLine();

            System.out.print("Nome da galaxia: ");
            sc.next();
            galaxia = sc.nextLine();

            System.out.print("Tamanho do planeta: ");
            tamanho_planeta = sc.nextDouble();

            System.out.print("Populacao do planeta: ");
            populacao = sc.nextInt();
            sc.nextLine();// Limpa buffer

            planeta[i] = new Planeta(nome, galaxia, tamanho_planeta, populacao);
        }

        for (int i = 0; i < academia.length; i++) {

            System.out.println("|---------------------------------Cadastro Academia[" + (i + 1)
                    + "]---------------------------------|");
            System.out.print("local da academia: ");
            local = sc.nextLine();

            System.out.print("Tamanho da academia: ");
            tamanho = sc.nextInt();

            System.out.print("Lotacao maxima da academia: ");
            lotacaoMaxima = sc.nextInt();

            System.out.print("Em que planeta esta a academia: ");
            int planeta_num = sc.nextInt();

            Jedi[] jedi_acad = new Jedi[4];

            for (int n = 0; n < jedi.length; n++) {
                System.out.println("Jedi [" + (n + 1) + "]:" + jedi[n].getNome() + ".");
            }

            for (int j = 0; j < jedi_acad.length; j++) {
                System.out.print("Digite os jedis que deseja na academia (1 a 8): ");
                int num_jedi = sc.nextInt();
                sc.nextLine();// Limpa buffer
                jedi_acad[j] = jedi[num_jedi - 1];
            }
            
            academia[i] = new Academia(local, tamanho, lotacaoMaxima, jedi_acad, planeta[planeta_num - 1]);
        }
        sc.close();

        for (int i = 0; i < jedi.length; i++) {
            System.out.print(
                    "|---------------------------------Jedi[" + (i + 1) + "]---------------------------------|");
            System.out.println(jedi[i].toString());
            System.out.println(Arrays.toString(jedi[i].getForca()));
        }

        for (int i = 0; i < academia.length; i++) {
            System.out.print(
                    "|---------------------------------Academia[" + (i + 1) + "]---------------------------------|");
            System.out.print(academia[i].toString());
        }
    }
}