package App;

import dao.carroDAO;
import model.Carro;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        carroDAO dao = new carroDAO();

        //Classe Scanner
        Scanner sc = new Scanner(System.in);
        int input;
        boolean flag = false;

        do {
            System.out.println("Escolha a operacao que deseja ralizar:");
            System.out.println("1 - LISTAR");
            System.out.println("2 - INSERIR");
            System.out.println("3 - ATUALIZAR");
            System.out.println("4 - EXCLUIR");
            System.out.println("0 - SAIR");

            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    List <Carro> carros = dao.listar();
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro encontrado");
                    } else {
                        for(Carro carro : carros) {
                            System.out.println("Código: " + carro.getCodigo());
                            System.out.println("Modelo: " + carro.getModelo());
                            System.out.println("Ano: " + carro.getAno());
                            System.out.println("Marca: " + carro.getMarca());
                            System.out.println("=================================");
                        }
                    }
                    System.out.println("Aperte Enter para continuar");
                    sc.nextLine();

                    flag = input != 0;
                    break;
                case 2:
                    System.out.println("Digite o codigo do carro:");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o modelo do carro:");
                    String modelo = sc.nextLine();

                    System.out.println("Digite o ano do carro:");
                    String ano = sc.nextLine();

                    System.out.println("Digite o marca do carro:");
                    String marca = sc.nextLine();

                    Carro novoCarro = new Carro(codigo, modelo, ano, marca);

                    dao.inserir(novoCarro);

                    System.out.println("Carro inserido com sucesso!");
                    System.out.println("Aperte Enter para continuar");
                    sc.nextLine();

                    flag = input != 0;
                    break;
                case 3:
                    System.out.println("Digite o codigo do carro:");
                    int codigoAtt = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o modelo do carro:");
                    String modeloAtt = sc.nextLine();

                    System.out.println("Digite o ano do carro:");
                    String anoAtt = sc.nextLine();

                    System.out.println("Digite o marca do carro:");
                    String marcaAtt = sc.nextLine();

                    Carro atualizarCarro = new Carro(codigoAtt, modeloAtt, anoAtt, marcaAtt);

                    dao.atualizar(atualizarCarro);

                    System.out.println("Aperte Enter para continuar");
                    sc.nextLine();

                    flag = input != 0;
                    break;
                case 4:
                    System.out.println("Digite o codigo do carro que deseja excluir: ");
                    int codigoExcluir = sc.nextInt();
                    sc.nextLine();

                    dao.excluir(codigoExcluir);

                    System.out.println("Aperte Enter para continuar");
                    sc.nextLine();

                    flag = input != 0;
                    break;
                default:
                    System.out.println("Valor nao definido, escolha uma opcao valida");
            }


        } while(flag);

        sc.close();
    }
}
