/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testesdoru;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VisualizarMenuFrame extends JFrame {

    private JButton btnVoltar;
    private JTextArea txtMenu;

    private List<String> menuAtual;

    public VisualizarMenuFrame(List<String> menuItems) {
        this.menuAtual = new ArrayList<>(menuItems); // Clonar para manter uma cópia do estado inicial
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Visualizar Menu");

        JPanel panel = new JPanel();

        txtMenu = new JTextArea(10, 30);
        txtMenu.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtMenu);

        btnVoltar = new JButton("Voltar");

        panel.add(scrollPane);
        panel.add(btnVoltar);

        add(panel);

        // Mostrar o menu inicial inventado
        mostrarMenuInicial();

        // Adicionando listener para o botão Voltar
        btnVoltar.addActionListener(e -> {
            dispose(); // Fechar a janela atual
            // Abrir a tela principal novamente
            SwingUtilities.invokeLater(() -> new RudaUfj().setVisible(true));
        });

        setVisible(true);
    }

    // Método para mostrar o menu inicial inventado
    private void mostrarMenuInicial() {
        StringBuilder menuText = new StringBuilder();
        menuText.append("Menu Inicial :\n");
        menuText.append("Segunda-feira - Almoço: Salada de Folhas, Frango Grelhado, Arroz Integral, Suco de Laranja, Mousse de Limão\n");
        menuText.append("Segunda-feira - Janta: Salada de Folhas, Tofu Grelhado, Quinoa, Suco de Abacaxi, Pudim de Chocolate\n");
        menuText.append("Terça-feira - Almoço: Salada Caprese, Salmão Assado, Purê de Batata, Suco de Uva, Torta de Maçã\n");
        menuText.append("Terça-feira - Janta: Salada Caprese, Proteína de Soja Grelhada, Risoto de Cogumelos, Suco de Limão, Pavê de Morango\n");
        menuText.append("Quarta-feira - Almoço: Salada de Rúcula com Tomate Seco, Carne Assada, Batata Sauté, Suco de Maçã, Cheesecake de Framboesa\n");
        menuText.append("Quarta-feira - Janta: Salada de Rúcula com Tomate Seco, Proteína de Ervilha, Purê de Abóbora, Suco de Pêssego, Sorvete de Baunilha\n");
        menuText.append("Quinta-feira - Almoço: Salada Caesar, Filé Mignon Grelhado, Risoto de Tomate Seco, Suco de Manga, Tiramisù\n");
        menuText.append("Quinta-feira - Janta: Salada Caesar, Hambúrguer Vegano, Batata Frita, Suco de Morango, Panna Cotta\n");
        menuText.append("Sexta-feira - Almoço: Salada Waldorf, Peixe Assado, Couscous Marroquino, Suco de Maracujá, Torta de Limão\n");
        menuText.append("Sexta-feira - Janta: Salada Waldorf, Seitan Grelhado, Legumes Assados, Suco de Kiwi, Gelatina de Frutas\n");

        txtMenu.setText(menuText.toString());
    }

    // Método para atualizar o texto do menu exibido no JTextArea
    public void atualizarMenu(List<String> novosItens) {
        this.menuAtual.clear();
        this.menuAtual.addAll(novosItens);
        updateMenuText();
    }

    private void updateMenuText() {
        StringBuilder menuText = new StringBuilder();
        for (String item : menuAtual) {
            menuText.append(item).append("\n");
        }
        txtMenu.setText(menuText.toString());
    }

    public static void main(String[] args) {
        List<String> menuItems = new ArrayList<>();
        menuItems.add("Segunda-feira - Almoço: Salada de Folhas, Frango Grelhado, Arroz Integral, Suco de Laranja, Mousse de Limão");
        menuItems.add("Segunda-feira - Janta: Salada de Folhas, Tofu Grelhado, Quinoa, Suco de Abacaxi, Pudim de Chocolate");
        menuItems.add("Terça-feira - Almoço: Salada Caprese, Salmão Assado, Purê de Batata, Suco de Uva, Torta de Maçã");
        menuItems.add("Terça-feira - Janta: Salada Caprese, Proteína de Soja Grelhada, Risoto de Cogumelos, Suco de Limão, Pavê de Morango");

        SwingUtilities.invokeLater(() -> new VisualizarMenuFrame(menuItems).setVisible(true));
    }
}
