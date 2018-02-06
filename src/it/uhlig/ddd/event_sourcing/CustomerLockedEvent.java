package it.uhlig.ddd.event_sourcing;

public class CustomerLockedEvent extends CustomerEvent<Object>
{
  public CustomerLockedEvent(Identity<Customer> id, Object value)
  {
    super(id, value);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}
