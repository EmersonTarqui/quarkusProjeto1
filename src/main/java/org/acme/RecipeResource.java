package org.acme;

import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/recipes")
public class RecipeResource {

    @GET
    public Response getAll() {
        return Response.ok(Book.listAll()).build();
    }

    @GET
    @Path("{id}")
    public  Response getById (@PathParam("id") int id) {
        Recipe entity = Recipe.findById(id);
        if (entity == null)
            return Response.status(404).build();
        return Response.ok(entity).build();
    }

    @GET
    @Path("/search")
    public Response search(
            @QueryParam("q") String q,
            @QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("direction") @DefaultValue("asc") String direction,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {
        Set<String> allowed = Set.of("id", "nome", "categoria", "ingredientes", "instrucoes","origem");
        if (!allowed.contains(sort))
            sort = "id";

        Sort sortObj = Sort.by(
                sort,
                "desc".equalsIgnoreCase(direction) ? Sort.Direction.Descending : Sort.Direction.Ascending
        );

        int effectivePage = page <= 1 ? 0 : page -1;

        var query = (q == null || q.isBlank()
                ? Recipe.findAll(sortObj)
                : Recipe.find("lower(nome) like ?1 or lower(categoria) like ?1",
                sortObj,
                "%" + q.toLowerCase() + "%"));

        var recipes = query.page(effectivePage, size).list();
        return Response.ok(recipes).build();
    }

    @POST
    @Transactional
    public Response insert(Recipe recipe) {
        Book.persist(recipe );
        return Response.status(201).entity(recipe).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {

        Recipe entity = Recipe.findById(id);
        if (entity == null)
            return Response.status(404).build();

        Recipe.deleteById(id);
        return Response.noContent().build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response update(@PathParam("id") int id, Recipe newRecipe) {
        Recipe entity = Recipe.findById(id);
        if (entity == null)
            return Response.status(404).build();

        entity = newRecipe;
        entity.nome = newRecipe.nome;
        entity.categoria = newRecipe.categoria;
        entity.ingredientes = newRecipe.ingredientes;
        entity.instrucoes = newRecipe.instrucoes;
        entity.origem = newRecipe.origem;

        return Response.status(200).entity(entity).build();
    }
}
