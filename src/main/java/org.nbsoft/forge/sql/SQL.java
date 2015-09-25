package org.nbsoft.forge.sql;

import org.nbsoft.forge.sql.builders.SelectQueryBuilder;
import org.nbsoft.forge.sql.syntax.From;

public class SQL {

    public static From select(String select) {
        return new SelectQueryBuilder().select(select);
    }

}
