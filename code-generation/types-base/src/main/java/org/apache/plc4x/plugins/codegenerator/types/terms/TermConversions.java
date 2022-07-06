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
package org.apache.plc4x.plugins.codegenerator.types.terms;

import java.util.Optional;

/**
 * Used to convert between types.
 */
public interface TermConversions {
    /**
     * @return true if {@code this} is instance of {@link BinaryTerm}
     */
    default boolean isBinaryTerm() {
        return this instanceof BinaryTerm;
    }

    /**
     * @return a {@link BinaryTerm} if castable.
     */
    default Optional<BinaryTerm> asBinaryTerm() {
        return Optional.of(this).filter(BinaryTerm.class::isInstance).map(BinaryTerm.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link Literal}
     */
    default boolean isLiteral() {
        return this instanceof Literal;
    }

    /**
     * @return a {@link Literal} if castable.
     */
    default Optional<Literal> asLiteral() {
        return Optional.of(this).filter(Literal.class::isInstance).map(Literal.class::cast);
    }


    /**
     * @return true if {@code this} is instance of {@link TernaryTerm}
     */
    default boolean isTernaryTerm() {
        return this instanceof TernaryTerm;
    }

    /**
     * @return a {@link TernaryTerm} if castable.
     */
    default Optional<TernaryTerm> asTernaryTerm() {
        return Optional.of(this).filter(TernaryTerm.class::isInstance).map(TernaryTerm.class::cast);
    }

    /**
     * @return true if {@code this} is instance of {@link UnaryTerm}
     */
    default boolean isUnaryTerm() {
        return this instanceof UnaryTerm;
    }

    /**
     * @return a {@link UnaryTerm} if castable.
     */
    default Optional<UnaryTerm> asUnaryTerm() {
        return Optional.of(this).filter(UnaryTerm.class::isInstance).map(UnaryTerm.class::cast);
    }

    /**
     * @return true if this is a {@link WildcardTerm}
     */
    default boolean isWildcard() {
        return this instanceof WildcardTerm;
    }
}
