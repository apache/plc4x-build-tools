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

import org.apache.plc4x.plugins.codegenerator.types.references.ComplexTypeReference;
import org.apache.plc4x.plugins.codegenerator.types.references.SimpleTypeReference;
import org.apache.plc4x.plugins.codegenerator.types.references.TypeReference;
import org.apache.plc4x.plugins.codegenerator.types.terms.Term;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BuiltIns {

    public static final String CUR_POS = "curPos";
    public static final String START_POS = "startPos";
    public static final String READ_BUFFER = "readBuffer";
    public static final String WRITE_BUFFER = "writeBuffer";

    // In mspec we are using some virtual fields that are useful for code generation.
    // As they should be shared over all language template implementations,
    // these are defined here manually.
    public static final Map<String, TypeReference> builtInFields;

    static {
        builtInFields = new HashMap<>();
        builtInFields.put(CUR_POS, new SimpleTypeReference() {
            @Override
            public SimpleBaseType getBaseType() {
                return SimpleBaseType.UINT;
            }

            @Override
            public int getSizeInBits() {
                return 16;
            }
        });
        builtInFields.put(START_POS, new SimpleTypeReference() {
            @Override
            public SimpleBaseType getBaseType() {
                return SimpleBaseType.UINT;
            }

            @Override
            public int getSizeInBits() {
                return 16;
            }
        });
        builtInFields.put(READ_BUFFER, new ComplexTypeReference() {
            @Override
            public String getName() {
                return "ReadBuffer";
            }

            @Override
            public Optional<List<Term>> getParams() {
                return Optional.empty();
            }

            @Override
            public ComplexTypeDefinition getTypeDefinition() {
                return null;
            }

            @Override
            public void setTypeDefinition(TypeDefinition typeDefinition) {
                throw new IllegalArgumentException("Built-In fields can't have the type definition set.");
            }

        });
        builtInFields.put(WRITE_BUFFER, new ComplexTypeReference() {
            @Override
            public String getName() {
                return "WriteBuffer";
            }

            @Override
            public Optional<List<Term>> getParams() {
                return Optional.empty();
            }

            @Override
            public ComplexTypeDefinition getTypeDefinition() {
                return null;
            }

            @Override
            public void setTypeDefinition(TypeDefinition typeDefinition) {
                throw new IllegalArgumentException("Built-In fields can't have the type definition set.");
            }

        });
    }
}
