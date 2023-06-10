package com.rentathing.factories;

import com.rentathing.products.Drill;

public class DrillFactory implements IDrillFactory {
    @Override
    public Drill createDrill(String name, String brand, String type) {
        return new Drill(name, brand, type);
    }
}
