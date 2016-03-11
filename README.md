# Turth Postfix Completion Plugin
[![Build Status](https://travis-ci.org/droibit/truth-postfix-plugin.svg?branch=develop)](https://travis-ci.org/droibit/truth-postfix-plugin)

This Plugin for [Google truth](https://github.com/google/truth) to use *Postfix Completion* in IntelliJ Idea/Android Studio.  
Available in Java and Kotlin (limited support).

## Support

**This plugin require [Kotlin Plugin](https://plugins.jetbrains.com/plugin/6954?pr=idea).**

* Android Studio 1.3 or higher
* IntelliJ Idea 1.4 or higher

## Available Templates

### Java

|Postfix Expression|Description|Example|
|------------------|-----------|-------|
|.assertThat|Creates assertion from actual.|assertThat(actual)|
|.assertWithMessage|Creates assertion using custom message.|assertWithMessage(message)|
|.assertAbout|Creates assertion from custom subject|assertAbout(subjectFactory).that(actual)|

### Kotlin

|Postfix Expression|Description|Example|
|------------------|-----------|-------|
|.assertThat|Creates assertion from actual.|Truth.assertThat(actual)|

If you want to use `assertThat`, manually run method import.

## Installation

This plugin is dependent on the [Kotlin Plugin](https://plugins.jetbrains.com/plugin/6954?pr=idea), please install first.

TODO:

## License

    Copyright 2015 Shinya Kumagai

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
