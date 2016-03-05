package com.github.droibit.plugin.truth.postfix.template

import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.*
import com.intellij.psi.PsiElement

/**
 * @author kumagai
 */
class AssertThatTemplate : StringBasedPostfixTemplate(
        "assertThat",
        "assertThat(expr)",
        selectorTopmost(IS_NON_VOID)) {

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