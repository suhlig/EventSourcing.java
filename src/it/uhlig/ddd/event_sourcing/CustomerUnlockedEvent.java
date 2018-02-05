package it.uhlig.ddd.event_sourcing;

public class CustomerUnlockedEvent extends Event<String>
{
  public CustomerUnlockedEvent(String string)
  {
    super(string);
  }

  @Override
  public void dispatch(Customer v)
  {
    v.when(this);
  }
}