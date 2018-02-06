package it.uhlig.ddd.event_sourcing;

public class Identity<T>
{
  private final String _identity;

  public Identity(String identifier)
  {
    _identity = identifier;
  }

  @Override
  public String toString()
  {
    return _identity;
  }
}
