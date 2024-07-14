
package testesdoru;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RudaUfj extends JFrame {

    private JButton btnVisualizar;
    private JButton btnAtualizar;
    private JButton btnSair;

    // Exemplo de menu inicial
    private List<String> menuItems;

    public RudaUfj() {
        this.menuItems = inicializarMenu();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Menu Interativo");

        JPanel panel = new JPanel();

        btnVisualizar = new JButton("Visualizar Menu");
        btnAtualizar = new JButton("Atualizar Menu");
        btnSair = new JButton("Sair");

        panel.add(btnVisualizar);
        panel.add(btnAtualizar);
        panel.add(btnSair);

        add(panel);

        // Adicionando listener para o botão Visualizar Menu
        btnVisualizar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                dispose(); // Fechar a janela atual
                // Abrir a tela de visualizar menu
                exibirMenuInventado();
            });
        });

        // Adicionando listener para o botão Atualizar Menu
        btnAtualizar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                dispose(); // Fechar a janela atual
                // Abrir a tela de atualizar menu
                AtualizarMenuFrame atualizarMenuFrame = new AtualizarMenuFrame();
                atualizarMenuFrame.setVisible(true);
            });
        });

        // Adicionando listener para o botão Sair
        btnSair.addActionListener(e -> {
            System.exit(0); // Sair do programa
        });

        setVisible(true);
    }

    // Método para inicializar o menu com os itens iniciais
    private List<String> inicializarMenu() {
        return List.of(
                "Segunda-feira - Almoço: Salada de Folhas, Frango Grelhado, Arroz Integral, Suco de Laranja, Mousse de Limão",
                "Segunda-feira - Janta: Salada de Folhas, Tofu Grelhado, Quinoa, Suco de Abacaxi, Pudim de Chocolate",
                "Terça-feira - Almoço: Salada Caprese, Salmão Assado, Purê de Batata, Suco de Uva, Torta de Maçã",
                "Terça-feira - Janta: Salada Caprese, Proteína de Soja Grelhada, Risoto de Cogumelos, Suco de Limão, Pavê de Morango",
                "Quarta-feira - Almoço: Salada de Rúcula com Tomate Seco, Carne Assada, Batata Sauté, Suco de Maçã, Cheesecake de Framboesa",
                "Quarta-feira - Janta: Salada de Rúcula com Tomate Seco, Proteína de Ervilha, Purê de Abóbora, Suco de Pêssego, Sorvete de Baunilha",
                "Quinta-feira - Almoço: Salada Caesar, Filé Mignon Grelhado, Risoto de Tomate Seco, Suco de Manga, Tiramisù",
                "Quinta-feira - Janta: Salada Caesar, Hambúrguer Vegano, Batata Frita, Suco de Morango, Panna Cotta",
                "Sexta-feira - Almoço: Salada Waldorf, Peixe Assado, Couscous Marroquino, Suco de Maracujá, Torta de Limão",
                "Sexta-feira - Janta: Salada Waldorf, Seitan Grelhado, Legumes Assados, Suco de Kiwi, Gelatina de Frutas"
        );
    }

    // Método para exibir o menu inventado
    private void exibirMenuInventado() {
        JTextArea menuTextArea = new JTextArea(15, 40);
        menuTextArea.setEditable(false);
        menuTextArea.setText(converterListaParaString(menuItems));

        JScrollPane scrollPane = new JScrollPane(menuTextArea);

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                dispose(); // Fechar a janela atual
                new RudaUfj().setVisible(true); // Voltar à tela principal
            });
        });
        panel.add(btnVoltar);

        JFrame frame = new JFrame("Menu Inventado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centralizar na tela
        frame.setVisible(true);
    }

    // Método para converter uma lista de strings em uma única string formatada
    private String converterListaParaString(List<String> lista) {
        StringBuilder sb = new StringBuilder();
        for (String item : lista) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RudaUfj().setVisible(true));
    }
}
