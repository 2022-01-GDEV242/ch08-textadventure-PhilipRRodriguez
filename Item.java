
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemDescription;
    private int weight;
    

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemDescription, int weight)
    {
        this.itemDescription = itemDescription;
        this.weight = weight;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getShortDescription()
    {
        String shortDescription = "Item Description:\n" + this.itemDescription + "\n" + "Item Weight:\n" + this.weight + "\n";
        return shortDescription;
    }
}
