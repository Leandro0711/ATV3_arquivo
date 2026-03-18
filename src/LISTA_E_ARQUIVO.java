import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LISTA_E_ARQUIVO {

    static ArrayList<String> listaN = new ArrayList<>();

    public static void main(String[] args) {

        Scanner l = new Scanner(System.in);

        System.out.println("Você já tem nomes cadastrados? (sim/nao)");
        String s = l.nextLine();

        if (s.equalsIgnoreCase("sim")) {
            carregarNomes("arquivo/meus_nomes.txt");

            int e = 0;
            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Consultar");
                System.out.println("2 - Alterar");
                System.out.println("3 - Remover");
                System.out.println("4 - Sair");
                System.out.print("Opção: ");

                e = l.nextInt();
                l.nextLine(); // Corrige o problema do nextInt() seguido de nextLine()

                switch (e) {
                    case 1:
                        System.out.println("Digite o nome que deseja encontrar: ");
                        String nomeB = l.nextLine();
                        int p = listaN.indexOf(nomeB);

                        if (listaN.contains(nomeB)) {
                            System.out.println("Nome encontrado! \nPosição: " + p);
                        } else {
                            System.out.println("Nome não encontrado.");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o nome que deseja alterar: ");
                        String nomeAntigo = l.nextLine();
                        if (listaN.contains(nomeAntigo)) {
                            System.out.println("Digite o novo nome: ");
                            String nomeNovo = l.nextLine();
                            int endereco = listaN.indexOf(nomeAntigo);
                            listaN.set(endereco, nomeNovo);
                            System.out.println("Nome alterado com sucesso!");
                        } else {
                            System.out.println("Nome não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("Digite o nome que deseja remover: ");
                        String nomeRemover = l.nextLine();
                        if (listaN.remove(nomeRemover)) {
                            System.out.println("Nome removido com sucesso!");
                        } else {
                            System.out.println("Nome não encontrado.");
                        }
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } while (e != 4);

            salvarNomesNoArquivo("arquivo/meus_nomes.txt");

        } else {
            for (int i = 0; i < 5; i++) {
                System.out.println("Digite o nome " + (i + 1) + ": ");
                listaN.add(l.nextLine());
            }

            File pasta = new File("arquivo");
            if (!pasta.exists()) {
                pasta.mkdir();
            }

            salvarNomesNoArquivo("arquivo/meus_nomes.txt");
            System.out.println("Os nomes foram salvos!");
        }
    }

    public static void carregarNomes(String nomeArquivo) {
        try (Scanner leitorArquivo = new Scanner(new File(nomeArquivo))) {
            while (leitorArquivo.hasNextLine()) {
                listaN.add(leitorArquivo.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Iniciando lista vazia.");
        }
    }

    public static void salvarNomesNoArquivo(String nomeArquivo) {
        try (PrintWriter gravador = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (String nome : listaN) {
                gravador.println(nome);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}