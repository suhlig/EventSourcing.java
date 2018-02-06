package it.uhlig.ddd.event_sourcing;

public class CustomerUnlockedEvent extends CustomerEvent<String>
{
  public CustomerUnlockedEvent(Identity<Customer> id, String string)
  {
    super(id, string);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}