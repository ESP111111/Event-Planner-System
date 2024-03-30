
package newpackage;

public class Event
{
    public int id;
    public int organizer_id;
    public int event_category_id;
    public String name;
    public String event_date;
    public String event_time;
    public String description;
    public int no_vesitors;
    public float price_per_visitor;
    public int no_meals;
    public float meal_price;
    public int no_drinks;
    public float drink_price;
    
    public Event()
    {
      id = -1;
    organizer_id = -1;
    event_category_id = -1;
    name = null;
    event_date = null;
    event_time = null;
    description = null;
    no_vesitors = 0;
    price_per_visitor = 0;
    no_meals = 0;
    meal_price = 0;
    no_drinks = 0;
    drink_price = 0;
    }
}
