package org.example.api;

import org.example.units.Unit;

import java.lang.reflect.InvocationTargetException;

public class UnitService {
    public Unit getInstanceByName(String name) throws NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class<Unit> unitClass = (Class<Unit>) Class.forName("org.example.units." + name);
        return unitClass.getDeclaredConstructor().newInstance();
    }
}
