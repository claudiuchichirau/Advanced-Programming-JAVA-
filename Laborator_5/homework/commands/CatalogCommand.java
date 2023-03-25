package org.example.homework.commands;

import org.example.homework.catalog.Catalog;

public abstract class CatalogCommand implements Command {
    protected Catalog catalog;

    public CatalogCommand(Catalog catalog) {
        this.catalog = catalog;
    }
}
