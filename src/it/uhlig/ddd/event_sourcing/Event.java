package it.uhlig.ddd.event_sourcing;

public abstract class Event<T>
{
  private T _value;

  public Event(T value)
  {
    _value = value;
  }

  public abstract void dispatch(Customer customer);

  public T getValue()
  {
    return _value;
  }
}