package de.hsteinmetz.rfg.gui;

import de.hsteinmetz.rfg.Generator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <a href="mailto:hendrik_steinmetz@live.com">Hendrik Steinmetz</a>
 */
public class RfgGui {
    private JPanel pnlMain;
    private JTextField txtName;
    private JPanel pnlName;
    private JComboBox presetSelect;
    private JButton presetCreateButton;
    private JTextField txtLength;
    private JButton createButton;

    // TODO JFileChooser
    public RfgGui() {

        createButton.addActionListener((e) -> {
            String name = txtName.getText();
            int size = Integer.parseInt(txtLength.getText());

            Generator.generate(name, size);
        });

        presetCreateButton.addActionListener((e) -> {
            String preset = presetSelect.getSelectedItem().toString();

            String name = JOptionPane.showInputDialog("File Name (Without file ending)");

            if(!name.isEmpty() && !name.matches("\\s+")) {
                if (preset.contains("PPTX")) {
                    Generator.generate(String.format("%s.%s", name, "pptx"),
                            1536000);
                }
                else if (preset.contains("DOCX")) {
                    Generator.generate(String.format("%s.%s", name, "docx"),
                            6144);
                }
                else if (preset.contains("PDF")) {
                    Generator.generate(String.format("%s.%s", name, "pdf"),
                            19456);
                }
                else if (preset.contains("XLSX")) {
                    Generator.generate(String.format("%s.%s", name, "xlsx"),
                            1024000);
                }
                else if (preset.contains("TXT")) {
                    Generator.generate(String.format("%s.%s", name, "txt"),
                            120);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random File Generator");
        frame.setContentPane(new RfgGui().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}