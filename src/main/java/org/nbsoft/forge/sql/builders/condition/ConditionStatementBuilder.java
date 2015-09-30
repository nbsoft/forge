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

package org.nbsoft.forge.sql.builders.condition;

import org.nbsoft.forge.sql.builders.condition.syntax.Predicate;
import org.nbsoft.forge.sql.builders.condition.syntax.Conjunction;
import org.nbsoft.forge.sql.builders.condition.syntax.Operator;

public class ConditionStatementBuilder implements Predicate, Operator, Conjunction {

    @Override
    public Operator predicate(String predicate) {
        return this;
    }

    @Override
    public Conjunction equal(Object equal) {
        return this;
    }

    @Override
    public Conjunction notEqual(Object notEqual) {
        return this;
    }

    @Override
    public Conjunction greaterThan(Object greaterThan) {
        return this;
    }

    @Override
    public Conjunction lessThan(Object lessThan) {
        return this;
    }

    @Override
    public Conjunction greaterThanOrEqual(Object greaterThanOrEqual) {
        return this;
    }

    @Override
    public Conjunction lessThanOrEqual(Object lessThanOrEqual) {
        return this;
    }

    @Override
    public Conjunction between(Object between) {
        return this;
    }

    @Override
    public Conjunction like(Object like) {
        return this;
    }

    @Override
    public Conjunction in(Object in) {
        return this;
    }

    @Override
    public Operator and(String and) {
        return this;
    }

    @Override
    public Operator or(String or) {
        return this;
    }

    @Override
    public ConditionStatement put() {
        return new ConditionStatement();
    }

}
