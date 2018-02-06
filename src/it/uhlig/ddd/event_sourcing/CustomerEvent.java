package it.uhlig.ddd.event_sourcing;

public abstract class CustomerEvent<T>
{
  private T _value;
  private final Identity<Customer> _id;

  public CustomerEvent(Identity<Customer> id, T value)
  {
    _value = value;
    _id = id;
  }

  public abstract void dispatch(Customer customer);

  public Identity<Customer> getCustomerID()
  {
    return _id;
  }

  public T getValue()
  {
    return _value;
  }
}