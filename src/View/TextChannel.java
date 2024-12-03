package View;

import Control.MessageController;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.Color;
import java.awt.Dimension;

/**
 * TODO: Move to Readme with explanations
 * Current Resources:
 * https://stackoverflow.com/questions/31928306/how-to-create-and-use-a-jtextpane
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextPane.html
 * https://stackoverflow.com/questions/4059198/jtextpane-appending-a-new-string
 * https://stackoverflow.com/questions/50152438/jtextpane-wont-display-text-added-by-defaultstyleddocument
 * https://stackoverflow.com/questions/4246351/creating-random-colour-in-java
 */

public class TextChannel extends JFrame {
    JTextPane messageArea;

    JTextField messageField;

    public JButton sendButton;

    public TextChannel() {

        super("¬WhatsApp");
        MessageController messageController = new MessageController(this);
        StyleContext context = new StyleContext();
        JPanel chatPanel = new JPanel();

        GroupLayout layout = new GroupLayout(chatPanel);
        chatPanel.setLayout(layout);

        // Components
        JLabel numUsers = new JLabel("Users: 1");

        messageArea = new JTextPane();
        // Add scroll pane for scrolling
        JScrollPane scrollPane = new JScrollPane(messageArea);
        messageArea.setEditable(false);
        messageArea.setPreferredSize(new Dimension(200, 200));

        messageField = new JTextField();
        sendButton = new JButton("Send");

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Define horizontal layout
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(numUsers).addComponent(scrollPane).addGroup(
                              layout.createSequentialGroup()
                                    .addComponent(messageField)
                                    .addComponent(sendButton)));

        // Define vertical layout
        layout.setVerticalGroup(
                layout.createSequentialGroup().addComponent(numUsers)
                      .addComponent(scrollPane).addGroup(
                              layout.createParallelGroup(
                                            GroupLayout.Alignment.BASELINE)
                                    .addComponent(messageField)
                                    .addComponent(sendButton)));

        this.setVisible(false); // Close the other window
        // Finalize frame
        add(chatPanel);
        pack();
        // TODO: We'll have to change this if we want to go to the main frame
        //  (to enter ip and port again) on exit.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sendButton.addActionListener(messageController);

    }

    public void addMessage(String username, String message, Color color)
    throws BadLocationException {
        Style usernameStyle =
                messageArea.getStyledDocument().addStyle("usernameStyle", null);
        StyleConstants.setForeground(usernameStyle, color);
        Style messageStyle =
                messageArea.getStyledDocument().addStyle("messageStyle", null);
        messageArea.getDocument()
                   .insertString(messageArea.getDocument().getLength(),
                                 username + ": ", usernameStyle);
        messageArea.getDocument()
                   .insertString(messageArea.getDocument().getLength(), message,
                                 messageStyle);

    }

    public String getMessageField() {
        return messageField.getText();
    }

}