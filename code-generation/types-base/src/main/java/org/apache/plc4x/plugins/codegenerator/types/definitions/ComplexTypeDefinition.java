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
import org.apache.plc4x.plugins.codegenerator.types.references.TypeReference;
import org.apache.plc4x.plugins.codegenerator.types.terms.Term;
import org.apache.plc4x.plugins.codegenerator.types.terms.VariableLiteral;

import java.util.*;
import java.util.stream.Collectors;

public interface ComplexTypeDefinition extends TypeDefinition {

    /**
     * Return the parent if one is present
     *
     * @return the parent
     */
    Optional<ComplexTypeDefinition> getParentType();

    /**
     * Get only the fields which are of type AbstractField.
     *
     * @return all abstract fields
     */
    List<AbstractField> getAbstractFields();

    /**
     * In contrast to getFields, this also gets all property fields of any parent type.
     *
     * @return all fields
     */
    List<Field> getAllFields();

    /**
     * In contrast to getPropertyFieldsFields, this also gets all property fields of any parent type.
     *
     * @return all simple fields including any parents simple fields
     */
    List<PropertyField> getAllPropertyFields();

    /**
     * In contrast to getVirtualFields, this also gets all virtual fields of any parent type.
     *
     * @return all virtual fields including any parents simple fields
     */
    List<VirtualField> getAllVirtualFields();

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
        ComplexTypeDefinition baseType = getParentType().orElse(this);
        return baseType.getSwitchField()
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
            parentType = getParentType().orElseThrow(IllegalStateException::new);
        } else {
            parentType = this;
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
     * Returns a {@link PropertyField} defined by {@code fieldName}.
     *
     * @param fieldName the fieldName to search for
     * @return {@link PropertyField} if found.
     */
    default Optional<PropertyField> getPropertyFieldFromThisOrParentByName(String fieldName) {
        return getAllPropertyFields().stream()
                .filter(propertyField -> propertyField.getName().equals(fieldName))
                .findFirst();
    }

    /**
     * Returns a {@link SwitchField} if found.
     *
     * @return the {@link SwitchField} if found.
     */
    default Optional<SwitchField> getSwitchField() {
        return getFields().stream()
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
        return getFields().stream()
                .filter(field -> (field instanceof PropertyField) || (field instanceof SwitchField))
                .collect(Collectors.toList());
    }

    /**
     * @return list of sub-types or an empty collection, if there are none
     */
    default List<DiscriminatedComplexTypeDefinition> getSubTypeDefinitions() {
        return getSwitchField()
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
        boolean hasMatchingPropertyField = getAllPropertyFields().stream()
                .anyMatch(field -> !(field instanceof DiscriminatorField) && field.getName().equals(discriminatorName));
        boolean hasMatchingVirtualField = getAllVirtualFields().stream()
                .anyMatch(field -> field.getName().equals(discriminatorName));
        return hasMatchingPropertyField || hasMatchingVirtualField;
    }

    default boolean isParserArgument(String discriminatorName) {
        return getAllParserArguments().orElse(Collections.emptyList()).stream().anyMatch(argument -> argument.getName().equals(discriminatorName));
    }

    /**
     * Returns the implicit field that has the same name as the variable. These need to be handled differently when serializing and parsing.
     *
     * @param variableLiteral The variable to search for.
     * @return ImplicitField returns the implicit field that corresponds to the variable's name.
     */
    default ImplicitField getReferencedImplicitField(VariableLiteral variableLiteral) {
        return getFields().stream()
                .filter(FieldConversions::isImplicitField)
                .map(ImplicitField.class::cast)
                .filter(implicitField -> variableLiteral.getName().equals(implicitField.getName()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Confirms if a variable is a discriminator variable. These need to be handled differently when serializing and parsing.
     *
     * @param variableLiteral The variable to search for.
     * @return boolean returns true if the variable's name is an discriminator field
     */
    default boolean isVariableLiteralDiscriminatorField(VariableLiteral variableLiteral) {
        return getFields().stream()
                .filter(FieldConversions::isDiscriminatorField)
                .map(DiscriminatorField.class::cast)
                .anyMatch(discriminatorField -> variableLiteral.getName().equals(discriminatorField.getName()));
    }

    /**
     * Confirms if a variable is an virtual variable. These need to be handled differently when serializing and parsing.
     *
     * @param variableLiteral The variable to search for.
     * @return boolean returns true if the variable's name is an virtual field
     */
    default boolean isVariableLiteralVirtualField(VariableLiteral variableLiteral) {
        return getAllPropertyFields().stream()
                .filter(FieldConversions::isVirtualField)
                .map(VirtualField.class::cast)
                .anyMatch(virtualField -> variableLiteral.getName().equals(virtualField.getName()));
    }

    /**
     * Confirms if a variable is an implicit variable. These need to be handled differently when serializing and parsing.
     *
     * @param variableLiteral The variable to search for.
     * @return boolean returns true if the variable's name is an implicit field
     */
    default boolean isVariableLiteralImplicitField(VariableLiteral variableLiteral) {
        return getFields().stream()
                .filter(FieldConversions::isImplicitField)
                .map(ImplicitField.class::cast)
                .anyMatch(implicitField -> variableLiteral.getName().equals(implicitField.getName()));
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
        // Check if the expression is a ImplicitField
        final Optional<ImplicitField> implicitFieldOptional = getFields().stream()
                .filter(ImplicitField.class::isInstance)
                .map(ImplicitField.class::cast)
                .filter(implicitField -> implicitField.getName().equals(propertyName))
                .findFirst();
        if (implicitFieldOptional.isPresent()) {
            return implicitFieldOptional.map(ImplicitField::getType);
        }
        // Check if the expression is a VirtualField
        final Optional<VirtualField> virtualFieldOptional = getFields().stream()
                .filter(VirtualField.class::isInstance)
                .map(VirtualField.class::cast)
                .filter(virtualField -> virtualField.getName().equals(propertyName))
                .findFirst();
        if (virtualFieldOptional.isPresent()) {
            return virtualFieldOptional.map(VirtualField::getType);
        }
        // Check if the expression root is referencing an argument
        final Optional<Argument> argumentOptional = getParserArguments()
                .orElse(Collections.emptyList())
                .stream()
                .filter(argument -> argument.getName().equals(propertyName))
                .findFirst();
        if (argumentOptional.isPresent()) {
            return argumentOptional.map(Argument::getType);
        }
        // Check if the expression is a DiscriminatorField
        // This is a more theoretical case where the expression is referencing a discriminator value of the current type
        final Optional<DiscriminatorField> discriminatorFieldOptional = getFields().stream()
                .filter(DiscriminatorField.class::isInstance)
                .map(DiscriminatorField.class::cast)
                .filter(discriminatorField -> discriminatorField.getName().equals(propertyName))
                .findFirst();
        if (discriminatorFieldOptional.isPresent()) {
            return discriminatorFieldOptional.map(DiscriminatorField::getType);
        }
        return Optional.empty();
    }

}
