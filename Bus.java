public class Bus{

  // instance variables
  private String name;
  private int seats;
  private Person[] passengers;


  // initialize
  public Bus(String name, int seats){
    this.name = name;
    this.seats = seats;
    this.passengers = new Person[seats];
  }

  // getters
  public String getName(){
    return this.name;
  }

  public int getSeats(){
    return this.seats;
  }

  public int getNumberOfPassengers(){
    int count = 0;

    for (int i = 0; i < this.passengers.length; i++){
      if (passengers[i] != null){
        count++;
      }
    }

    return count;
  }

  // setters


  // other behaviour
  public boolean isBusFull(){
    return getNumberOfPassengers() == this.seats;
  }

  public void addPassenger(Person passenger){
    if (!isBusFull()){
      int passengerCount = getNumberOfPassengers();
      this.passengers[passengerCount] = passenger;
    }
  }

  public void emptyBus(){
    for (int i = 0; i < this.seats; i++){
      this.passengers[i] = null;
    }
  }

  public void removePassenger(Person person){
    for (int i = 0; i < this.passengers.length; i++){
      if (passengers[i] == person){
        passengers[i] = null;
      }
    }
  }

}
