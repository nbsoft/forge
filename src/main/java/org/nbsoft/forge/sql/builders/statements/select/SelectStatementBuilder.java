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

package org.nbsoft.forge.sql.builders.statements.select;

import org.nbsoft.forge.sql.builders.predicates.condition.ConditionPredicate;
import org.nbsoft.forge.sql.builders.predicates.order.OrderPredicate;
import org.nbsoft.forge.sql.builders.statements.select.syntax.*;

public class SelectStatementBuilder implements Select, From, Where, Conjunction, Order, SQL {

    @Override
    public From select(String fields) {
        return this;
    }

    @Override
    public Where from(String table) {
        return this;
    }

    @Override
    public Conjunction where(ConditionPredicate predicate) {
        return this;
    }

    @Override
    public Conjunction and(ConditionPredicate predicate) {
        return this;
    }

    @Override
    public Conjunction or(ConditionPredicate predicate) {
        return this;
    }

    @Override
    public SQL order(OrderPredicate predicate) {
        return this;
    }

    @Override
    public SelectStatement sql() {
        return new SelectStatement();
    }

}
