package com.rentathing.ui.product.creation;

import com.rentathing.factories.IProductFactory;
import com.rentathing.utils.session.EmployeeSessionAware;
import javafx.fxml.Initializable;

public abstract class ProductCreationController implements EmployeeSessionAware, Initializable {

    protected IProductFactory productFactory;
    protected abstract void addProduct();
    public abstract void setProductFactory(IProductFactory productFactory);
}
