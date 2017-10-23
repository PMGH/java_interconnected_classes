import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest{

  Bus bus;
  Person person;

  @Before
  public void before(){
    person = new Person("Peter McCready");
    bus = new Bus("119", 30);
  }

  @Test
  public void hasName(){
    assertEquals("119", bus.getName());
  }

  @Test
  public void hasSeats(){
    assertEquals(30, bus.getSeats());
  }

  @Test
  public void getNumberOfPassengers(){
    assertEquals(0, bus.getNumberOfPassengers());
  }

  @Test
  public void isBusFull(){
    assertEquals(false, bus.isBusFull());
  }

  @Test
  public void canAddPassenger(){
    bus.addPassenger(person);

    assertEquals(1, bus.getNumberOfPassengers());
  }

  @Test
  public void busIsFull(){
    for (int i = 0; i < bus.getSeats(); i++){
      person = new Person("Peter McCready");
      bus.addPassenger(person);
    }

    assertEquals(true, bus.isBusFull());
  }

  @Test
  public void busHasSpace(){
    for (int i = 0; i < bus.getSeats()-1; i++){
      person = new Person("Peter McCready");
      bus.addPassenger(person);
    }

    assertEquals(false, bus.isBusFull());
  }

  @Test
  public void canEmptyBus(){
    for (int i = 0; i < bus.getSeats(); i++){
      person = new Person("Peter McCready");
      bus.addPassenger(person);
    }
    bus.emptyBus();

    assertEquals(0, bus.getNumberOfPassengers());
  }

  @Test
  public void removeFromBus(){
    bus.addPassenger(person);
    bus.removePassenger(person);

    assertEquals(0, bus.getNumberOfPassengers());
  }

}
