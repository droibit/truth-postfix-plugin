package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.utils.KotlinSelectorConditions.ANY_EXPR
import com.github.droibit.plugin.truth.postfix.utils.KotlinAncestorSelectors.selectorTopmost
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.psi.PsiElement

/**
 * @author kumagai
 */
class KotlinAssertThatTemplate : StringBasedPostfixTemplate(
        "assertThat",
        "assertThat(expr)",
        selectorTopmost(ANY_EXPR)) {

    // Ref: https://goo.gl/jpjA7w
    override fun getElementToRemove(expr: PsiElement) = expr

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            isToReformat = shouldReformat()
            setValue(USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String {
       return "com.google.common.truth.Truth.assertThat(\$expr\$)\$END\$"
    }
}