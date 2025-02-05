// Pizza.java
package soutenance_java;

public class Pizza {
    String nomPizza;
    String nomIngredient;
    Integer quantiteIngredient;
    String uniteIngredient;
    
    public Pizza(String nomPizza, String nomIngredient, Integer quantiteIngredient, String uniteIngredient) {
        this.nomPizza = nomPizza;
        this.nomIngredient = nomIngredient;
        this.quantiteIngredient = quantiteIngredient;
        this.uniteIngredient = uniteIngredient;
    }
    
    @Override
    public String toString() {
        return String.format("Pizza %s : %d %s de %s", 
            nomPizza,
            quantiteIngredient,
            uniteIngredient,
            nomIngredient);
    }
}
