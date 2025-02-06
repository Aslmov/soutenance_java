
package soutenance_java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pizza_connect {
    static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
    
    public static void main(String[] args) {
        System.out.println("*** Récupération des données de la base MySQL ***");
        System.out.println("Connexion à MySQL pizzaboxinnodb");
        
        String url = "jdbc:mysql://localhost/pizzaboxinnodb";
        String login = "root";
        String passwd = "";
        
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            
            String sql = """
                SELECT p.DESIGNPIZZ, i.NOMINGR, c.QTECOMP, i.UNITEINGR
                FROM pizza p
                JOIN composer c ON p.NROPIZZ = c.NROPIZZ
                JOIN ingredient i ON c.CODEINGR = i.CODEINGR
                ORDER BY p.DESIGNPIZZ, i.NOMINGR
            """;
            
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Pizza p = new Pizza(
                    rs.getString("DESIGNPIZZ"),
                    rs.getString("NOMINGR"),
                    rs.getInt("QTECOMP"),
                    rs.getString("UNITEINGR")
                );
                pizzaList.add(p);
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("*** Liste des pizzas et leurs ingrédients ***");
        String currentPizza = "";
        for (Pizza pizza : pizzaList) {
            if (!pizza.nomPizza.equals(currentPizza)) {
                System.out.println("\n" + pizza.nomPizza + " :");
                currentPizza = pizza.nomPizza;
            }
            System.out.printf("  - %d %s de %s%n", 
                pizza.quantiteIngredient,
                pizza.uniteIngredient,
                pizza.nomIngredient);
        }
    }
}