package Decorator.example;

import javax.swing.table.TableModel;

public abstract class TableFilterDecorator extends 
                                         TableModelDecorator {
   // Extensions of Decorator.example.TableSortDecorator must implement the
   // abstract sort method, in addition to tableChanged. The
   // latter is required because Decorator.example.TableModelDecorator
   // implements the TableModelListener interface.
   abstract public void filter();

   public TableFilterDecorator(TableModel realModel) {
      super(realModel);
   }
}
