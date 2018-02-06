package test.it.uhlig.ddd.event_sourcing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import it.uhlig.ddd.event_sourcing.Customer;
import it.uhlig.ddd.event_sourcing.CustomerCreatedEvent;
import it.uhlig.ddd.event_sourcing.CustomerEvent;
import it.uhlig.ddd.event_sourcing.CustomerLockedEvent;
import it.uhlig.ddd.event_sourcing.CustomerUnlockedEvent;
import it.uhlig.ddd.event_sourcing.Identity;

// https://stackoverflow.com/a/47964119
public class TestCustomer
{
  private Identity<Customer> _customer = new Identity<Customer>("Precious")
  {
  };

  private List<CustomerEvent<? extends Object>> _events = new ArrayList<CustomerEvent<? extends Object>>();

  @Test
  public void testLock()
  {
    Customer customer = new Customer();

    _events.add(new CustomerCreatedEvent(_customer, new Date()));
    _events.add(new CustomerLockedEvent(_customer, new AtomicInteger(100)));

    for (CustomerEvent<? extends Object> event : _events)
      event.dispatch(customer);

    assertTrue(customer.isLocked());
  }

  @Test
  public void testLockUnlock()
  {
    _events.add(new CustomerCreatedEvent(_customer, new Date()));
    _events.add(new CustomerLockedEvent(_customer, new AtomicInteger(100)));
    _events.add(new CustomerUnlockedEvent(_customer, "we forgive her"));

    Customer customer = new Customer();

    for (CustomerEvent<? extends Object> event : _events)
      event.dispatch(customer);

    assertFalse(customer.isLocked());
  }
}
