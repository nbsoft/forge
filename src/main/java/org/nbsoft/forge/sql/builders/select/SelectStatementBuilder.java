/*
 * Copyright (C) 2015 NB Soft (info@nbsoft.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nbsoft.forge.sql.builders.select;

import org.nbsoft.forge.sql.builders.condition.ConditionStatement;
import org.nbsoft.forge.sql.builders.order.OrderStatement;
import org.nbsoft.forge.sql.builders.select.syntax.*;

public class SelectStatementBuilder implements Select, From, Where, Conjunction, Order, SQL {

    @Override
    public From select(String select) {
        return this;
    }

    @Override
    public Where from(String from) {
        return this;
    }

    @Override
    public Conjunction where(ConditionStatement where) {
        return this;
    }

    @Override
    public Conjunction and(ConditionStatement and) {
        return this;
    }

    @Override
    public Conjunction or(ConditionStatement or) {
        return this;
    }

    @Override
    public SQL order(OrderStatement order) {
        return this;
    }

    @Override
    public SelectStatement sql() {
        return new SelectStatement();
    }

}
