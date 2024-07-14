/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testesdoru;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class AtualizarMenuFrame extends JFrame {

    private JComboBox<String> cmbDiaSemana;
    private JComboBox<String> cmbTipoRefeicao;
    private JTextField txtSalada;
    private JTextField txtProteina;
    private JTextField txtAcompanhamentos;
    private JTextField txtSuco;
    private JTextField txtSobremesa;
    private JButton btnAtualizar;
    private JButton btnVoltar;

    private Consumer<String> atualizacaoListener;

    public AtualizarMenuFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Atualizar Menu");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblDiaSemana = new JLabel("Dia da Semana:");
        cmbDiaSemana = new JComboBox<>(new String[]{"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"});
        JLabel lblTipoRefeicao = new JLabel("Tipo de Refeição:");
        cmbTipoRefeicao = new JComboBox<>(new String[]{"Almoço", "Jantar"});
        JLabel lblSalada = new JLabel("Salada:");
        txtSalada = new JTextField(20);
        JLabel lblProteina = new JLabel("Proteína:");
        txtProteina = new JTextField(20);
        JLabel lblAcompanhamentos = new JLabel("Acompanhamentos:");
        txtAcompanhamentos = new JTextField(20);
        JLabel lblSuco = new JLabel("Suco:");
        txtSuco = new JTextField(20);
        JLabel lblSobremesa = new JLabel("Sobremesa:");
        txtSobremesa = new JTextField(20);

        btnAtualizar = new JButton("Atualizar");
        btnVoltar = new JButton("Voltar");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblDiaSemana, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cmbDiaSemana, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lblTipoRefeicao, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(cmbTipoRefeicao, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(lblSalada, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(txtSalada, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(lblProteina, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(txtProteina, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(lblAcompanhamentos, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(txtAcompanhamentos, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(lblSuco, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(txtSuco, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(lblSobremesa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(txtSobremesa, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(btnAtualizar, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(btnVoltar, constraints);

        add(panel);

        // Adicionando listener para o botão Voltar
        btnVoltar.addActionListener(e -> {
            dispose(); // Fechar a janela atual
            SwingUtilities.invokeLater(() -> new RudaUfj().setVisible(true)); // Voltar à tela principal
        });

        // Adicionando listener para o botão Atualizar
        btnAtualizar.addActionListener(this::atualizarMenu);

        setVisible(true);
    }

    private void atualizarMenu(ActionEvent e) {
        String diaSemana = (String) cmbDiaSemana.getSelectedItem();
        String tipoRefeicao = (String) cmbTipoRefeicao.getSelectedItem();
        String salada = txtSalada.getText();
        String proteina = txtProteina.getText();
        String acompanhamentos = txtAcompanhamentos.getText();
        String suco = txtSuco.getText();
        String sobremesa = txtSobremesa.getText();

        StringBuilder novoMenu = new StringBuilder();
        novoMenu.append(diaSemana).append(" - ").append(tipoRefeicao).append(": ");
        novoMenu.append("Salada: ").append(salada).append(", ");
        novoMenu.append("Proteína: ").append(proteina).append(", ");
        novoMenu.append("Acompanhamentos: ").append(acompanhamentos).append(", ");
        novoMenu.append("Suco: ").append(suco).append(", ");
        novoMenu.append("Sobremesa: ").append(sobremesa);

        if (atualizacaoListener != null) {
            atualizacaoListener.accept(novoMenu.toString());
        }

        int opcao = JOptionPane.showConfirmDialog(this, "Menu atualizado com sucesso! Deseja fazer outra alteração?",
                "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.NO_OPTION) {
            System.exit(0); // Sair do programa
        } else {
            limparCampos();
        }
    }

    private void limparCampos() {
        cmbDiaSemana.setSelectedIndex(0);
        cmbTipoRefeicao.setSelectedIndex(0);
        txtSalada.setText("");
        txtProteina.setText("");
        txtAcompanhamentos.setText("");
        txtSuco.setText("");
        txtSobremesa.setText("");
        txtSalada.requestFocus(); // Colocar foco no campo de salada
    }

    public void setAtualizacaoListener(Consumer<String> listener) {
        this.atualizacaoListener = listener;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AtualizarMenuFrame().setVisible(true));
    }
}

