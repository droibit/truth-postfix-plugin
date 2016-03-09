package com.github.droibit.plugin.truth.postfix.template

import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.IS_NON_VOID
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost
import com.intellij.psi.PsiElement

/**
 * @author kumagai
 */
class AssertThatTemplate : StringBasedPostfixTemplate(
        "assertThat",
        "assertThat(expr)",
        selectorTopmost(IS_NON_VOID)) {

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            setValue(USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String {
       return "com.google.common.truth.Truth.assertThat(\$expr\$)\$END\$"
    }
}