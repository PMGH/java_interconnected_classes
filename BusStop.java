public class BusStop{

  // encapsulated instance variables
  private String name;
  private Person[] queue;

  // initialize
  public BusStop(String name){
    this.name = name;
    this.queue = new Person[5];
  }

  // getters

  public String getName(){
    return this.name;
  }

  public int getBusStopCapacity(){
    return this.queue.length;
  }

  public int getLengthOfQueue(){
    int count = 0;

    for (int i = 0; i < this.queue.length; i++){
      if (queue[i] != null){
        count++;
      }
    }

    return count;
  }

  public boolean isBusStopFull(){
    return getLengthOfQueue() == this.queue.length;
  }

  // setters


  // other behaviour

  public void addToQueue(Person person){
    if (!isBusStopFull()){
      int queueLength = getLengthOfQueue();
      this.queue[queueLength] = person;
    }
  }

  // Method superceeded, see next Method below
  // public void removePersonFromQueue(Person person){
  //   for (int i = 0; i < this.queue.length; i++){
  //     if (queue[i] == person){
  //       queue[i] = null;
  //     }
  //   }
  // }

  public void removePersonFromQueue(int position){
    if (queue[position] != null){
      queue[position] = null;
    }
  }

  public void removePersonFromQueueAndAddToBus(Bus bus){
    // check if people waiting at busStop
    if (this.getLengthOfQueue() > 0){
      // for each person in the queue
      for (int i = 0; i < this.queue.length; i++){
        // check if bus is full
        if (!bus.isBusFull()){
          // add to bus
          bus.addPassenger(queue[i]);
          // remove from queue
          this.removePersonFromQueue(i);
        }
      }
    }
  }

}
