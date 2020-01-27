/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.SessionFactory;

/**
 *
 * @author TUF FX504
 */
public class DBConnection {
    private Connection connection;

    public Connection getConnection() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setUser("system");
            ods.setServiceName("XE");
            ods.setPassword("makankuy");
            this.connection = ods.getConnection();
            connection.setSchema("HR");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

 
}
