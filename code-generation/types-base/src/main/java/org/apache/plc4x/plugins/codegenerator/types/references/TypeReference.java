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
package org.apache.plc4x.plugins.codegenerator.types.references;

import org.apache.plc4x.plugins.codegenerator.types.definitions.ComplexTypeDefinition;
import org.apache.plc4x.plugins.codegenerator.types.terms.VariableLiteral;

import java.util.Optional;

public interface TypeReference extends TypeReferenceConversions {

    /**
     * @return true if this is a {@link SimpleTypeReference.SimpleBaseType} == {@code BYTE}
     */
    default boolean isByteBased() {
        if (!isSimpleTypeReference()) {
            return false;
        }
        return ((SimpleTypeReference) this).getBaseType() == SimpleTypeReference.SimpleBaseType.BYTE;
    }

    default Optional<TypeReference> getDiscriminatorType(VariableLiteral variableLiteral) {
        // If we found something but there's a "rest" left, we got to use the type we
        // found in this level, get that type's definition and continue from there.
        if (variableLiteral.getChild().isEmpty()) {
            return Optional.of(this);
        }
        // If we're accessing a child, then the root must be a complex type.
        if (!(this instanceof ComplexTypeReference)) {
            return Optional.empty();
        }
        ComplexTypeReference complexTypeReference = (ComplexTypeReference) this;
        final ComplexTypeDefinition complexTypeDefinition = complexTypeReference.getComplexTypeDefinition();
        VariableLiteral childVariableLiteral = variableLiteral.getChild().get();
        return complexTypeDefinition.getTypeReferenceForProperty(childVariableLiteral.getName())
                .flatMap(innerTypeReference -> innerTypeReference.getDiscriminatorType(childVariableLiteral));
    }

}
