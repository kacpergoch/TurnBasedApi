package org.example.api;

import org.example.model.units.Unit;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class UnitService {
    public Unit getUnitInstance(String name) throws NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class<Unit> unitClass = (Class<Unit>) Class.forName("org.example.units." + name);
        return unitClass.getDeclaredConstructor().newInstance();
    }
}
