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

package org.nbsoft.forge.sql.builders.predicates.condition;

import org.nbsoft.forge.sql.builders.predicates.condition.syntax.Predicate;
import org.nbsoft.forge.sql.builders.predicates.condition.syntax.Conjunction;
import org.nbsoft.forge.sql.builders.predicates.condition.syntax.Operator;

public class ConditionPredicateBuilder implements Predicate, Operator, Conjunction {

    @Override
    public Operator predicate(String predicate) {
        return this;
    }

    @Override
    public Conjunction equal(Object expression) {
        return this;
    }

    @Override
    public Conjunction notEqual(Object expression) {
        return this;
    }

    @Override
    public Conjunction greaterThan(Object expression) {
        return this;
    }

    @Override
    public Conjunction lessThan(Object expression) {
        return this;
    }

    @Override
    public Conjunction greaterThanOrEqual(Object expression) {
        return this;
    }

    @Override
    public Conjunction lessThanOrEqual(Object expression) {
        return this;
    }

    @Override
    public Conjunction between(Object expression) {
        return this;
    }

    @Override
    public Conjunction like(Object expression) {
        return this;
    }

    @Override
    public Conjunction in(Object expression) {
        return this;
    }

    @Override
    public Operator and(String predicate) {
        return this;
    }

    @Override
    public Operator or(String predicate) {
        return this;
    }

    @Override
    public ConditionPredicate put() {
        return new ConditionPredicate();
    }

}
