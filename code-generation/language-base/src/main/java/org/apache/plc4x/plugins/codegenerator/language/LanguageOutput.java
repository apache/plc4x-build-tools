/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package org.apache.plc4x.plugins.codegenerator.language;

import java.util.Set;
import org.apache.plc4x.plugins.codegenerator.types.definitions.TypeDefinition;
import org.apache.plc4x.plugins.codegenerator.types.exceptions.GenerationException;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface LanguageOutput {

    /**
     * The name of the template is what the plugin will use to select the correct language module.
     *
     * @return the name of the template.
     */
    String getName();

    List<String> supportedOutputFlavors();

    /**
     * An additional method which allows generator to have a hint which options are supported by it.
     * This method might be used to improve user experience and warn, if set options are ones generator does not support.
     *
     * @return Set containing names of options this language output can accept.
     */
    Set<String> supportedOptions();

    void generate(File outputDir, String languageName, String protocolName, String outputFlavor, Map<String, TypeDefinition> types,
        Map<String, String> options)
        throws GenerationException;

}
