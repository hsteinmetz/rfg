package de.hsteinmetz.rfg.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import de.hsteinmetz.rfg.Generator;

import javax.swing.*;
import java.awt.*;
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
    private JButton btnHelp;

    // TODO JFileChooser
    public RfgGui() {
        createButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(final ActionEvent e) {
                String name = txtName.getText();
                int size = Integer.parseInt(txtLength.getText());

                Generator.generate(name, size);
            }
        });

        presetCreateButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(final ActionEvent e) {
                String preset = presetSelect.getSelectedItem().toString();

                String name = JOptionPane.showInputDialog(
                        "File Name (Without file ending)");

                if (!name.isEmpty() && !name.matches("\\s+")) {
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
                    else if (preset.contains("ODP")) {
                        Generator.generate(String.format("%s.%s", name, "odp"),
                                1536000);
                    }
                    else if (preset.contains("ODS")) {
                        Generator.generate(String.format("%s.%s", name, "ods"),
                                1024000);
                    }
                    else if (preset.contains("ODT")) {
                        Generator.generate(String.format("%s.%s", name, "odt"),
                                6144);
                    }
                }
            }
        });
        btnHelp.addActionListener(new ActionListener() {
            @Override public void actionPerformed(final ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Creating a file:\n"
                        + "When creating a file, you can choose wether you want to\n"
                        + "use a preset or use custom values. A preset contains\n"
                        + "an appropiate file size and file ending, while\n" + "custom values should be used when none of the presets\n"
                        + "are applicable.\n" + "\n" + "The created file will"
                        + " always be saved in the directory containing\n"
                        + "this file (so if you want your file to be created on the desktop, just\n"
                        + "move this file to the desktop).");
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

    {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT
     * edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnlMain = new JPanel();
        pnlMain.setLayout(
                new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        pnlMain.add(spacer1,
                new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_VERTICAL, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null,
                        0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(
                new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        Font panel1Font = this.$$$getFont$$$(null, Font.BOLD, -1,
                panel1.getFont());
        if (panel1Font != null)
            panel1.setFont(panel1Font);
        pnlMain.add(panel1,
                new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
                        null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder("Preset"));
        presetSelect = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 =
                new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("PDF");
        defaultComboBoxModel1.addElement("PPTX (Powerpoint)");
        defaultComboBoxModel1.addElement("DOCX (Word)");
        defaultComboBoxModel1.addElement("XLSX (Excel)");
        defaultComboBoxModel1.addElement("TXT (Text Document)");
        defaultComboBoxModel1.addElement("ODT (Open/Libre Office Writer)");
        defaultComboBoxModel1.addElement("ODP (Open/Libre Office Impress)");
        defaultComboBoxModel1.addElement("ODS (Open/Libre Office Calc)");
        presetSelect.setModel(defaultComboBoxModel1);
        panel1.add(presetSelect,
                new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
                        false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2,
                new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_VERTICAL, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null,
                        0, false));
        presetCreateButton = new JButton();
        presetCreateButton.setText("Create");
        panel1.add(presetCreateButton,
                new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
                        false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(
                new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        Font panel2Font = this.$$$getFont$$$(null, Font.BOLD, -1,
                panel2.getFont());
        if (panel2Font != null)
            panel2.setFont(panel2Font);
        panel1.add(panel2,
                new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
                        null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder("Custom"));
        pnlName = new JPanel();
        pnlName.setLayout(
                new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(pnlName,
                new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
                        null, null, 0, false));
        pnlName.setBorder(BorderFactory.createTitledBorder("Name"));
        txtName = new JTextField();
        pnlName.add(txtName,
                new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null,
                        new Dimension(150, -1), null, 0, false));
        final Spacer spacer3 = new Spacer();
        pnlName.add(spacer3,
                new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_VERTICAL, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null,
                        0, false));
        final Spacer spacer4 = new Spacer();
        panel2.add(spacer4,
                new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null,
                        null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel2.add(spacer5,
                new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_VERTICAL, 1,
                        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null,
                        0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(
                new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3,
                new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW, null,
                        null, null, 0, false));
        panel3.setBorder(
                BorderFactory.createTitledBorder("Size (in characters)"));
        txtLength = new JTextField();
        panel3.add(txtLength,
                new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null,
                        new Dimension(150, -1), null, 0, false));
        createButton = new JButton();
        createButton.setText("Create");
        panel2.add(createButton,
                new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
                        false));
        btnHelp = new JButton();
        btnHelp.setText("Help");
        panel1.add(btnHelp,
                new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
                        false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size,
            Font currentFont) {
        if (currentFont == null)
            return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        }
        else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            }
            else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(),
                size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlMain;
    }
}