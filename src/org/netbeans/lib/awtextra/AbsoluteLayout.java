package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class AbsoluteLayout
  implements LayoutManager2, Serializable
{
  static final long serialVersionUID = -1919857869177070440L;
  protected Hashtable constraints = new Hashtable();

  public void addLayoutComponent(String paramString, Component paramComponent)
  {
    throw new IllegalArgumentException();
  }

  public void removeLayoutComponent(Component paramComponent)
  {
    this.constraints.remove(paramComponent);
  }

  public Dimension preferredLayoutSize(Container paramContainer)
  {
    int i = 0;
    int j = 0;
    Enumeration localEnumeration = this.constraints.keys();
    while (localEnumeration.hasMoreElements())
    {
      Component localComponent = (Component)localEnumeration.nextElement();
      AbsoluteConstraints localAbsoluteConstraints = (AbsoluteConstraints)this.constraints.get(localComponent);
      Dimension localDimension = localComponent.getPreferredSize();
      int k = localAbsoluteConstraints.getWidth();
      if (k == -1)
        k = localDimension.width;
      int l = localAbsoluteConstraints.getHeight();
      if (l == -1)
        l = localDimension.height;
      if (localAbsoluteConstraints.x + k > i)
        i = localAbsoluteConstraints.x + k;
      if (localAbsoluteConstraints.y + l > j)
        j = localAbsoluteConstraints.y + l;
    }
    return new Dimension(i, j);
  }

  public Dimension minimumLayoutSize(Container paramContainer)
  {
    int i = 0;
    int j = 0;
    Enumeration localEnumeration = this.constraints.keys();
    while (localEnumeration.hasMoreElements())
    {
      Component localComponent = (Component)localEnumeration.nextElement();
      AbsoluteConstraints localAbsoluteConstraints = (AbsoluteConstraints)this.constraints.get(localComponent);
      Dimension localDimension = localComponent.getMinimumSize();
      int k = localAbsoluteConstraints.getWidth();
      if (k == -1)
        k = localDimension.width;
      int l = localAbsoluteConstraints.getHeight();
      if (l == -1)
        l = localDimension.height;
      if (localAbsoluteConstraints.x + k > i)
        i = localAbsoluteConstraints.x + k;
      if (localAbsoluteConstraints.y + l > j)
        j = localAbsoluteConstraints.y + l;
    }
    return new Dimension(i, j);
  }

  public void layoutContainer(Container paramContainer)
  {
    Enumeration localEnumeration = this.constraints.keys();
    while (localEnumeration.hasMoreElements())
    {
      Component localComponent = (Component)localEnumeration.nextElement();
      AbsoluteConstraints localAbsoluteConstraints = (AbsoluteConstraints)this.constraints.get(localComponent);
      Dimension localDimension = localComponent.getPreferredSize();
      int i = localAbsoluteConstraints.getWidth();
      if (i == -1)
        i = localDimension.width;
      int j = localAbsoluteConstraints.getHeight();
      if (j == -1)
        j = localDimension.height;
      localComponent.setBounds(localAbsoluteConstraints.x, localAbsoluteConstraints.y, i, j);
    }
  }

  public void addLayoutComponent(Component paramComponent, Object paramObject)
  {
    if (!(paramObject instanceof AbsoluteConstraints))
      throw new IllegalArgumentException();
    this.constraints.put(paramComponent, paramObject);
  }

  public Dimension maximumLayoutSize(Container paramContainer)
  {
    return new Dimension(2147483647, 2147483647);
  }

  public float getLayoutAlignmentX(Container paramContainer)
  {
    return 0.0F;
  }

  public float getLayoutAlignmentY(Container paramContainer)
  {
    return 0.0F;
  }

  public void invalidateLayout(Container paramContainer)
  {
  }
}