import static org.junit.Assert.assertEquals;
import org.junit.*;

public class PersonTest{

  Person person;

  @Before
  public void before(){
    person = new Person("Peter McCready");
  }

  @Test
  public void hasName(){
    assertEquals("Peter McCready", person.getName());
  }

}
