import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> arraycl = new ArrayList<Cliente>();
        ArrayList<Produto> arraypr = new ArrayList<Produto>();
        String escolha;
        do {
            System.out.println("===============================");
            System.out.println("      Sistema SmartTech");
            System.out.println("===============================");
            System.out.println("Selecione a opção:");
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Listagem de Clientes");
            System.out.println("3 - Procurar Clientes");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Cadastro de Produto");
            System.out.println("6 - Listagem de Produtos");
            System.out.println("7 - Procurar Produtos");
            System.out.println("8 - Excluir Produto");
            System.out.println("9 - Funções Extras");
            System.out.println("0 - Encerrar Programa");
            System.out.println("===============================");
            escolha = scanner.nextLine();
            if(escolha.equals("1")) {
                System.out.println("===============================");
                System.out.println("Cadastro de Cliente!");
                System.out.println("===============================");
                Cliente cliente = new Cliente();
                System.out.println("Digite o nome do cliente: ");
                cliente.setNome(scanner.nextLine());
                pedirIdade(cliente, scanner);
                scanner.nextLine();
                System.out.println("Digite o endereço do cliente: ");
                cliente.setEndereco(scanner.nextLine());
                pedirTelefone(cliente, scanner);
                scanner.nextLine();
                System.out.println("Digite o email do cliente: ");
                cliente.setEmail(scanner.nextLine());
                arraycl.add(cliente);
            } else if(escolha.equals("2")) {
                if(arraycl.size() == 0) {
                    System.out.println("Não existe clientes registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Listagem de Clientes!");
                    System.out.println("===============================");
                    int cont = 0;
                    for (Cliente clientes : arraycl) {
                        System.out.println("===============================");
                        System.out.println("Cliente n° " + (cont + 1));
                        clientes.exibir();
                        cont++;
                    }
                }
            } else if (escolha.equals("3")) {
                if (arraycl.size() == 0) {
                    System.out.println("Não existe clientes registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Procurar Clientes");
                    System.out.println("===============================");
                    System.out.println("Digite o nome do cliente que deseja procurar: ");
                    String nomecl = scanner.nextLine().toUpperCase();
                    int cont = 0;
                    int qtd = 0;
                    for (Cliente clientes : arraycl) {
                        if (clientes.getNome().toUpperCase().contains(nomecl)) {
                            System.out.println("Cliente n° " + (cont + 1));
                            clientes.exibir();
                            qtd++;
                        }
                        cont++;
                    }
                    if(qtd == 0) {
                        System.out.println("Não foi encontrado nenhum cliente com esse nome.");
                    }
                }
            } else if(escolha.equals("4")) {
                if(arraycl.size() == 0) {
                    System.out.println("Não existe clientes registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Excluir Cliente");
                    System.out.println("===============================");
                    excluirCliente(arraycl, scanner);
                }
            } else if(escolha.equals("5")) {
                System.out.println("===============================");
                System.out.println("Cadastro de Produto!");
                System.out.println("===============================");
                Produto produto = new Produto();
                System.out.println("Digite a descrição do Produto: ");
                produto.setDescricao(scanner.nextLine());
                pedirPreco(produto, scanner);
                scanner.nextLine();
                System.out.println("Digite a marca do Produto: ");
                produto.setMarca(scanner.nextLine());
                System.out.println("Digite o modelo do Produto: ");
                produto.setModelo(scanner.nextLine());
                arraypr.add(produto);
            } else if(escolha.equals("6")) {
                if(arraypr.size() == 0) {
                    System.out.println("Não existe produtos registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Listagem de Produtos");
                    System.out.println("===============================");
                    int cont = 0;
                    for (Produto produtos : arraypr) {
                        System.out.println("Produto n° " + (cont + 1));
                        produtos.exibir();
                        cont++;
                    }
                }
            } else if (escolha.equals("7")) {
                if(arraypr.size() == 0) {
                    System.out.println("Não existe produtos registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Procurar Produtos");
                    System.out.println("===============================");
                    System.out.println("Digite a descrição do produto que deseja procurar: ");
                    String nomecl = scanner.nextLine();
                    int cont = 0;
                    int qtd = 0;
                    for (Produto produtos : arraypr) {
                        if (produtos.getDescricao().contains(nomecl) == true) {
                            System.out.println("Produto n° " + (cont + 1));
                            produtos.exibir();
                            qtd++;
                        }
                        cont++;
                    }
                    if(qtd == 0) {
                        System.out.println("Não foi encontrado nenhum produto com essa descrição.");
                    }
                }
            } else if(escolha.equals("8")) {
                if(arraypr.size() == 0) {
                    System.out.println("Não existe produtos registrados.");
                } else {
                    System.out.println("===============================");
                    System.out.println("Excluir Produto");
                    System.out.println("===============================");
                    excluirProduto(arraypr, scanner);
                }
            } else if (escolha.equals("9")) {
                System.out.println("===============================");
                System.out.println("1 - Mostrar cliente com maior Idade");
                System.out.println("2 - Listar quantidade de clientes -18");
                System.out.println("3 - Mostrar idade média dos clientes");
                System.out.println("4 - Mostrar produto mais barato");
                System.out.println("5 - Mostrar média dos preços");
                System.out.println("6 - Listar quantidade de produtos acima da média");
                System.out.println("===============================");
                escolha = scanner.nextLine();
                if (escolha.equals("1")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe clientes registrados.");
                    } else {
                        System.out.println("===============================");
                        System.out.println("Cliente com maior idade");
                        System.out.println("===============================");
                        int cont = 0;
                        int idademax = 0;
                        int idadeguard = 0;
                        for (Cliente clientes : arraycl) {
                            if (clientes.getIdade() > idadeguard) {
                                idademax = cont;
                                idadeguard = clientes.getIdade();
                            }
                            cont++;
                        }
                        System.out.println("Cliente nº " + (idademax + 1));
                        cont = 0;
                        for (Cliente clientes : arraycl) {
                            if (cont == idademax) {
                                clientes.exibir();
                            }
                            cont++;
                        }
                    }
                } else if (escolha.equals("2")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe clientes registrados.");
                    } else {
                        int cont = 0;
                        for (Cliente clientes : arraycl) {
                            if (clientes.getIdade() < 18) {
                                cont++;
                            }
                        }
                        System.out.println("===============================");
                        System.out.println("Quantidade de clientes -18: " + cont);
                        System.out.println("===============================");
                    }
                } else if (escolha.equals("3")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe clientes registrados.");
                    } else {
                        int cont = 0;
                        double media = 0;
                        for (Cliente clientes : arraycl) {
                            media += clientes.getIdade();
                            cont++;
                        }
                        media /= cont;
                        System.out.println("===============================");
                        System.out.println("Média das idades dos clientes: " + media);
                        System.out.println("===============================");
                    }
                } else if (escolha.equals("4")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe produtos registrados.");
                    } else {
                        System.out.println("===============================");
                        System.out.println("Produto mais barato");
                        System.out.println("===============================");
                        int cont = 0;
                        double precomin = 0;
                        double precoguard = 0;
                        for (Produto produtos : arraypr) {
                            if (cont == 0) {
                                precoguard = produtos.getValor();
                                precomin = cont;
                            }
                            if (produtos.getValor() < precoguard) {
                                precoguard = produtos.getValor();
                                precomin = cont;
                            }
                            cont++;
                        }
                        System.out.println("Produto nº " + (precomin + 1));
                        cont = 0;
                        for (Produto produtos : arraypr) {
                            if (cont == precomin) {
                                produtos.exibir();
                            }
                            cont++;
                        }
                    }
                } else if (escolha.equals("5")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe produtos registrados.");
                    } else {
                        int cont = 0;
                        double media = 0;
                        for (Produto produtos : arraypr) {
                            media += produtos.getValor();
                            cont++;
                        }
                        media /= cont;
                        System.out.println("===============================");
                        System.out.println("Média dos preços dos produtos: " + media);
                        System.out.println("===============================");
                    }
                } else if (escolha.equals("6")) {
                    if(arraypr.size() == 0) {
                        System.out.println("Não existe produtos registrados.");
                    } else {
                        int cont = 0;
                        double media = 0;
                        for (Produto produtos : arraypr) {
                            media += produtos.getValor();
                            cont++;
                        }
                        media /= cont;
                        cont = 0;
                        for (Produto produtos : arraypr) {
                            if (produtos.getValor() > media) {
                                cont++;
                            }
                        }
                        System.out.println("Quantidade de produtos com preço acima da média: " + cont);
                    }
                }
            } else if (escolha.equals("0")) {
                System.out.println("===============================");
                System.out.println("Encerrando Programa...");
                System.out.println("===============================");
            } else {
                System.out.println("Escolha uma opção válida!");
            }
        } while(!escolha.equals("0"));
    }

    private static void excluirCliente(ArrayList<Cliente> arraycl, Scanner scanner) {
        System.out.println("Digite o número do cliente que deseja excluir: ");
        try {
            arraycl.remove(scanner.nextInt()-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de cliente inexistente!");
            excluirCliente(arraycl, scanner);
        } catch (InputMismatchException e) {
            System.out.println("Digite um número!");
            scanner.nextLine();
            excluirCliente(arraycl, scanner);
        } catch (Exception e) {
            System.out.println("Valor inválido!");
            scanner.nextLine();
            excluirCliente(arraycl, scanner);
        }
    }

    private static void excluirProduto(ArrayList<Produto> arraypr, Scanner scanner) {
        System.out.println("Digite o número do cliente que deseja excluir: ");
        try {
            arraypr.remove(scanner.nextInt()-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número do produto inexistente!");
            excluirProduto(arraypr, scanner);
        } catch (InputMismatchException e) {
            System.out.println("Digite um número!");
            scanner.nextLine();
            excluirProduto(arraypr, scanner);
        } catch (Exception e) {
            System.out.println("Valor inválido!");
            scanner.nextLine();
            excluirProduto(arraypr, scanner);
        }
    }

    private static void pedirIdade(Cliente cliente, Scanner scanner) {
        System.out.println("Digite a idade do cliente: ");
        try {
            cliente.setIdade(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            pedirIdade(cliente, scanner);
        } catch (Exception e) {
            System.out.println("Idade inválida");
            scanner.nextLine();
            pedirIdade(cliente, scanner);
        }
    }

    private static void pedirTelefone(Cliente cliente, Scanner scanner) {
        System.out.println("Digite o telefone do cliente: ");
        try {
            cliente.setTelefone(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Valor inválido");
            scanner.nextLine();
            pedirTelefone(cliente, scanner);
        }
    }

    private static void pedirPreco(Produto produto, Scanner scanner) {
        System.out.println("Digite o preço do Produto: ");
        try {
            produto.setValor(scanner.nextDouble());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            pedirPreco(produto, scanner);
        } catch (Exception e) {
            System.out.println("Valor inválido");
            scanner.nextLine();
            pedirPreco(produto, scanner);
        }
    }
}