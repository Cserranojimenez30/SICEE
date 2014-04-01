package Utilerias;

import java.sql.Connection;

/**
 * Constantes para el uso de diferentes bases de datos. La personalizacion de
 * properties y gestores debe configurarse aqui.
 *
 * @author aya
 */
public enum DataBase {

    SISA,
    ESCOLAR;

    public Connection getConnection() {
        switch (ordinal()) {
            case 0:
                return MySQL_Connection.getConnection("SISA");

            case 1:
                // return SQLServerConnection.getConnection("CE");
                return MySQL_Connection.getConnection("CEM");
        }

        return null;
    }

}
