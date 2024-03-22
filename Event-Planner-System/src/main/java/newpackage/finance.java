
package newpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;

public class finance
{
  
   public void event_report(int event_id)
    {
        String query= "select \n" +
                "event_info.no_visitor ,\n" +
                "event_info.price_per_person,\n" +
                "CAST(no_visitor AS DECIMAL(10,2)) * CAST(price_per_person AS DECIMAL(10,2)) as \"Total visitors price \",\n" +
                "event_info.no_meals,\n" +
                "event_info.meal_price,\n" +
                "CAST(no_meals AS DECIMAL(10,2)) * CAST(meal_price AS DECIMAL(10,2)) as \"Total meals price \",\n" +
                "event_info.no_drinks,\n" +
                "event_info.drink_price,\n" +
                "CAST(no_drinks AS DECIMAL(10,2)) * CAST(drink_price AS DECIMAL(10,2)) as \"Total drinks price \",\n" +
                "\n" +
                " TIMESTAMPDIFF(\n" +
                "        HOUR,\n" +
                "        CONCAT(CAST(start_date AS CHAR), ' ', CAST(start_time AS CHAR)),\n" +
                "        CONCAT(CAST(end_date AS CHAR), ' ', CAST(end_time AS CHAR))\n" +
                "    ) as number_of_hours,\n" +
                "place.Price_per_hour ,\n" +
                "CAST(Price_per_hour AS DECIMAL(10,2)) * CAST( TIMESTAMPDIFF(\n" +
                "        HOUR,\n" +
                "        CONCAT(CAST(start_date AS CHAR), ' ', CAST(start_time AS CHAR)),\n" +
                "        CONCAT(CAST(end_date AS CHAR), ' ', CAST(end_time AS CHAR))\n" +
                "    ) AS DECIMAL(10,2)) as \"Total place price \"\n" +
                "from event_info \n" +
                "left join event_place_order on event_place_order.event_info_id = event_info.id\n" +
                "left join place on place.id = event_place_order.place_id\n" +
                "where event_info.id = "+event_id+";";
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
  
           
            while (rs.next()) {
                int no_persons = rs.getInt(1);
                float person_price = rs.getFloat(2);
                float persons_total = rs.getFloat(3);
                int no_meal = rs.getInt(4);
                float meal_price = rs.getFloat(5);
                float meals_total = rs.getFloat(6);
                int no_drinks = rs.getInt(7);
                float drink_price = rs.getFloat(8);
                float drinks_total = rs.getFloat(9);
                int no_hours = rs.getInt(10);
                float hour_price = rs.getFloat(11);
                float hours_total = rs.getFloat(12);
                
                float Earned_money = persons_total + meals_total + drinks_total ;
                float Lost_money = hours_total;
                float total = Earned_money - Lost_money;
                
            // Create an HTML table for the finance report
          String reportHtml = "<html><body style='font-family: Arial, sans-serif;'>"
            + "<h1 style='text-align: center; color: blue;'>Finance Report</h1>"
            + "<table style='width: 100%; border-collapse: collapse;'>"
            + "<tr><th style='border: 1px solid black;'>Type</th><th style='border: 1px solid black;'>Count</th><th style='border: 1px solid black;'>Price/item</th><th style='border: 1px solid black;'>Total</th></tr>"
            + "<tr style='color: green;'><td style='border: 1px solid black;'>Tickets</td><td style='border: 1px solid black;'>" + no_persons + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", person_price) + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", persons_total) + "</td></tr>"
            + "<tr style='color: green;'><td style='border: 1px solid black;'>Meals</td><td style='border: 1px solid black;'>" + no_meal + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", meal_price) + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", meals_total) + "</td></tr>"
            + "<tr style='color: green;'><td style='border: 1px solid black;'>Drinks</td><td style='border: 1px solid black;'>" + no_drinks + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", drink_price) + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", drinks_total) + "</td></tr>"
            + "<tr style='color: green; font-weight: bold;'><td colspan='3' style='border: 1px solid black;'>Total Earned Money</td><td style='border: 1px solid black;'>" + String.format("%.2f", Earned_money) + "</td></tr>"
            + "<tr style='color: red;'><td style='border: 1px solid black;'>Place</td><td style='border: 1px solid black;'>" + no_hours + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", hour_price) + "</td><td style='border: 1px solid black;'>" + String.format("%.2f", hours_total) + "</td></tr>"
            + "<tr style='color: red; font-weight: bold;'><td colspan='3' style='border: 1px solid black;'>Total Lost Money</td><td style='border: 1px solid black;'>" + String.format("%.2f", Lost_money) + "</td></tr>"
            + "<tr style='color: " + (total >= 0 ? "green" : "red") + "; font-weight: bold;'><td colspan='3' style='border: 1px solid black;'>Your Total Money</td><td style='border: 1px solid black;'>" + String.format("%.2f", total) + "</td></tr>"
            + "</table></body></html>";

       JLabel reportLabel = new JLabel(reportHtml);
        reportLabel.setPreferredSize(new Dimension(280, 300)); // Set the preferred size
        
        // ScrollPane for larger content
        JScrollPane scrollPane = new JScrollPane(reportLabel);
        scrollPane.setPreferredSize(new Dimension(280, 300));

        // OptionPane configuration
        JOptionPane optionPane = new JOptionPane(scrollPane, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        
        // Display in a dialog
        JDialog dialog = optionPane.createDialog(null, "Finance Report");
        dialog.setVisible(true);

        // After the dialog is closed, save the content to an image
        BufferedImage image = new BufferedImage(scrollPane.getViewport().getWidth(), 
                                                scrollPane.getViewport().getHeight(), 
                                                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        scrollPane.getViewport().printAll(g2d);
        g2d.dispose();

        try {
            // Save as PNG
            ImageIO.write(image, "png", new File("FinanceReport.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
   
   
                
                
                
                
                
//                JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        // Create JLabels with different colors
//        JLabel label1 = new JLabel("Type    |Count|Price/item||Total");
//        label1.setForeground(Color.black);
//        panel.add(label1);
//        JLabel label2 = new JLabel("Tickets| " + no_persons + " | " + preson_price + " || " + presons_total);
//        JLabel label3 = new JLabel("Meals  | " + no_meal + " | " + meal_price + " || " + meals_total);
//        JLabel label4 = new JLabel("Drinks | " + no_drinks + " | " + drink_price + " || " + drinks_total);
//        JLabel label5 = new JLabel("--------------------------");
//        JLabel label6 = new JLabel(" Total Earned money : " +Earned_money);
//        JLabel label7 = new JLabel("--------------------------");
//        
//        JLabel label8 = new JLabel("Place  | " + no_hours + " | " + hour_price + " || " + hours_total);
//        JLabel label9 = new JLabel("--------------------------");
//        JLabel labe20 = new JLabel("Total Lost mony : " +Lost_mony);
//        JLabel labe21 = new JLabel("--------------------------");
//        JLabel labe22 = new JLabel("Your Total Mony : " +total);
//
//        label2.setForeground(Color.green);
//        label3.setForeground(Color.green);
//        label4.setForeground(Color.green);
//        label5.setForeground(Color.green);
//        label6.setForeground(Color.green);
//        panel.add(label2);
//        panel.add(label3);
//        panel.add(label4);
//        panel.add(label5);
//        panel.add(label6);
//        label7.setForeground(Color.red);
//        label8.setForeground(Color.red);
//        label9.setForeground(Color.red);
//        labe20.setForeground(Color.red);
//        labe21.setForeground(Color.red);        
//        panel.add(label7);
//        panel.add(label8);
//        panel.add(label9);
//        panel.add(labe20); 
//        panel.add(labe21);
//        if(total >0)
//        {
//          labe22.setForeground(Color.green);   
//        }
//        else if(total <0)
//        {
//            labe22.setForeground(Color.red);   
//        }
//        else 
//        {
//            labe22.setForeground(Color.black);   
//        }
//        panel.add(labe22);
//
//        // Show JOptionPane with the custom panel
//        JOptionPane.showMessageDialog(null, panel);
//

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
