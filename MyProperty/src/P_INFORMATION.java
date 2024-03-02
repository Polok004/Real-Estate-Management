import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class P_INFORMATION {

    private JTextArea resultTextArea;
    private JPanel buttonPanel;
    private JLabel imageLabel; // Added JLabel for displaying the image
    private JsonObject mainObject; // Declare mainObject as a class field
    private JsonArray dataArray; // Declare dataArray as a class field

    public P_INFORMATION(JTextArea resultTextArea, JPanel buttonPanel) {
        this.resultTextArea = resultTextArea;
        this.buttonPanel = buttonPanel;
        this.imageLabel = new JLabel(); // Initialize the JLabel for the image
    }

    public void fetchData(String response) {
      //  System.out.println("Response: " + response);

        try {
            jsonParse(response);
        } catch (Exception e) {
            e.printStackTrace();
            resultTextArea.setText("Error parsing JSON. Check console for details.");
        }
    }

    public void jsonParse(String response) {
        resultTextArea.setText("\n\n\n\n\n\tWelcome to Real Estate Information!\n\n");

        mainObject = JsonParser.parseString(response).getAsJsonObject();
        JsonElement dataElement = mainObject.getAsJsonObject("data").get("Data");

        if (dataElement != null && dataElement.isJsonArray()) {
            dataArray = dataElement.getAsJsonArray();

            buttonPanel.removeAll();

            for (JsonElement element : dataArray) {
                if (element.isJsonObject()) {
                    JsonObject section = element.getAsJsonObject();

                    JsonElement nameElement = section.get("name");
                    if (nameElement != null && nameElement.isJsonPrimitive()) {
                        String name = nameElement.getAsString();
                      //  System.out.println("Processing section with name: " + name);

                        JButton nameButton = new JButton(name);
                         nameButton.setFont(new Font(nameButton.getFont().getName(), Font.PLAIN, 16));
                        nameButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                displayDetails(section);
                            }
                        });

                        buttonPanel.add(nameButton);
                    } else {
                      //  System.out.println("Section is missing the 'name' field. Skipping...");
                       // System.out.println("Section content: " + section);
                    }
                }
            }
        } else {
          //  System.out.println("'Data' array is missing or not an array. Skipping...");
           // System.out.println("Data content: " + dataElement);
        }

        // Increase the font size of the resultTextArea
        resultTextArea.setFont(new Font(resultTextArea.getFont().getName(), Font.PLAIN, 50));
      //  nameButton.setFont(new Font(nameButton.getFont().getName(), Font.PLAIN, 16));

        // Set the background color of the buttonPanel
        buttonPanel.setBackground(new Color(100, 100, 100)); // Customize the color as needed

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void displayDetails(JsonObject section) {
        String name = section.get("name").getAsString();
        JsonArray precautionsArray = section.getAsJsonArray("Precautions");
        String information = section.get("Information").getAsString();
        String description = section.get("Description").getAsString();
        String imgUrl = section.get("img").getAsString();

        JPanel detailsPanel = new JPanel();
        detailsPanel.setPreferredSize(new Dimension(300, 400));

        // Create and set image label
        ImageIcon imageIcon = createImageIcon(imgUrl);
        if (imageIcon != null) {
            imageLabel.setIcon(imageIcon);
            detailsPanel.add(imageLabel);
        } else {
          //  System.err.println("Error loading image: " + imgUrl);
        }

        // Display name in the text area with increased font size
        resultTextArea.setText(String.format("Name: %s\n\n", name));
        resultTextArea.setFont(new Font(resultTextArea.getFont().getName(), Font.PLAIN, 18));

        // Display precautions
        resultTextArea.append("Precautions:\n");
        for (int i = 0; i < precautionsArray.size(); i++) {
            resultTextArea.append(String.format("- %s\n", precautionsArray.get(i).getAsString()));
        }

        // Make the precautions text bold
        Font boldFont = new Font(resultTextArea.getFont().getFamily(), Font.BOLD, resultTextArea.getFont().getSize());
        resultTextArea.setFont(boldFont);
         detailsPanel.setBackground(Color.red); // Sky Blue color
          buttonPanel.setBackground(new Color(100, 100, 100)); // Customize the color as needed
        // Display information and description
        resultTextArea.append(String.format("\nInformation:\n%s\n", information));
        resultTextArea.append(String.format("\nDescription:\n%s\n", description));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 60, 0));

        // Add details panel to the buttonPanel
        buttonPanel.removeAll();
        buttonPanel.add(detailsPanel);

        // Create a new panel for name buttons
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());

        // Iterate through dataArray and add each name button to the name panel
        for (JsonElement element : dataArray) {
            if (element.isJsonObject()) {
                JsonObject sectionObj = element.getAsJsonObject();
                JsonElement nameElement = sectionObj.get("name");
                if (nameElement != null && nameElement.isJsonPrimitive()) {
                    String sectionName = nameElement.getAsString();
                    JButton nameButton = new JButton(sectionName);
                    nameButton.setFont(new Font(nameButton.getFont().getName(), Font.PLAIN, 16));
                    nameButton.setBackground(new Color(100, 100, 100));
                    nameButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            displayDetails(sectionObj);
                        }
                    });
                    namePanel.add(nameButton);
                }
            }
        }

        // Add name panel to the buttonPanel
        buttonPanel.add(namePanel);

        // Set layout for buttonPanel
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Repaint the panel
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private ImageIcon createImageIcon(String imgUrl) {
        try {
            URL url = new URL(imgUrl);
            Image image = new ImageIcon(url).getImage();
            Image scaledImage = image.getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
