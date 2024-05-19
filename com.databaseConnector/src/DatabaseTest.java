import java.util.*;
import java.sql.*;

public class DatabaseTest {

    public static void main(String[] args) {
        DatabaseConnector con = new DatabaseConnector("",0,"einkaufsdb.db","","");
        con.executeStatement("select produkt, menge,kk,mm from einkaufsliste;");
        QueryResult res = con.getCurrentQueryResult();
        System.out.println(res);
        if (res != null) {
            String[][] data = res.getData();
            for (int i = 0; i < res.getRowCount(); i++) {
                for(int j=0; j< res.getColumnCount();j++){
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();

            }
        }
        con.close();
    }

}
