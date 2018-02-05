package it.uhlig.ddd.event_sourcing;

import java.util.Date;

public class CustomerCreatedEvent extends Event<Date>
{
  public CustomerCreatedEvent(Date date)
  {
    super(date);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}