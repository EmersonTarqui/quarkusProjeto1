package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeResponse {
    public List<PanacheEntityBase> Recipes = new ArrayList<>();

    public int TotalRecipes;
    public int TotalPages;
    public Boolean HasMore;
    public String NextPage;

}
