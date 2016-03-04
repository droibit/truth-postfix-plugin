package com.github.droibit.plugin.truth.postfix

import com.intellij.codeInsight.template.postfix.templates.JavaPostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate

/**
 * Created by kumagai on 2016/03/04.
 */
class TruthPostfixTemplateProvider: JavaPostfixTemplateProvider {

    private val _templates: Set<PostfixTemplate>

    constructor() {
        _templates = hashSetOf()
    }

    override fun getTemplates() = _templates
}