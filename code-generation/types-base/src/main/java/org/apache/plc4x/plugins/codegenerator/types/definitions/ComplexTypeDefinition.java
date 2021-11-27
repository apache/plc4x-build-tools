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

import org.apache.plc4x.plugins.codegenerator.types.fields.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ComplexTypeDefinition extends TypeDefinition {

    /**
     * Get only the fields which are of type AbstractField.
     *
     * @return all abstract fields
     */
    List<AbstractField> getAbstractFields();

    /**
     * In contrast to getFields, this also gets all property fields of any parent type.
     *
     * @return all simple fields including any parents simple fields
     */
    List<PropertyField> getAllPropertyFields();

    /**
     * Get only the fields which are of type ConstField.
     *
     * @return all constant fields
     */
    List<ConstField> getConstFields();

    /**
     * Get only the fields which are of type {@code AssertField}
     *
     * @return the assert fields
     */
    List<AssertField> getAssertFields();

    /**
     * Get all fields no matter the type.
     *
     * @return all fields
     */
    List<Field> getFields();

    /**
     * Get only the fields which are of type {@code ImplicitField}
     *
     * @return the implicit fields
     */
    List<ImplicitField> getImplicitFields();

    /**
     * Returns all protery fields defined by any parent type.
     *
     * @return all parent types simple fields.
     */
    List<PropertyField> getParentPropertyFields();

    /**
     * Get only the fields which are of type SimpleField or OptionalField.
     *
     * @return all simple and optional fields
     */
    List<PropertyField> getPropertyFields();

    /**
     * Get only the fields which are of type SimpleField.
     *
     * @return all simple fields
     */
    List<SimpleField> getSimpleFields();

    /**
     * Get any fields which are of type VirtualField.
     *
     * @return all virtual fields
     */
    List<VirtualField> getVirtualFields();

    /**
     * indicates if this type is abstract
     *
     * @return true if abstract.
     */
    boolean isAbstract();

    /**
     * Returns a {@link PropertyField} defined by {@code fieldName}.
     *
     * @param fieldName the fieldName to search for
     * @return {@link PropertyField} if found.
     */
    default Optional<PropertyField> getPropertyFieldByName(String fieldName) {
        return this.getPropertyFields().stream()
                .filter(propertyField -> propertyField.getName().equals(fieldName))
                .findFirst();
    }

    /**
     * Returns a {@link PropertyField} defined by {@code fieldName}.
     *
     * @param fieldName the fieldName to search for
     * @return {@link PropertyField} if found.
     */
    default Optional<PropertyField> getPropertyFieldFromThisOrParentByName(String fieldName) {
        return this.getAllPropertyFields().stream()
                .filter(propertyField -> propertyField.getName().equals(fieldName))
                .findFirst();
    }

    /**
     * Returns a {@link SwitchField} if found.
     *
     * @return the {@link SwitchField} if found.
     */
    default Optional<SwitchField> getSwitchField() {
        return this.getFields().stream()
                .filter(SwitchField.class::isInstance)
                .map(SwitchField.class::cast)
                .findFirst();
    }

    /**
     * Returns Fields of type {@link PropertyField} and {@link SwitchField}
     *
     * @return a list of {@link PropertyField}s and {@link SwitchField}s.
     */
    default Collection<Field> getPropertyAndSwitchFields() {
        return this.getFields().stream()
                .filter(field -> (field instanceof PropertyField) || (field instanceof SwitchField))
                .collect(Collectors.toList());
    }

    /**
     * @return list of sub-types or an empty collection, if there are none
     */
    default List<DiscriminatedComplexTypeDefinition> getSubTypeDefinitions() {
        return this.getSwitchField()
                .map(SwitchField::getCases)
                .orElse(Collections.emptyList());
    }

    /**
     * Check if there's any field with the given name.
     * This is required to suppress the generation of a discriminator field
     * in case a named field is providing the information.
     *
     * @param discriminatorName name of the discriminator name
     * @return true if a field with the given name already exists in the same type.
     */
    default boolean isNonDiscriminatorField(String discriminatorName) {
        return getAllPropertyFields().stream()
                .anyMatch(field -> !(field instanceof DiscriminatorField) && field.getName().equals(discriminatorName));
    }

    default boolean isParserArgument(String discriminatorName) {
        return getAllParserArguments().orElse(Collections.emptyList()).stream().anyMatch(argument -> argument.getName().equals(discriminatorName));
    }

}
