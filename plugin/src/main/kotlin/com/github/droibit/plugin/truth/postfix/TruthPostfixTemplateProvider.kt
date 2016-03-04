package com.github.droibit.plugin.truth.postfix

import com.github.droibit.plugin.truth.postfix.template.AssertThatTemplate
import com.github.droibit.plugin.truth.postfix.template.AssertWithMessageTemplate
import com.intellij.codeInsight.template.postfix.templates.JavaPostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate

/**
 * @author kumagai
 */
class TruthPostfixTemplateProvider: JavaPostfixTemplateProvider {

    private val templates: Set<PostfixTemplate>

    constructor() {
        templates = hashSetOf(
                AssertThatTemplate(),
                AssertWithMessageTemplate()
        )
    }

    override fun getTemplates() = templates
}