/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.plugins.codegenerator.types.terms;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface VariableLiteral extends Literal {

    int NO_INDEX = -1;

    String getName();

    Optional<List<Term>> getArgs();

    int getIndex();

    Optional<VariableLiteral> getChild();

    default boolean isIndexed() {
        return getIndex() != NO_INDEX;
    }

    @Override
    default boolean contains(String str) {
        if (getName().contains(str) || getChild().map(child -> child.contains(str)).orElse(false)) {
            return true;
        }
        for (Term arg : getArgs().orElse(Collections.emptyList())) {
            if (arg.contains(str)) {
                return true;
            }
        }
        return false;
    }

    default String getVariableLiteralName() {
        return getName() + getChild()
                .map(VariableLiteral::getVariableLiteralName)
                .map(rest -> rest.substring(0, 1).toUpperCase() + rest.substring(1))
                .orElse("");
    }
}
