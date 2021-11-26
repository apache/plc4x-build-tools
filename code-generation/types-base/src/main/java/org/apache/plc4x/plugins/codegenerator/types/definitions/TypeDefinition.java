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
package org.apache.plc4x.plugins.codegenerator.types.definitions;

import org.apache.plc4x.plugins.codegenerator.types.Constants;
import org.apache.plc4x.plugins.codegenerator.types.fields.SwitchField;
import org.apache.plc4x.plugins.codegenerator.types.references.TypeReference;
import org.apache.plc4x.plugins.codegenerator.types.terms.Term;

import java.util.*;
import java.util.stream.Collectors;

public interface TypeDefinition extends TypeDefinitionConversions {

    String getName();

    Optional<Term> getAttribute(String attributeName);

    default Optional<Term> getEncoding() {
        return getAttribute(Constants.ATTRIBUTE_ENCODING);
    }

    default Optional<Term> getByteOrder() {
        return getAttribute(Constants.ATTRIBUTE_BYTE_ORDER);
    }

    Optional<List<Argument>> getParserArguments();

    /**
     * @return Concatenation of this type's parser arguments, prefixed by the parent types
     *         parser arguments.
     */
    Optional<List<Argument>> getAllParserArguments();

    // TODO: replace with Optional
    // TODO: should this be move to ComplexTypeDefinition? Can a normal type definition have a parent type
    // TODO: check if this can be moved down.
    TypeDefinition getParentType();

    /**
     * @return true if {@code this} is a discriminated parent.
     */
    default boolean isDiscriminatedParentTypeDefinition() {
        return asComplexTypeDefinition()
                .map(ComplexTypeDefinition::isAbstract)
                .orElse(false);
    }

    /**
     * @return true if {@code this} is a discriminated child.
     */
    default boolean isDiscriminatedChildTypeDefinition() {
        return asDiscriminatedComplexTypeDefinition()
                .map(ComplexTypeDefinition::isAbstract)
                .map(isAbstract -> !isAbstract)
                .orElse(false);
    }

    /**
     * Check if there's any field with the given name.
     * This is required to suppress the generation of a virtual field
     * in case a discriminated field is providing the information.
     *
     * @param discriminatorName name of the virtual name
     * @return true if a field with the given name already exists in the same type.
     */
    default boolean isDiscriminatorField(String discriminatorName) {
        return getDiscriminatorNames().stream()
                .anyMatch(field -> field.equals(discriminatorName));
    }

    /**
     * Get an ordered list of generated names for the discriminators.
     * These names can be used to access the type definitions as well as well as the values.
     *
     * @return list of symbolic names for the discriminators.
     */
    // TODO: check if this can be moved down.
    default List<String> getDiscriminatorNames() {
        TypeDefinition baseType = this;
        if (this.getParentType() != null) {
            baseType = this.getParentType();
        }
        if (!(baseType instanceof ComplexTypeDefinition)) {
            return Collections.emptyList();
        }
        ComplexTypeDefinition complexTypeDefinition = (ComplexTypeDefinition) baseType;
        return complexTypeDefinition.getSwitchField()
                .map(SwitchField::getDiscriminatorExpressions)
                .map(terms -> terms.stream()
                        .map(Term::getDiscriminatorName).collect(Collectors.toList())
                )
                .orElse(Collections.emptyList());
    }

    /**
     * Get a list of the values for every discriminator name for every discriminated type.
     *
     * @return Map mapping discriminator names to discriminator values for every discriminated type.
     */
    // TODO: check if this can be moved down.
    default Map<String, Map<String, Term>> getDiscriminatorCaseToKeyValueMap() {
        // Get the parent type (Which contains the typeSwitch field)
        ComplexTypeDefinition parentType;
        if (isDiscriminatedComplexTypeDefinition()) {
            parentType = (ComplexTypeDefinition) getParentType();
        } else {
            parentType = (ComplexTypeDefinition) this;
        }
        // Get the typeSwitch field from that.
        return parentType.getSwitchField()
                .map(SwitchField::getCases)
                .map(cases -> cases.stream()
                        // Build a map containing the named discriminator values for every case of the typeSwitch.
                        .collect(
                                Collectors.toMap(
                                        DiscriminatedComplexTypeDefinition::getName,
                                        DiscriminatedComplexTypeDefinition::getDiscriminatorMap,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new
                                )
                        )
                )
                .orElse(new LinkedHashMap<>());
    }

}
