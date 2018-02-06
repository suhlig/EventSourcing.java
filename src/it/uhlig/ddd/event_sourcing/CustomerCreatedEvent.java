package it.uhlig.ddd.event_sourcing;

import java.util.Date;

public class CustomerCreatedEvent extends CustomerEvent<Date>
{
  public CustomerCreatedEvent(Identity<Customer> id, Date date)
  {
    super(id, date);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}