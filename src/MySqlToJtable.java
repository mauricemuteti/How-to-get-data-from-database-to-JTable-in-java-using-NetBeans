/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://mauricemuteti.info/how-to-get-data-from-database-to-jtable-in-java-using-netbeans/
 * How to get data from database to JTable in java using NetBeans
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class MySqlToJtable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
    // Connect to the database
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test", "root", "");

        // Create a SQL query
        String query = "SELECT * FROM users";

        // Execute the query and retrieve the results
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();

        // Add the columns to the model
        model.addColumn("Column 1");
        model.addColumn("Column 2");
        model.addColumn("Column 3");

        // Add the rows to the model
        while (rs.next()) {
            String col1 = rs.getString("column1");
            String col2 = rs.getString("column2");
            String col3 = rs.getString("column3");
            model.addRow(new Object[] { col1, col2, col3 });
        }

        // Create a JTable and set the model
        JTable table = new JTable();

        table.setModel(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the content pane
        JFrame frame = new JFrame();
        frame.setSize(700, 600);

        frame.add(scrollPane);
        frame.setVisible(true);
    }}