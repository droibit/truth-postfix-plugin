package com.github.droibit.plugin.truth.postfix

import com.github.droibit.plugin.truth.postfix.template.AssertThatTemplate
import com.intellij.codeInsight.template.postfix.templates.JavaPostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate

/**
 * Created by kumagai on 2016/03/04.
 */
class TruthPostfixTemplateProvider: JavaPostfixTemplateProvider {

    private val templates: Set<PostfixTemplate>

    constructor() {
        templates = hashSetOf(
                AssertThatTemplate()
        )
    }

    override fun getTemplates() = templates
}