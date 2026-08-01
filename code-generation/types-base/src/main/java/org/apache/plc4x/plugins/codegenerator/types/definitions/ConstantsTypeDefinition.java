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
package org.apache.plc4x.plugins.codegenerator.types.definitions;

import org.apache.plc4x.plugins.codegenerator.types.fields.*;
import org.apache.plc4x.plugins.codegenerator.types.references.TypeReference;

import java.util.*;

public interface ConstantsTypeDefinition extends TypeDefinition {

    /**
     * Get all fields no matter the type.
     *
     * @return all fields
     */
    List<Field> getFields();

    /**
     * Get only the fields which are of type ConstField.
     *
     * @return all constant fields
     */
    List<ConstField> getConstFields();

    /**
     * Get only the fields which are of type SimpleField or OptionalField.
     *
     * @return all simple and optional fields
     */
    List<PropertyField> getPropertyFields();

    /**
     * Returns a {@link NamedField} defined by {@code fieldName}.
     *
     * @param fieldName the fieldName to search for
     * @return {@link NamedField} if found.
     */
    default Optional<NamedField> getNamedFieldByName(String fieldName) {
        return getFields().stream()
                .filter(FieldConversions::isNamedField)
                .map(field -> (NamedField) field)
                .filter(namedField -> namedField.getName().equals(fieldName))
                .findFirst();
    }

    /**
     * Returns a {@link PropertyField} defined by {@code fieldName}.
     *
     * @param fieldName the fieldName to search for
     * @return {@link PropertyField} if found.
     */
    default Optional<PropertyField> getPropertyFieldByName(String fieldName) {
        return getPropertyFields().stream()
                .filter(propertyField -> propertyField.getName().equals(fieldName))
                .findFirst();
    }

    /**
     * Return the {@link TypeReference} of a given property.
     *
     * @param propertyName name of the property
     * @return the type reference of the given property
     */
    default Optional<TypeReference> getTypeReferenceForProperty(String propertyName) {
        Objects.requireNonNull(propertyName);
        // If this is a built-in type, use that.
        if (BuiltIns.builtInFields.containsKey(propertyName)) {
            return Optional.of(BuiltIns.builtInFields.get(propertyName));
        }
        // Check if the expression root is referencing a field
        final Optional<PropertyField> propertyFieldOptional = getPropertyFields().stream()
                .filter(propertyField -> propertyField.getName().equals(propertyName))
                .findFirst();
        if (propertyFieldOptional.isPresent()) {
            return propertyFieldOptional.map(PropertyField::getType);
        }
        return Optional.empty();
    }

}
