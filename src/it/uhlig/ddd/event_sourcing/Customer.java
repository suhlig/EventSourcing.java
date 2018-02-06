package it.uhlig.ddd.event_sourcing;

import java.util.Date;

public class Customer
{
  private boolean _locked = false;

  public boolean isLocked()
  {
    return _locked;
  }

  void when(CustomerCreatedEvent event)
  {
    Date value = event.getValue();
    System.out.println("Customer " + event.getCustomerID() + " was created at " + value);
  }

  void when(CustomerLockedEvent event)
  {
    Object value = event.getValue();
    System.out.println("Customer " + event.getCustomerID() + " was locked because of " + value + " unsuccessful login attempts");
    _locked = true;
  }

  void when(CustomerUnlockedEvent event)
  {
    String value = event.getValue();
    System.out.println("Customer " + event.getCustomerID() + " was unlocked because " + value);
    _locked = false;
  }
}