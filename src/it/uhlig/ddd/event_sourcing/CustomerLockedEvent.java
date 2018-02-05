package it.uhlig.ddd.event_sourcing;

public class CustomerLockedEvent extends Event<Object>
{
  public CustomerLockedEvent(Object value)
  {
    super(value);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}
