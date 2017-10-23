import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusStopTest{

  BusStop busStop;
  Bus bus;
  Person person;

  @Before
  public void before(){
    busStop = new BusStop("Trongate");
    bus = new Bus("119", 30);
    person = new Person("Peter McCready");
  }

  @Test
  public void hasName(){
    assertEquals("Trongate", busStop.getName());
  }

  @Test
  public void getBusStopCapacity(){
    assertEquals(5, busStop.getBusStopCapacity());
  }

  @Test
  public void getLengthOfQueue(){
    assertEquals(0, busStop.getLengthOfQueue());
  }

  @Test
  public void busStopIsFull(){
    assertEquals(false, busStop.isBusStopFull());
  }

  @Test
  public void canAddToQueue(){
    busStop.addToQueue(person);

    assertEquals(1, busStop.getLengthOfQueue());
  }

  @Test
  public void busStopIsNotFull(){
    for (int i = 0; i < busStop.getBusStopCapacity(); i++){
      busStop.addToQueue(person);
    }

    assertEquals(true, busStop.isBusStopFull());
  }

  // Test superceeded, see next Test below
  // @Test
  // public void canRemovePersonFromQueue(){
  //   busStop.addToQueue(person);
  //   busStop.removePersonFromQueue(person);
  //
  //   assertEquals(0, busStop.getLengthOfQueue());
  // }

  @Test
  public void canRemovePersonFromQueue(){
    busStop.addToQueue(person);
    assertEquals(1, busStop.getLengthOfQueue());

    busStop.removePersonFromQueue(0);
    assertEquals(0, busStop.getLengthOfQueue());
  }

  @Test
  public void canRemovePersonFromBusStopAndAddToBus(){
    busStop.addToQueue(person);

    assertEquals(0, bus.getNumberOfPassengers());
    assertEquals(1, busStop.getLengthOfQueue());

    busStop.removePersonFromQueue(0);
    bus.addPassenger(person);

    assertEquals(0, busStop.getLengthOfQueue());

    assertEquals(1, bus.getNumberOfPassengers());
  }

  @Test
  public void removePersonFromQueueAndAddToBus(){
    for (int i = 0; i < 5; i++){
      busStop.addToQueue(person);
    }

    assertEquals(5, busStop.getLengthOfQueue());
    assertEquals(0, bus.getNumberOfPassengers());

    busStop.removePersonFromQueueAndAddToBus(bus);

    assertEquals(0, busStop.getLengthOfQueue());
    assertEquals(5, bus.getNumberOfPassengers());
  }

  @Test
  public void cannotAddMorePersonsThanSpacesToBus(){
    Bus bus2 = new Bus("211", 4);

    for (int i = 0; i < 5; i++){
      busStop.addToQueue(person);
    }

    assertEquals(5, busStop.getLengthOfQueue());
    assertEquals(0, bus2.getNumberOfPassengers());

    busStop.removePersonFromQueueAndAddToBus(bus2);

    assertEquals(4, bus2.getNumberOfPassengers());
    assertEquals(1, busStop.getLengthOfQueue());
  }

}
