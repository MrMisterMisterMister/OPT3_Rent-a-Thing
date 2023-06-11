package com.rentathing.ui.product.creation;

import com.rentathing.factories.IProductFactory;
import com.rentathing.utils.session.EmployeeSessionAware;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public abstract class ProductCreationController implements EmployeeSessionAware, Initializable {

    @FXML
    protected MFXTextField productNameTextField;
    protected IProductFactory productFactory;
    protected abstract void addProduct();
    public abstract void setProductFactory(IProductFactory productFactory);
}
