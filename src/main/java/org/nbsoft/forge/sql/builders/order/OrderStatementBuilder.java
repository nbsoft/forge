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

package org.nbsoft.forge.sql.builders.order;

import org.nbsoft.forge.sql.builders.order.syntax.By;
import org.nbsoft.forge.sql.builders.order.syntax.Put;
import org.nbsoft.forge.sql.builders.order.syntax.Sort;

public class OrderStatementBuilder implements By, Sort {

    @Override
    public Sort by(String by) {
        return this;
    }

    @Override
    public By asc() {
        return this;
    }

    @Override
    public By desc() {
        return this;
    }

    @Override
    public OrderStatement put() {
        return new OrderStatement();
    }

}
