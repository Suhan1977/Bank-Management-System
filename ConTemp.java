package bank.management.system;

import java.sql.*;

public class ConTemp {
    private Connection connection;
    private Statement statement;

//    use this url
//    "jdbc:mysql://localhost:3306/bankSystem", "root", "1234"


    public ConTemp() {
        try {
            connection = DriverManager.getConnection("url");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void close() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}