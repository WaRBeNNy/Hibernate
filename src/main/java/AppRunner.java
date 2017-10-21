import view.JDBCView;

import java.sql.SQLException;

public class AppRunner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCView view = new JDBCView();
        view.start();
    }
}
