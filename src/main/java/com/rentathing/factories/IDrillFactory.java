package com.rentathing.factories;

import com.rentathing.products.Drill;

public interface IDrillFactory {
    Drill createDrill(String name, String brand, String type);
}
