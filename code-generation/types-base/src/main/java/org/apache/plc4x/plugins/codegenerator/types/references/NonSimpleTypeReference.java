/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.plugins.codegenerator.types.references;

import org.apache.plc4x.plugins.codegenerator.types.definitions.Argument;
import org.apache.plc4x.plugins.codegenerator.types.definitions.TypeDefinition;
import org.apache.plc4x.plugins.codegenerator.types.terms.Term;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface NonSimpleTypeReference extends TypeReference {

    String getName();

    Optional<List<Term>> getParams();

    TypeDefinition getTypeDefinition();

    void setTypeDefinition(TypeDefinition typeDefinition);

    default TypeReference getArgumentType(int index) {
        TypeDefinition typeDefinition = getTypeDefinition();
        List<Argument> parserArguments = new LinkedList<>();
        typeDefinition.asComplexTypeDefinition()
                .map(complexTypeDefinition ->
                        complexTypeDefinition.getParentType().map(parentType ->
                                parserArguments.addAll(parentType.getParserArguments().orElse(Collections.emptyList()))
                        )
                );
        parserArguments.addAll(typeDefinition.getParserArguments().orElse(Collections.emptyList()));
        if (parserArguments.size() <= index) {
            throw new IllegalArgumentException("Type " + getName() + " specifies too few parser arguments. Available:" + parserArguments.size() + " index:" + index);
        }
        return parserArguments.get(index).getType();
    }

}
