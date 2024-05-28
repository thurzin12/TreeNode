import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Inserir nó");
            System.out.println("2. Remover nó");
            System.out.println("3. Buscar nó");
            System.out.println("4. Exibir travessia em ordem");
            System.out.println("5. Exibir travessia pré-ordem");
            System.out.println("6. Exibir travessia pós-ordem");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Insira o valor do nó: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    break;
                case 2:
                    System.out.println("Escolha o tipo de nó para remover:");
                    System.out.println("a. Raiz");
                    System.out.println("b. Filho");
                    System.out.println("c. Folha");
                    char typeChoice = scanner.next().charAt(0);

                    switch (typeChoice) {
                        case 'a':
                            if (bst.getRoot() != null) {
                                System.out.println("Removendo a raiz: " + bst.getRoot().getVal());
                                bst.deleteKey(bst.getRoot().getVal());
                            } else {
                                System.out.println("A árvore está vazia.");
                            }
                            break;
                        case 'b':
                            System.out.print("Insira o valor do nó filho a ser removido: ");
                            int deleteValue = scanner.nextInt();
                            TreeNode nodeToDelete = bst.search(deleteValue);
                            if (nodeToDelete != null && !bst.isLeaf(nodeToDelete)) {
                                bst.deleteKey(deleteValue);
                                System.out.println("Nó filho removido: " + deleteValue);
                            } else {
                                System.out.println("Nó não encontrado ou não é um nó filho.");
                            }
                            break;
                        case 'c':
                            System.out.print("Insira o valor da folha a ser removida: ");
                            int leafValue = scanner.nextInt();
                            TreeNode leafNode = bst.search(leafValue);
                            if (bst.isLeaf(leafNode)) {
                                bst.deleteKey(leafValue);
                                System.out.println("Folha removida: " + leafValue);
                            } else {
                                System.out.println("Nó não encontrado ou não é uma folha.");
                            }
                            break;
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                    }
                    break;
                case 3:
                    System.out.print("Insira o valor do nó a ser buscado: ");
                    int searchValue = scanner.nextInt();
                    TreeNode foundNode = bst.search(searchValue);
                    if (foundNode != null) {
                        System.out.println("Nó encontrado: " + foundNode.getVal());
                    } else {
                        System.out.println("Nó não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Travessia em ordem:");
                    bst.inorder();
                    break;
                case 5:
                    System.out.println("Travessia pré-ordem:");
                    bst.preorder();
                    break;
                case 6:
                    System.out.println("Travessia pós-ordem:");
                    bst.postorder();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
