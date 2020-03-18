package Decorator.example;

import javax.swing.table.TableModel;

public abstract class TableSortDecorator extends 
                                         TableModelDecorator {
   // Extensions of Decorator.example.TableSortDecorator must implement the
   // abstract sort method, in addition to tableChanged. The
   // latter is required because Decorator.example.TableModelDecorator
   // implements the TableModelListener interface.
   abstract public void sort(int column);

   public TableSortDecorator(TableModel realModel) {
      super(realModel);
   }
}
