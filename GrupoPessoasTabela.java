import java.util.ArrayList;
import java.util.Scanner;

public class GrupoPessoasTabela {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays dinâmicos para armazenar os grupos
        ArrayList<String> grupoMasculino = new ArrayList<>();
        ArrayList<String> grupoFeminino = new ArrayList<>();

        System.out.println("Digite os nomes e sexos no formato 'Nome-Sexo' (ex: João-Masculino).");
        System.out.println("Para encerrar, digite 'sair'.\n");

        while (true) {
            System.out.print("Entrada: ");
            String entrada = scanner.nextLine();

            // Encerra o programa quando o usuário digitar "sair"
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            // Divide a entrada em nome e sexo
            String[] dados = entrada.split("-");
            if (dados.length != 2) {
                System.out.println("Formato inválido! Use 'Nome-Sexo'.");
                continue;
            }

            String nome = dados[0].trim();
            String sexo = dados[1].trim().toLowerCase();

            // Verifica o sexo e adiciona ao grupo correspondente
            if (sexo.equals("masculino")) {
                grupoMasculino.add(nome);
            } else if (sexo.equals("feminino")) {
                grupoFeminino.add(nome);
            } else {
                System.out.println("Sexo inválido! Use 'Masculino' ou 'Feminino'.");
            }
        }

        // Exibe os grupos em formato de tabela
        System.out.println("\nTabela de Grupos:");
        System.out.printf("%-20s | %-20s%n", "Grupo Masculino", "Grupo Feminino");
        System.out.println("---------------------+---------------------");

        // Calcula o número máximo de linhas na tabela
        int maxLinhas = Math.max(grupoMasculino.size(), grupoFeminino.size());

        for (int i = 0; i < maxLinhas; i++) {
            String masculino = i < grupoMasculino.size() ? grupoMasculino.get(i) : "";
            String feminino = i < grupoFeminino.size() ? grupoFeminino.get(i) : "";
            System.out.printf("%-20s | %-20s%n", masculino, feminino);
        }

        // Fecha o scanner após a leitura de dados
        scanner.close();
    }
}
