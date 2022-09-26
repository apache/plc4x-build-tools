# CHANGELOG

## [releases/code-generation/1.6.0](https://github.com/apache/plc4x-build-tools/releases/tag/releases/code-generation/1.6.0) - 2022-09-22 12:04:36

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.6...releases/code-generation/1.6.0

## [rel/1.6](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.6) - 2022-09-22 11:34:53

## What's Changed
* fix typo by @hboutemy in https://github.com/apache/plc4x-build-tools/pull/7
* Bump junit from 4.12 to 4.13.2 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/9
* Bump maven.version from 3.3.9 to 3.8.4 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/10
* Bump commons-lang3 from 3.9 to 3.12.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/11
* build(deps): bump commons-beanutils from 1.9.3 to 1.9.4 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/15
* Bump maven.version from 3.6.3 to 3.8.4 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/12
* chore(deps): bump maven-plugin-plugin from 3.6.1 to 3.6.4 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/18
* chore(deps): bump maven-plugin-annotations from 3.6.0 to 3.6.4 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/17
* build(deps): bump commons-io from 2.6 to 2.11.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/16
* chore(deps): bump maven-javadoc-plugin from 3.3.1 to 3.3.2 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/22
* chore(deps): bump maven-project-info-reports-plugin from 3.1.2 to 3.2.2 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/19
* chore(deps): bump maven-jar-plugin from 3.2.0 to 3.2.2 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/20
* chore(deps): bump maven-release-plugin from 3.0.0-M4 to 3.0.0-M5 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/21
* chore(deps): bump download-maven-plugin from 1.6.7 to 1.6.8 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/26
* chore(deps): bump maven-compiler-plugin from 3.8.1 to 3.10.1 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/27
* chore(deps): bump maven-invoker-plugin from 3.2.2 to 3.3.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/31
* chore(deps): bump maven-dependency-plugin from 3.2.0 to 3.3.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/29
* chore(deps): bump maven.version from 3.6.3 to 3.8.5 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/28
* chore(deps): bump maven-javadoc-plugin from 3.3.2 to 3.4.1 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/32
* chore(deps): bump maven-install-plugin from 2.5.2 to 3.0.1 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/34
* chore(deps): bump maven-project-info-reports-plugin from 3.2.2 to 3.4.1 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/36
* chore(deps): bump maven-deploy-plugin from 2.8.2 to 3.0.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/35
* chore(deps): bump maven-assembly-plugin from 3.3.0 to 3.4.2 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/38
* chore(deps): bump maven-release-plugin from 3.0.0-M5 to 3.0.0-M6 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/37
* chore(deps): bump maven-jar-plugin from 3.2.2 to 3.3.0 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/39
* chore(deps): bump apache-rat-plugin from 0.14 to 0.15 by @dependabot in https://github.com/apache/plc4x-build-tools/pull/40

## New Contributors
* @hboutemy made their first contribution in https://github.com/apache/plc4x-build-tools/pull/7
* @dependabot made their first contribution in https://github.com/apache/plc4x-build-tools/pull/9

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.5...rel/1.6

### Feature

- codegen:
  - changed validation to fail parsing conditionally ([12c6aa9](https://github.com/apache/plc4x-build-tools/commit/12c6aa9eda06ddda855737f7a82e37f38dd8bfc9))
  - added a get getAllFields method ([24f61be](https://github.com/apache/plc4x-build-tools/commit/24f61be6fd9517ce5c739eb5720f720cad01c361))
  - Tried getting stuff working in C ;-) ([6ef2695](https://github.com/apache/plc4x-build-tools/commit/6ef269525859e0f566a9cd422b958b9239a09825))
  - Fixed array type handling and data-io code generation ([26e0a2f](https://github.com/apache/plc4x-build-tools/commit/26e0a2f180778e69c10dfc5e2030618e2fc3c102))
  - added new type conversion ([ba2d024](https://github.com/apache/plc4x-build-tools/commit/ba2d02447302676d6d00278f1f0db3a9a3f43f79))
  - Started clening up the type references ([3ff59b8](https://github.com/apache/plc4x-build-tools/commit/3ff59b8390af00e1379a95fbd65f4745c8539042))
  - Ensured the VariableLiterals are able to provide their type. ([39be9f6](https://github.com/apache/plc4x-build-tools/commit/39be9f6a25157e6e11e7ecf9b9aab386ae4ad818))
  - moved functions from helper into types ([1755a7c](https://github.com/apache/plc4x-build-tools/commit/1755a7c509d35683e9e87c528c6ab515dfa57f44))
  - introduce TypeContext to transport more information out of code generation ([70731aa](https://github.com/apache/plc4x-build-tools/commit/70731aa6d1451168b89d77084e7a5066193fbdd0))

- code-generation:
  - Added the concept of a "protocol version" to the protocol modules and the code-generation plugin. ([6d4e024](https://github.com/apache/plc4x-build-tools/commit/6d4e024af7229fc6d4b228fdf96dc2ff8b5a0215))

- general:
  - add peek field ([2a7f841](https://github.com/apache/plc4x-build-tools/commit/2a7f841adcfe7d20db54056e75e9700d05e8f6e5))
  - add validation field ([efbcecb](https://github.com/apache/plc4x-build-tools/commit/efbcecbd9465dd88a324734ab6a52afed71a0abe))
  - mspec extension with parameterized type refs, assert, try, const ([548b557](https://github.com/apache/plc4x-build-tools/commit/548b557e3400addf2bc2aaa553a7e297c7583229))

- ci:
  - add github workflows ([82e38ef](https://github.com/apache/plc4x-build-tools/commit/82e38efdadb4712454a58d9c49dfbe2631c1bbe5))

- plc4x/codegen:
  - remove obsolete ticks ([0e30364](https://github.com/apache/plc4x-build-tools/commit/0e303649aacfbd8f7b974ce22a41c9816821cb17))

### Bug Fixes

- site:
  - partially update versions ([73102c6](https://github.com/apache/plc4x-build-tools/commit/73102c6e0ddbf7cef48b3405ad46b8759f458eef))

- general:
  - added missing extends to WildcardTerm ([2792cd0](https://github.com/apache/plc4x-build-tools/commit/2792cd0607e7cdedd3e82945d9ce5c9b4eccb0ff))
  - Enabled the language tests again and fixed all the stuff that needed fixing after that. ([9e8ec04](https://github.com/apache/plc4x-build-tools/commit/9e8ec040008a67fd59c337612853ebe114624fd5))
  - Worked hard on getting the conditions for typeSwitches strongly typed. (WIP ... currently all Java modules work, C and Go still need some polishing) ([8c0c38b](https://github.com/apache/plc4x-build-tools/commit/8c0c38bf2318c371ae3b90b0085dee77b1313203))
  - Changed typeSwitch to no longer use expressions as discriminators (Now variableLiterals are required) in const fields now no longer expressions can be used and instead only Literals can be used. ([d6f6ba2](https://github.com/apache/plc4x-build-tools/commit/d6f6ba20104f344630b9deb74f4dfea4e5e99409))
  - Changed typeSwitch to no longer use expressions as discriminators (Now variableLiterals are required) in const fields now no longer expressions can be used and instead only Literals can be used. ([40d3992](https://github.com/apache/plc4x-build-tools/commit/40d3992c5897cd07068f28931d7333e5216cd2bc))
  - Changed typeSwitch to no longer use expressions as discriminators (Now variableLiterals are required) in const fields now no longer expressions can be used and instead only Literals can be used. ([32cc800](https://github.com/apache/plc4x-build-tools/commit/32cc80000b13ef6a4e0ab00b4d74c4dbda17f754))
  - set maven version to the previous lts to give plugins a bit time to catch up ([106e256](https://github.com/apache/plc4x-build-tools/commit/106e2566af547892399290049084289931390f27))
  - Continued implementing the arguments in the parser
fix: Set a byteOrder argument on every root-type in our mspec grammars ([629ed6e](https://github.com/apache/plc4x-build-tools/commit/629ed6e712f5e68306491de440710c46c2a52702))
  - getDiscriminatorCaseToKeyValueMap should return Map interface again ([168a718](https://github.com/apache/plc4x-build-tools/commit/168a71847ab3a061c269120567cc3f136af1ded6))
  - fixed order on getDiscriminatorCaseToKeyValueMap ([82324e5](https://github.com/apache/plc4x-build-tools/commit/82324e591c267d1215bd9a1b3e3305a19f910433))
  - fix typo ([d23c1d5](https://github.com/apache/plc4x-build-tools/commit/d23c1d517e1b8467ee05781d881a183a3cb32639)) ([#7](https://github.com/apache/plc4x-build-tools/pull/7))

- codegen:
  - Added more testcases for the new field types and added support for them in Java, C and Go ([49f41ca](https://github.com/apache/plc4x-build-tools/commit/49f41ca4af64e634f5c408e703003639db9a8449))
  - isNonDiscriminatorField has broken logic ([5b038cf](https://github.com/apache/plc4x-build-tools/commit/5b038cf6797298ffa013d6063d4f14bf77b4244e))
  - getAllVirtualFields returning wrong type ([3072bf1](https://github.com/apache/plc4x-build-tools/commit/3072bf1d41303fea0a3baf11566750074c0183c2))
  - fix ComplexTypeDefinition#isNonDiscriminatorField so it respects virtual fields too ([ffbec8f](https://github.com/apache/plc4x-build-tools/commit/ffbec8f639d5bc753f5cba66ed0f2dd4f9ce0dd9))
  - fix ComplexTypeReference ([a105b61](https://github.com/apache/plc4x-build-tools/commit/a105b61ec4d87203e96c4b8c403921528e953f3b))
  - put DataIo below ComplexType ([eb5dcf5](https://github.com/apache/plc4x-build-tools/commit/eb5dcf5c0374c77cefe80c7515256e4fa229dd48))

- plc4j:
  - Made the bacnet RandomPackagesTest.java execute on Windows and updated the documentation on setting up libpcap on Windows. ([4b0090a](https://github.com/apache/plc4x-build-tools/commit/4b0090a4be756c7d22ffc96445bfe0f19f06b21f))

- .mvn:
  - upgrading mvn wrapper to 3.6.3 (previous LTS version) ([8fe7394](https://github.com/apache/plc4x-build-tools/commit/8fe739443b18c61d2ac6db8bb9143a76907b6641))

- ci:
  - remove java 8 from platform ensurance ([93d5974](https://github.com/apache/plc4x-build-tools/commit/93d597402a1aeebfbf26b2b9a0cd94f09cec3854))
  - remove not needed languages from codeql ([83541a0](https://github.com/apache/plc4x-build-tools/commit/83541a06d8c1847b7aa508d4cb4737290157599e))
  - fix build by using min java version ([65c1385](https://github.com/apache/plc4x-build-tools/commit/65c13854874eb0bb5482599c494cee40864fc48a))
  - add mvn wrapper at top level ([ed7641c](https://github.com/apache/plc4x-build-tools/commit/ed7641c930f989aa604735576817a346a8148b06))

- plc4j/codgen:
  - avoid duplicating params ([7b0da44](https://github.com/apache/plc4x-build-tools/commit/7b0da448a8242a9893dbd7311b55329b2672caf8))
  - fixed data reader complex working with a empty logical name ([e709e45](https://github.com/apache/plc4x-build-tools/commit/e709e45722edd5f75c68bcb549b2dc34c19cd39f))

### Refactor

- codegen:
  - move WildcardTerm to build-tools ([5b9129b](https://github.com/apache/plc4x-build-tools/commit/5b9129b34276bb78889255a0e8458326fbf4259d))
  - change index on variable literal to make use of optional ([57e8c65](https://github.com/apache/plc4x-build-tools/commit/57e8c65914b9afeac6f4f65cab89ae9a7b494d24))
  - replaced some lookups ([59cf376](https://github.com/apache/plc4x-build-tools/commit/59cf37666f602b87ef7531cc93a26c0594ceb2de))
  - fixed enum type definition ([70b443c](https://github.com/apache/plc4x-build-tools/commit/70b443c78d0e3668a464382636f4647110f0d113))
  - fixed enum type defintion ([7c8383b](https://github.com/apache/plc4x-build-tools/commit/7c8383b041769d1068949e40840677406e894baf))
  - fixed some open todos ([121c789](https://github.com/apache/plc4x-build-tools/commit/121c78978fffaf5f4aed0caef3bc97caa72b7dc5))
  - moved default types to mspec base ([5739421](https://github.com/apache/plc4x-build-tools/commit/5739421c29fafef7fac1ae6a7cd69af588541846))

- codegen/plc4go:
  - avoid duplicating arguments as fields when present in parent ([0ecd07c](https://github.com/apache/plc4x-build-tools/commit/0ecd07c96c97594d1a483aaa0c54ca85c42ec07e))

- general:
  - cleanup pom ([6d7364d](https://github.com/apache/plc4x-build-tools/commit/6d7364d18ab0d3fd75248f527380ff317fca1a26))
  - add todos to TypeDefinition ([4397826](https://github.com/apache/plc4x-build-tools/commit/4397826495d70eb4fc16e139796188cfc8bd1e9c))
  - cleanup interfaces and add functionality ([f75623e](https://github.com/apache/plc4x-build-tools/commit/f75623ee3a1f8cc1690a8af1fa0c167f369def97))

- plc4j/codgen:
  - small cleanups ([cfb213f](https://github.com/apache/plc4x-build-tools/commit/cfb213f9954cc82c9dd643efebabdde9bb7bc8d2))

## [releases/code-generation/1.5.0](https://github.com/apache/plc4x-build-tools/releases/tag/releases/code-generation/1.5.0) - 2021-09-08 17:57:20

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.5...releases/code-generation/1.5.0

## [rel/1.5](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.5) - 2021-09-08 17:48:46

## What's Changed
* Feature/string enum mspec by @hutcheb in https://github.com/apache/plc4x-build-tools/pull/5
* PLC4X-307 Support for custom packages. by @splatch in https://github.com/apache/plc4x-build-tools/pull/6

## New Contributors
* @hutcheb made their first contribution in https://github.com/apache/plc4x-build-tools/pull/5

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.4...rel/1.5

### Bug Fixes

- general:
  - sneaky colection import ([01bbb6e](https://github.com/apache/plc4x-build-tools/commit/01bbb6e4f23f50f9e331320797ff50e0faaaf6c4))
  - add missing getAbstractFields to ComplexTypeDefinition ([f2d08e2](https://github.com/apache/plc4x-build-tools/commit/f2d08e229628b11e3b7e05f298550f579121cd90))

## [releases/code-generation/1.4.0](https://github.com/apache/plc4x-build-tools/releases/tag/releases/code-generation/1.4.0) - 2020-12-13 16:37:43

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.4...releases/code-generation/1.4.0

## [rel/1.4](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.4) - 2020-12-13 16:27:40

## What's Changed
* More content about MSpec, its use and overall structure. by @splatch in https://github.com/apache/plc4x-build-tools/pull/4


**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.3...rel/1.4

## [releases/code-generation/1.3.0](https://github.com/apache/plc4x-build-tools/releases/tag/releases/code-generation/1.3.0) - 2020-09-08 11:25:05

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.3...releases/code-generation/1.3.0

## [rel/1.3](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.3) - 2020-09-08 11:06:50

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.2...rel/1.3

## [rel/1.2](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.2) - 2020-03-29 12:37:09

## What's Changed
* Remove headline border and background by @NiklasMerz in https://github.com/apache/plc4x-build-tools/pull/1
* PLC4X landing page by @dominikriemer in https://github.com/apache/plc4x-build-tools/pull/2

## New Contributors
* @NiklasMerz made their first contribution in https://github.com/apache/plc4x-build-tools/pull/1
* @dominikriemer made their first contribution in https://github.com/apache/plc4x-build-tools/pull/2

**Full Changelog**: https://github.com/apache/plc4x-build-tools/compare/rel/1.1...rel/1.2

## [plc4x-code-generaton-1.2.0](https://github.com/apache/plc4x-build-tools/releases/tag/plc4x-code-generaton-1.2.0) - 2020-03-29 12:41:07

## What's Changed
* Remove headline border and background by @NiklasMerz in https://github.com/apache/plc4x-build-tools/pull/1
* PLC4X landing page by @dominikriemer in https://github.com/apache/plc4x-build-tools/pull/2

## New Contributors
* @NiklasMerz made their first contribution in https://github.com/apache/plc4x-build-tools/pull/1
* @dominikriemer made their first contribution in https://github.com/apache/plc4x-build-tools/pull/2

**Full Changelog**: https://github.com/apache/plc4x-build-tools/commits/plc4x-code-generaton-1.2.0

## [release/code-generation/1.1.0](https://github.com/apache/plc4x-build-tools/releases/tag/release/code-generation/1.1.0) - 2020-01-04 19:23:33

**Full Changelog**: https://github.com/apache/plc4x-build-tools/commits/release/code-generation/1.1.0

## [rel/1.1](https://github.com/apache/plc4x-build-tools/releases/tag/rel/1.1) - 2020-01-04 19:16:05

**Full Changelog**: https://github.com/apache/plc4x-build-tools/commits/rel/1.1

## [release/code-generation/1.0.0](https://github.com/apache/plc4x-build-tools/releases/tag/release/code-generation/1.0.0) - 2019-09-26 10:12:44

**Full Changelog**: https://github.com/apache/plc4x-build-tools/commits/release/code-generation/1.0.0

\* *This CHANGELOG was automatically generated by [auto-generate-changelog](https://github.com/BobAnkh/auto-generate-changelog)*
