package it.uhlig.ddd.event_sourcing;

import java.util.Date;

public class Customer
{
  private boolean _locked = false;

  public boolean isLocked()
  {
    return _locked;
  }

  void when(CustomerCreatedEvent f)
  {
    Date value = f.getValue();
    System.out.println("Customer was created at " + value);
  }

  void when(CustomerLockedEvent f)
  {
    Object value = f.getValue();
    System.out.println("Customer was locked because of " + value + " unsuccessful login attempts");
    _locked = true;
  }

  void when(CustomerUnlockedEvent f)
  {
    String value = f.getValue();
    System.out.println("Customer was unlocked because " + value);
    _locked = false;
  }
}