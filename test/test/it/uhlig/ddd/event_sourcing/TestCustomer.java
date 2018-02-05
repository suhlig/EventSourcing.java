package test.it.uhlig.ddd.event_sourcing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import it.uhlig.ddd.event_sourcing.Customer;
import it.uhlig.ddd.event_sourcing.CustomerCreatedEvent;
import it.uhlig.ddd.event_sourcing.CustomerLockedEvent;
import it.uhlig.ddd.event_sourcing.CustomerUnlockedEvent;
import it.uhlig.ddd.event_sourcing.Event;

// https://stackoverflow.com/a/47964119
public class TestCustomer
{
  @Test
  public void testLock()
  {
    // @formatter:off
    List<Event<? extends Object>> events = Arrays.asList(
        new CustomerCreatedEvent(new Date()),
        new CustomerLockedEvent(new AtomicInteger(100))
    );
    // @formatter:on

    Customer customer = new Customer();

    for (Event<? extends Object> event : events)
      event.dispatch(customer);

    assertTrue(customer.isLocked());
  }

  @Test
  public void testLockUnlock()
  {
    // @formatter:off
    List<Event<? extends Object>> events = Arrays.asList(
        new CustomerCreatedEvent(new Date()),
        new CustomerLockedEvent(new AtomicInteger(100)),
        new CustomerUnlockedEvent("we forgive him")
    );
    // @formatter:on

    Customer customer = new Customer();

    for (Event<? extends Object> event : events)
      event.dispatch(customer);

    assertFalse(customer.isLocked());
  }
}
