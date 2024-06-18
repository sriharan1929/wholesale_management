import javax.swing.*;
import java.awt.*;

public class demo extends JFrame {

    public demo() {
        setTitle("Wholesale Project Management");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // North panel for header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(createHeader());

        // Center panel for content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(createCategoriesPanel());
        contentPanel.add(createDiscountPanel());
        contentPanel.add(createProductGrid());

        // Add contentPanel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // South panel for footer
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
        footerPanel.add(createFooter());

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createHeader() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        // Top bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.add(new JLabel("99WHOLESALE"));
        topBar.add(new JTextField(30));
        topBar.add(new JButton("Search"));
        topBar.add(new JLabel("Support"));
        topBar.add(new JLabel("Contact Us"));
        topBar.add(new JButton("Login/Register"));
        panel.add(topBar);

        // Category bar
        JPanel categoryBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        categoryBar.add(new JButton("UNDER ₹29"));
        categoryBar.add(new JButton("UNDER ₹49"));
        categoryBar.add(new JButton("UNDER ₹99"));
        categoryBar.add(new JButton("UNDER ₹149"));
        categoryBar.add(new JButton("PREMIUM STORE"));
        panel.add(categoryBar);

        return panel;
    }

    private JPanel createCategoriesPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Big Discount for Wholesale Buyers!"));
        return panel;
    }

    private JPanel createDiscountPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Discount Codes:"));
        panel.add(new JLabel("5% Site Code: bulk05"));
        panel.add(new JLabel("10% Site Code: bulk10"));
        panel.add(new JLabel("15% Site Code: bulk15"));
        return panel;
    }

    private JPanel createProductGrid() {
        JPanel panel = new JPanel(new GridLayout(5, 5, 10, 10));
        for (int i = 1; i <= 25; i++) {
            panel.add(createProductCard("Product " + i));
        }
        return panel;
    }

    private JPanel createProductCard(String productName) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel productImage = new JLabel(productName);
        productImage.setHorizontalAlignment(JLabel.CENTER);
        panel.add(productImage, BorderLayout.CENTER);
        
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(new JLabel("<html><div style='text-align: center;'><b>₹" + (10 + (int) (Math.random() * 90)) + "</b></div></html>", JLabel.CENTER));
        JButton addToCartButton = new JButton("ADD TO CART");
        infoPanel.add(addToCartButton);
        
        panel.add(infoPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createFooter() {
        JPanel panel = new JPanel();
        JTextArea footerText = new JTextArea(5, 80);
        footerText.setText("WHY TO CHOOSE 99WHOLESALE?\n\n" +
                           "WHAT CAN YOU BUY FROM 99WHOLESALE?\n\n" +
                           "Home & Kitchen...\n\n" +
                           "Truly Loved by Bharat!\n\n" +
                           "CONNECT WITH US");
        footerText.setLineWrap(true);
        footerText.setWrapStyleWord(true);
        footerText.setEditable(false);
        panel.add(footerText);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            demo frame = new demo();
            frame.setVisible(true);
        });
    }
}
