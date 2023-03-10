package com.example.recapp.services.Impl;

import com.example.recapp.model.Ingredient;
import com.example.recapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipesIngredientServiceImpl
        implements IngredientService {
    private static final Map<Integer, Ingredient> ingredients = new LinkedHashMap<>();
    private int id = 1;

    @Override
    public void addIngredient(Ingredient ingredient) {
        if (!ingredients.containsValue(ingredient)) {
            ingredients.put(id++, ingredient);
        }
    }

    @Override
    public Ingredient getIngredient(int id) {
        return ingredients.get(id);
    }

    @Override
    public Collection<Ingredient> getAllIngredients() {
        return ingredients.values();
    }

    @Override
    public Ingredient editIngredient(int id, Ingredient ingredient) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        Ingredient ingredient = ingredients.remove(id);
        return ingredient != null;
    }
}
