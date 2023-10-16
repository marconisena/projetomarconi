package daos;
import java.util.Scanner;

import models.Compra;
import models.Passagem;
import models.Usuario;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    private static Scanner scanner;

    public static <passagemToUpdate, passagemToUpdate1> void main(String[] args) throws Exception {
        Calendar cal = Calendar.getInstance();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PassagemDAO passagemDAO = new PassagemDAO();
        CompraDAO compraDAO = new CompraDAO();

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Cadastrar passagem");
            System.out.println("6 - Listar passagens");
            System.out.println("7 - Atualizar passagem");
            System.out.println("8 - Excluir passagem");
            System.out.println("9 - Cadastrar compra");
            System.out.println("10 - Listar compras");
            System.out.println("11 - Atualizar compra");
            System.out.println("12 - Excluir compra");
            System.out.println("13 - Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    Usuario usuario1 = new Usuario();
                    System.out.print("Digite o nome: ");
                    usuario1.setNome(scanner.next());
                    System.out.print("Digite o CPF: ");
                    usuario1.setCpf(scanner.next());
                    System.out.print("Digite o email: ");
                    usuario1.setEmail(scanner.next());
                    System.out.print("Digite a senha: ");
                    usuario1.setSenha(scanner.next());
                    System.out.print("Digite o telefone: ");
                    usuario1.setTelefone(scanner.next());
                    usuarioDAO.cadastraUsuario(usuario1);
                    break;

                case 2:
                    // Listar usuários
                    List<Usuario> usuarios1 = usuarioDAO.listarUsuario();
                    for (Usuario u : usuarios1) {
                        System.out.println("\nNome: " + u.getNome() + ", Cpf: " + u.getCpf() + ", Email: " + u.getEmail()
                                + ", Senha: " + u.getSenha() + ", Telefone: " + u.getTelefone());
                    }
                    break;

                case 3:
                    // Atualizar usuário
                    Usuario usuarioToUpdate = new Usuario();
                    System.out.print("Digite o ID do usuário a ser atualizado: ");
                    int userIdToUpdate = scanner.nextInt();
                    System.out.print("Digite o novo nome do usuário: ");
                    usuarioToUpdate.setNome(scanner.next());
                    System.out.print("Digite o novo CPF do usuário: ");
                    usuarioToUpdate.setCpf(scanner.next());
                    System.out.print("Digite o novo email do usuário: ");
                    usuarioToUpdate.setEmail(scanner.next());
                    System.out.print("Digite a nova senha do usuário: ");
                    usuarioToUpdate.setSenha(scanner.next());
                    System.out.print("Digite o novo telefone do usuário: ");
                    usuarioToUpdate.setTelefone(scanner.next());
                    usuarioDAO.atualizarUsuario(usuarioToUpdate, userIdToUpdate);
                    break;

                case 4:
                    // Excluir usuário
                    System.out.print("Digite o ID do usuário a ser excluído: ");
                    int userIdToDelete = scanner.nextInt();
                    usuarioDAO.excluirUsuario(userIdToDelete);
                    break;

                case 5:
                    // Cadastrar passagem
                    Passagem passagem11 = new Passagem();
                    System.out.print("Digite o destino: ");
                    passagem11.setDestino(scanner.next());
                    cal.set(2023, Calendar.JANUARY, 7);
                    passagem11.setData(new Date(cal.getTimeInMillis()));
                    System.out.print("Digite o preço: ");
                    passagem11.setPreco(scanner.nextDouble());
                    passagemDAO.cadastrapassagem(passagem11);
                    break;

                case 6:
                    // Listar passagens
                    List<Passagem> passagens = passagemDAO.listarPassagem();
                    for (Passagem p : passagens) {
                        System.out.println("Destino: " + p.getDestino() + ", Data: " + p.getData() + ", Preço: " + p.getPreco());
                    }
                    break;

                case 7:
                    // Atualizar passagem
                 Passagem passagemToUpdate = new Passagem();
                    System.out.print("Digite o ID da passagem a ser atualizada: ");
                    int passagemIdToUpdate = scanner.nextInt();
                    System.out.print("Digite o novo destino: ");
                    passagemToUpdate.setDestino(scanner.next());
                    cal.set(2023, Calendar.JANUARY, 7);
                    passagemToUpdate.setData(new Date(cal.getTimeInMillis()));
                    System.out.print("Digite o novo preço: ");
                    passagemToUpdate.setPreco(scanner.nextDouble());
                    passagemDAO.atualizarPassagem(passagemToUpdate, passagemIdToUpdate);
                    break;

                case 8:
                    // Excluir passagem
                    System.out.print("Digite o ID da passagem a ser excluída: ");
                    int passagemIdToDelete = scanner.nextInt();
                    passagemDAO.excluirPassagem(passagemIdToDelete);
                    break;

                case 9:
                    // Cadastrar compra
                    Compra compra1 = new Compra();
                    System.out.print("Digite o ID da passagem: ");
                    compra1.setId_passagem(scanner.nextInt());
                    System.out.print("Digite o ID do usuário: ");
                    compra1.setId_usuario(scanner.nextInt());
                    compraDAO.cadastraCompra(compra1);
                    break;

                case 10:
                    // Listar compras
                    List<Compra> compras = compraDAO.listarCompras();
                    for (Compra c : compras) {
                        System.out.println("ID: " + c.getId() + ", ID Passagem: " + c.getId_passagem() + ", ID Usuário: " + c.getId_usuario());
                    }
                    break;

                case 11:
                    // Atualizar compra
                    Compra compraToUpdate = new Compra();
                    System.out.print("Digite o ID da compra a ser atualizada: ");
                    int compraIdToUpdate = scanner.nextInt();
                    System.out.print("Digite o novo ID da passagem: ");
                    compraToUpdate.setId_passagem(scanner.nextInt());
                    System.out.print("Digite o novo ID do usuário: ");
                    compraToUpdate.setId_usuario(scanner.nextInt());
                    compraDAO.AtualizarCompra(compraToUpdate, compraIdToUpdate);
                    break;

                case 12:
                    // Excluir compra
                    System.out.print("Digite o ID da compra a ser excluída: ");
                    int compraIdToDelete = scanner.nextInt();
                    compraDAO.excluirCompra(compraIdToDelete);
                    break;

                case 13:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
