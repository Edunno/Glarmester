/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glarmester.data;

import glarmester.logic.FrameType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Esben
 */
public class DataAccessorDataBase implements DataAccessor {

    @Override
    public double getGlassprice() {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT `*` "
                    + "FROM `prices`"
                    + "WHERE name = 'Glass';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                return res.getInt("price");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return 0;
    }

    @Override
    public double getFramePrice(FrameType type) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String query
                    = "SELECT `*` "
                    + "FROM `prices`"
                    + "WHERE name = '" + type.name() + "';";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                 return res.getInt("price");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
        return 0;
    }
    
}
