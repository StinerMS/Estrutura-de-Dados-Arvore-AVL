import java.util.Scanner;

public class Aplicativo {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        AvlTree avlTree = new AvlTree();
        String[] menu = new String[] {"\n*** Menu ***",
                "1 - Inserir valor",
                "2 - Procurar Valor",
                "3 - Mostrar arvore",
                "4 - Verifica se a Arvore está vazia",
                "5 - Resetar Nó principal",
                "6 - Pos Ordem",
                "7 - Pre Ordem",
                "8 - Em Ordem",
                "0 - Sair"};

        int option;

        loop: while(true) {

            for(String s : menu) System.out.println(s);
            option = k.nextInt();

            switch (option) {
                case 1 -> avlTree.insert(k.nextInt());
                case 2 -> System.out.println(avlTree.searchForElement(k.nextInt()));
                case 3 -> avlTree.printTree();
                case 4 -> System.out.println(avlTree.isEmpty());
                case 5 -> avlTree.removeAll();
                case 6 -> avlTree.posOrder();
                case 7 -> avlTree.preOrder();
                case 8 -> avlTree.inOrder();
                case 0 -> {break loop;}
            }

        }
    }
}
