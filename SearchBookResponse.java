package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.ArrayList;
import java.util.List;

public class SearchBookResponse {
    public List<PanacheEntityBase> Books = new ArrayList<>();

    public int TotalBooks;
    public int TotalPages;
    public Boolean HasMore;
    public String NextPage;

}
