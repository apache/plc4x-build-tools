<!--
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
  -->
[![Maven central](https://img.shields.io/maven-central/v/org.apache.plc4x.plugins/plc4x-maven-plugin.svg)](https://img.shields.io/maven-central/v/org.apache.plc4x.plugins/plc4x-maven-plugin.svg)
[![License](https://img.shields.io/github/license/apache/plc4x.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Last commit](https://img.shields.io/github/last-commit/apache/plc4x-build-tools.svg)]()
[![Platform compatibility](https://img.shields.io/github/workflow/status/apache/plc4x-build-tools/Platform%20compatibility?label=Platform%20compatibility)](https://github.com/apache/plc4x-build-tools/actions/workflows/ensure-platforms.yml)
[![Twitter](https://img.shields.io/twitter/follow/ApachePLC4X.svg?label=Follow&style=social)](https://twitter.com/ApachePLC4X)

Apache PLC4X Build-Tools
========================

Apache PLC4X Build-Tools is a sub-project of the Apache PLC4X project and contains
all the tools needed to build the main project.

Currently the only tools it contains is a maven plugin used to generate drivers and
a new maven-site-plugin site theme.

It currently doesn't contain any actual code-generation modules, but just the plugin
and the API required to load and use code-generation modules.

The actual code-generation modules are located inside the main project.

Environment
-----------

Currently the project is configured to require the following software:

1) Java >=9 JDK: For running Maven in general as well as compiling the Java and Scala
modules JAVA_HOME configured to point to that.


Getting Started
---------------

Normally you wouldn't be required to build this module as the artifacts it produces
will be made available via one of the maven repositories. However if you want to improve
or fix the existing tools, you will have to build your version locally.

You must have Java >=9 installed on your system and connectivity to Maven Central
(for downloading external third party dependencies). Maven will be automatically
downloaded and installed by the maven wrapper `mvnw`.

Build PLC4X Java jars and install them in your local maven repository

`$ ./mvnw install`

This should make the build-tools available to the main projects build.
In order to use your locally built version of the build-tools you should
update the property: `plc4x-code-generation.version` in the PLC4X main pom.xml.



Licensing
---------

Apache PLC4X is released under the Apache License Version 2.0.
